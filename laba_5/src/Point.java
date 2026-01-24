// Класс для хранения координат точки на плоскости
public class Point {
    private double x;
    private double y;

    // конструктор для создания точки с координатами x и y
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // методы для получения координат x, y
    public double getX() { return x; }
    public double getY() { return y; }

    // метод для преобразования точки в строку
    // используется при выводе ломаной
    @Override
    public String toString() {
        return "{" + x + ";" + y + "}";
    }

    // метод для сравнения двух точек
    // важен чтобы distinct в стриме работал правильно
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point)) return false;
        Point p = (Point) o;

        // сравниваем координаты с учётом double
        return Double.compare(p.x, x) == 0 &&
                Double.compare(p.y, y) == 0;
    }

    // метод для корректной работы equals в коллекциях
    @Override
    public int hashCode() {
        return java.util.Objects.hash(x, y);
    }
}