package model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Cennik {
    private String kwota;
    private String opis;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "CENNIK_ID")
    private int id;

    @OneToOne
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "WIZYTA_ID", foreignKey = @ForeignKey(name = "FK_CEN_WIZ"))
    private Wizyta wizyta;

    public Cennik(String kwota,String opis) {
        this.kwota = kwota;
        this.opis = opis;
    }

    public Wizyta getWizyta() {
        return wizyta;
    }

    public void setWizyta(Wizyta wizyta) {
        this.wizyta = wizyta;
    }

    @Basic
    @Column(name = "KWOTA")
    public String getKwota() {
        return kwota;
    }

    public void setKwota(String kwota) {
        this.kwota = kwota;
    }

    @Basic
    @Column(name = "OPIS")
    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
