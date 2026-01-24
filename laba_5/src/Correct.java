import java.util.Scanner;

public class Correct {
    public static int validateIntInput(Scanner scanner) {
        while (true) {
            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            } else {
                System.out.println("Некорректный ввод. Пожалуйста, попробуйте еще раз.");
                scanner.next();
            }
        }
    }

    public static String validateStringInput(Scanner scanner) {
        while (true) {
            String input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            } else {
                System.out.println("Некорректный ввод. Пожалуйста, введите непустую строку.");
            }
        }
    }

    public static double validateDoubleInput(Scanner scanner) {
        while (true) {
            if (scanner.hasNextDouble()) {
                return scanner.nextDouble();
            } else {
                System.out.println("Некорректный ввод. Пожалуйста, введите число.");
                scanner.next();
            }
        }
    }

    public static int validateSingleScore(Scanner scanner, int number) {
        while (true) {
            System.out.println("Введите балл №" + number + " (0–25):");

            if (scanner.hasNextInt()) {
                int s = scanner.nextInt();
                if (s >= 0 && s <= 25) {
                    return s;
                } else {
                    System.out.println("Ошибка: балл должен быть от 0 до 25.");
                }
            } else {
                System.out.println("Ошибка: введите целое число.");
                scanner.next();
            }
        }
    }
}