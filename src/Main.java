import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        StoreService store = new StoreService();

        store.addProduct(new Product("P001", "Beras 5 Kg", "Sembako", 72000, 10));
        store.addProduct(new Product("P002", "Gula 1 Kg", "Sembako", 16000, 20));
        store.addProduct(new Product("P003", "Minyak Goreng 1 L", "Sembako", 18000, 15));

        int pilihan;
        do {
            System.out.println("\\n=== MANAJEMEN TOKO KELONTONG ===");
            System.out.println("1. Tampilkan barang");
            System.out.println("2. Tambah barang");
            System.out.println("3. Cari barang berdasarkan ID");
            System.out.println("4. Tambah stok");
            System.out.println("5. Penjualan");
            System.out.println("0. Keluar");
            System.out.print("Pilih: ");
            while (!input.hasNextInt()) { input.next(); System.out.print("Masukkan angka: "); }
            pilihan = input.nextInt();
            input.nextLine();

            try {
                switch (pilihan) {
                    case 1:
                        for (Product p : store.getProducts()) System.out.println(p);
                        break;
                    case 2:
                        System.out.print("ID: "); String id = input.nextLine();
                        System.out.print("Nama: "); String nama = input.nextLine();
                        System.out.print("Kategori: "); String kategori = input.nextLine();
                        System.out.print("Harga: "); double harga = input.nextDouble();
                        System.out.print("Stok awal: "); int stok = input.nextInt(); input.nextLine();
                        store.addProduct(new Product(id, nama, kategori, harga, stok));
                        System.out.println("Produk berhasil ditambahkan.");
                        break;
                    case 3:
                        System.out.print("Masukkan ID: ");
                        Product p = store.findProduct(input.nextLine());
                        System.out.println(p == null ? "Produk tidak ditemukan." : p);
                        break;
                    case 4:
                        System.out.print("ID produk: "); String idRestock = input.nextLine();
                        System.out.print("Jumlah tambahan: "); int tambah = input.nextInt(); input.nextLine();
                        store.restock(idRestock, tambah);
                        System.out.println("Stok berhasil diperbarui.");
                        break;
                    case 5:
                        System.out.print("ID produk: "); String idJual = input.nextLine();
                        System.out.print("Jumlah jual: "); int jumlah = input.nextInt(); input.nextLine();
                        Transaction tx = store.sell(idJual, jumlah);
                        System.out.println("Transaksi " + tx.getTransactionId()
                            + " berhasil. Total: Rp" + tx.getTotal());
                        break;
                    case 0:
                        System.out.println("Program selesai.");
                        break;
                    default:
                        System.out.println("Pilihan tidak tersedia.");
                }
            } catch (RuntimeException e) {
                System.out.println("Operasi gagal: " + e.getMessage());
            }
        } while (pilihan != 0);
        input.close();
    }
}
