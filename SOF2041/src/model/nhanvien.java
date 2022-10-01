
package model;

public class NhanVien {
    private String manv;
    private String matkhau;
    private String hoten;
    private boolean vaitro;

    public NhanVien() {
    }

    public NhanVien(String manv, String matkhau, String hoten, boolean vaitro) {
        this.manv = manv;
        this.matkhau = matkhau;
        this.hoten = hoten;
        this.vaitro = vaitro;
    }

    public NhanVien(String manv, String matkhau) {
        this.manv = manv;
        this.matkhau = matkhau;
    }
    
    

    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public boolean isVaitro() {
        return vaitro;
    }

    public void setVaitro(boolean vaitro) {
        this.vaitro = vaitro;
    }

    @Override
    public String toString() {
        return "nhanvien{" + "manv=" + manv + ", matkhau=" + matkhau + ", hoten=" + hoten + ", vaitro=" + vaitro + '}';
    }
    
    
}
