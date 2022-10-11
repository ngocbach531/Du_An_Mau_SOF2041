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
                ps = con.prepareStatement(query);
                rs = ps.executeQuery();
                while (rs.next()) {
                listCd.add(new ChuyenDe(rs.getNString(1), rs.getNString(2), rs.getDouble(3), rs.getInt(4), rs.getNString(5), rs.getNString(6)));
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
    public ChuyenDe finByMaCd(String macd) {
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
                    ChuyenDe Cd = new ChuyenDe();
                    Cd.setMachuyende(rs.getNString(indexValue++));
                    Cd.setTenchuyende(rs.getString(indexValue++));
                    Cd.setThoiluong(rs.getInt(indexValue++));
                    Cd.setHocphi(rs.getDouble(indexValue++));
                    Cd.setHinh(rs.getNString(indexValue++));
                    Cd.setMota(rs.getString(indexValue++));
                };
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

    @Override
    public ChuyenDe xoaChuyenDe(String macd) {
        ChuyenDe cd = null;
        String query = "DELETE FROM CHUYENDE WHERE macd = ?";

        //Mở kết nối
        con = openDbConnection();
        if (con != null) {
            try {
                int indexParam = 1;
                ps = con.prepareStatement(query);
                cd = new ChuyenDe();
                cd.setMachuyende(macd);
                ps.executeUpdate();
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

    @Override
    public boolean ThemChuyenDe(ChuyenDe cd) {
        int check = 0;
        String query = "INSERT INTO [dbo].[CHUYENDE]\n"
                + "           ([MACD]\n"
                + "           ,[TENCD]\n"
                + "           ,[HOCPHI]\n"
                + "           ,[THOILUONG]\n"
                + "           ,[HINH]\n"
                + "           ,[MOTA])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?,?)";

        //Mở kết nối
        con = openDbConnection();
        try {
            ps = con.prepareStatement(query);
            ps.setObject(1, cd.getMachuyende());
            ps.setObject(2, cd.getTenchuyende());
            ps.setObject(3, cd.getHocphi());
            ps.setObject(4, cd.getThoiluong());
            ps.setObject(5, cd.getHinh());
            ps.setObject(6, cd.getMota());
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            closeConnection(con);
        }

        return check > 0;
    }

    @Override
    public ChuyenDe SuaChuyenDe(ChuyenDe Cd, String Macd) {
        ChuyenDe cd = null;
        String query = "UPDATE [dbo].[CHUYENDE]\n"
                + "   SET [MACD] = ?\n"
                + "      ,[TENCD] = ?\n"
                + "      ,[HOCPHI] = ?\n"
                + "      ,[THOILUONG] = ?\n"
                + "      ,[HINH] = ?\n"
                + "      ,[MOTA] = ?\n"
                + " WHERE <MACD = ?";

        //Mở kết nối
        con = openDbConnection();
        if (con != null) {
            try {
                int indexParam = 1;
                ps = con.prepareStatement(query);
                ps.setString(indexParam++, Macd);
                rs = ps.executeQuery();
               while (rs.next()) {
                    int indexValue = 1;
                    Cd.setMachuyende(rs.getNString(indexValue++));
                    Cd.setTenchuyende(rs.getString(indexValue++));
                    Cd.setThoiluong(rs.getInt(indexValue++));
                    Cd.setHocphi(rs.getDouble(indexValue++));
                    Cd.setHinh(rs.getNString(indexValue++));
                    Cd.setMota(rs.getString(indexValue++));
                };
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
