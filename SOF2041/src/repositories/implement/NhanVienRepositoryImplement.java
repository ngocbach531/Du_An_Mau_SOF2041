/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositories.implement;

import model.NhanVien;
import repositories.INhanvienRespository;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HA NGOC BACH
 */
public class NhanVienRepositoryImplement extends DBConnection implements INhanvienRespository {

    private Statement statement;
    private PreparedStatement ps;
    private ResultSet rs;

    @Override
    public NhanVien getNVbyMaAndPass(String maNv, String password) {
        String query = "SELECT * FROM nhanvien WHERE manv = ? AND matkhau = ?";
        NhanVien nv = null;
        //Mở kết nối
        con = openDbConnection();
        if (con != null) {
            try {
                int indexParam = 1;
                ps = con.prepareStatement(query);
                ps.setString(indexParam++, maNv);
                ps.setString(indexParam++, password);

                rs = ps.executeQuery();
                while (rs.next()) {
                    int indexValue = 1;
                    nv = new NhanVien();
                    nv.setManv(rs.getString(indexValue++));
                    nv.setMatkhau(rs.getString(indexValue++));
                    nv.setManv(rs.getString(indexValue++));
                    nv.setVaitro(rs.getBoolean(indexValue++));
                }
            } catch (SQLException ex) {
                Logger.getLogger(NhanVienRepositoryImplement.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                closeConnection(con);
            }

        } else {
            System.out.println("Kết nối đến database thất bại");
        }

        return nv;

    }

}
