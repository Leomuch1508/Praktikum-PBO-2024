package data;

public class pemain {
    private statistik state;
    private kontrakPemain contract;
    private int idPemain;
    protected String namaPemain;
    protected String asalKlub;
    protected int umur;
    protected double marketValue;

    public pemain(int idPemain, String namaPemain, String asalKlub, int umur, double marketValue){
        this.idPemain = idPemain;
        this.namaPemain = namaPemain;
        this.asalKlub = asalKlub;
        this.umur = umur;
        this.marketValue = marketValue; 
    }
    public statistik getState() {
        return state;
    }
    public kontrakPemain getContract() {
        return contract;
    }
    public int getIdPemain() {
        return idPemain;
    }
    public String getNamaPemain() {
        return namaPemain;
    }
    public String getAsalKlub() {
        return asalKlub;
    }
    public int getUmur() {
        return umur;
    }
    public double getMarketValue() {
        return marketValue;
    }
    public void setIdPemain(int idPemain) {
        this.idPemain = idPemain;
    }
    public void setNamaPemain(String namaPemain) {
        this.namaPemain = namaPemain;
    }
    public void setAsalKlub(String asalKlub) {
        this.asalKlub = asalKlub;
    }
    public void setUmur(int umur) {
        this.umur = umur;
    }
    public void setMarketValue(double marketValue) {
        this.marketValue = marketValue;
    }
}