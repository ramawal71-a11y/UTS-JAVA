import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StoreService {
    private final SortedList<Product> products = new SortedList<>(
        Comparator.comparing(Product::getName, String.CASE_INSENSITIVE_ORDER));
    private final List<Transaction> transactions = new ArrayList<>();

    public void addProduct(Product product) {
        if (product == null) throw new IllegalArgumentException("Produk tidak boleh null");
        if (findProduct(product.getId()) != null)
            throw new IllegalArgumentException("ID produk sudah digunakan");
        products.insert(product);
    }
    public Product findProduct(String id) {
        for (Product p : products.toList())
            if (p.getId().equalsIgnoreCase(id)) return p;
        return null;
    }
    public void restock(String id, int qty) {
        Product p = findProduct(id);
        if (p == null) throw new IllegalArgumentException("Produk tidak ditemukan");
        p.addStock(qty);
    }
    public Transaction sell(String id, int qty) {
        Product p = findProduct(id);
        if (p == null) throw new IllegalArgumentException("Produk tidak ditemukan");
        p.reduceStock(qty);
        Transaction tx = new Transaction("TRX-" + (transactions.size() + 1));
        tx.addItem(new TransactionItem(p, qty));
        transactions.add(tx);
        return tx;
    }
    public List<Product> getProducts() { return products.toList(); }
    public List<Transaction> getTransactions() { return new ArrayList<>(transactions); }
}
