public class MonthInfo {
    String title;
    public boolean isExpense;
    int quantity;
    int unitPrice;

    public MonthInfo(String title, boolean isExpense, int quantity, int unitPrice) {
        this.title = title;
        this.isExpense = isExpense;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }
}
