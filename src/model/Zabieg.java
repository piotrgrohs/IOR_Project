package model;

public class Zabieg {
    private String nrZeba;
    private String opis;

    public String getNrZeba() {
        return nrZeba;
    }

    public void setNrZeba(String nrZeba) {
        this.nrZeba = nrZeba;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Zabieg(String nrZeba, String opis) {
        this.nrZeba = nrZeba;
        this.opis = opis;
    }
}
