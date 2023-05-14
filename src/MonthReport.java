import java.util.ArrayList;
import java.util.HashMap;

public class MonthReport {

    FileReader fileReader = new FileReader();
    public ArrayList<MonthInfo> monthStatistics = new ArrayList<>();
    public HashMap<Integer, ArrayList<MonthInfo>> monthsData = new HashMap<>();

    public MonthReport() {

    }

   public void readFile () {
       for (int i = 1; i < 4; i++) {
           ArrayList<String> lines = fileReader.readFileContents("m.20210" + i + ".csv");
           for (int k = 1; k < lines.size(); k++) {
               String line = lines.get(k);
               String[] lineContents = line.split(",");
               String title = lineContents[0];
               boolean isExpense = Boolean.parseBoolean(lineContents[1]);
               int quantity = Integer.parseInt(lineContents[2]);
               int unitPrice = Integer.parseInt(lineContents[3]);

               MonthInfo monthInfo = new MonthInfo(title, isExpense, quantity, unitPrice);
               monthStatistics.add(monthInfo);
               monthsData.put(i, monthStatistics);
               }
       }

   }

   public void monthFullStatistics() {
       HashMap<String, Integer> profits = new HashMap<>();
       HashMap<String, Integer> expensies = new HashMap<>();

        for (Integer month : monthsData.keySet()) {
           System.out.println("Месяц № " + month);
           ArrayList<MonthInfo> lines = monthsData.get(month);

            for (MonthInfo stat : lines) {
                if (!stat.isExpense) {
                    profits.put(stat.title, (stat.quantity * stat.unitPrice));
                } else {
                    expensies.put(stat.title, (stat.quantity * stat.unitPrice));
                }

            }
            findMost(profits);
            findMost(expensies);
       }
   }
   public void findMost(HashMap<String, Integer> x) {
        String maxTitle = "";
        int amount = 0;
        int maxAmount = 0;
        for(String title : x.keySet()) {
            amount = x.get(title);
            if (amount > maxAmount) {
                maxAmount = amount;
                maxTitle = title;
            }
        }
   }

}



