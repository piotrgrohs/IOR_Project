package model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Wizyta {
    private Timestamp data;
    private String typ;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "WIZYTA_ID")
    private int id;

    @OneToMany
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private Set<Cennik> cennik = new HashSet<>();

    @OneToMany
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinColumn(name="ZABIEG_ID",foreignKey = @ForeignKey(name = "FK_WIZ_ZAB"))
    private Set<Zabieg> zabiegi = new HashSet<>();

    @Basic
    @Column(name = "data")
    public Timestamp getData() {
        return data;
    }

    public void setData(Timestamp data) {
        this.data = data;
    }

    @Basic
    @Column(name = "typ")
    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<Zabieg> getZabiegi() {
        return zabiegi;
    }

    public void setZabiegi(Set<Zabieg> zabiegi) {
        this.zabiegi = zabiegi;
    }


    public Set<Cennik> getCennik() {
        return cennik;
    }

    public void setCennik(Set<Cennik> cennik) {
        this.cennik = cennik;
    }
}

