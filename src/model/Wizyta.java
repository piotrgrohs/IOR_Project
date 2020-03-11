package model;

import java.util.Calendar;

public class Wizyta {
    private Calendar data;
    private String typ;

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public Wizyta(Calendar data, String typ) {
        this.data = data;
        this.typ = typ;
    }
}
