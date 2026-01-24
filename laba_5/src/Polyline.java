import java.util.List;

// Класс для представления ломаной линии состоящей из списка точек
public class Polyline {
    private List<Point> points;

    // конструктор принимает список точек через которые проходит ломаная
    public Polyline(List<Point> points) {
        this.points = points;
    }

    // метод для вывода ломаной в виде списка точек
    @Override
    public String toString() {
        return "Линия " + points;
    }
}