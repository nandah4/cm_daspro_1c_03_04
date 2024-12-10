import java.util.Scanner;

public class App {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        OUTER_LOOP: while (true) {
            System.out.println("===== MENU INVENTORI KAFE =====");

            System.out.println("1. Tampilkan Inventori");
            System.out.println("2. Tampilkan Stok untuk Item yang ada");
            System.out.println("3. Tambah Item Baru");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu: ");
            int pilihanMenu = sc.nextInt();

            if (pilihanMenu == 1) {

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