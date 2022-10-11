/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;


public class ChuyenDe {
    private String machuyende;
    private String tenchuyende;
    private double hocphi;
    private int thoiluong;
    private String hinh;
    private String mota;

    public ChuyenDe() {
    }

    public ChuyenDe(String machuyende, String tenchuyende, double hocphi, int thoiluong, String hinh, String mota) {
        this.machuyende = machuyende;
        this.tenchuyende = tenchuyende;
        this.hocphi = hocphi;
        this.thoiluong = thoiluong;
        this.hinh = hinh;
        this.mota = mota;
    }

    public String getMachuyende() {
        return machuyende;
    }

    public void setMachuyende(String machuyende) {
        this.machuyende = machuyende;
    }

    public String getTenchuyende() {
        return tenchuyende;
    }

    public void setTenchuyende(String tenchuyende) {
        this.tenchuyende = tenchuyende;
    }

    public double getHocphi() {
        return hocphi;
    }

    public void setHocphi(double hocphi) {
        this.hocphi = hocphi;
    }

    public int getThoiluong() {
        return thoiluong;
    }

    public void setThoiluong(int thoiluong) {
        this.thoiluong = thoiluong;
    }

    public String getHinh() {
        return hinh;
    }

    public void setHinh(String hinh) {
        this.hinh = hinh;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    @Override
    public String toString() {
        return "chuyende{" + "machuyende=" + machuyende + ", tenchuyende=" + tenchuyende + ", hocphi=" + hocphi + ", thoiluong=" + thoiluong + ", hinh=" + hinh + ", mota=" + mota + '}';
    }
    
    
}
