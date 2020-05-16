package model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Adres {
    private String kod;
    private String miejscowosc;
    private String ulica;
    private Integer nrDomu;
    private Integer nrMieszkania;
    private int id;

    public Adres(){}

    public Adres(String kod, String miejscowosc, String ulica, Integer nrDomu,Integer nrMieszkania) {
        this.kod = kod;
        this.miejscowosc = miejscowosc;
        this.ulica = ulica;
        this.nrDomu = nrDomu;
        this.nrMieszkania = nrMieszkania;
    }


    @Basic
    @Column(name = "KOD")
    public String getKod() {
        return kod;
    }

    public void setKod(String kod) {
        this.kod = kod;
    }

    @Basic
    @Column(name = "MIEJSOWOSC")
    public String getMiejscowosc() {
        return miejscowosc;
    }

    public void setMiejscowosc(String miejscowosc) {
        this.miejscowosc = miejscowosc;
    }

    @Basic
    @Column(name = "ULICA")
    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    @Basic
    @Column(name = "NRDOMU")
    public Integer getNrDomu() {
        return nrDomu;
    }

    public void setNrDomu(Integer nrDomu) {
        this.nrDomu = nrDomu;
    }

    @Basic
    @Column(name = "NRMIESZKANIA")
    public Integer getNrMieszkania() {
        return nrMieszkania;
    }

    public void setNrMieszkania(Integer nrMieszkania) {
        this.nrMieszkania = nrMieszkania;
    }

    @Id
    @Column(name = "ADRES_ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Adres adres = (Adres) o;
        return id == adres.id &&
                Objects.equals(kod, adres.kod) &&
                Objects.equals(miejscowosc, adres.miejscowosc) &&
                Objects.equals(ulica, adres.ulica) &&
                Objects.equals(nrDomu, adres.nrDomu) &&
                Objects.equals(nrMieszkania, adres.nrMieszkania);
    }

    @Override
    public int hashCode() {
        return Objects.hash(kod, miejscowosc, ulica, nrDomu, nrMieszkania, id);
    }
}
