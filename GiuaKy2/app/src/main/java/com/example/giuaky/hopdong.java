package com.example.giuaky;

public class hopdong {
    int sohd;
    String ngayhd;
    int makh;

    public hopdong(int sohd, String ngayhd, int makh) {
        this.sohd = sohd;
        this.ngayhd = ngayhd;
        this.makh = makh;
    }

    public int getSohd() {
        return sohd;
    }

    public int getMakh() {
        return makh;
    }

    public void setMakh(int makh) {
        this.makh = makh;
    }

    public void setSohd(int sohd) {
        this.sohd = sohd;
    }

    public String getNgayhd() {
        return ngayhd;
    }

    public void setNgayhd(String ngayhd) {
        this.ngayhd = ngayhd;
    }
}
