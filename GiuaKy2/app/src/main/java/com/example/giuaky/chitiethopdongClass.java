package com.example.giuaky;

public class chitiethopdongClass {
    int soHD;
    int maXe;
//    String tenKH;
//    String ngayHD;
    int songaythue;
    int gia;

    public chitiethopdongClass(int soHD, int maXe, int songaythue, int gia) {
        this.soHD = soHD;
        this.maXe = maXe;
//        this.tenKH = tenKH;
//        this.ngayHD = ngayHD;
        this.songaythue = songaythue;
        this.gia = gia;
    }

    public int getSoHD() {
        return soHD;
    }

    public void setSoHD(int soHD) {
        this.soHD = soHD;
    }

    public int getMaXe() {
        return maXe;
    }

    public void setMaXe(int maXe) {
        this.maXe = maXe;
    }

//    public String getTenKH() {
//        return tenKH;
//    }
//
//    public void setTenKH(String tenKH) {
//        this.tenKH = tenKH;
//    }
//
//    public String getNgayHD() {
//        return ngayHD;
//    }

//    public void setNgayHD(String ngayHD) {
//        this.ngayHD = ngayHD;
//    }

    public int getSongaythue() {
        return songaythue;
    }

    public void setSongaythue(int songaythue) {
        this.songaythue = songaythue;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }
}
