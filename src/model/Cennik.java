package model;

public class Cennik {
    private double kwota;
    private String opis;

    public double getKwota() {
        return kwota;
    }

    public void setKwota(double kwota) {
        this.kwota = kwota;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Cennik(double kwota, String opis) {
        this.kwota = kwota;
        this.opis = opis;
    }
}
