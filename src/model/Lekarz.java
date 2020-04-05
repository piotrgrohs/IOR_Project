package model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Lekarz extends Osoba implements Serializable {
    private String specjalizacja;
    private String tytulNauk;
    private int id;
    private Wizyta wizyta;

    @ManyToOne
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinColumn(name="WIZYTA_ID",foreignKey = @javax.persistence.ForeignKey(name = "FK_LEK_WIZ"))
    public Wizyta getWizyta() {
        return wizyta;
    }

    public void setWizyta(Wizyta wizyta) {
        this.wizyta = wizyta;
    }


    public Lekarz(String nazwisko, String imie, String pesel) {
        super(nazwisko, imie, pesel);
    }

    @Basic
    @Column(name = "SPECJALIZACJA")
    public String getSpecjalizacja() {
        return specjalizacja;
    }

    public void setSpecjalizacja(String specjalizacja) {
        this.specjalizacja = specjalizacja;
    }

    @Basic
    @Column(name = "TYTULNAUK")
    public String getTytulNauk() {
        return tytulNauk;
    }

    public void setTytulNauk(String tytulnauk) {
        this.tytulNauk = tytulnauk;
    }

    @Id
    @Column(name = "LEKARZ_ID")
    public int getId() {
        return id;
    }

    public void setId(int lekarzId) {
        this.id = lekarzId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lekarz lekarze = (Lekarz) o;
        return id == lekarze.id &&
                Objects.equals(specjalizacja, lekarze.specjalizacja) &&
                Objects.equals(tytulNauk, lekarze.tytulNauk);
    }

    @Override
    public int hashCode() {
        return Objects.hash(specjalizacja, tytulNauk, id);
    }
}
