
package model;

public class hocvien {
    private String mahv;
    private String makh;
    private String manh;
    private Double diem;

    public hocvien() {
    }

    public hocvien(String mahv, String makh, String manh, Double diem) {
        this.mahv = mahv;
        this.makh = makh;
        this.manh = manh;
        this.diem = diem;
    }

    public String getMahv() {
        return mahv;
    }

    public void setMahv(String mahv) {
        this.mahv = mahv;
    }

    public String getMakh() {
        return makh;
    }

    public void setMakh(String makh) {
        this.makh = makh;
    }

    public String getManh() {
        return manh;
    }

    public void setManh(String manh) {
        this.manh = manh;
    }

    public Double getDiem() {
        return diem;
    }

    public void setDiem(Double diem) {
        this.diem = diem;
    }

    @Override
    public String toString() {
        return "hocvien{" + "mahv=" + mahv + ", makh=" + makh + ", manh=" + manh + ", diem=" + diem + '}';
    }
    
    
}
