package repositories.implement;

import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import model.ChuyenDe;
import repositories.IChuyenDeRespository;
import java.sql.*;
import java.util.ArrayList;

public class ChuyenDeRespositoryImplement extends DBConnection implements IChuyenDeRespository {

    private Statement statement;
    private PreparedStatement ps;
    private ResultSet rs;

    @Override
    public ArrayList<ChuyenDe> getallChuyenDe() {
        ArrayList<ChuyenDe> listCd = new ArrayList<>();
        String query = "SELECT * FROM CHUYENDE";

        //Mở kết nối
        con = openDbConnection();
        if (con != null) {
            try {
                int indexParam = 1;
                ps = con.prepareStatement(query);

                rs = ps.executeQuery();
                while (rs.next()) {
                    int indexValue = 1;
                    ChuyenDe cd = new ChuyenDe();
                    cd.setMachuyende(rs.getString(indexValue++));
                    cd.setTenchuyende(rs.getString(indexValue++));
                    cd.setHocphi(rs.getDouble(indexValue++));
                    cd.setThoiluong(rs.getInt(indexValue++));
                    cd.setHinh(rs.getString(indexValue++));
                    cd.setMota(rs.getString(indexValue++));

                    listCd.add(cd);
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            } finally {
                closeConnection(con);
            }

        } else {
            System.out.println("Kết nối đến database thất bại");
        }

        return listCd;
    }

    @Override
    public ChuyenDe finById(String macd) {
        ChuyenDe cd = null;
        String query = "SELECT * FROM CHUYENDE WHERE macd = ?";

        //Mở kết nối
        con = openDbConnection();
        if (con != null) {
            try {
                int indexParam = 1;
                ps = con.prepareStatement(query);
                ps.setString(indexParam++, macd);
                rs = ps.executeQuery();
                while (rs.next()) {
                    int indexValue = 1;
                    cd = new ChuyenDe();
                    cd.setMachuyende(rs.getString(indexValue++));
                    cd.setTenchuyende(rs.getString(indexValue++));
                    cd.setHocphi(rs.getDouble(indexValue++));
                    cd.setThoiluong(rs.getInt(indexValue++));
                    cd.setHinh(rs.getString(indexValue++));
                    cd.setMota(rs.getString(indexValue++));

                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            } finally {
                closeConnection(con);
            }

        } else {
            System.out.println("Kết nối đến database thất bại");
        }

        return cd;
    }

}
