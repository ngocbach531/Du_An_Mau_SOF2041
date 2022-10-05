/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositories.implement;

import java.util.ArrayList;
import model.KhoaHoc;
import repositories.IKhoaHocRepository;
import java.sql.*;

/**
 *
 * @author HA NGOC BACH
 */
public class KhoaHocRepositoryImplement extends DBConnection implements IKhoaHocRepository {

    private Statement statement;
    private PreparedStatement ps;
    private ResultSet rs;
    @Override
    public ArrayList<KhoaHoc> getallKhoaHoc() {
        ArrayList<KhoaHoc> listKh = new ArrayList<>();
        String query = "SELECT * FROM KHOAHOC";

        //Mở kết nối
        con = openDbConnection();
        if (con != null) {
            try {
                int indexParam = 1;
                ps = con.prepareStatement(query);

                rs = ps.executeQuery();
                while (rs.next()) {
                    int indexValue = 1;
                    KhoaHoc Kh = new KhoaHoc();
                    Kh.setMakh(rs.getInt(indexValue++));
                    Kh.setMachuyende(rs.getString(indexValue++));
                    Kh.setHocphi(rs.getDouble(indexValue++));
                    Kh.setThoiluong(rs.getInt(indexValue++));
                    Kh.setNgaykhaigiang(rs.getDate(indexValue++));
                    Kh.setGhichu(rs.getString(indexValue++));
                    Kh.setManv(rs.getString(indexValue++));
                    Kh.setNgaytao(rs.getDate(indexValue++));

                    listKh.add(Kh);
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            } finally {
                closeConnection(con);
            }

        } else {
            System.out.println("Kết nối đến database thất bại");
        }

        return listKh;
    }
    
}
