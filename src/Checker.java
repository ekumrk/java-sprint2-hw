import java.util.HashMap;
import java.util.ArrayList;

public class Checker {
    public YearReport yearReport;
    public MonthReport monthReport;

    public Checker(YearReport yearReport, MonthReport monthReport) {
        this.yearReport = yearReport;
        this.monthReport = monthReport;
    }

    public boolean check() {
        //Мапа для годовых отчетов
        HashMap<Boolean, HashMap<Integer, Integer>> repByYear = new HashMap<>();
        for (YearInfo line : yearReport.yearStatistics) {
            if (!repByYear.containsKey(line.isExpense)) {
                repByYear.put(line.isExpense, new HashMap<>());
            }
            HashMap<Integer, Integer> amountToIncome = repByYear.get(line.isExpense);
            amountToIncome.put(line.month, amountToIncome.getOrDefault(line.month,0) + line.amount);

        }
        System.out.println(repByYear);


        //Мапа для месячных отчётов
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
    } System.out.println(repByMonths);
return false;
}
    }
