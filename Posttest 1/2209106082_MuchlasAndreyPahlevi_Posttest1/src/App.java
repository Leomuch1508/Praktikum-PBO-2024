import java.util.ArrayList;
import data.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class App {
    public static void main(String[] args) throws IOException {
        ArrayList<pemain> player = new ArrayList<>();
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        while (true) {
            System.out.println("======================");
            System.out.println("|| 1. Lihat Pemain  ||");
            System.out.println("|| 2. Tambah Pemain ||");
            System.out.println("|| 3. Ubah Pemain   ||");
            System.out.println("|| 4. Hapus Pemain  ||");
            System.out.println("|| 5. Exit          ||");
            System.out.println("======================");
            System.out.print("Pilihan : ");
            int pilihan = Integer.parseInt(br.readLine());
            switch (pilihan) {
                case 1:
                    tampilkanPemain(player);
                    break;
                case 2:
                    tambahPemain(player);
                    break;
                case 3:
                    updatePemain(player);
                    break;
                case 4:
                    hapusPemain(player);
                    break;
                case 5:
                    System.out.println("Terimakasih Telah Menggunakan Program Ini");
                    System.exit(0);
                default:
                    break;
            }
        }

    }
    public static void tampilkanPemain(ArrayList<pemain> player) {
        if (player.isEmpty()) {
            System.out.println("Belum Ada Data Pemain");
        } else {
            System.out.println("===================================================================");
            System.out.printf("|%-4s| %-25s| %-15s| %-15s| %n", "No", "Nama Pemain", "Asal Klub", "Market Value" );
            for (int i = 0; i < player.size(); i++) {
                pemain plyr = player.get(i);
                String namaPemain = plyr.getNamaPemain();
                String asalKlub = plyr.getAsalKlub();
                int marketValue = plyr.getMarketValue();
                System.out.println("===================================================================");
                System.out.printf("|%-4d| %-25s| %-15s| %-15d| %n", i + 1, namaPemain, asalKlub, marketValue);
            }
            System.out.println("===================================================================");
        }
    }

    public static void tambahPemain(ArrayList<pemain> player) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        System.out.print("Masukkan Nama Pemain : ");
        String namaPemain = br.readLine();
        System.out.print("Masukkan Asal Klub : ");
        String asalKlub = br.readLine();
        System.out.print("Masukkan Market Value : ");
        int marketValue = Integer.parseInt(br.readLine());
        pemain plyr = new pemain(namaPemain, asalKlub, marketValue);
        player.add(plyr);
    }

    public static void updatePemain(ArrayList<pemain> player) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        System.out.println("Update Data Pemain");
        tampilkanPemain(player);
        System.out.print("Data Nomor Ke Berapa Yang Ingin Di Update? : ");
        int cari = Integer.parseInt(br.readLine()) - 1;
        for (int i = 0; i < player.size(); i++ ) {
            if (cari == i) {
                pemain newPlayer = player.get(i);
                System.out.print("Masukkan Nama Pemain Baru  : ");
                String newNamePlayer = br.readLine();
                newPlayer.setNamaPemain(newNamePlayer);
                System.out.print("Masukkan Asal Klub Baru    : ");
                String newClub = br.readLine();
                newPlayer.setAsalKlub(newClub);
                System.out.print("Masukkan Market Value Baru : ");
                int newMarketValue = Integer.parseInt(br.readLine());
                newPlayer.setMarketValue(newMarketValue);
            }
        }
    }
    
    public static void hapusPemain(ArrayList<pemain> player) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        System.out.println("Hapus Data Pemain");
        tampilkanPemain(player);
        System.out.print("Data Nomor Ke Berapa Yang Ingin Di Hapus? : ");
        int hapus = Integer.parseInt(br.readLine()) - 1;
        player.remove(hapus);
    }
}