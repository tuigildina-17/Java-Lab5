import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("ЗАДАНИЕ 1. Шаблоны");
        System.out.println("Создание дроби");

        System.out.print("Введите числитель: ");
        int num = Correct.validateIntInput(scanner);

        int den;
        while (true) {
            System.out.print("Введите знаменатель: ");
            den = Correct.validateIntInput(scanner);
            if (den == 0) {
                System.out.println("Знаменатель не может быть равен 0. Попробуйте снова.");
            } else {
                break;
            }
        }

        Fraction fraction = new Fraction(num, den);

        System.out.println("Создана дробь: " + fraction);
        System.out.println("Её значение = " + fraction.getValue());

        System.out.println("\nПроверка кэширования");
        System.out.println("Повторный вызов getValue(): " + fraction.getValue());

        System.out.println("\nИзменение числителя");
        System.out.print("Введите новый числитель: ");
        int newNum = Correct.validateIntInput(scanner);
        fraction.setNumerator(newNum);

        System.out.println("Обновлённая дробь: " + fraction);
        System.out.println("Новое значение = " + fraction.getValue());

        System.out.println("\nПроверка equals()");
        Fraction f2 = new Fraction(newNum, den);
        System.out.println("Сравниваем " + fraction + " и " + f2);
        System.out.println("Результат equals(): " + fraction.equals(f2));


        System.out.println("\nЗАДАНИЕ 2. Структурные шаблоны");
        System.out.println("Количество мяуканий");

        System.out.println("Введите имя кота:");
        scanner.nextLine();
        String catName = Correct.validateStringInput(scanner);

        Cat myCat;

        try {
            myCat = new Cat(catName);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
            return;
        }

        int meowCount = Funs.meowsCare(myCat);

        System.out.println("Результат: Кот по имени " + catName + " мяукал " + meowCount + " раз(а)");


        System.out.println("\nЗАДАНИЕ 3. Список");
        System.out.println("ЗАДАЧА 5. Удаление всех элементов с указанным значением");

        System.out.println("Выберите тип данных:");
        System.out.println("1 — строки");
        System.out.println("2 — числа");

        int choice = Correct.validateIntInput(scanner);

        while (choice != 1 && choice != 2) {
            System.out.println("Некорректный выбор. Введите 1 (строки) или 2 (числа):");
            choice = Correct.validateIntInput(scanner);
        }

        if (choice == 1) {
            System.out.println("Сколько строк вы хотите добавить?");
            int count = Correct.validateIntInput(scanner);
            while (count <= 0) {
                System.out.println("Количество должно быть положительным. Попробуйте снова:");
                count = Correct.validateIntInput(scanner);
            }

            List<String> strings = new ArrayList<>();
            scanner.nextLine();

            for (int i = 0; i < count; i++) {
                System.out.println("Введите строку №" + (i + 1) + ":");
                strings.add(Correct.validateStringInput(scanner));
            }

            System.out.println("Введите строку, которую нужно удалить:");
            String valueToRemove = Correct.validateStringInput(scanner);

            ListCleaner<String> cleaner = new ListCleaner<>(strings);
            cleaner.removeValue(valueToRemove);

            System.out.println("Результат: " + cleaner);

        } else {
            System.out.println("Сколько чисел вы хотите добавить?");
            int count = Correct.validateIntInput(scanner);
            while (count <= 0) {
                System.out.println("Количество должно быть положительным. Попробуйте снова:");
                count = Correct.validateIntInput(scanner);
            }

            List<Integer> numbers = new ArrayList<>();

            for (int i = 0; i < count; i++) {
                System.out.println("Введите число №" + (i + 1) + ":");
                numbers.add(Correct.validateIntInput(scanner));
            }

            System.out.println("Введите число, которое нужно удалить:");
            int valueToRemove = Correct.validateIntInput(scanner);

            ListCleaner<Integer> cleaner = new ListCleaner<>(numbers);
            cleaner.removeValue(valueToRemove);

            System.out.println("Результат: " + cleaner);
        }


        System.out.println("\nЗАДАНИЕ 4. Мап");
        System.out.println("ЗАДАЧА 2. Максимальный балл");

        String filePath = "src/participants.txt";

        OlympiadMap olympiad = new OlympiadMap();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String firstLine = br.readLine();
            if (firstLine == null) {
                System.out.println("Файл пуст.");
                return;
            }

            int n = Integer.parseInt(firstLine.trim());
            if (n <= 0 || n > 250) {
                System.out.println("Некорректное количество участников.");
                return;
            }

            for (int i = 1; i <= n; i++) {
                String line = br.readLine();
                if (line == null) {
                    System.out.println("Недостаточно строк в файле.");
                    return;
                }

                String[] parts = line.split("\\s+");
                if (parts.length != 5) {
                    System.out.println("Ошибка в строке " + i + ": неверный формат.");
                    continue;
                }

                String lastName = parts[0];
                String firstName = parts[1];

                if (lastName.length() > 20) {
                    System.out.println("Ошибка в строке " + i + ": фамилия > 20 символов.");
                    continue;
                }

                if (firstName.length() > 15) {
                    System.out.println("Ошибка в строке " + i + ": имя > 15 символов.");
                    continue;
                }

                int s1, s2, s3;
                try {
                    s1 = Integer.parseInt(parts[2]);
                    s2 = Integer.parseInt(parts[3]);
                    s3 = Integer.parseInt(parts[4]);
                } catch (NumberFormatException e) {
                    System.out.println("Ошибка в строке " + i + ": баллы должны быть числами.");
                    continue;
                }

                if (s1 < 0 || s1 > 25 || s2 < 0 || s2 > 25 || s3 < 0 || s3 > 25) {
                    System.out.println("Ошибка в строке " + i + ": баллы должны быть 0–25.");
                    continue;
                }

                Participant p = new Participant(lastName, firstName, s1, s2, s3);
                olympiad.add(p);
            }

        } catch (IOException e) {
            System.out.println("Ошибка чтения файла.");
            return;
        }

        List<Participant> winners = olympiad.getWinners();

        System.out.println("\nМаксимальный балл: ");
        for (Participant p : winners) {
            System.out.println(p.getFullName() + " - " + p.getTotal());
        }


        System.out.println("\nЗАДАНИЕ 5. Сет");
        System.out.println("ЗАДАЧА 3: Согласные, которые встречаются ровно в одном слове");

        System.out.println("Введите текст:");
        String text = Correct.validateStringInput(scanner);

        ConsonantSetProcessor processor = new ConsonantSetProcessor(text);

        Set<Character> result = processor.findUniqueConsonants();

        System.out.println("Результат:");
        if (result.isEmpty()) {
            System.out.println("Нет согласных, которые встречаются ровно в одном слове.");
        } else {
            for (char c : result) {
                System.out.print(c + " ");
            }
            System.out.println();
        }


        System.out.println("\nЗАДАНИЕ 6. Очередь");
        System.out.println("ЗАДАЧА 4: Равенство участка");

        Queue<Integer> queue = new LinkedList<>();

        System.out.println("Введите количество элементов очереди:");
        int queueSize = Correct.validateIntInput(scanner);

        System.out.println("Введите элементы очереди:");
        for (int k = 0; k < queueSize; k++) {
            queue.add(Correct.validateIntInput(scanner));
        }

        System.out.println("Введите i:");
        int startIndex = Correct.validateIntInput(scanner);

        System.out.println("Введите j:");
        int endIndex = Correct.validateIntInput(scanner);

        try {
            boolean equal = QueueChecker.checkSegmentEquality(queue, startIndex, endIndex);
            System.out.println("Все элементы с " + startIndex + " по " + endIndex + " равны: " + equal);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }


        System.out.println("ЗАДАНИЕ 7. Стрим");
        System.out.println("ЗАДАЧА 1. Точки");
        System.out.println("Введите количество точек:");

        int pointsCount = scanner.nextInt();

        List<Point> points = new ArrayList<>();

        System.out.println("Введите точки в формате: X Y");

        for (int idx = 0; idx < pointsCount; idx++) {
            System.out.print("Точка " + (idx + 1) + ": ");
            double x = scanner.nextDouble();
            double y = scanner.nextDouble();
            points.add(new Point(x, y));
        }

        Polyline polyline = StreamTask.buildPolyline(points);

        System.out.println("\nРезультат:");
        System.out.println(polyline);


        System.out.println("ЗАДАЧА 2. Группировка людей по номеру");

        String peopleFile = "src/people.txt";

        Map<Integer, List<String>> grouped = PeopleGrouper.groupPeople(peopleFile);

        System.out.println(grouped);
    }
}


