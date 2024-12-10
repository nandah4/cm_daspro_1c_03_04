import java.util.Scanner;

public class App {

    static Scanner sc = new Scanner(System.in);

    static void tampilkanInventori(String[][] dataInventori, String[] namaHeader) {
        System.out.println("===== DATA INVENTORI =====");
        System.out.printf("%-15s", namaHeader[0]);
        for (int h = 1; h < namaHeader.length; h++) {
            System.out.printf("%15s", namaHeader[h]);
        }
        System.out.println();

        for (int i = 0; i < dataInventori.length; i++) {
            System.out.print(i);
            for (int j = 0; j < dataInventori[i].length; j++) {
                System.out.print(dataInventori[i][j] + "\t");
            }
        }

        System.out.println();
    }

    public static void main(String[] args) {
        String[] namaHeader = { "No", "Nama Item", "Kategori", "Stok" };

        String[][] dataInventori = {
                {
                        "Kopi Hitam", "Minuman", "10",
                        "Cappuccino", "Minuman", "5",
                        "Teh", "Minuman", "8",
                }
        };

        OUTER_LOOP: while (true) {
            System.out.println("===== MENU INVENTORI KAFE =====");

            System.out.println("1. Tampilkan Inventori");
            System.out.println("2. Tampilkan Stok untuk Item yang ada");
            System.out.println("3. Tambah Item Baru");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu: ");
            int pilihanMenu = sc.nextInt();

            if (pilihanMenu == 1) {
                tampilkanInventori(dataInventori, namaHeader);
            } else if (pilihanMenu == 2) {

            } else if (pilihanMenu == 3) {

            } else if (pilihanMenu == 4) {
                break OUTER_LOOP;
            } else {
                continue OUTER_LOOP;
            }

        }
    }
}