package data;

public class pemain {
    String namaPemain;
    String asalKlub;
    int marketValue;

    public pemain(String namaPemain, String asalKlub, int marketValue){
        this.namaPemain = namaPemain;        
        this.asalKlub = asalKlub;        
        this.marketValue = marketValue;        
    }
    public String getNamaPemain() {
        return namaPemain;
    }
    public String getAsalKlub() {
        return asalKlub;
    }
    public int getMarketValue() {
        return marketValue;
    }
    public void setNamaPemain(String namaPemain) {
        this.namaPemain = namaPemain;
    }
    public void setAsalKlub(String asalKlub) {
        this.asalKlub = asalKlub;
    }
    public void setMarketValue(int marketValue) {
        this.marketValue = marketValue;
    }
}