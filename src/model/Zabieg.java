package model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Zabieg {
    private String nrZeba;
    private String opis;
    private int id;

    public Zabieg(){}

    public Zabieg(String nrZeba, String opis) {
        this.nrZeba = nrZeba;
        this.opis = opis;
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



}
