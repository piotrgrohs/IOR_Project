package model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Lekarz extends Osoba implements Serializable {
    private String specjalizacja;
    private String tytulNauk;

    @ManyToOne
    @JoinColumn(name = "WIZYTA_ID", foreignKey = @javax.persistence.ForeignKey(name = "FK_LEK_WIZ"))
    private Wizyta wizyta;

    public Wizyta getWizyta() {
        return wizyta;
    }

    public void setWizyta(Wizyta wizyta) {
        this.wizyta = wizyta;
    }

    public Lekarz() {

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


}