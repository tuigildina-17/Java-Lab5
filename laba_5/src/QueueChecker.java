import java.util.*;

// Класс для проверки равенства элементов очереди на участке
public class QueueChecker {

    // метод для проверки что элементы от i до j одинаковые
    public static <T> boolean checkSegmentEquality(Queue<T> queue, int i, int j) {

        if (i < 0 || j >= queue.size() || i >= j) {
            throw new IllegalArgumentException("Некорректные индексы i и j");
        }

        // переводим очередь в список чтобы можно было обращаться по индексу
        List<T> list = new ArrayList<>(queue);

        // первый элемент участка
        T first = list.get(i);

        // проверяем что все элементы равны первому
        for (int k = i + 1; k <= j; k++) {
            if (!list.get(k).equals(first)) {
                return false;
            }
        }

        return true;
    }
}