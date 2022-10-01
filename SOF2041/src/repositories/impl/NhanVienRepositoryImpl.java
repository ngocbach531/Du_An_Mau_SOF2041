/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositories.impl;

import model.NhanVien;
import repositories.INhanvienRespository;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HA NGOC BACH
 */
public class NhanVienRepositoryImpl extends DBConnection implements INhanvienRespository {

    private Statement statement;
    private PreparedStatement psmt;
    private ResultSet rs;

    @Override
    public NhanVien getNVbyMaAndPass(String maNv, String password) {
        String querySql = "SELECT * FROM nhanvien WHERE manv = ? AND matkhau = ?";
        NhanVien nhanVien = null;
        //Mở kết nối
        con = openDbConnection();
        if (con != null) {
            try {
                int indexParam = 1;
                psmt = con.prepareStatement(querySql);
                psmt.setString(indexParam++, maNv);
                psmt.setString(indexParam++, password);

                rs = psmt.executeQuery();
                while (rs.next()) {
                    int indexValue = 1;
                    nhanVien = new NhanVien();
                    nhanVien.setManv(rs.getString(indexValue++));
                    nhanVien.setMatkhau(rs.getString(indexValue++));
                    nhanVien.setManv(rs.getString(indexValue++));
                    nhanVien.setVaitro(rs.getBoolean(indexValue++));
                }
            } catch (SQLException ex) {
                Logger.getLogger(NhanVienRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                closeConnection(con);
            }

        } else {
            System.out.println("Kết nối đến database thất bại");
        }

        return nhanVien;

    }

}
