package repositories;

import java.util.ArrayList;
import model.NhanVien;
import java.sql.*;

public interface INhanvienRespository extends IDBConnection{

    public NhanVien getNVbyMaAndPass(String maNv, String password);
}
