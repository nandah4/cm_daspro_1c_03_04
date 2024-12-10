import java.util.Scanner;

public class App {

    static Scanner sc = new Scanner(System.in);

    static void tampilkanInventori(String[][] dataInventori, String[] namaHeader) {
        System.out.println("===== DATA INVENTORI =====");
        System.out.printf("%-12s", namaHeader[0]);
        for (int h = 1; h < namaHeader.length; h++) {
            System.out.printf("%12s", namaHeader[h]);
        }
        System.out.println();
        System.out.println("-------------------------------------------------");

        for (int i = 0; i < dataInventori.length; i++) {
            System.out.printf("%-12s", i + 1);
            for (int j = 0; j < dataInventori[i].length; j++) {
                System.out.printf("%12s", dataInventori[i][j]);
            }
            System.out.println();
        }

        System.out.println();
    }

    static void tambahStok(String[][] dataInventori) {
        System.out.println("===== TAMBAH STOK =====");
        System.out.print("Masukkan nomor item: ");
        int nomorItem = sc.nextInt();
        sc.nextLine();

        if (nomorItem < 1 || nomorItem > dataInventori.length) {
            System.out.println("Nomor item tidak valid.");
            return;
        }

        int i = nomorItem - 1;

        System.out.print("Masukkan jumlah stok yang akan ditambahkan: ");
        int jumlahStok = sc.nextInt();
        sc.nextLine();
        int stokAwal = Integer.parseInt(dataInventori[i][2]);
        int stokBaru = stokAwal + jumlahStok;

        System.out.println("Stok untuk " + dataInventori[i][0] + " berhasil ditambahkan. Stok baru: " + stokBaru);
    }

    static void Keluar() {
        System.out.println("Terimakasih Telah Menggunakan Aplikasi Inventori Kafe");
    }

    public static void main(String[] args) {
        String[] namaHeader = { "No", "Nama Item", "Kategori", "Stok" };

        String[][] dataInventori = {
                { "Kopi Hitam", "Minuman", "10" },
                { "Cappuccino", "Minuman", "5" },
                { "Teh", "Minuman", "8" },
        };

        OUTER_LOOP: while (true)

        {
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
                tambahStok(dataInventori);
            } else if (pilihanMenu == 3) {

            } else if (pilihanMenu == 4) {
                Keluar();
                break OUTER_LOOP;
            }

        }
    }
}