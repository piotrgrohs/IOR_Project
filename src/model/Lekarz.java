package model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@PrimaryKeyJoinColumn(name="LEKARZ_ID", foreignKey = @ForeignKey(name = "FK_LEK_OS"))
public class Lekarz extends Osoba implements Serializable {
    private String specjalizacja;
    private String tytulNauk;

    @OneToMany
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinColumn(name="WIZYTA_ID",foreignKey = @ForeignKey(name = "FK_LEK_WIZ"))
    private Set<Wizyta> wizyty = new HashSet<>();

    public Set<Wizyta> getWizyty() {
        return wizyty;
    }

    public void setWizyty(Set<Wizyta> wizyty) {
        this.wizyty = wizyty;
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