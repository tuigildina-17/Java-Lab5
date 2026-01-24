// Класс для представления одной линии между двумя точками
public class Line {
    private Point start;
    private Point end;

    // конструктор для создания линии из двух точек
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    // метод для вывода линии в удобном виде
    @Override
    public String toString() {
        return "Линия от " + start + " до " + end;
    }
}