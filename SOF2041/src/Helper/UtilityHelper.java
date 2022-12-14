/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper;

import static java.awt.Color.pink;
import static java.awt.Color.white;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author HA NGOC BACH
 */
public class UtilityHelper {

    public static String getXepLoai(double diem) {
        String xepLoai = "Xuất sắc";
        if (diem < 0) {
            xepLoai = "Chưa nhập điểm";

        } else if (diem < 3) {
            xepLoai = "Kém";

        } else if (diem < 5) {
            xepLoai = "Yếu";

        } else if (diem < 6.5) {

            xepLoai = "Trung bình";

        } else if (diem < 7.5) {
            xepLoai = "Khá";

        } else if (diem < 9) {
            xepLoai = "Giỏi";

        }
        return xepLoai;
    }

    /*
    1-10 kí tự
    a-z, A-Z, 0-9
     */
    public static boolean checkMaNV(JTextField txt) {
        txt.setBackground(white);
        String id = txt.getText();
        String rgx = "[a-zA-Z0-9]{3,15}";
        if (id.matches(rgx)) {
            return true;
        } else {
            txt.setBackground(pink);
            Helper.DialogHelper.alert(txt.getRootPane(), "Mã nhân viên phải có 3-15 kí tự\nchữ hoa, thường không dấu hoặc số.");
            return false;
        }
    }

    /*
    đúng 7 kí tự
    a-z, A-Z, 0-9
     */
    public static boolean checkMaNH(JTextField txt) {
        txt.setBackground(white);
        String id = txt.getText();
        String rgx = "[a-zA-Z0-9]{7}";
        if (id.matches(rgx)) {
            return true;
        } else {
            txt.setBackground(pink);
            Helper.DialogHelper.alert(txt.getRootPane(), "Mã người học phải có đúng 7 kí tự\nchữ thường, chữ hoa hoặc số");
            return false;
        }
    }

    /*
    đúng 5 kí tự
    a-z, A-Z, 0-9
     */
    public static boolean checkMaCD(JTextField txt) {
        txt.setBackground(white);
        String id = txt.getText();
        String rgx = "[a-zA-Z0-9]{5}";
        if (id.matches(rgx)) {
            return true;
        } else {
            txt.setBackground(pink);
            Helper.DialogHelper.alert(txt.getRootPane(), "Mã chuyên đề phải có đúng 5 kí tự\nchữ thường, chữ hoa hoặc số");
            return false;
        }
    }

    //pass từ 3-16 kí tự
    public static boolean checkPass(JPasswordField txt) {
        txt.setBackground(white);
        if (txt.getPassword().length > 2 && txt.getPassword().length < 17) {
            return true;
        } else {
            txt.setBackground(pink);
            Helper.DialogHelper.alert(txt.getRootPane(), "Mật khẩu phải có từ 3-16 kí tự.");
            return false;
        }
    }

    public static boolean isValidDate(String inDate) {

        if (inDate == null) {
            return false;
        }

        //set the format to use as a constructor argument
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        if (inDate.trim().length() != dateFormat.toPattern().length()) {
            return false;
        }

        dateFormat.setLenient(false);

        try {
            //parse the inDate parameter
            dateFormat.parse(inDate.trim());
        } catch (ParseException pe) {
            pe.printStackTrace();
            return false;
        }
        return true;
    }

    public static boolean checkDate(JTextField txt) {
        txt.setBackground(white);
        String id = txt.getText();
        if (isValidDate(id)) {
            return true;
        } else {
            txt.setBackground(pink);
            Helper.DialogHelper.alert(txt.getRootPane(), "Ngày không đúng định dạng dd/MM/yyyy");
            return false;
        }
    }

    //gồm các ký tự chữ đấu cách
    //từ 3-25 kí tự
    public static boolean checkName(JTextField txt) {
        txt.setBackground(white);
        String id = txt.getText();
        String rgx = "^[A-Za-zÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚÝàáâãèéêìíòóôõùúýĂăĐđĨĩŨũƠơƯưẠ-ỹ ]{3,25}$";
        if (id.matches(rgx)) {
            return true;
        } else {
            txt.setBackground(pink);
            Helper.DialogHelper.alert(txt.getRootPane(), "Họ tên phải là tên tiếng việt hoặc không đấu\ntừ 3-25 kí tự");
            return false;
        }
    }

    //bất kì kí tự nào
    //từ 3-50 kí tự
    public static boolean checkTenCD(JTextField txt) {
        txt.setBackground(white);
        String id = txt.getText();
        String rgx = ".{3,50}";
        if (id.matches(rgx)) {
            return true;
        } else {
            txt.setBackground(pink);
            Helper.DialogHelper.alert(txt.getRootPane(), "Tên chuyên đề phải từ 3-50 kí tự.");
            return false;
        }
    }

    //bất kì kí tự nào
    //từ 3-255 kí tự
    public static boolean checkMoTaCD(JTextArea txt) {
        txt.setBackground(white);
        String id = txt.getText();
        String rgx = ".{3,255}";
        if (id.matches(rgx)) {
            return true;
        } else {
            txt.setBackground(pink);
            Helper.DialogHelper.alert(txt.getRootPane(), "Mô tả phải từ 3-255 kí tự.");
            return false;
        }
    }

