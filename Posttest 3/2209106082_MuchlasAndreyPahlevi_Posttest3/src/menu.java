public class menu {
    protected void index() {
        System.out.println("======================");
        System.out.println("|| 1. Lihat Pemain  ||");
        System.out.println("|| 2. Tambah Detail ||");
        System.out.println("|| 3. Ubah Pemain   ||");
        System.out.println("|| 4. Hapus Pemain  ||");
        System.out.println("|| 5. Exit          ||");
        System.out.println("======================");
        System.out.print("Pilihan : ");
    }

    protected void detail() {
        System.out.println("===========================");
        System.out.println("||  1. Statistik Pemain  ||");
        System.out.println("||  2. Kontrak Pemain    ||");
        System.out.println("||  3. Kembali           ||");
        System.out.println("===========================");
        System.out.print("Pilihan : ");
    }

    protected void tambahDetail() {
        System.out.println("===========================");
        System.out.println("||  1. Tambah Pemain     ||");
        System.out.println("||  2. Tambah Statistik  ||");
        System.out.println("||  3. Tambah Kontrak    ||");
        System.out.println("||  4. Kembali           ||");
        System.out.println("===========================");
        System.out.print("Pilihan : ");
    }

    protected void lihatDetail() {
        System.out.println("==========================");
        System.out.println("||  1. Lihat Pemain     ||");
        System.out.println("||  2. Lihat Statistik  ||");
        System.out.println("||  3. Lihat Kontrak    ||");
        System.out.println("||  4. Kembali          ||");
        System.out.println("==========================");
        System.out.print("Pilihan : ");
    }
}