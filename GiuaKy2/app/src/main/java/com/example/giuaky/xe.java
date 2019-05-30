package com.example.giuaky;

public class xe {
    public int icon;
    public int maXe;
    public String tenXe;
    public String xuatXu;
    public String gia;

    public xe(int icon, int maXe, String tenXe, String xuatXu, String gia) {
        this.maXe = maXe;
        this.tenXe = tenXe;
        this.xuatXu = xuatXu;
        this.gia = gia;
        this.icon = icon;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public int getMaXe() {
        return maXe;
    }

    public void setMaXe(int maXe) {
        this.maXe = maXe;
    }

    public String getTenXe() {
        return tenXe;
    }

    public void setTenXe(String tenXe) {
        this.tenXe = tenXe;
    }

    public String getXuatXu() {
        return xuatXu;
    }

    public void setXuatXu(String xuatXu) {
        this.xuatXu = xuatXu;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }
}
