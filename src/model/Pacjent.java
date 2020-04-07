package model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Pacjent extends Osoba implements Serializable {
    private String nrKartyUbezp;

    @ManyToOne
    @JoinColumn(name = "WIZYTA_ID", foreignKey = @javax.persistence.ForeignKey(name = "FK_LEK_WIZ"))
    private Wizyta wizyta;


    public Pacjent(String nazwisko, String imie, String pesel) {
        super(nazwisko, imie, pesel);
    }

    public Pacjent() {

    }

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
}
