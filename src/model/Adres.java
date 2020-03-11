package model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="ADRES")
public class Adres implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ADRES_ID")
    private String kod;
    private String miejscowosc;
    private String ulica;
    private int nrDomu;
    private int nrMieszkania;

    public String getKod() {
        return kod;
    }

    public void setKod(String kod) {
        this.kod = kod;
    }

    public String getMiejscowosc() {
        return miejscowosc;
    }

    public void setMiejscowosc(String miejscowosc) {
        this.miejscowosc = miejscowosc;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public int getNrDomu() {
        return nrDomu;
    }

    public void setNrDomu(int nrDomu) {
        this.nrDomu = nrDomu;
    }

    public int getNrMieszkania() {
        return nrMieszkania;
    }

    public void setNrMieszkania(int nrMieszkania) {
        this.nrMieszkania = nrMieszkania;
    }

    public Adres(String kod, String miejscowosc, String ulica, int nrDomu, int nrMieszkania){
        this.kod = kod;
        this.miejscowosc = miejscowosc;
        this.ulica = ulica;
        this.nrDomu = nrDomu;
        this.nrMieszkania = nrMieszkania;

    }
}
