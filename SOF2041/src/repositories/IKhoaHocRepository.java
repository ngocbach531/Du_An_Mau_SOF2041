
package repositories;

import java.util.ArrayList;
import model.KhoaHoc;


public interface IKhoaHocRepository extends IDBConnection{
    public ArrayList<KhoaHoc> getallKhoaHoc();
    
}
