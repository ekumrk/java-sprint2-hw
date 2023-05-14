import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        // Поехали!
        Scanner scanner = new Scanner(System.in);

        YearReport yearReport = new YearReport();
        MonthReport monthReport = new MonthReport();

            while (true) {
                printMenu();

                int command = scanner.nextInt();
                if (command == 1) {
                    monthReport.readFile();
                } else if (command == 2) {
                    yearReport.readFile();
                    System.out.println("Годовой отчёт успешно считан.");
                } else if (command == 3) {

                } else if (command == 4) {
                    monthReport.monthFullStatistics();
                } else if (command == 5) {
                    yearReport.yearFullStatistics();
                } else if (command == 0) {
                    System.out.println("Ввведите секретное число для выхода из приложения:");
                    int secretNumber = scanner.nextInt();
                    if (secretNumber == 888) {
                        System.out.println("Выход.");
                        break;
                    } else {
                        System.out.println("Неверное число, попробуйте ещё раз.");
                    }
                } else {
                    System.out.println("Такой команды пока нет.");
                }
            }
        }


    public static void printMenu() {
            System.out.println("Выберите желаемое действие:");
            System.out.println("1 - Считать все месячные отчёты");
            System.out.println("2 - Считать годовой отчёт");
            System.out.println("3 - Сверить месячные и годовой отчёты");
            System.out.println("4 - Вывести информацию обо всех месячных отчётах");
            System.out.println("5 - Вывести информацию о годовом отчёте");
            System.out.println("0 - Выход");

    }
}


