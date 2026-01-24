import java.util.*;
import java.util.stream.Collectors;

// Класс для обработки точек с помощью стримов
public class StreamTask {

    // метод для построения ломаной линии из списка точек
    public static Polyline buildPolyline(List<Point> points) {

        List<Point> processed = points.stream()

                // убрать одинаковые точки
                .distinct()

                // заменить отрицательные Y на положительные
                .map(p -> new Point(p.getX(), Math.abs(p.getY())))

                // сортировка по X
                .sorted(Comparator.comparingDouble(Point::getX))

                .collect(Collectors.toList());

        return new Polyline(processed);
    }
}