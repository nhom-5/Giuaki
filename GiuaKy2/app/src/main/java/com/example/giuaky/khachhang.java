package com.example.giuaky;

public class khachhang {
    int makh;
    String tenkh;
    int sdt;

    public int getMakh() {
        return makh;
    }

    public void setMakh(int makh) {
        this.makh = makh;
    }

    public String getTenkh() {
        return tenkh;
    }

    public void setTenkh(String tenkh) {
        this.tenkh = tenkh;
    }

    public int getSdt() {
        return sdt;
    }

    public void setSdt(int sdt) {
        this.sdt = sdt;
    }

    khachhang(int makh, String tenkh, int sdt) {
        this.makh = makh;
        this.tenkh = tenkh;
        this.sdt = sdt;
    }
}
