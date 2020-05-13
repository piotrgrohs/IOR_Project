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

    @OneToMany
    private Set<Zabieg> zabieg = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "LEKARZ_ID", foreignKey = @javax.persistence.ForeignKey(name = "FK_WIZ_LEK"))
    private Lekarz lekarz;

    @ManyToOne
    @JoinColumn(name = "PACJENT_ID", foreignKey = @javax.persistence.ForeignKey(name = "FK_WIZ_PAC"))
    private Pacjent pacjent;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "WIZYTA_ID")
    private int id;

    @OneToOne
    @JoinColumn(name = "CENNIK_ID", foreignKey = @ForeignKey(name = "FK_WIZ_CEN"))
    private Cennik cennik;

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

    public Lekarz getLekarz() {
        return lekarz;
    }

    public void setLekarz(Lekarz lekarz) {
        this.lekarz = lekarz;
    }

    public Pacjent getPacjent() {
        return pacjent;
    }

    public void setPacjent(Pacjent pacjent) {
        this.pacjent = pacjent;
    }

    public Set<Zabieg> getZabieg() {
        return zabieg;
    }

    public void setZabieg(Set<Zabieg> zabieg) {
        this.zabieg = zabieg;
    }

    public Cennik getCennik() {
        return cennik;
    }

    public void setCennik(Cennik cennik) {
        this.cennik = cennik;
    }
}

