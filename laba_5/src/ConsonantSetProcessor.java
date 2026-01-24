import java.util.*;

// Класс для поиска согласных которые встречаются ровно в одном слове
public class ConsonantSetProcessor {
    private String text;

    // набор всех русских согласных букв
    private static final Set<Character> CONSONANTS = Set.of(
            'б','в','г','д','ж','з','й','к','л','м','н','п','р','с','т','ф','х','ц','ч','ш','щ',
            'Б','В','Г','Д','Ж','З','Й','К','Л','М','Н','П','Р','С','Т','Ф','Х','Ц','Ч','Ш','Щ'
    );

    // конструктор сохраняет текст
    public ConsonantSetProcessor(String text) {
        this.text = text;
    }

    public Set<Character> findUniqueConsonants() {
        String[] words = text.split("\\s+");

        // Map для подсчёта в скольких словах встречается каждая согласная
        Map<Character, Integer> consonantCount = new HashMap<>();

        for (String word : words) {
            // множество согласных в текущем слове чтобы не считать повторно
            Set<Character> consonantsInWord = new HashSet<>();

            for (char c : word.toCharArray()) {
                if (CONSONANTS.contains(c)) {
                    // приводим к нижнему регистру
                    consonantsInWord.add(Character.toLowerCase(c));
                }
            }

            // увеличиваем счётчик для каждой согласной из слова
            for (char c : consonantsInWord) {
                consonantCount.put(c, consonantCount.getOrDefault(c, 0) + 1);
            }
        }

        // выбираем только те согласные которые встречаются ровно в одном слове
        Set<Character> result = new TreeSet<>();
        for (var entry : consonantCount.entrySet()) {
            if (entry.getValue() == 1) {
                result.add(entry.getKey());
            }
        }

        return result;
    }

    @Override
    public String toString() {
        return "Текст: " + text;
    }
}