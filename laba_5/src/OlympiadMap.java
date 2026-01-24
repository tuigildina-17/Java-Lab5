import java.util.*;

// Класс для хранения участников олимпиады и поиска победителей
public class OlympiadMap {
    private Map<String, Participant> map = new HashMap<>();

    // метод для добавления участника в карту
    // ключ это полное имя чтобы не было повторов
    public void add(Participant p) {
        map.put(p.getFullName(), p);
    }

    // метод для поиска всех участников с максимальной суммой баллов
    public List<Participant> getWinners() {
        List<Participant> winners = new ArrayList<>();
        int max = -1; // начальное значение меньше любого возможного результата

        // перебираем всех участников
        for (Participant p : map.values()) {
            int total = p.getTotal();
            // если найден новый максимум очищаем список и добавляем только этого участника
            if (total > max) {
                max = total;
                winners.clear();
                winners.add(p);
                // если баллы равны текущему максимуму добавляем в список
            } else if (total == max) {
                winners.add(p);
            }
        }

        return winners;
    }
}