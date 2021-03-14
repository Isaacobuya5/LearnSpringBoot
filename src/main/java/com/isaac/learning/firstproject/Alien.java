package com.isaac.learning.firstproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
//@Scope(value = "prototype")
public class Alien {

    private int aid;
    private String aname;
    private String lang;

//    @Autowired
//    private Laptop laptop;

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
//
//    public Laptop getLaptop() {
//        return laptop;
//    }
//
//    public void setLaptop(Laptop laptop) {
//        this.laptop = laptop;
//    }

//    public void showObject() {
//        System.out.println("Show object");
//        laptop.compile();
//    }
}
