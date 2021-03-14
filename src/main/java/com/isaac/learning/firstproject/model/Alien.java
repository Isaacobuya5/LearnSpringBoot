package com.isaac.learning.firstproject.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Alien {

    @Id
    private int aid;

    @Column(name = "name", nullable = false)
    private String aname;

    @Column(name = "lang", nullable = false)
    private String lang;

    public Alien() {
        super();
        // track how many times object is created
        System.out.println("Object created");
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    @Override
    public String toString() {
        return "[aid=" + aid + ", aname=" + aname + ", lang=" + lang + "]";
    }
}
