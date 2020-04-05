package model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Pacjent extends Osoba implements Serializable {
    private String nrKartyUbezp;
    private int id;
    private Wizyta wizyta;

    public Pacjent(String nazwisko, String imie, String pesel) {
        super(nazwisko, imie, pesel);
    }

    @ManyToOne
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinColumn(name="WIZYTA_ID",foreignKey = @javax.persistence.ForeignKey(name = "FK_LEK_WIZ"))
    public Wizyta getWizyta() {
        return wizyta;
    }

    public void setWizyta(Wizyta wizyta) {
        this.wizyta = wizyta;
    }

    @Basic
    @Column(name = "nrKartyUbezp")
    public String getNrKartyUbezp() {
        return nrKartyUbezp;
    }

    public void setNrKartyUbezp(String nrKartyUbezp) {
        this.nrKartyUbezp = nrKartyUbezp;
    }

    @Id
    @Column(name = "PACJENT_ID")
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
        Pacjent pacjent = (Pacjent) o;
        return id == pacjent.id &&
                Objects.equals(nrKartyUbezp, pacjent.nrKartyUbezp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nrKartyUbezp, id);
    }
}
