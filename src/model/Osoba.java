package model;

import javax.persistence.*;

@Entity

@Inheritance(strategy= InheritanceType.JOINED)
@Table(name="OSOBY")
public class Osoba {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String imie;
    private String nazwisko;
    private String PESEL;

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getPESEL() {
        return PESEL;
    }

    public void setPESEL(String PESEL) {
        this.PESEL = PESEL;
    }

    public Osoba(String imie, String nazwisko, String PESEL) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.PESEL = PESEL;
    }
}
