// Класс для представления кота который умеет мяукать
public class Cat implements Meowable {
    private String name;

    // конструктор сохраняет имя кота
    public Cat(String name) {
        this.name = name;
    }

    // метод для мяуканья кота
    @Override
    public void meow() {
        System.out.println(name + ": мяу");
    }

    // метод для получения имени
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Кот по имени " + name;
    }
}