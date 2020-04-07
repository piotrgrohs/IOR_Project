package model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Cennik {
    private String kwota;
    private String opis;
    private int id;

    @ManyToOne
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinColumn(name="WIZYTA_ID",foreignKey = @ForeignKey(name = "FK_CEN_WIZ"))
    private Wizyta wizyta;

    public Wizyta getWizyta() {
        return wizyta;
    }

    public void setWizyta(Wizyta wizyta) {
        this.wizyta = wizyta;
    }

    @Basic
    @Column(name = "kwota")
    public String getKwota() {
        return kwota;
    }

    public void setKwota(String kwota) {
        this.kwota = kwota;
    }

    @Basic
    @Column(name = "opis")
    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    @Id
    @Column(name = "id")
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
        Cennik cennik = (Cennik) o;
        return id == cennik.id &&
                Objects.equals(kwota, cennik.kwota) &&
                Objects.equals(opis, cennik.opis);
    }

    @Override
    public int hashCode() {
        return Objects.hash(kwota, opis, id);
    }
}
