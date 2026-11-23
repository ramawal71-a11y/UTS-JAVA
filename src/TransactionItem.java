public class TransactionItem {
    private final Product product;
    private final int quantity;

    public TransactionItem(Product product, int quantity) {
        if (product == null || quantity <= 0)
            throw new IllegalArgumentException("Produk/kuantitas tidak valid");
        this.product = product;
        this.quantity = quantity;
    }
    public Product getProduct() { return product; }
    public int getQuantity() { return quantity; }
    public double calculateSubtotal() { return product.getPrice() * quantity; }
}
