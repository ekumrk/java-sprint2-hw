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
        HashMap <Integer, ArrayList<Integer>> reportByYear = new HashMap<>();
        ArrayList <Integer> monthCounts = new ArrayList<>();
        int sum = 0;
        for (YearInfo stat : yearReport.yearStatistics) {
            if (!reportByYear.containsKey(stat.month)) {
                reportByYear.put(stat.month, new ArrayList<>());
            }
            if (!stat.isExpense) {
                if (monthCounts.isEmpty()) {
                    monthCounts.add(0, stat.amount);
                } else {

                }

            }
            }




        return false;
    }

}
