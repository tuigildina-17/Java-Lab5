// Класс для хранения информации об участнике олимпиады
public class Participant {
    private String lastName;
    private String firstName;
    private int s1, s2, s3;

    // конструктор сохраняет фамилию имя и три балла
    public Participant(String lastName, String firstName, int s1, int s2, int s3) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
    }

    // метод для получения суммы баллов участника
    public int getTotal() {
        return s1 + s2 + s3;
    }

    // метод для получения полного имени
    public String getFullName() {
        return lastName + " " + firstName;
    }
}