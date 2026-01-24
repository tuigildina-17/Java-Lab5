// Класс для функций работающих с объектами которые умеют мяукать
public class Funs {

    // метод для вызова мяуканья 5 раз
    // возвращает сколько раз объект мяукал
    public static int meowsCare(Meowable m) {
        int count = 0;

        for (int i = 0; i < 5; i++) {
            m.meow();
            count++;
        }

        return count;
    }
}