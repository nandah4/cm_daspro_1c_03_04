import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Inisialisasi array dengan ukuran tetap
        String[][] data = new String[10][4];
        int count = 0; // Jumlah data awal

        // Menambahkan beberapa data awal
        count = addItem(data, count, "Burger", "Makanan", "10");
        count = addItem(data, count, "Pizza", "Makanan", "8");
        count = addItem(data, count, "Soda", "Minuman", "15");

        System.out.println("Jumlah data: " + count);

        while (true) {
            // Menampilkan menu
            System.out.println("\nNo\tNama\t\tKategori\tStok");
            System.out.println("==========================================");
            for (int i = 0; i < count; i++) {
                System.out.printf("%s\t%-8s\t%-10s\t%s\n", data[i][0], data[i][1], data[i][2], data[i][3]);
            }

            // Tanya apakah ingin menambah menu
            System.out.print("\nApakah Anda ingin menambah menu? (y/n): ");
            String pilihan = scanner.nextLine();

            if (pilihan.equalsIgnoreCase("n")) {
                break;
            }

            // Input data baru
            System.out.print("Masukkan nama: ");
            String nama = scanner.nextLine();

            System.out.print("Masukkan kategori: ");
            String kategori = scanner.nextLine();

            System.out.print("Masukkan stok: ");
            String stok = scanner.nextLine();

            // Menambahkan item baru
            count = addItem(data, count, nama, kategori, stok);
        }

        scanner.close();
    }

    /**
     * Fungsi untuk menambahkan item baru ke dalam array.
     * 
     * @param data     Array tempat menyimpan data
     * @param count    Jumlah data yang ada saat ini
     * @param nama     Nama item
     * @param kategori Kategori item
     * @param stok     Stok item
     * @return Jumlah data setelah item baru ditambahkan
     */
    public static int addItem(String[][] data, int count, String nama, String kategori, String stok) {
        if (count >= data.length) {
            System.out.println("Array penuh! Tidak dapat menambahkan item baru.");
            return count;
        }
        data[count] = new String[] { String.valueOf(count + 1), nama, kategori, stok };
        return count + 1;
    }
}
