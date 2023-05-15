import java.util.ArrayList;
import java.util.HashMap;

public class YearReport {

    public ArrayList<YearInfo> yearStatistics = new ArrayList<>();
    FileReader fileReader = new FileReader();

    public YearReport() {

    }
        public void readFile () {
            ArrayList<String> lines = fileReader.readFileContents("y.2021.csv");
            for (int i = 1; i < lines.size(); i++) {
                String line = lines.get(i);
                String[] lineContents = line.split(",");
                int month = Integer.parseInt(lineContents[0]);
                int amount = Integer.parseInt(lineContents[1]);
                boolean isExpense = Boolean.parseBoolean(lineContents[2]);

                YearInfo yearInfo = new YearInfo(month, amount, isExpense);
                yearStatistics.add(yearInfo);
            }
        }

    public void yearFullStatistics() {
        System.out.println("Год 2021.");
        HashMap<Integer, Integer> monthDemands = new HashMap<>();
        HashMap<Integer, Integer> monthExpenses = new HashMap<>();

        for (YearInfo stat : yearStatistics) {
            if (stat.isExpense) {
                monthExpenses.put(stat.month, stat.amount);
            } else {
                monthDemands.put(stat.month, stat.amount);
            }
        }
        monthExpenses(monthDemands, monthExpenses);// Метод для подсчёта прибыли по каждому месяцу
        System.out.println("Расходы в среднем составили: " + getAverageAmount(monthExpenses) + " руб./мес.");// Метод для расчёта среднего расхода
        System.out.println("Доходы в среднем составили: " + getAverageAmount(monthDemands) + " руб./мес.");// Метод для расчёта среднего дохода

    }

      public void monthExpenses(HashMap<Integer, Integer> monthDemands, HashMap<Integer, Integer> monthExpenses) {
        int expenses = 0;
        int demands = 0;
        int difference = 0;
        for (Integer demand : monthDemands.keySet()) {
            for (Integer expense : monthExpenses.keySet()) {
                if (demand == expense) {
                    demands = monthDemands.get(demand);
                    expenses = monthExpenses.get(expense);
                    difference = demands - expenses;
                    System.out.println("В месяце № " + demand + " прибыль составила: " + difference + " рублей.");
                }
            }
        }
    }

    public int getAverageAmount (HashMap<Integer, Integer> map) {
        int amounts = 0;
        int sum = 0;
        int average = 0;
        for (Integer month : map.keySet()) {
            amounts = map.get(month);
            sum += amounts;
            average = sum / month;
        }
        return average;
    }

}








