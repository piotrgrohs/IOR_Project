package model;

public class Lekarz {
    private String specjalizacja;
    private String tytulNauk;

    public String getSpecjalizacja() {
        return specjalizacja;
    }

    public void setSpecjalizacja(String specjalizacja) {
        this.specjalizacja = specjalizacja;
    }

    public String getTytulNauk() {
        return tytulNauk;
    }

    public void setTytulNauk(String tytulNauk) {
        this.tytulNauk = tytulNauk;
    }

    public Lekarz(String specjalizacja, String tytulNauk) {
        this.specjalizacja = specjalizacja;
        this.tytulNauk = tytulNauk;
    }
}
