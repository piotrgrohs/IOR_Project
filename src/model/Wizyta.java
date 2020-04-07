package model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Wizyta {
    private Timestamp data;
    private String typ;
    private int id;

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

    @Id
    @Column(name = "WIZYTA_ID")
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
        Wizyta wizyta = (Wizyta) o;
        return id == wizyta.id &&
                Objects.equals(data, wizyta.data) &&
                Objects.equals(typ, wizyta.typ);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, typ, id);
    }
}
