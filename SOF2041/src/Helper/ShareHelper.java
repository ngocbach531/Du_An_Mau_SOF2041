/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper;

import javax.swing.ImageIcon;
import model.NhanVien;


public class ShareHelper {

    public static final java.awt.Image APP_ICON;
    public static final ImageIcon APP_ICON_1;

    static {
        // Tải biểu tượng ứng dụng 
        //CÁCH TẢI ẢNH TỪ TRONG PROJECT
        //icon là thư mục con của src
        String file = "/Icon/logo.png";      //icon là thư mục con của src
        APP_ICON = new ImageIcon(ShareHelper.class.getResource(file)).getImage();
        APP_ICON_1 = new ImageIcon(ShareHelper.class.getResource(file));
    }
    public static NhanVien USER = null;

    public static void clear() {
        USER = null;
    }

    public static boolean isLogin() {
        return USER != null;
    }

    public static boolean isManager() {
        return isLogin() && USER.isVaitro();
    }

    public static boolean authenticated() {
        return ShareHelper.USER != null;
    }
}
