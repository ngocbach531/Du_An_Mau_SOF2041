/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import DAO.NhanVienDAO;
import Entity.NhanVien;
import Helper.DialogHelper;
import Helper.Image;
import Helper.ShareHelper;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author BUI_QUANG_HIEU
 */
public class NhanVienJDialog extends javax.swing.JDialog {

    NhanVienDAO _NhanVienDAO = new NhanVienDAO();
    int _row = 0;
    int _trang = 1, _soTrang;

    /**
     * Creates new form NhanVienJDialog
     */
    public NhanVienJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        init();
    }

    public void init() {
        setLocationRelativeTo(null);
        setIconImage(Image.getAppIcon());
        setResizable(true);
        ButtonGroup bg = new ButtonGroup();
        bg.add(rdbNhanVien);
        bg.add(rdbTruongPhong);
        rdbNhanVien.setSelected(true);
        this.viewSoTrang();
        this.updateStatus(true);
        tabs.setSelectedIndex(1);

        //nếu đăng nhập với vai trò là nhân viên thì xóa tab cập nhât
        if (!ShareHelper.isManager()) {
            tabs.remove(0);
        }
    }

    public void viewSoTrang() {
        if (_NhanVienDAO.countDB() % 10 == 0) {
            _soTrang = _NhanVienDAO.countDB() / 10;
        } else {
            _soTrang = _NhanVienDAO.countDB() / 10 + 1;
        }
        this.fillTable(1);
        lbl_soTrang.setText("1/" + _soTrang);
        lbl_trang.setText("Trang: 1");
    }

    private void fillTable(int trang) {
        DefaultTableModel model = (DefaultTableModel) tblNhanVien.getModel();
        model.setRowCount(0);
        try {
            List<NhanVien> list = _NhanVienDAO.fillTop(trang);
            for (NhanVien nv : list) {
                Object[] row = {nv.getMaNV(), Helper.ShareHelper.USER.isVaiTro() ? nv.getMatKhau() : matKhauToSao(),
                    nv.getHoTen(), nv.isVaiTro() ? "Trưởng phòng" : "Nhân viên"};
                model.addRow(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
            Helper.DialogHelper.alert(this, "Lỗi truy vấn dữ liệu");
        }
    }

    //chỉ trưởng phòng mới đc xem mật khẩu người khác
    public String matKhauToSao() {
        String sao = "*****";
//        for (int i = 0; i < pass.length(); i++) {
//            sao += "*";
//        }
        return sao;
    }

    public void insert() {
        NhanVien nv = getForm();
        String confirm = new String(txtXacNhan.getPassword());
        if (confirm.equals(nv.getMatKhau())) {
            try {
                _NhanVienDAO.insert(nv);
//                this.fillTable(_trang); //cập nhật lại bảng nhân viên
                this.viewSoTrang();
                this.clearForm(); //xóa trắng form
                Helper.DialogHelper.alert(this, "Thêm mới thành công");
                tabs.setSelectedIndex(1);
            } catch (Exception e) {
                e.printStackTrace();
                Helper.DialogHelper.alert(this, "Thêm mới thất bại");
            }
        } else {
            Helper.DialogHelper.alert(this, "Xác nhận mật khẩu không đúng ");
        }
    }

    public void update() {
        NhanVien nv = getForm();
        String confirm = new String(txtXacNhan.getPassword());
        if (!confirm.equals(nv.getMatKhau())) {
            Helper.DialogHelper.alert(this, "Xác nhận mật khẩu không đúng!");
        } else {
            try {
                _NhanVienDAO.update(nv);     //cập nhật nhân viên theo maNV
//                this.fillTable(_trang);//điền tt mới vào bảng
                this.viewSoTrang();
                this.clearForm();
                tabs.setSelectedIndex(1);
                Helper.DialogHelper.alert(this, "Cập nhật thành công!");
            } catch (Exception e) {
                e.printStackTrace();
                Helper.DialogHelper.alert(this, "Cập nhật thất bại!");
            }
        }
    }

    public void delete() {
        if (Helper.DialogHelper.confirm(this, "Bạn thực sự muốn xóa nhân viên này?")) {
            String manv = txtMaNV.getText();
            try {
                _NhanVienDAO.delete(manv);   //xóa nhân viên theo maNV
//                this.fillTable(_trang);//điền tt mới vào bảng
                this.viewSoTrang();
                this.clearForm();//xóa trắng form và chỉnh lại status
                Helper.DialogHelper.alert(this, "Xóa thành công!");
                tabs.setSelectedIndex(1);
            } catch (Exception e) {
                e.printStackTrace();
                Helper.DialogHelper.alert(this, "Xóa thất bại!");
            }
        }
    }

    //Hàm để không cho xóa chính bản thân mình =))
    public boolean checkChinhMinh(JTextField txt) {
        NhanVien nv = _NhanVienDAO.findById(txt.getText());
        if (nv.getMaNV().equals(Helper.ShareHelper.USER.getMaNV())) {
            Helper.DialogHelper.alert(this, "bạn không được xóa chính mình.");
            return false;
        } else {
            return true;
        }
    }

    private void updateStatus(boolean insertable) {
        txtMaNV.setEditable(insertable);    //enable txtMaNV
        btnThem.setEnabled(insertable);   //enable btnInsert
        btnSua.setEnabled(!insertable);  //disable btnUpdate
        btn_Xoa.setEnabled(!insertable);  //disable brnDelete
        boolean first = this._row > 0;
        boolean last = this._row < tblNhanVien.getRowCount() - 1;
        btnFirst.setEnabled(!insertable && first);//enable 4 nút này khi ở editable
        btnPrev.setEnabled(!insertable && first); //disable khi First, Prev khi ở bản ghi đầu (index = 0)
        btnNext.setEnabled(!insertable && last);  //disable khi Next, Last khi ở bản ghi cuối
        btnLast.setEnabled(!insertable && last);  //index = tblGridView.getRowCount() - 1
    }

    public NhanVien getForm() {
        NhanVien nv = new NhanVien();
        nv.setMaNV(txtMaNV.getText());
        nv.setHoTen(_NhanVienDAO.chuanHoaDanhTuRieng(txtHoTen.getText()));
        nv.setMatKhau(new String(txtPassword.getPassword()));
        nv.setVaiTro(rdbTruongPhong.isSelected());
        return nv;
    }

    public void setForm(NhanVien nv) {
        txtMaNV.setText(nv.getMaNV());
        txtHoTen.setText(nv.getHoTen());
        txtPassword.setText(nv.getMatKhau());
        txtXacNhan.setText(nv.getMatKhau());
        rdbTruongPhong.setSelected(nv.isVaiTro());
        rdbNhanVien.setSelected(!nv.isVaiTro());
    }

    public void clearForm() {

        NhanVien nv = new NhanVien();
        this.setForm(nv);
//        this._row = -1;
        this.updateStatus(true);
    }

    public void edit() {
        String manv = (String) tblNhanVien.getValueAt(this._row, 0);
        NhanVien nv = _NhanVienDAO.findById(manv);
        try {
            if (nv != null) {
                this.setForm(nv); // điền thông tin lên form
                this.updateStatus(false); //chuyển chế độ edittable
            }
        } catch (Exception e) {
            e.printStackTrace();
            Helper.DialogHelper.alert(this, "Lỗi truy vấn dữ liệu");
        }

//        this.updateStatus();
    }

    public boolean checkTrungMa(String manv) {
        if (_NhanVienDAO.findById(manv) == null) {
            return true;
        } else {
            Helper.DialogHelper.alert(this, manv + " đã tồn tại !");
            return false;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        tabs = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        txtMaNV = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtHoTen = new javax.swing.JTextField();
        rdbTruongPhong = new javax.swing.JRadioButton();
        rdbNhanVien = new javax.swing.JRadioButton();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btn_Xoa = new javax.swing.JButton();
        btnNew = new javax.swing.JButton();
        btnFirst = new javax.swing.JButton();
        btnPrev = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();
        txtPassword = new javax.swing.JPasswordField();
        txtXacNhan = new javax.swing.JPasswordField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblNhanVien = new javax.swing.JTable();
        btnFirst1 = new javax.swing.JButton();
        btnPrev1 = new javax.swing.JButton();
        btnNext1 = new javax.swing.JButton();
        btnLast1 = new javax.swing.JButton();
        lbl_trang = new javax.swing.JLabel();
        lbl_soTrang = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("EduSys - Quản lý nhân viên");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 204));
        jLabel1.setText("QUẢN LÝ NHÂN VIÊN QUẢN TRỊ");
        jLabel1.setToolTipText("EduSys - Quản lý nhân viên");

        tabs.setToolTipText("EduSys - Quản lý nhân viên");

        txtMaNV.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtMaNV.setName("Mã nhân viên"); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Mã nhân viên");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Mật khẩu");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Vai trò");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Xác nhận mật khẩu");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Họ và tên");

        txtHoTen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtHoTen.setName("Họ tên"); // NOI18N

        rdbTruongPhong.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rdbTruongPhong.setText("Trưởng phòng");

        rdbNhanVien.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rdbNhanVien.setText("Nhân viên");

        btnThem.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Accept.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Edit.png"))); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btn_Xoa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_Xoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Delete.png"))); // NOI18N
        btn_Xoa.setText("Xóa");
        btn_Xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_XoaActionPerformed(evt);
            }
        });

        btnNew.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Add.png"))); // NOI18N
        btnNew.setText("Mới");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        btnFirst.setText("|<");
        btnFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstActionPerformed(evt);
            }
        });

        btnPrev.setText("<<");
        btnPrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrevActionPerformed(evt);
            }
        });

        btnNext.setText(">>");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnLast.setText(">|");
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastActionPerformed(evt);
            }
        });

        txtPassword.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtPassword.setName("Mật khẩu"); // NOI18N

        txtXacNhan.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtXacNhan.setName("Xác nhận mật khẩu"); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtHoTen)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMaNV)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnThem)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSua)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_Xoa)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnNew)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnFirst)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnPrev)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnNext)
                                .addGap(9, 9, 9)
                                .addComponent(btnLast))
                            .addComponent(txtPassword)
                            .addComponent(txtXacNhan, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(rdbTruongPhong)
                                        .addGap(38, 38, 38)
                                        .addComponent(rdbNhanVien))
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel7))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(7, 7, 7)
                .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(9, 9, 9)
                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(13, 13, 13)
                .addComponent(txtXacNhan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdbTruongPhong)
                    .addComponent(rdbNhanVien))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnSua)
                    .addComponent(btn_Xoa)
                    .addComponent(btnNew)
                    .addComponent(btnFirst)
                    .addComponent(btnPrev)
                    .addComponent(btnNext)
                    .addComponent(btnLast))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabs.addTab("CẬP NHẬT", jPanel1);

        tblNhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MÃ NV", "MẬT KHẨU", "HỌ VÀ TÊN", "VAI TRÒ"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNhanVienMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblNhanVien);

        btnFirst1.setText("|<");
        btnFirst1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirst1ActionPerformed(evt);
            }
        });

        btnPrev1.setText("<<");
        btnPrev1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrev1ActionPerformed(evt);
            }
        });

        btnNext1.setText(">>");
        btnNext1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNext1ActionPerformed(evt);
            }
        });

        btnLast1.setText(">|");
        btnLast1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLast1ActionPerformed(evt);
            }
        });

        lbl_trang.setText("jLabel6");

        lbl_soTrang.setText("jLabel6");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 585, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnFirst1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPrev1)
                        .addGap(18, 18, 18)
                        .addComponent(lbl_trang)
                        .addGap(24, 24, 24)
                        .addComponent(btnNext1)
                        .addGap(9, 9, 9)
                        .addComponent(btnLast1)
                        .addGap(43, 43, 43)
                        .addComponent(lbl_soTrang)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFirst1)
                    .addComponent(btnPrev1)
                    .addComponent(btnNext1)
                    .addComponent(btnLast1)
                    .addComponent(lbl_trang)
                    .addComponent(lbl_soTrang))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        tabs.addTab("DANH SÁCH", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tabs)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tabs)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        if (Helper.UtilityHelper.checkNullText(txtMaNV)
                && Helper.UtilityHelper.checkNullPass(txtPassword)
                && Helper.UtilityHelper.checkNullPass(txtXacNhan)
                && Helper.UtilityHelper.checkNullText(txtHoTen)) {
            if (Helper.UtilityHelper.checkMaNV(txtMaNV)
                    && Helper.UtilityHelper.checkPass(txtPassword)
                    && Helper.UtilityHelper.checkName(txtHoTen)) {
                if (checkTrungMa(txtMaNV.getText())) {
                    insert();
                }
            }
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        if (Helper.UtilityHelper.checkNullPass(txtPassword) && Helper.UtilityHelper.checkNullPass(txtXacNhan)
                && Helper.UtilityHelper.checkNullText(txtHoTen)) {
            if (Helper.UtilityHelper.checkPass(txtPassword) && Helper.UtilityHelper.checkName(txtHoTen)) {
                update();
            }
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btn_XoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_XoaActionPerformed
        if (Helper.ShareHelper.USER.isVaiTro()) {
            if (checkChinhMinh(txtMaNV)) {
                delete();
            }
        } else {
            Helper.DialogHelper.alert(this, "Chỉ trưởng phòng mới được phép xóa !");
        }
    }//GEN-LAST:event_btn_XoaActionPerformed

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        if (DialogHelper.confirm(this, "Bạn thực sự muốn clear ?")) {
            clearForm();
        }
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstActionPerformed
        this._row = 0;
        this.edit();
    }//GEN-LAST:event_btnFirstActionPerformed

    private void btnPrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrevActionPerformed
        this._row--;
        this.edit();
    }//GEN-LAST:event_btnPrevActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        this._row++;
        this.edit();
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed
        this._row = tblNhanVien.getRowCount() - 1;
        this.edit();
    }//GEN-LAST:event_btnLastActionPerformed

    private void tblNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNhanVienMouseClicked
        if (evt.getClickCount() == 2) {
            this._row = tblNhanVien.rowAtPoint(evt.getPoint()); // lấy vị trị dòng được chọn
            if (this._row >= 0) {
                this.edit();
                tabs.setSelectedIndex(0);
            }
        }
    }//GEN-LAST:event_tblNhanVienMouseClicked

    private void btnFirst1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirst1ActionPerformed
        _trang = 1;
        this.fillTable(_trang);
        lbl_trang.setText("Trang: " + _trang);
        lbl_soTrang.setText(_trang + "/" + _soTrang);
    }//GEN-LAST:event_btnFirst1ActionPerformed

    private void btnPrev1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrev1ActionPerformed
        if (_trang > 1) {
            _trang--;
            this.fillTable(_trang);
            lbl_trang.setText("Trang: " + _trang);
            lbl_soTrang.setText(_trang + "/" + _soTrang);
        }
    }//GEN-LAST:event_btnPrev1ActionPerformed

    private void btnNext1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNext1ActionPerformed
        if (_trang < _soTrang) {
            _trang++;
            this.fillTable(_trang);
            lbl_trang.setText("Trang: " + _trang);
            lbl_soTrang.setText(_trang + "/" + _soTrang);
        }
    }//GEN-LAST:event_btnNext1ActionPerformed

    private void btnLast1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLast1ActionPerformed
        _trang = _soTrang;
        this.fillTable(_trang);
        lbl_trang.setText("Trang: " + _trang);
        lbl_soTrang.setText(_trang + "/" + _soTrang);
    }//GEN-LAST:event_btnLast1ActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(NhanVienJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(NhanVienJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(NhanVienJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(NhanVienJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                NhanVienJDialog dialog = new NhanVienJDialog(new javax.swing.JFrame(), true);
//                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
//                    @Override
//                    public void windowClosing(java.awt.event.WindowEvent e) {
//                        System.exit(0);
//                    }
//                });
//                dialog.setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFirst;
    private javax.swing.JButton btnFirst1;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnLast1;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnNext1;
    private javax.swing.JButton btnPrev;
    private javax.swing.JButton btnPrev1;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btn_Xoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_soTrang;
    private javax.swing.JLabel lbl_trang;
    private javax.swing.JRadioButton rdbNhanVien;
    private javax.swing.JRadioButton rdbTruongPhong;
    private javax.swing.JTabbedPane tabs;
    private javax.swing.JTable tblNhanVien;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JPasswordField txtXacNhan;
    // End of variables declaration//GEN-END:variables
}
