import java.util.ArrayList;
import java.util.List;

// Класс для удаления всех элементов с указанным значением из списка
public class ListCleaner<T> {
    private List<T> list;

    // конструктор создаёт копию списка чтобы не менять исходный
    public ListCleaner(List<T> list) {
        this.list = new ArrayList<>(list);
    }

    // метод для удаления всех элементов равных value
    // removeIf удаляет по условию
    public void removeValue(T value) {
        list.removeIf(x -> x.equals(value));
    }

    @Override
    public String toString() {
        return "Список: " + list;
    }
}