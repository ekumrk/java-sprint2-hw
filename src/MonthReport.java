import java.util.ArrayList;
import java.util.HashMap;

public class MonthReport {

    FileReader fileReader = new FileReader();
    HashMap<Integer, ArrayList<MonthInfo>> monthsData = new HashMap<>();

    public MonthReport() {

    }

   public void readFile () {

       for (int i = 1; i < 4; i++) {
           ArrayList<MonthInfo> monthStatistics = new ArrayList<>();
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
           }
               monthsData.put(i,monthStatistics);
       }
      }




   public void monthFullStatistics() {
       HashMap<String, Integer> profits;
       HashMap<String, Integer> expensies;

       for (int month : monthsData.keySet()) {
           System.out.println("Месяц № " + month);
           ArrayList<MonthInfo> lines = monthsData.get(month);
           profits = new HashMap<>();
           expensies = new HashMap<>();

            for (MonthInfo stat : lines) {
                if (stat.isExpense) {
                    expensies.put(stat.title, (stat.quantity * stat.unitPrice));
                } else {
                    profits.put(stat.title, (stat.quantity * stat.unitPrice));
                }

            }
            System.out.println("Самый прибыльный товар месяца: " + findMost(profits) + ".");
            System.out.println("Самая большая трата месяца: " + findMost(expensies) + ".");
       }
   }
   public HashMap<String, Integer> findMost(HashMap<String, Integer> x) {

        HashMap<String, Integer> hash = new HashMap<>();
        String maxTitle = null;
        int amount = 0;
        int maxAmount = 0;

        for(String title : x.keySet()) {
            amount = x.get(title);
            //for ()
            if (amount > maxAmount) {
                maxAmount = amount;
                maxTitle = title;
            } if (!hash.isEmpty()) {
                hash.clear();
            }
            hash.put(maxTitle, maxAmount);
        }
        return hash;
   }

}



