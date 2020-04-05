package model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Osoba {
    private int id;
    private String nazwisko;
    private String imie;
    private String pesel;
    private Adres adres;

    public void setAdres(Adres adres) {
        this.adres = adres;
    }

    @ManyToOne
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinColumn(name="ADRES_ID",foreignKey = @javax.persistence.ForeignKey(name = "FK_OS_AD"))
    public Adres getAdres() {
        return adres;
    }

    public Osoba(String nazwisko, String imie, String pesel) {
        this.nazwisko = nazwisko;
        this.imie = imie;
        this.pesel = pesel;
    }

    @Id
    @Column(name = "ID_OSOBY")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    @Basic
    @Column(name = "NAZWISKO")
    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    @Basic
    @Column(name = "IMIE")
    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    @Basic
    @Column(name = "PESEL")
    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Osoba osoba = (Osoba) o;
        return id == osoba.id &&
                Objects.equals(nazwisko, osoba.nazwisko) &&
                Objects.equals(imie, osoba.imie) &&
                Objects.equals(pesel, osoba.pesel);
    }


    @Override
    public int hashCode() {
        return Objects.hash(id, nazwisko, imie, pesel);
    }
}
