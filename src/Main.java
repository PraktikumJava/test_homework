import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        printMenu();
        int userInput = scanner.nextInt();
        StepTracker stepTracker = new StepTracker();

        while (userInput != 0) {
            printMenu();
            userInput = scanner.nextInt();

            if (userInput == 1) {
                System.out.println("Введите месяц от 0 до 11");
                stepTracker.printMenuUser();
                int monthnumber = scanner.nextInt();
                System.out.println("Введите день от 0 до 30");
                int daynumber = scanner.nextInt();
                System.out.println("Укажите количество шагов пройденных за сегодня");
                int stepssum = scanner.nextInt();
                stepTracker.getDaySteps(monthnumber, daynumber, stepssum);
            } else if (userInput == 2) {
                System.out.println("Введите номер месяца для получения статистики");
                stepTracker.printMenuUser();
                int month = scanner.nextInt();
                stepTracker.getStatistic(month);

            } else if (userInput == 3) {
                System.out.println("Установите цель ваших шагов на день");
                int newplanstep = scanner.nextInt();
                if (newplanstep < 0) {
                    System.out.println("Вы ввели некорректное число! Попробуйте еще раз!");
                    break;
                } else {
                    stepTracker.changeDaySteps(newplanstep);
                }

            } else if (userInput == 0) {
                break;
            }
        }
        System.out.println("Программа завершена");
    }

    private static void printMenu() {
        System.out.println("Что вы хотите сделать?");
        System.out.println("1 - Ввести количество шагов за день"); // done
        System.out.println("2 - Получить статистику");
        System.out.println("3 - Изменить цель по количеству шагов");// done
        System.out.println("0 - Выход из приложения");
    }
}