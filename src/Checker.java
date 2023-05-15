import java.util.HashMap;
import java.util.ArrayList;

public class Checker {
    public YearReport yearReport;
    public MonthReport monthReport;

    public Checker(YearReport yearReport, MonthReport monthReport) {
        this.yearReport = yearReport;
        this.monthReport = monthReport;
    }

    public void check() {
        boolean control = false;
        //Мапа для годовых отчетов: доход/расход -> месяц -> сумма
        HashMap<Boolean, HashMap<Integer, Integer>> repByYear = new HashMap<>();
        for (YearInfo line : yearReport.yearStatistics) {
            if (!repByYear.containsKey(line.isExpense)) {
                repByYear.put(line.isExpense, new HashMap<>());
            }
            HashMap<Integer, Integer> amountToIncome = repByYear.get(line.isExpense);
            amountToIncome.put(line.month, amountToIncome.getOrDefault(line.month,0) + line.amount);

        }

        //Мапа для месячных отчётов: доход/расход -> месяц -> сумма
        HashMap<Boolean, HashMap<Integer, Integer>> repByMonths = new HashMap<>();
        for (Integer monthName : monthReport.monthsData.keySet()) {
            ArrayList<MonthInfo> lines = monthReport.monthsData.get(monthName);

            for (MonthInfo line : lines) {
            if (!repByMonths.containsKey(line.isExpense)) {
                repByMonths.put(line.isExpense, new HashMap<>());
            }
            HashMap<Integer, Integer> amountToIncome = repByMonths.get(line.isExpense);
            amountToIncome.put(monthName, amountToIncome.getOrDefault(monthName, 0) + (line.quantity*line.unitPrice));
            repByMonths.put(line.isExpense, amountToIncome);
        }
    }
        for (Boolean isExp : repByYear.keySet()) {
            HashMap<Integer, Integer> amountToIncomeByYear = repByYear.get(isExp);
            HashMap<Integer, Integer> amountToIncomeByMonths = repByMonths.get(isExp);

            for (Integer month : amountToIncomeByYear.keySet()) {
                int monthAmountByYear = amountToIncomeByYear.get(month);
                int monthAmountByMonths = amountToIncomeByMonths.get(month);

                if (monthAmountByYear != monthAmountByMonths) {
                        if (!isExp) {
                        System.out.println("Месяц № " + month + " сумма доходов (по даннм годового отчёта) " +
                                " составляет " + monthAmountByYear + " рублей. А в месячном отчёте сумма " +
                                " доходов составила " + monthAmountByMonths + " рублей.");
                            control = false;
                    } else {
                        System.out.println("Месяц № " + month + " сумма расходов (по даннм годового отчёта) " +
                                " составляет " + monthAmountByYear + " рублей. А в месячном отчёте сумма " +
                                " расходов составила " + monthAmountByMonths + " рублей.");
                            control = false;
                    }
                } else {
                    control = true;
                }
            }
        }
            if (control) {
                System.out.println("Сверка успешна: отчёты не противоречят друг другу.");
            }
    }
}
