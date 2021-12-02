package com.example.learningfun.Model;

public class TT {
    private String hoten;
    private String email;
    private String ngaySinh;
    private String sdt;

    public TT() {
    }

    public TT(String hoten, String email, String ngaySinh, String sdt) {
        this.hoten = hoten;
        this.email = email;
        this.ngaySinh = ngaySinh;
        this.sdt = sdt;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }
}
