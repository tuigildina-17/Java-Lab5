import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

// Класс для чтения людей из файла и группировки их по номеру
public class PeopleGrouper {

    public static Map<Integer, List<String>> groupPeople(String filePath) {

        // try with resources автоматически закрывает файл
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            return br.lines() // читаем файл построчно как поток строк

                    // убираем пустые строки
                    .filter(line -> !line.trim().isEmpty())

                    // оставляем только строки, где есть двоеточие
                    .filter(line -> line.contains(":"))

                    // разбиваем строку на имя и номер
                    .map(line -> line.split(":"))

                    // пропускаем строки где нет номера
                    .filter(arr -> arr.length == 2 && !arr[1].trim().isEmpty())

                    // создаём пары имя номер
                    // имя нормализуем чтобы первая буква была заглавной
                    .map(arr -> new AbstractMap.SimpleEntry<>(
                            normalizeName(arr[0]),
                            Integer.parseInt(arr[1].trim())
                    ))

                    // группируем по номеру
                    // ключ это номер, значение это список имён
                    .collect(Collectors.groupingBy(
                            AbstractMap.SimpleEntry::getValue,
                            Collectors.mapping(AbstractMap.SimpleEntry::getKey, Collectors.toList())
                    ));

        } catch (IOException e) {
            System.out.println("Ошибка чтения файла: " + e.getMessage());
            return Collections.emptyMap();
        }
    }

    // Имя - первая буква заглавная, остальные строчные
    private static String normalizeName(String name) {
        name = name.trim().toLowerCase();
        if (name.isEmpty()) return name;
        return Character.toUpperCase(name.charAt(0)) + name.substring(1);
    }
}