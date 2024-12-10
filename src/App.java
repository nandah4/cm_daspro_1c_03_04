import java.util.Scanner;

public class App {

    static Scanner sc = new Scanner(System.in);

    static void tampilkanInventori(String[][] dataInventori, String[] namaHeader) {
        LOOP_SHOWINVENTORI: while (true) {
            System.out.println("===== DATA INVENTORI =====");
            System.out.printf("%-6s", namaHeader[0]);
            for (int h = 1; h < namaHeader.length; h++) {
                System.out.printf("%15s", namaHeader[h]);
            }
            System.out.println();
            System.out.println("----------------------------------------------------");

            for (int i = 0; i < dataInventori.length; i++) {
                if (dataInventori[i][0] == null) {
                    break;
                } else {
                    System.out.printf("%-6s", i + 1);
                }
                for (int j = 1; j < dataInventori[i].length; j++) {
                    if (dataInventori[i][j] != null) {
                        System.out.printf("%15s", dataInventori[i][j]);
                    }
                }
                System.out.println();
            }
            System.out.println();

            System.out.println("Kembali ke menu utama? (y/n)");
            char innerMenu = sc.nextLine().charAt(0);
            if (innerMenu == 'y' || innerMenu == 'Y') {
                break;
            } else if (innerMenu == 'n' || innerMenu == 'N') {
                continue LOOP_SHOWINVENTORI;
            } else {
                System.out.println("Pilihan tidak valid");
                continue LOOP_SHOWINVENTORI;
            }
        }
    }

    static void tambahStok(String[][] dataInventori) {
        System.out.println("===== TAMBAH STOK =====");
        System.out.print("Masukkan nomor item: ");
        int nomorItem = sc.nextInt();
        sc.nextLine();

        boolean itemAda = false;

        for (int i = 0; i < dataInventori.length; i++) {
            if (i == nomorItem - 1) {
                System.out.print("Masukkan jumlah stok yang akan ditambahkan: ");
                int jumlahStok = sc.nextInt();
                sc.nextLine();

                String stokLama = dataInventori[i][3];

                int stokAwal = Integer.parseInt(stokLama);
                int stokBaru = stokAwal + jumlahStok;

                dataInventori[i][3] = Integer.toString(stokBaru);

                System.out
                        .println("Stok untuk " + dataInventori[i][1] + " berhasil ditambahkan. Stok baru: " + stokBaru);
                itemAda = true;
                break;
            }
        }

        if (!itemAda) {
            System.out.println("Item dengan nomor tersebut tidak ditemukan.");
        }
    }

    static int tambahItemBaru(String[][] dataInventori, int barisSelanjutnya) {
        if (dataInventori.length > 10) {
            System.out.println("Inventory penuh! Tidak dapat menambahkan item baru.");
            return barisSelanjutnya;
        }

        LOOP_TAMBAHITEM: while (true) {
            System.out.println("===== TAMBAH ITEM BARU =====");
            System.out.print("Masukkan nama item baru: ");
            String namaItem = sc.nextLine().trim();
            System.out.print("Masukkan kategori item baru: ");
            String kategoriItem = sc.nextLine().trim();
            System.out.print("Masukkan jumlah stok awal: ");
            String stokItem = sc.nextLine().trim();

            dataInventori[barisSelanjutnya] = new String[] { Integer.toString(dataInventori.length + 1), namaItem,
                    kategoriItem, stokItem };
            System.out.println(
                    "Item baru berhasil ditambahkan: " + namaItem + " (" + kategoriItem + ") " + " - Stok: "
                            + stokItem);

            System.out.println("Kembali ke menu utama? (y/n)");
            char innerMenu = sc.nextLine().charAt(0);
            if (innerMenu == 'y' || innerMenu == 'Y') {
                break;
            } else if (innerMenu == 'n' || innerMenu == 'N') {
                continue LOOP_TAMBAHITEM;
            } else {
                System.out.println("Pilihan tidak valid");
                continue LOOP_TAMBAHITEM;
            }
        }
        return barisSelanjutnya++;
    }

    static void Keluar() {
        System.out.println("Apakah anda ingin keluar? (y/n)");
        String jawaban = sc.next();

        if (jawaban.equalsIgnoreCase("y")) {
            System.out.println("Terima kasih telah menggunakan program ini!");
            System.exit(0);
        } else if (jawaban.equalsIgnoreCase("n")) {
            System.out.println("Kembali ke menu utama");
        }
    }

    public static void main(String[] args) {
        String[] namaHeader = { "No", "Nama Item", "Kategori", "Stok" };

        String[][] dataInventori = new String[10][4];
        int barisSelanjutnya = 0;

        OUTER_LOOP: while (true)

        {
            System.out.println("===== MENU INVENTORI KAFE =====");

            System.out.println("1. Tampilkan Inventori");
            System.out.println("2. Tampilkan Stok untuk Item yang ada");
            System.out.println("3. Tambah Item Baru");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu: ");
            int pilihanMenu = sc.nextInt();
            sc.nextLine();

            if (pilihanMenu == 1) {
                tampilkanInventori(dataInventori, namaHeader);
            } else if (pilihanMenu == 2) {

            } else if (pilihanMenu == 3) {
                tambahItemBaru(dataInventori, barisSelanjutnya);
            } else if (pilihanMenu == 4) {
                Keluar();
                break OUTER_LOOP;
            } else {
                continue OUTER_LOOP;
            }

        }
    }
}