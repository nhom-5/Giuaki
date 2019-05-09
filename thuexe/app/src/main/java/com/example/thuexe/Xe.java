package com.example.thuexe;

public class Xe {
    public int icon;
    public String title1;
    public String title2;
    public String title3;
    public Xe(){super();}

    public Xe(int icon, String title1, String title2, String title3) {
        this.icon = icon;
        this.title1 = title1;
        this.title2 = title2;
        this.title3 = title3;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getTitle1() {
        return title1;
    }

    public void setTitle1(String title1) {
        this.title1 = title1;
    }

    public String getTitle2() {
        return title2;
    }

    public void setTitle2(String title2) {
        this.title2 = title2;
    }

    public String getTitle3() {
        return title3;
    }

    public void setTitle3(String title3) {
        this.title3 = title3;
    }
}
