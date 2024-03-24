package data;

public class statistik extends pemain{
    String posisi;
    private int gol;
    private int assist;
    private int match;
    
    public statistik(int idPemain, String namaPemain, String asalKlub, int umur, double marketValue, String posisi, int gol, int assist, int match) {
        super(idPemain, namaPemain, asalKlub, umur, marketValue);
        this.posisi = posisi;
        this.gol = gol;
        this.assist = assist;
        this.match = match;
    }
    @Override
    public int getIdPemain() {
        return super.getIdPemain();
    }

    @Override
    public statistik getState() {
        return super.getState();
    }
    
    public String getPosisi() {
        return posisi;
    }

    public int getGol() {
        return gol;
    }

    public int getAssist() {
        return assist;
    }

    public int getMatch() {
        return match;
    }

    public void setPosisi(String posisi) {
        this.posisi = posisi;
    }

    public void setGol(int gol) {
        this.gol = gol;
    }

    public void setAssist(int assist) {
        this.assist = assist;
    }

    public void setMatch(int match) {
        this.match = match;
    }
}
