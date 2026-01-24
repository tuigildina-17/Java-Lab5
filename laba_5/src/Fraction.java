// Класс для представления дроби с кэшированием результата
public class Fraction implements FractionInterface {

    private int numerator;
    private int denominator;

    // кэш для хранения уже вычисленного значения дроби
    private Double cachedValue = null;

    // конструктор для создания дроби
    public Fraction(int numerator, int denominator) {
        setNumerator(numerator);
        setDenominator(denominator);
    }

    // метод для изменения числителя
    // при изменении числителя кэш нужно сбросить
    @Override
    public void setNumerator(int numerator) {
        this.numerator = numerator;
        cachedValue = null;
    }

    // метод для изменения знаменателя
    // запрещаем ноль и переносим минус в числитель
    @Override
    public void setDenominator(int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Знаменатель не может быть равен 0");
        }
        if (denominator < 0) {
            denominator = -denominator;
            numerator = -numerator;
        }
        this.denominator = denominator;
        cachedValue = null;
    }

    // метод для получения вещественного значения дроби
    // вычисляем только один раз и сохраняем в кэш
    @Override
    public double getValue() {
        // если значение ещё не вычислялось вычисляем и сохраняем
        if (cachedValue == null) {
            cachedValue = (double) numerator / denominator;
        }
        return cachedValue;
    }

    // метод для вывода дроби в виде a/b
    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    // метод для сравнения двух дробей по числителю и знаменателю
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Fraction)) return false;
        Fraction other = (Fraction) obj;
        return numerator == other.numerator && denominator == other.denominator;
    }

    // метод для корректной работы equals в коллекциях
    @Override
    public int hashCode() {
        return numerator * 31 + denominator;
    }
}