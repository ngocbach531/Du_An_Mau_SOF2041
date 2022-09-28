package repositories;

import java.util.ArrayList;
import model.nhanvien;
import java.sql.*;

public class nhanvienRespository {

    public ArrayList<nhanvien> getall() {
        ArrayList<nhanvien> getnhanvien = new ArrayList<>();
        String query = "select * from nhanvien where MANV = ? and MATKHAU = ?";
        try(Connection con = DBConnection.openDbConnection()) {
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                getnhanvien.add(new nhanvien(rs.getString(1), rs.getString(1)));
            }
            return getnhanvien;
        } catch (Exception e) {
        }
        return null;
    }
}
