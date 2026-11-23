public class Product {
    private final String id;
    private final String name;
    private final String category;
    private double price;
    private int stock;

    public Product(String id, String name, String category, double price, int stock) {
        if (id == null || id.isBlank() || name == null || name.isBlank())
            throw new IllegalArgumentException("ID dan nama wajib diisi");
        if (price < 0 || stock < 0)
            throw new IllegalArgumentException("Harga dan stok tidak boleh negatif");
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.stock = stock;
    }
    public String getId() { return id; }
    public String getName() { return name; }
    public String getCategory() { return category; }
    public double getPrice() { return price; }
    public int getStock() { return stock; }

    public void setPrice(double price) {
        if (price < 0) throw new IllegalArgumentException("Harga tidak valid");
        this.price = price;
    }
    public void addStock(int qty) {
        if (qty <= 0) throw new IllegalArgumentException("Jumlah harus lebih dari 0");
        stock += qty;
    }
    public void reduceStock(int qty) {
        if (qty <= 0 || qty > stock)
            throw new IllegalArgumentException("Jumlah tidak valid atau stok tidak cukup");
        stock -= qty;
    }
    @Override public String toString() {
        return id + " | " + name + " | " + category + " | Rp" + price + " | stok " + stock;
    }
}
