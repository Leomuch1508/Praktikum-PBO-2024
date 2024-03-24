import java.util.ArrayList;
import java.util.Date;

import data.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
public class App extends menu {
    public static void main(String[] args) throws IOException, ParseException {
        ArrayList<pemain> player = new ArrayList<>();
        ArrayList<statistik> statistikPlayer = new ArrayList<>();
        ArrayList<kontrakPemain> contract = new ArrayList<>();
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        while (true) {
            clearScreen();
            menu obj = new menu();
            obj.index();
            int pilihan = Integer.parseInt(br.readLine());
            switch (pilihan) {
                case 1:
                    menuLihatDetail(player, statistikPlayer, contract);
                    break;
                case 2:
                    menuTambahDetail(player, statistikPlayer, contract);
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

    private static void menuTambahDetail(ArrayList<pemain> player, ArrayList<statistik> stat, ArrayList<kontrakPemain> contract) throws IOException, ParseException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        menu obj = new menu();
        int pilihan;
        
        do {
            obj.tambahDetail();
            pilihan = Integer.parseInt(br.readLine());
            switch (pilihan) {
                case 1:
                    tambahPemain(player);
                    break;
                case 2:
                    if (player.isEmpty()) {
                        System.out.println("Belum Ada Data Pemain");
                        break;
                    } else {
                        tambahStatistik(stat, player);
                    }
                    break;
                case 3:
                    if (player.isEmpty()) {
                        System.out.println("Belum Ada Data Pemain");
                        break;
                    } else {
                        tambahKontrakPemain(contract, player);
                    }
                    break;
                case 4:
                    pause();
                    break;
                default:
                    break;
            }
        } while (pilihan != 4);
    }

    private static void menuLihatDetail(ArrayList<pemain> player, ArrayList<statistik> stat, ArrayList<kontrakPemain> contract) throws IOException, ParseException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        menu obj = new menu();
        int pilihan;
        
        do {
            obj.lihatDetail();
            pilihan = Integer.parseInt(br.readLine());
            switch (pilihan) {
                case 1:
                    tampilkanPemain(player);
                    pause();
                    break;
                case 2:
                    lihatStatistik(player, stat);               
                    break;
                case 3:
                    lihatKontrakPemain(player, contract);
                    break;
                case 4:
                    pause();
                    break;
                default:
                    break;
            }
        } while (pilihan != 4);
    }
    
    private static void tampilkanPemain(ArrayList<pemain> player) throws IOException {
        if (player.isEmpty()) {
            System.out.println("Belum Ada Data Pemain");
            pause();
        } else {
            clearScreen();
            System.out.println("=========================================================================");
            System.out.printf("|%-4s| %-25s| %-15s| %-4s| %-15s| %n", "No", "Nama Pemain", "Asal Klub", "Umur", "Market Value" );
            for (int i = 0; i < player.size(); i++) {
                pemain plyr = player.get(i);
                String namaPemain = plyr.getNamaPemain();
                int umur = plyr.getUmur();
                String asalKlub = plyr.getAsalKlub();
                double marketValue = plyr.getMarketValue();
                System.out.println("=========================================================================");
                System.out.printf("|%-4d| %-25s| %-15s| %-4d| %-15.2f| %n", i + 1, namaPemain, asalKlub, umur, marketValue);
            }
            System.out.println("=========================================================================");
        }
    }
    
    private static void lihatStatistik(ArrayList<pemain> player, ArrayList<statistik> stateList) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);{
        tampilkanPemain(player);
        System.out.print("Masukkan ID Pemain Yang Ingin Dilihat Statistik nya : ");
        int idPemain = Integer.parseInt(br.readLine());
        pemain cekPemain = null;

        for (pemain cek : player) {
            if (cek.getIdPemain() == idPemain) {
                cekPemain = cek;
                break;
            }
        }

        if (cekPemain == null) {
            System.out.println("Pemain dengan ID " + idPemain + " tidak ditemukan!!!");
            return;
        }

        statistik state = null;
        for (statistik st : stateList) {
            if (st.getIdPemain() == idPemain) {
                state = st;
                break;
            }
        }

        if (state == null) {
            System.out.println("Statistik Tidak Ditemukan");
            return;
        }

        String namaPemain = state.getNamaPemain(); 
        String posisi = state.getPosisi();
        int gol = state.getGol();
        int assist = state.getAssist();
        int match = state.getMatch();

        System.out.println("===================================================================");
        System.out.printf("|%-25s| %-15s| %-8s| %-8s| %-8s| %n", "Nama Pemain", "Posisi", "Match", "Gol", "Assist" );
        System.out.println("===================================================================");
        System.out.printf("|%-25s| %-15s| %-8d| %-8d| %-8d| %n", namaPemain, posisi, match, gol, assist );
        System.out.println("===================================================================");
        }
    }
    

    private static void lihatKontrakPemain(ArrayList<pemain> player, ArrayList<kontrakPemain> contractList) throws IOException{
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        if (contractList.isEmpty()) {
            System.out.println("Belum Ada Data Statistik dari Pemain Tersebut");
        } else {
            tampilkanPemain(player);
            System.out.println("Masukkan ID Pemain Yang Ingin Dilihat Kontrak nya : ");
            int idPemain;
            try {
                idPemain = Integer.parseInt(br.readLine());
            } catch (NumberFormatException e) {
                System.out.println("Input bukan angka yang valid. Silahkan coba lagi.");
                return;
            }
    
            pemain cekPemain = null;
            for (pemain cek : player) {
                if (cek.getIdPemain() == idPemain) {
                    cekPemain = cek;
                    break;
                }
            }
    
            if (cekPemain == null) {
                System.out.println("Pemain dengan ID " + idPemain + " tidak ditemukan!!!");
                return;
            }
    
            kontrakPemain contract = cekPemain.getContract();
            if (contract == null) {
                System.out.println("Statistik untuk pemain dengan ID " + idPemain + " tidak ditemukan.");
                return;
            }
    
            String namaPemain = contract.getNamaPemain(); 
            Date tanggalMulaiKontrak = contract.getTanggalMulaiKontrak();
            Date tanggalAkhirKontrak = contract.getTanggalAkhirKontrak();
            double nilaiKontrak = contract.getNilaiKontrak();
            double klausulPelepasan = contract.getKlausulPelepasan();
    
            System.out.println("===================================================================");
            System.out.printf("|%-25s| %-25s| %-25s| %-20s| %-20s| %n", "Nama Pemain", "Tanggal Awal Kontrak", "Tanggal Akhir Kontrak", "Nilai Kontrak", "Klausul Pelepasan" );
            System.out.println("===================================================================");
            System.out.printf("|%-25s| %-25s| %-25d| %-20f| %-20f| %n", namaPemain, tanggalMulaiKontrak, tanggalAkhirKontrak, nilaiKontrak, klausulPelepasan);
            System.out.println("===================================================================");
        }
    }

    private static void tambahPemain(ArrayList<pemain> player) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        int idPemain = player.size() + 1;
        System.out.print("Masukkan Nama Pemain  : ");
        String namaPemain = br.readLine();
        System.out.print("Masukkan Asal Klub    : ");
        String asalKlub = br.readLine();
        System.out.print("Masukkan Umur Pemain  : ");
        int umur = Integer.parseInt(br.readLine());
        System.out.print("Masukkan Market Value : ");
        double marketValue = Double.parseDouble(br.readLine());
        pemain plyr = new pemain(idPemain, namaPemain, asalKlub, umur, marketValue);
        player.add(plyr);
        System.out.println("Pemain Berhasil Ditambahkan");
        pause();
    }

    private static void tambahStatistik(ArrayList<statistik> stat, ArrayList<pemain> player) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        System.out.print("Masukkan ID Pemain     : ");
        int idPemain = Integer.parseInt(br.readLine());
        pemain cekPemain = null;
        for (pemain cek : player) {
            if (cek.getIdPemain() == idPemain) {
                cekPemain = cek;
                break;
            }
        }
        if (cekPemain == null) {
            System.out.println("Pemain dengan ID tersebut tidak ditemukan!!!");
            return;
        }
        String namaPemain = cekPemain.getNamaPemain();
        String asalKlub = cekPemain.getAsalKlub();
        int umur = cekPemain.getUmur();
        double marketValue = cekPemain.getMarketValue();
        System.out.print("Masukkan Posisi Pemain : ");
        String posisi = br.readLine();
        System.out.print("Masukkan Jumlah Gol    : ");
        int gol = Integer.parseInt(br.readLine());
        System.out.print("Masukkan Jumlah Assist : ");
        int assist = Integer.parseInt(br.readLine());
        System.out.print("Masukkan Jumlah Match  : ");
        int match = Integer.parseInt(br.readLine());
        statistik statBaru = new statistik(idPemain, namaPemain, asalKlub, umur, marketValue, posisi, gol, assist, match);
        stat.add(statBaru);
        System.out.println("Statistik Pemain Berhasil Ditambahkan");
        pause();
    }

    private static void tambahKontrakPemain(ArrayList<kontrakPemain> contract, ArrayList<pemain> player) throws IOException, ParseException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        System.out.print("Masukkan ID Pemain     : ");
        int idPemain = Integer.parseInt(br.readLine());
        pemain cekPemain = null;
        for (pemain cek : player) {
            if (cek.getIdPemain() == idPemain) {
                cekPemain = cek;
                break;
            }
        }
        if (cekPemain == null) {
            System.out.println("Pemain dengan ID tersebut tidak ditemukan!!!");
            return;
        }
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String namaPemain = cekPemain.getNamaPemain();
        String asalKlub = cekPemain.getAsalKlub();
        int umur = cekPemain.getUmur();
        double marketValue = cekPemain.getMarketValue();
        System.out.print("Masukkan Tanggal Awal      : ");
        Date tanggalMulaiKontrak = formatter.parse(br.readLine());
        System.out.print("Masukkan Tanggal Akhir     : ");
        Date tanggalAkhirKontrak = formatter.parse(br.readLine());
        System.out.print("Masukkan Nilai Kontrak     : ");
        double nilaiKontrak = Double.parseDouble(br.readLine());
        System.out.print("Masukkan Klausul Pelepasan : ");
        double klausulPelepasan = Double.parseDouble(br.readLine());
        kontrakPemain contractPlayer = new kontrakPemain(idPemain, namaPemain, asalKlub, umur, marketValue, tanggalMulaiKontrak, tanggalAkhirKontrak, nilaiKontrak, klausulPelepasan);
        contract.add(contractPlayer);
        System.out.println("Statistik Pemain Berhasil Ditambahkan");
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