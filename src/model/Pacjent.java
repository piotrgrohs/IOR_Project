package model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@PrimaryKeyJoinColumn(name="PACJENT_ID", foreignKey = @ForeignKey(name = "FK_PAC_OS"))
public class Pacjent extends Osoba implements Serializable {
    private String nrKartyUbezp;


    @OneToMany
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinColumn(name="WIZYTA_ID",foreignKey = @ForeignKey(name = "FK_PAC_WIZ"))
    private Set<Wizyta> wizyty = new HashSet<>();

    public Set<Wizyta> getWizyty() {
        return wizyty;
    }

    public void setWizyty(Set<Wizyta> wizyty) {
        this.wizyty = wizyty;
    }

    public Set<Wizyta> getWizyta(){
        return wizyty;
    }
    public void setWizyta(Set<Wizyta> wizyty){
        this.wizyty = wizyty;
    }

    public Pacjent(String nazwisko, String imie, String pesel) {
        super(nazwisko, imie, pesel);
    }

    public Pacjent() {}

    @Basic
    @Column(name = "nrKartyUbezp")
    public String getNrKartyUbezp() {
        return nrKartyUbezp;
    }

    public void setNrKartyUbezp(String nrKartyUbezp) {
        this.nrKartyUbezp = nrKartyUbezp;
    }
}
