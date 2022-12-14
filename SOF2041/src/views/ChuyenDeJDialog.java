/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import Helper.DialogHelper;
import Helper.ShareHelper;
import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import model.ChuyenDe;
import service.implement.ChuyenDeServiceImplement;
import service.IChuyenDeService;

/**
 *
 * @author HA NGOC BACH
 */
public class ChuyenDeJDialog extends javax.swing.JDialog {

    IChuyenDeService chuyenDeService = new ChuyenDeServiceImplement();
    int _row = 0;
    File _file;
    FileDialog _fd = new FileDialog(new Frame(), "Chọn logo cho chuyên đề", FileDialog.LOAD);
    String _images = null;


    public ChuyenDeJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        init();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        tabs = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        txtMaChuyenDe = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtTenChuyenDe = new javax.swing.JTextField();
        txtThoiLuong = new javax.swing.JTextField();
        txtHocPhi = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtMoTa = new javax.swing.JTextArea();
        btnInsert = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        lblHinh = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblChuyenDe = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("EduSys - Quản lý chuyên đề");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 204));
        jLabel1.setText("QUẢN LÝ CHUYÊN ĐỀ");
        jLabel1.setToolTipText("");

        tabs.setToolTipText("");

        txtMaChuyenDe.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtMaChuyenDe.setName("Mã chuyên đề"); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Mã chuyên đề");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Tên chuyên đề");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Thời lượng");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Học phí");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Mô tả chuyên đề");

        txtTenChuyenDe.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtTenChuyenDe.setName("Tên chuyên đề"); // NOI18N

        txtThoiLuong.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtThoiLuong.setName("Thời lượng"); // NOI18N

        txtHocPhi.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtHocPhi.setName("Học phí"); // NOI18N

        txtMoTa.setColumns(20);
        txtMoTa.setLineWrap(true);
        txtMoTa.setRows(5);
        txtMoTa.setWrapStyleWord(true);
        jScrollPane2.setViewportView(txtMoTa);

        btnInsert.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnInsert.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Accept.png"))); // NOI18N
        btnInsert.setText("Thêm");
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });

        btnUpdate.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Edit.png"))); // NOI18N
        btnUpdate.setText("Sửa");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Delete.png"))); // NOI18N
        btnDelete.setText("Xóa");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnClear.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Add.png"))); // NOI18N
        btnClear.setText("Mới");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("Hình logo");

        lblHinh.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 204), 2));
        lblHinh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHinhMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addComponent(btnInsert)
                                .addGap(44, 44, 44)
                                .addComponent(btnUpdate)
                                .addGap(45, 45, 45)
                                .addComponent(btnDelete)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                                .addComponent(btnClear)
                                .addGap(54, 54, 54))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(lblHinh, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtThoiLuong, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE)
                                    .addComponent(jLabel3)
                                    .addComponent(txtTenChuyenDe)
                                    .addComponent(txtMaChuyenDe)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtHocPhi))))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel9))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtMaChuyenDe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTenChuyenDe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addGap(13, 13, 13)
                        .addComponent(txtThoiLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtHocPhi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lblHinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(21, 21, 21)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInsert)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelete)
                    .addComponent(btnClear))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabs.addTab("CẬP NHẬT", jPanel1);

        tblChuyenDe.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MÃ CĐ", "TÊN CĐ", "HỌC PHÍ", "THỜI LƯỢNG", "HÌNH"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblChuyenDe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblChuyenDeMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblChuyenDeMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblChuyenDe);
        if (tblChuyenDe.getColumnModel().getColumnCount() > 0) {
            tblChuyenDe.getColumnModel().getColumn(0).setMaxWidth(70);
            tblChuyenDe.getColumnModel().getColumn(1).setMinWidth(200);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(91, Short.MAX_VALUE))
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
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    public void init() {
        setIconImage(Helper.Image.getAppIcon());
        setLocationRelativeTo(null);
        setResizable(false);
        tabs.setSelectedIndex(1);
        updateStatus(true);
        if (tblChuyenDe.getRowCount() > 0) {
            tblChuyenDe.setRowSelectionInterval(0, 0);
            _row = 0;
            this.edit();
        }
        duadulieulenbang();
        
    }

    //Đổ dữ liệu từ CSDL lên table
    public void duadulieulenbang() {
        DefaultTableModel model = (DefaultTableModel) tblChuyenDe.getModel();
        model.setRowCount(0);
        try {
            ArrayList<ChuyenDe> list = chuyenDeService.getallChuyenDe();
            for (ChuyenDe cd : list) {
                model.addRow(new Object[]{
                    cd.getMachuyende(),cd.getTenchuyende(),cd.getHocphi(),cd.getThoiluong(),cd.getHinh(),cd.getMota()
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
            Helper.DialogHelper.alert(this, "Lỗi truy vấn dữ liệu!");
        }

    }

    //Thêm 1 bản ghi mới từ form vào CSDL
    public void them() {
        ChuyenDe cd = getForm();
        try {
            chuyenDeService.themChuyenDe(cd);
            this.clearForm();
            tabs.setSelectedIndex(1);
            Helper.DialogHelper.alert(this, "Thêm mới thành công!");
        } catch (Exception e) {
            e.printStackTrace();
            Helper.DialogHelper.alert(this, "Thêm mới thất bại!");
        }
    }

    //Sửa 1 bản ghi mới từ form vào CSDL theo MaCD
    public void sua() {
        
        ChuyenDe cd = getForm();
        try {
            tabs.setSelectedIndex(1);
            Helper.DialogHelper.alert(this, "Cập nhật thành công!");
        } catch (Exception e) {
            e.printStackTrace();
            Helper.DialogHelper.alert(this, "Cập nhật thất bại!");
        }
    }

    //Xóa 1 bản ghi từ CSDL xong update lại table
    public void xoa() {
        if (Helper.DialogHelper.confirm(this, "Bạn có muốn xóa hay không?")) {
            String macd = txtMaChuyenDe.getText();
            try {
                chuyenDeService.xoaChuyenDe(macd);
                this.clearForm();
                tabs.setSelectedIndex(1);
                Helper.DialogHelper.alert(this, "Xóa thành công!");
            } catch (Exception e) {
                e.printStackTrace();
                Helper.DialogHelper.alert(this, "Xóa thất bại!");
            }
        }
    }

    //Lấy dữ liệu trên form đổ vào đối tượng
    public ChuyenDe getForm() {
        ChuyenDe cd = new ChuyenDe();
        cd.setMachuyende(txtMaChuyenDe.getText());
        cd.setTenchuyende(txtTenChuyenDe.getText());
        cd.setHocphi(Double.parseDouble(txtHocPhi.getText()));
        cd.setThoiluong(Integer.parseInt(txtThoiLuong.getText()));
        cd.setMota(txtMoTa.getText());
        cd.setHinh(_images);
        return cd;
    }

    //Lấy dữ liệu từ đối tượng đổ lên form
    public void setForm(ChuyenDe cd) {
        txtMaChuyenDe.setText(cd.getMachuyende());
        txtTenChuyenDe.setText(cd.getTenchuyende());
        txtHocPhi.setText(cd.getHocphi()+ "");
        txtThoiLuong.setText(cd.getThoiluong()+ "");
        txtMoTa.setText(cd.getMota());
        lblHinh.setText(cd.getHinh());
        String url = "logos\\" + cd.getHinh();
        ImageIcon imgIcon = new ImageIcon(url);
        Image img = imgIcon.getImage();
        lblHinh.setIcon(new ImageIcon(img.getScaledInstance(180, 225, 0)));
    }

    //Xóa dữ liệu đang có trên form
    public void clearForm() {
        ChuyenDe cd = new ChuyenDe();
        this.setForm(cd);
        this.updateStatus(true);
    }

    //Lấy dữ liệu theo index đổ lên form
    public void edit() {
        String macd = (String) tblChuyenDe.getValueAt(this._row, 0);
        ChuyenDe nv = chuyenDeService.finByMaCd(macd);
        try {
            if (nv != null) {
                this.setForm(nv); // điền thông tin lên form
                this.updateStatus(false); //chuyển chế độ edittable
            }
        } catch (Exception e) {
            e.printStackTrace();
            Helper.DialogHelper.alert(this, "Lỗi truy vấn dữ liệu");
        }
    }

    //Check trống hình ảnh
    public boolean checkNullHinh() {
        if (_images != null) {
            return true;
        } else {
            Helper.DialogHelper.alert(this, "Không được để trống hình.");
            return false;
        }
    }

    //Set trạng thái cho các nút 
    private void updateStatus(boolean insertable) {
        txtMaChuyenDe.setEditable(insertable);    //enable txtMaNV
        btnInsert.setEnabled(insertable);   //enable btnInsert
        btnUpdate.setEnabled(!insertable);  //disable btnUpdate
        btnDelete.setEnabled(!insertable);  //disable brnDelete
        boolean first = this._row > 0;
        boolean last = this._row < tblChuyenDe.getRowCount() - 1;

    }
    
    public void show(int index){
        txtMaChuyenDe.setText((String) tblChuyenDe.getValueAt(index, 0));
        txtTenChuyenDe.setText((String) tblChuyenDe.getValueAt(index, 1));
        txtHocPhi.setText( tblChuyenDe.getValueAt(index, 2)+ "");
        txtThoiLuong.setText(tblChuyenDe.getValueAt(index, 3)+ "");
    }

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
        if (Helper.UtilityHelper.checkNullText(txtMaChuyenDe)
                && Helper.UtilityHelper.checkNullText(txtMaChuyenDe)
                && Helper.UtilityHelper.checkNullText(txtThoiLuong)
                && Helper.UtilityHelper.checkNullText(txtHocPhi)
                && Helper.UtilityHelper.checkNullText(txtMoTa)
                && checkNullHinh()) {
            if (Helper.UtilityHelper.checkMaCD(txtMaChuyenDe)
                    && Helper.UtilityHelper.checkTenCD(txtTenChuyenDe)
                    && Helper.UtilityHelper.checkSoThoiLuong(txtThoiLuong)
                    && Helper.UtilityHelper.checkThoiLuong(txtThoiLuong)
                    && Helper.UtilityHelper.checkSoHocPhi(txtHocPhi)
                    && Helper.UtilityHelper.checkHocPhi(txtHocPhi)
                    && Helper.UtilityHelper.checkMoTaCD(txtMoTa))
                    them();
        }
        duadulieulenbang();
    }//GEN-LAST:event_btnInsertActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed

        if (Helper.UtilityHelper.checkNullText(txtThoiLuong)
                && Helper.UtilityHelper.checkNullText(txtHocPhi)
                && Helper.UtilityHelper.checkNullText(txtMoTa)
                && checkNullHinh()) {
            if (Helper.UtilityHelper.checkTenCD(txtTenChuyenDe)
                    && Helper.UtilityHelper.checkSoThoiLuong(txtThoiLuong)
                    && Helper.UtilityHelper.checkThoiLuong(txtThoiLuong)
                    && Helper.UtilityHelper.checkSoHocPhi(txtHocPhi)
                    && Helper.UtilityHelper.checkHocPhi(txtHocPhi)
                    && Helper.UtilityHelper.checkMoTaCD(txtMoTa))
                sua();
        }
        duadulieulenbang();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if (Helper.ShareHelper.USER.isVaitro()) {
            xoa();
        } else {
            Helper.DialogHelper.alert(this, "Chỉ trưởng phòng mới được phép xóa");
        }
        duadulieulenbang();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void lblHinhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHinhMouseClicked
        try {
            _fd.setVisible(true); //mở hộp thoại chọn file
            _file = new File(_fd.getDirectory() + _fd.getFile());
            if (!String.valueOf(_file).equals("nullnull")) {
                Helper.Image.save(_file);
                Image image = ImageIO.read(_file);
                _images = _file.getName();
                lblHinh.setIcon(new ImageIcon(image.getScaledInstance(180, 225, 0)));
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_lblHinhMouseClicked

    private void tblChuyenDeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblChuyenDeMouseClicked
        ChuyenDe cd = new ChuyenDe();
        int getIndex = tblChuyenDe.getSelectedRow();
        cd = chuyenDeService.getallChuyenDe().get(getIndex);
        if (evt.getClickCount() == 2) {
            this._row = tblChuyenDe.rowAtPoint(evt.getPoint());
            if (this._row >= 0) {
                _images = cd.getHinh().toString();
                this.edit();
                tabs.setSelectedIndex(0);
                String url = "logos\\" + cd.getHinh();
                ImageIcon imgIcon = new ImageIcon(url);
                Image img = imgIcon.getImage();
                lblHinh.setIcon(new ImageIcon(img.getScaledInstance(180, 225, 0)));
            }
        }
    }//GEN-LAST:event_tblChuyenDeMouseClicked

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        if (DialogHelper.confirm(this, "Bạn thực sự muốn clear ?")) {
            clearForm();
        }
    }//GEN-LAST:event_btnClearActionPerformed

    private void tblChuyenDeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblChuyenDeMousePressed
        show(tblChuyenDe.getSelectedRow());
    }//GEN-LAST:event_tblChuyenDeMousePressed

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
            java.util.logging.Logger.getLogger(ChuyenDeJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChuyenDeJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChuyenDeJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChuyenDeJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ChuyenDeJDialog dialog = new ChuyenDeJDialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblHinh;
    private javax.swing.JTabbedPane tabs;
    private javax.swing.JTable tblChuyenDe;
    private javax.swing.JTextField txtHocPhi;
    private javax.swing.JTextField txtMaChuyenDe;
    private javax.swing.JTextArea txtMoTa;
    private javax.swing.JTextField txtTenChuyenDe;
    private javax.swing.JTextField txtThoiLuong;
    // End of variables declaration//GEN-END:variables
}
