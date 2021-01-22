package com.rauln.proiect;

public class MyListClass {
    private String itemname;
    private String descitem;

    public MyListClass() {
    }

    public MyListClass(String itemname, String descitem) {
        this.itemname = itemname;
        this.descitem = descitem;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public String getDescitem() {
        return descitem;
    }

    public void setDescitem(String descitem) {
        this.descitem = descitem;
    }
}