    //gồm 10 số 
    //các đầu 3 số của nhà mạng
    public static boolean checkSDT(JTextField txt) {
        txt.setBackground(white);
        String id = txt.getText();
        String rgx = "(086|096|097|098|032|033|034|035|036|037|038|039|089|090|093|070|079|077|078|076|088|091|094|083|084|085|081|082|092|056|058|099|059)[0-9]{7}";
        if (id.matches(rgx)) {
            return true;
        } else {
            txt.setBackground(pink);
            Helper.DialogHelper.alert(txt.getRootPane(), "SĐT phải gồm 10 số\nđúng các đầu số của nhà mạng.");
            return false;
        }
    }

    public static boolean checkEmail(JTextField txt) {
        txt.setBackground(white);
        String id = txt.getText();
        String rgx = "^[a-zA-Z][a-zA-Z0-9_\\.]{2,32}@[a-zA-Z0-9]{2,10}(\\.[a-zA-Z0-9]{2,4}){1,2}$";
        if (id.matches(rgx)) {
            return true;
        } else {
            txt.setBackground(pink);
            Helper.DialogHelper.alert(txt.getRootPane(), "Email không đúng định dạng");
            return false;
        }
    }

    //gio là int >0
    public static boolean checkThoiLuong(JTextField txt) {
        txt.setBackground(white);
        try {
            int hour = Integer.parseInt(txt.getText());
            if (hour >= 0) {
                return true;
            } else {
                txt.setBackground(pink);
                Helper.DialogHelper.alert(txt.getRootPane(), "Thời lượng phải lớn hơn bằng 0.");
                return false;
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            txt.setBackground(pink);
            Helper.DialogHelper.alert(txt.getRootPane(), "Thời lượng phải là số nguyên.");
            return false;
        }
    }

//học phí là float >0
    public static boolean checkHocPhi(JTextField txt) {
        txt.setBackground(white);
        try {
            float hp = Float.parseFloat(txt.getText());
                if (hp >= 0) {
                    return true;
                } else {
                    txt.setBackground(pink);
                    Helper.DialogHelper.alert(txt.getRootPane(), "Học phí phải là lớn hơn bằng 0.");
                    return false;
                }
         
        } catch (NumberFormatException e) {
            e.printStackTrace();
            txt.setBackground(pink);
            Helper.DialogHelper.alert(txt.getRootPane(), "Học phí phải là số thực.");
            return false;
        }
    }

    public static boolean checkDiem(JTextField txt) {
        txt.setBackground(white);
        try {
            float hp = Float.parseFloat(txt.getText());
            if ((hp >= 0 && hp <= 10) || hp == -1) {
                return true;
            } else {
                txt.setBackground(pink);
                Helper.DialogHelper.alert(txt.getRootPane(), "Điểm phải là trong khoảng 0-10 hoặc chưa nhập (-1).");
                return false;
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            txt.setBackground(pink);
            Helper.DialogHelper.alert(txt.getRootPane(), "Điểm phải là số thực.");
            return false;
        }
    }

    public static boolean checkNullText(JTextField txt) {
        txt.setBackground(white);
        if (txt.getText().trim().length() > 0) {
            return true;
        } else {
            txt.setBackground(pink);
            Helper.DialogHelper.alert(txt.getRootPane(), "Không được để trống " + txt.getName());
            return false;
        }
    }

    public static boolean checkNullText(JTextArea txt) {
        txt.setBackground(white);
        if (txt.getText().trim().length() > 0) {
            return true;
        } else {
            txt.setBackground(pink);
            Helper.DialogHelper.alert(txt.getRootPane(), "Không được để trống " + txt.getName());
            return false;
        }
    }

    public static boolean checkNullPass(JPasswordField txt) {
        txt.setBackground(white);
        if (txt.getPassword().length > 0) {
            return true;
        } else {
            txt.setBackground(pink);
            Helper.DialogHelper.alert(txt.getRootPane(), "Không được để trống " + txt.getName());
            return false;
        }
    }

    public static boolean checkSoThoiLuong(JTextField txt) {
        String input = txt.getText();
        String rgx = "[0-9]+";
        if (input.matches(rgx)) {
            return true;
        } else {
//            txt.setBackground(pink);
            Helper.DialogHelper.alert(null, txt.getName() + " là số nguyên !");
            return false;
        }
    }
    
    public static boolean checkSoHocPhi(JTextField txt) {
        String input = txt.getText();
        String rgx = "[0-9]+.[0-9]";
        if (input.matches(rgx)) {
            return true;
        } else {
//            txt.setBackground(pink);
            Helper.DialogHelper.alert(null, txt.getName() + " là số thực !");
            return false;
        }
    }

    public static boolean checkSo1(String input) {
//        String input = txt.getText();
        String rgx = "[0-9]+";
        if (input.matches(rgx)) {
            return true;
        } else {
//            txt.setBackground(pink);
            Helper.DialogHelper.alert(null, "Điểm là số không phải chữ hoặc ký tự !");
            return false;
        }
    }
}
