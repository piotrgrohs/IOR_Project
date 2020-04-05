package model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Usluga {
    private Double cena;
    private String opis;
    private Double rabat;
    private int id;

    @Basic
    @Column(name = "CENA")
    public Double getCena() {
        return cena;
    }

    public void setCena(Double cena) {
        this.cena = cena;
    }

    @Basic
    @Column(name = "OPIS")
    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    @Basic
    @Column(name = "RABAT")
    public Double getRabat() {
        return rabat;
    }

    public void setRabat(Double rabat) {
        this.rabat = rabat;
    }

    @Id
    @Column(name = "USLUGA_ID")
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
        Usluga usluga = (Usluga) o;
        return id == usluga.id &&
                Objects.equals(cena, usluga.cena) &&
                Objects.equals(opis, usluga.opis) &&
                Objects.equals(rabat, usluga.rabat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cena, opis, rabat, id);
    }
}
