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

            System.out.print("Kembali ke menu utama? (y/n) ");
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

        if (nomorItem < 1 || nomorItem > dataInventori.length) {
            System.out.println("Nomor item tidak valid.");
            return;
        }

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
                break;
            }
        }

        int i = nomorItem - 1;

        System.out.print("Masukkan jumlah stok yang akan ditambahkan: ");
        int jumlahStok = sc.nextInt();
        sc.nextLine();
        int stokAwal = Integer.parseInt(dataInventori[i][2]);
        int stokBaru = stokAwal + jumlahStok;

        System.out.println("Stok untuk " + dataInventori[i][0] + " berhasil ditambahkan. Stok baru: " + stokBaru);
    }

    static int tambahItemBaru(String[][] dataInventori, int barisSelanjutnya) {
        int nextRowUpdate = barisSelanjutnya;

        LOOP_TAMBAHITEM: while (true) {
            if (nextRowUpdate >= dataInventori.length) {
                System.out.println("Inventory penuh! Tidak dapat menambahkan item baru.");
                break;
            }

            System.out.println("===== TAMBAH ITEM BARU =====");

            String namaItem, kategoriItem, stokItem;

            LOOP_INPUTNAME: while (true) {
                System.out.print("Masukkan nama item baru: ");
                namaItem = sc.nextLine().trim();

                if (namaItem.isEmpty()) {
                    System.out.println("Nama tidak boleh kosong");
                    continue LOOP_INPUTNAME;
                } else {
                    break LOOP_INPUTNAME;
                }
            }

            System.out.print("Masukkan kategori item baru: ");
            kategoriItem = sc.nextLine().trim();

            while (true) {
                System.out.print("Masukkan jumlah stok awal: ");
                stokItem = sc.nextLine().trim();
                if (stokItem.isEmpty()) {
                    System.out.println("Stok tidak boleh kosong");
                    continue;
                } else if (Integer.parseInt(stokItem) < 1) {
                    System.out.println("Stok tidak boleh < 1");
                    continue;
                } else {
                    break;
                }
            }

            dataInventori[nextRowUpdate] = new String[] {
                    Integer.toString(nextRowUpdate + 1), namaItem, kategoriItem, stokItem
            };

            System.out.println(
                    "Item baru berhasil ditambahkan: " + namaItem + " (" + kategoriItem + ") " + " - Stok: "
                            + stokItem);

            nextRowUpdate++;

            System.out.print("Kembali ke menu utama? (y/n) ");
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
        return nextRowUpdate;
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
                tambahStok(dataInventori);
            } else if (pilihanMenu == 3) {
                barisSelanjutnya = tambahItemBaru(dataInventori, barisSelanjutnya);
            } else if (pilihanMenu == 4) {
                System.out.println("Terima kasih telah menggunakan program ini!");
                break OUTER_LOOP;
            }

        }
    }
}