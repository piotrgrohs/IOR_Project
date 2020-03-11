package model;

public class Usluga {
    private double cena;
    private String opis;
    private double rabat;

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public double getRabat() {
        return rabat;
    }

    public void setRabat(double rabat) {
        this.rabat = rabat;
    }

    public Usluga(double cena, String opis, double rabat) {
        this.cena = cena;
        this.opis = opis;
        this.rabat = rabat;
    }
}
