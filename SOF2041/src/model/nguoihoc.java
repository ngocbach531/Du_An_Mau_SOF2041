
package model;

import java.util.Date;

public class NguoiHoc {
    private String manh;
    private String hoten;
    private Date ngaysinh;
    private boolean gioitinh;
    private String dienthoai;
    private String email;
    private String ghichu;
    private String manv;
    private Date ngaydki;

    public NguoiHoc() {
    }

    public NguoiHoc(String manh, String hoten, Date ngaysinh, boolean gioitinh, String dienthoai, String email, String ghichu, String manv, Date ngaydki) {
        this.manh = manh;
        this.hoten = hoten;
        this.ngaysinh = ngaysinh;
        this.gioitinh = gioitinh;
        this.dienthoai = dienthoai;
        this.email = email;
        this.ghichu = ghichu;
        this.manv = manv;
        this.ngaydki = ngaydki;
    }

    public String getManh() {
        return manh;
    }

    public void setManh(String manh) {
        this.manh = manh;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public Date getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(Date ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public boolean isGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(boolean gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getDienthoai() {
        return dienthoai;
    }

    public void setDienthoai(String dienthoai) {
        this.dienthoai = dienthoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Date getNgaydki() {
        return ngaydki;
    }

    public void setNgaydki(Date ngaydki) {
        this.ngaydki = ngaydki;
    }

    @Override
    public String toString() {
        return "nguoihoc{" + "manh=" + manh + ", hoten=" + hoten + ", ngaysinh=" + ngaysinh + ", gioitinh=" + gioitinh + ", dienthoai=" + dienthoai + ", email=" + email + ", ghichu=" + ghichu + ", manv=" + manv + ", ngaydki=" + ngaydki + '}';
    }
    
    
}
