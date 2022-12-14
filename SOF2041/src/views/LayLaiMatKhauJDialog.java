/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import DAO.NhanVienDAO;
import Entity.NhanVien;
import Helper.ClockThread;
import Helper.DateHelper;
import Helper.DialogHelper;
import Helper.Image;
import Helper.UtilityHelper;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Properties;
import java.util.UUID;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import java.sql.*;
import java.time.LocalDateTime;

/**
 *
 * @author HA NGOC BACH
 */
public class LayLaiMatKhauJDialog extends javax.swing.JDialog {

    public LayLaiMatKhauJDialog(java.awt.Frame parent, boolean modal) {
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_email = new javax.swing.JTextField();
        btn_layMa = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btn_exit = new javax.swing.JButton();
        btn_login = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_tenDangNhap = new javax.swing.JTextField();
        btn_xacNhan = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_maEmail = new javax.swing.JTextField();
        txt_passNew = new javax.swing.JPasswordField();
        txt_xnPassNew = new javax.swing.JPasswordField();
        lbl_timeCapCha = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("EduSys - L???y l???i m???t kh???u");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        txt_email.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        btn_layMa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_layMa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Tick.png"))); // NOI18N
        btn_layMa.setText("L???y m??");
        btn_layMa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_layMaActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 51, 255));
        jLabel3.setText("L???y l???i m???t kh???u");

        btn_exit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Delete.png"))); // NOI18N
        btn_exit.setText("H???y b???");
        btn_exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_exitActionPerformed(evt);
            }
        });

        btn_login.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_login.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Key.png"))); // NOI18N
        btn_login.setText("????ng nh???p");
        btn_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_loginActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("T??n ????ng nh???p: ");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Email ????ng k??:");

        txt_tenDangNhap.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        btn_xacNhan.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_xacNhan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Accept.png"))); // NOI18N
        btn_xacNhan.setText("X??c nh???n");
        btn_xacNhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xacNhanActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("M?? x??c nh???n:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("M???t kh???u m???i:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("X??c nh???n m???t kh???u:");

        txt_maEmail.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txt_passNew.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txt_xnPassNew.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lbl_timeCapCha.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_timeCapCha.setForeground(new java.awt.Color(204, 0, 51));
        lbl_timeCapCha.setText("jLabel7");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_tenDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btn_layMa))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(txt_passNew, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txt_maEmail, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lbl_timeCapCha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btn_login, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btn_xacNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btn_exit))
                                    .addComponent(txt_xnPassNew))))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel3)
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_tenDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_layMa, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_maEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_timeCapCha))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_passNew, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txt_xnPassNew, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_exit)
                    .addComponent(btn_xacNhan))
                .addGap(18, 18, 18)
                .addComponent(btn_login)
                .addGap(13, 13, 13))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_layMaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_layMaActionPerformed
        //Kh???i t???o ph????ng th???c LocalDateTime()
        _LocalDateTime = LocalDateTime.now();
        //L???y th???i gian khi b???m n??t l???y m?? x??c nh???n
        _layMa = _LocalDateTime.getMinute() * 60 + _LocalDateTime.getSecond();
        //Check s??? t???n t???i c???a m?? nh??n vi??n
        NhanVien nv = _NhanVienDAO.findById(txt_tenDangNhap.getText());
        if (txt_tenDangNhap.getText().isEmpty() || txt_tenDangNhap.getText().isBlank() || txt_email.getText().isEmpty() || txt_email.getText().isBlank()) {
            Helper.DialogHelper.alert(this, "T??n ????ng nh???p v?? Email kh??ng ???????c ????? tr???ng !");
            return;
        }
        if (nv == null) {
            Helper.DialogHelper.alert(this, "Sai t??n ????ng nh???p !");
            return;
        }
        if (UtilityHelper.checkEmail(txt_email)) {

            try {
                //Ph????ng th???c random chu???i
                _uuid = UUID.randomUUID().toString().replace("-", "");
                //L???y m?? x??c nh???n g???m 6 k?? t???
                _capcha = _uuid.substring(0, 6);

                //Account v?? password mail g???i ??i
                final String username = "horsesoftware002@gmail.com";
                final String password = "HSoft002.";

                Properties prop = new Properties();
                prop.put("mail.smtp.host", "smtp.gmail.com");
                prop.put("mail.smtp.port", 587);
                prop.put("mail.smtp.auth", "true");
                prop.put("mail.smtp.starttls.enable", "true"); //TLS

                //????ng nh???p gmail
                Session session = Session.getInstance(prop,
                        new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

                try {

                    Message message = new MimeMessage(session);
                    message.setFrom(new InternetAddress("horsesoftware002@gmail.com"));
                    message.setRecipients(
                            Message.RecipientType.TO,
                            InternetAddress.parse(txt_email.getText())
                    );
                    //Ti??u ????? mail
                    message.setSubject("EduSys");

                    //N???i dung mail
                    String text = ("Ch??o b???n: " + txt_tenDangNhap.getText() + "\n  M?? kh??i ph???c l??: " + _capcha);
                    message.setContent(text, "text/html;charset=utf-8");
                    Transport.send(message);
                    DialogHelper.alert(this, "M?? kh??i ph???c ???? ???????c g???i v??? Email !");
                    lbl_timeCapCha.setVisible(true);
                    _clockThread = new ClockThread(lbl_timeCapCha);
                    _clockThread.start();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_btn_layMaActionPerformed

    private void btn_exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_exitActionPerformed
        if (Helper.DialogHelper.confirm(this, "B???n mu???n k???t th??c l??m vi???c ?")) {
            System.exit(0);
        }
    }//GEN-LAST:event_btn_exitActionPerformed

    private void btn_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_loginActionPerformed
        this.dispose();
        new DangNhapJDialog(null, true).setVisible(true);
    }//GEN-LAST:event_btn_loginActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed

    }//GEN-LAST:event_formWindowClosed

    private void btn_xacNhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xacNhanActionPerformed
        //Kh???i t???o ph????ng th???c LocalDateTime()
        _LocalDateTime = LocalDateTime.now();
        NhanVien nv = _NhanVienDAO.findById(txt_tenDangNhap.getText());
        if (txt_tenDangNhap.getText().isEmpty() || txt_tenDangNhap.getText().isBlank()
                || txt_email.getText().isEmpty() || txt_email.getText().isBlank()
                || txt_maEmail.getText().isEmpty() || txt_maEmail.getText().isBlank()
                || txt_passNew.getText().isEmpty() || txt_passNew.getText().isBlank()
                || txt_xnPassNew.getText().isEmpty() || txt_xnPassNew.getText().isBlank()) {
            Helper.DialogHelper.alert(this, "C??c ?? kh??ng ???????c ????? tr???ng !");
            return;
        }
        if (nv == null) {
            Helper.DialogHelper.alert(this, "Sai t??n ????ng nh???p !");
            return;
        }
        if (UtilityHelper.checkEmail(txt_email)) {
            if (!txt_maEmail.getText().equals(_capcha)) {
                DialogHelper.alert(this, "M?? x??c nh???n kh??ng ????ng !");
                return;
            }
            if (!txt_xnPassNew.getText().equals(txt_passNew.getText())) {
                DialogHelper.alert(this, "M???t kh???u x??c nh???n kh??ng kh???p !");
                return;
            }
            if ((_LocalDateTime.getMinute() * 60 + _LocalDateTime.getSecond()) - _layMa > 60) {
                DialogHelper.alert(this, "M?? ch??? kh??? d???ng trong 1 ph??t \nM???i b???n l???y m?? m???i !");
                return;
            }
            try {
                _NhanVienDAO.updatePass(txt_passNew.getText(), txt_tenDangNhap.getText());
                DialogHelper.alert(this, "L???y l???i m???t kh???u th??nh c??ng !");
                txt_email.setText("");
                txt_maEmail.setText("");
                txt_passNew.setText("");
                txt_tenDangNhap.setText("");
                txt_xnPassNew.setText("");
//                ClockThread clockThread = new ClockThread(lbl_timeCapCha);
                _clockThread.stop();
                lbl_timeCapCha.setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
                DialogHelper.alert(this, "Th???t b???i !");
            }
        }
    }//GEN-LAST:event_btn_xacNhanActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LayLaiMatKhauJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LayLaiMatKhauJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LayLaiMatKhauJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LayLaiMatKhauJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                LayLaiMatKhauJDialog dialog = new LayLaiMatKhauJDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_exit;
    private javax.swing.JButton btn_layMa;
    private javax.swing.JButton btn_login;
    private javax.swing.JButton btn_xacNhan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel lbl_timeCapCha;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_maEmail;
    private javax.swing.JPasswordField txt_passNew;
    private javax.swing.JTextField txt_tenDangNhap;
    private javax.swing.JPasswordField txt_xnPassNew;
    // End of variables declaration//GEN-END:variables
}
