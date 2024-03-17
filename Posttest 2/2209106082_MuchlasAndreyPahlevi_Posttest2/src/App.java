import java.util.ArrayList;

import data.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class App extends menu {
    public static void main(String[] args) throws IOException {
        ArrayList<pemain> player = new ArrayList<>();
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        while (true) {
            clearScreen();
            menu obj = new menu();
            obj.msg();
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
    
    private static void tampilkanPemain(ArrayList<pemain> player) throws IOException {
        if (player.isEmpty()) {
            System.out.println("Belum Ada Data Pemain");
            pause();
        } else {
            clearScreen();
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
            pause();
        }
    }

    private static void tambahPemain(ArrayList<pemain> player) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        System.out.print("Masukkan Nama Pemain  : ");
        String namaPemain = br.readLine();
        System.out.print("Masukkan Asal Klub    : ");
        String asalKlub = br.readLine();
        System.out.print("Masukkan Market Value : ");
        int marketValue = Integer.parseInt(br.readLine());
        pemain plyr = new pemain(namaPemain, asalKlub, marketValue);
        player.add(plyr);
        System.out.println("Pemain Berhasil Ditambahkan");
        pause();
    }

    private static void updatePemain(ArrayList<pemain> player) throws IOException {
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
                System.out.println("Data Pemain Berhasil Diupdate");
                pause();
            }
        }
    }
    
    private static void hapusPemain(ArrayList<pemain> player) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        System.out.println("Hapus Data Pemain");
        tampilkanPemain(player);
        System.out.print("Data Nomor Ke Berapa Yang Ingin Di Hapus? : ");
        int hapus = Integer.parseInt(br.readLine()) - 1;
        player.remove(hapus);
        System.out.println("Data Pemain Berhasil Dihapus");
        pause();
    }
    
    static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }

    static void pause() throws IOException {
        System.out.println("Press Any Key To Continue...");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        reader.readLine(); 
    }
}