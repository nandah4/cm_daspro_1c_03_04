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

                System.out.println("Stok untuk " + dataInventori[i][1] + " berhasil ditambahkan. Stok baru: " + stokBaru);
                itemAda = true;
                break;
            }
        }

        if (!itemAda) {
            System.out.println("Item dengan nomor tersebut tidak ditemukan.");
        }
    }

    static void Keluar() {
            System.out.println("Apakah anda ingin keluar? (y/n)");
            String jawaban = sc.next();

            if (jawaban.equalsIgnoreCase("y")) {
                System.out.println("Terima kasih telah menggunakan program ini!");
                System.exit(0);
            }else if (jawaban.equalsIgnoreCase("n")) {
                System.out.println("Kembali ke menu utama");
            }
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
                tambahStok(dataInventori);
            } else if (pilihanMenu == 3) {

            } else if (pilihanMenu == 4) {
                Keluar();
                break OUTER_LOOP;
            } else {
                continue OUTER_LOOP;
            }

        }
    }
}