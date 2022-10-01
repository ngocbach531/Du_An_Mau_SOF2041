
package model;

import java.util.Date;

public class KhoaHoc {
    private int makh;
    private String machuyende;
    private double hocphi;
    private int thoiluong;
    private Date ngaykhaigiang;
    private String ghichu;
    private String manv;
    private Date ngaytao;

    public KhoaHoc() {
    }

    public KhoaHoc(int makh, String machuyende, double hocphi, int thoiluong, Date ngaykhaigiang, String ghichu, String manv, Date ngaytao) {
        this.makh = makh;
        this.machuyende = machuyende;
        this.hocphi = hocphi;
        this.thoiluong = thoiluong;
        this.ngaykhaigiang = ngaykhaigiang;
        this.ghichu = ghichu;
        this.manv = manv;
        this.ngaytao = ngaytao;
    }

    public int getMakh() {
        return makh;
    }

    public void setMakh(int makh) {
        this.makh = makh;
    }

    public String getMachuyende() {
        return machuyende;
    }

    public void setMachuyende(String machuyende) {
        this.machuyende = machuyende;
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

    public Date getNgaykhaigiang() {
        return ngaykhaigiang;
    }

    public void setNgaykhaigiang(Date ngaykhaigiang) {
        this.ngaykhaigiang = ngaykhaigiang;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }

    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public Date getNgaytao() {
        return ngaytao;
    }

    public void setNgaytao(Date ngaytao) {
        this.ngaytao = ngaytao;
    }

    @Override
    public String toString() {
        return "khoahoc{" + "makh=" + makh + ", machuyende=" + machuyende + ", hocphi=" + hocphi + ", thoiluong=" + thoiluong + ", ngaykhaigiang=" + ngaykhaigiang + ", ghichu=" + ghichu + ", manv=" + manv + ", ngaytao=" + ngaytao + '}';
    }
    
    
}
