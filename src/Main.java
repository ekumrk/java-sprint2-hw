import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        // Поехали!
        Scanner scanner = new Scanner(System.in);

        YearReport yearReport = new YearReport();
        MonthReport monthReport = new MonthReport();
        Checker checker = new Checker(yearReport, monthReport);

        boolean yearOpened = false;
        boolean monthOpened = false;

            while (true) {
                printMenu();

                int command = scanner.nextInt();
                if (command == 1) {
                    monthReport.readFile();
                    monthOpened = true;
                    System.out.println("Месячные отчёты успешно считаны.");
                } else if (command == 2) {
                    yearReport.readFile();
                    yearOpened = true;
                    System.out.println("Годовой отчёт успешно считан.");
                } else if (command == 3) {
                    if (yearOpened && monthOpened) {
                        checker.check();
                    } else {
                        System.out.println("Один из отчётов не подгружен. Проверьте подгрузку всех файлов.");
                    }
                } else if (command == 4) {
                    if (monthOpened) {
                        monthReport.monthFullStatistics();
                    } else {
                        System.out.println("Вы еще не подгрузили месячные отчёты, пожалуйста выберите команду 1, чтобы сделать это.");
                    }
                } else if (command == 5) {
                    if (yearOpened) {
                        yearReport.yearFullStatistics();
                    } else {
                        System.out.println("Вы еще не подгрузили годовой отчёт, пожалуйста выберите команду 2, чтобы сделать это.");
                    }
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


