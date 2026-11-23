import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Transaction {
    private final String transactionId;
    private final LocalDateTime dateTime;
    private final List<TransactionItem> items = new ArrayList<>();

    public Transaction(String transactionId) {
        this.transactionId = transactionId;
        this.dateTime = LocalDateTime.now();
    }
    public void addItem(TransactionItem item) {
        if (item == null) throw new IllegalArgumentException("Item tidak boleh null");
        items.add(item);
    }
    public double calculateTotal() {
        double total = 0;
        for (TransactionItem item : items) total += item.calculateSubtotal();
        return total;
    }
    public String getTransactionId() { return transactionId; }
    public LocalDateTime getDateTime() { return dateTime; }
    public List<TransactionItem> getItems() { return new ArrayList<>(items); }
    public double getTotal() { return calculateTotal(); }
}
