package model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Zabieg {
    private String nrZeba;
    private String opis;
    private int id;

    @ManyToOne
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinColumn(name="WIZYTA_ID",foreignKey = @ForeignKey(name = "FK_ZAB_WIZ"))
    private Wizyta wizyta;

    public Wizyta getWizyta() {
        return wizyta;
    }

    public void setWizyta(Wizyta wizyta) {
        this.wizyta = wizyta;
    }

    @Basic
    @Column(name = "NRZEBA")
    public String getNrZeba() {
        return nrZeba;
    }

    public void setNrZeba(String nrZeba) {
        this.nrZeba = nrZeba;
    }

    @Basic
    @Column(name = "OPIS")
    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    @Id
    @Column(name = "ZABIEG_ID")
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
        Zabieg zabieg = (Zabieg) o;
        return id == zabieg.id &&
                Objects.equals(nrZeba, zabieg.nrZeba) &&
                Objects.equals(opis, zabieg.opis);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nrZeba, opis, id);
    }



}
