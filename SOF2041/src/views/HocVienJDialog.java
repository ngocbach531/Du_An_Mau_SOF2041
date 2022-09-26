/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import DAO.ChuyenDeDAO;
import DAO.HocVienDAO;
import DAO.KhoaHocDAO;
import DAO.NguoiHocDAO;
import Entity.ChuyenDe;
import Entity.HocVien;
import Entity.KhoaHoc;
import Entity.NguoiHoc;
import Helper.DialogHelper;
import Helper.Image;
import Helper.ShareHelper;
import Helper.UtilityHelper;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HA NGOC BACH
 */
public class HocVienJDialog extends javax.swing.JDialog {
    
    ChuyenDeDAO _ChuyenDeDAO = new ChuyenDeDAO();
    KhoaHocDAO _KhoaHocDAO = new KhoaHocDAO();
    NguoiHocDAO _NguoiHocDAO = new NguoiHocDAO();
    HocVienDAO _HocVienDAO = new HocVienDAO();
    long _trang = 1, _soTrang;
    long _trangHV = 1, _soTrangHV;
    DefaultTableModel _dModelNguoiHoc;
    DefaultTableModel _dModelHocVien;

    /**
     * Creates new form HocVienJDialog
     */
    public HocVienJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        _dModelNguoiHoc = (DefaultTableModel) tblNguoiHoc.getModel();
        _dModelHocVien = (DefaultTableModel) tblHocVien.getModel();
        init();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        cbbChuyenDe = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        tabs = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblHocVien = new javax.swing.JTable();
        btnDelete = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        lbl_trang1 = new javax.swing.JLabel();
        lbl_soTrang1 = new javax.swing.JLabel();
        btnFirst3 = new javax.swing.JButton();
        btnPrev4 = new javax.swing.JButton();
        btnNext3 = new javax.swing.JButton();
        btnLast3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblNguoiHoc = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        txtTimKiem = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnInsert = new javax.swing.JButton();
        btnFirst2 = new javax.swing.JButton();
        btnPrev3 = new javax.swing.JButton();
        btnNext2 = new javax.swing.JButton();
        btnLast2 = new javax.swing.JButton();
        lbl_trang = new javax.swing.JLabel();
        lbl_soTrang = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        cbbKhoaHoc = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("EduSys - Quản lý học viên");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        cbbChuyenDe.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbbChuyenDe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbChuyenDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbChuyenDeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbbChuyenDe, 0, 272, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbbChuyenDe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 204));
        jLabel6.setText("KHÓA HỌC");

        tblHocVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "TT", "MÃ HV", "MÃ NH", "HỌ VÀ TÊN", "ĐIỂM"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblHocVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHocVienMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblHocVien);
        if (tblHocVien.getColumnModel().getColumnCount() > 0) {
            tblHocVien.getColumnModel().getColumn(0).setMaxWidth(50);
            tblHocVien.getColumnModel().getColumn(1).setMaxWidth(60);
            tblHocVien.getColumnModel().getColumn(3).setPreferredWidth(100);
        }

        btnDelete.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Delete.png"))); // NOI18N
        btnDelete.setText("Xóa khỏi khóa học");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnUpdate.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Edit.png"))); // NOI18N
        btnUpdate.setText("Cập nhật điểm");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        lbl_trang1.setText("jLabel4");

        lbl_soTrang1.setText("jLabel4");

        btnFirst3.setText("|<");
        btnFirst3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirst3ActionPerformed(evt);
            }
        });

        btnPrev4.setText("<<");
        btnPrev4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrev4ActionPerformed(evt);
            }
        });

        btnNext3.setText(">>");
        btnNext3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNext3ActionPerformed(evt);
            }
        });

        btnLast3.setText(">|");
        btnLast3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLast3ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        jLabel2.setText("Click 2 lần vào học viên mà bạn muốn sửa điểm !");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 628, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnDelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnUpdate))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnFirst3)
                                .addGap(1, 1, 1)
                                .addComponent(btnPrev4)
                                .addGap(35, 35, 35)
                                .addComponent(lbl_trang1)
                                .addGap(42, 42, 42)
                                .addComponent(btnNext3)
                                .addGap(3, 3, 3)
                                .addComponent(btnLast3)
                                .addGap(18, 18, 18)
                                .addComponent(lbl_soTrang1))
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_soTrang1)
                    .addComponent(lbl_trang1)
                    .addComponent(btnLast3)
                    .addComponent(btnNext3)
                    .addComponent(btnPrev4)
                    .addComponent(btnFirst3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDelete)
                    .addComponent(btnUpdate))
                .addContainerGap())
        );

        tabs.addTab("HỌC VIÊN", jPanel1);

        tblNguoiHoc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MÃ NH", "HỌ VÀ TÊN", "GIỚI TÍNH", "NGÀY SINH", "ĐIỆN THOẠI", "EMAIL"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblNguoiHoc);
        if (tblNguoiHoc.getColumnModel().getColumnCount() > 0) {
            tblNguoiHoc.getColumnModel().getColumn(0).setMaxWidth(150);
            tblNguoiHoc.getColumnModel().getColumn(1).setPreferredWidth(200);
            tblNguoiHoc.getColumnModel().getColumn(2).setPreferredWidth(50);
        }

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm kiếm"));

        txtTimKiem.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        jLabel3.setText("Mời bạn nhập mã người học hoặc họ tên để tìm kiếm !");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, 596, Short.MAX_VALUE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        btnInsert.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnInsert.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Accept.png"))); // NOI18N
        btnInsert.setText("Thêm vào khóa học");
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });

        btnFirst2.setText("|<");
        btnFirst2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirst2ActionPerformed(evt);
            }
        });

        btnPrev3.setText("<<");
        btnPrev3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrev3ActionPerformed(evt);
            }
        });

        btnNext2.setText(">>");
        btnNext2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNext2ActionPerformed(evt);
            }
        });

        btnLast2.setText(">|");
        btnLast2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLast2ActionPerformed(evt);
            }
        });

        lbl_trang.setText("jLabel4");

        lbl_soTrang.setText("jLabel4");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(btnFirst2)
                        .addGap(1, 1, 1)
                        .addComponent(btnPrev3)
                        .addGap(35, 35, 35)
                        .addComponent(lbl_trang)
                        .addGap(42, 42, 42)
                        .addComponent(btnNext2)
                        .addGap(3, 3, 3)
                        .addComponent(btnLast2)
                        .addGap(18, 18, 18)
                        .addComponent(lbl_soTrang)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                        .addComponent(btnInsert)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbl_soTrang)
                        .addComponent(lbl_trang)
                        .addComponent(btnLast2)
                        .addComponent(btnNext2)
                        .addComponent(btnPrev3)
                        .addComponent(btnFirst2))
                    .addComponent(btnInsert))
                .addContainerGap())
        );

        tabs.addTab("NGƯỜI HỌC", jPanel2);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 204));
        jLabel1.setText("CHUYÊN ĐỀ");

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        cbbKhoaHoc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbbKhoaHoc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbKhoaHoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbKhoaHocActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbbKhoaHoc, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbbKhoaHoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tabs)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(185, 185, 185))
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(tabs)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void init() {
        setLocationRelativeTo(null);
        setResizable(false);
        setIconImage(Image.getAppIcon());
        fillComboboxChuyenDe();
        viewSoTrangNguoiHoc();
        viewSoTrangHocVien();
        txtTimKiem.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                fillTableNguoiHoc(_trang);
            }
            
            @Override
            public void removeUpdate(DocumentEvent e) {
                fillTableNguoiHoc(_trang);
            }
            
            @Override
            public void changedUpdate(DocumentEvent e) {
                fillTableNguoiHoc(_trang);
            }
        });
    }

    //View số trang Người học thông qua countDBNguoiHoc
    public void viewSoTrangNguoiHoc() {
        
        if (_NguoiHocDAO.countDBNguoiHoc() % 10 == 0) { //Nếu tổng số bản người học chia hết cho 10 thì số trang = count/10
            _soTrang = _NguoiHocDAO.countDBNguoiHoc() / 10;
        } else {
            _soTrang = _NguoiHocDAO.countDBNguoiHoc() / 10 + 1; //còn không chia hết thì số trang = count /10 +1
        }
        this.fillTableNguoiHoc(1);
        lbl_soTrang.setText("1/" + _soTrang);
        lbl_trang.setText("Trang: 1");
    }

    //View số trang Học viên thông qua countDB
    public void viewSoTrangHocVien() {
        KhoaHoc khoaHoc = (KhoaHoc) cbbKhoaHoc.getSelectedItem();
        if (khoaHoc != null) {
            if (_HocVienDAO.countDB(khoaHoc.getMaKH()) % 10 == 0) {
                _soTrangHV = _HocVienDAO.countDB(khoaHoc.getMaKH()) / 10;
            } else {
                _soTrangHV = _HocVienDAO.countDB(khoaHoc.getMaKH()) / 10 + 1;
            }
            this.fillTableHocVien(1);
            lbl_soTrang1.setText("1/" + _soTrangHV);
            lbl_trang1.setText("Trang: 1");
        }
    }

    //Đổ tên chuyên đề vào combobox
    public void fillComboboxChuyenDe() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cbbChuyenDe.getModel();
        model.removeAllElements();
        List<ChuyenDe> list = _ChuyenDeDAO.selectAll();
        for (ChuyenDe cd : list) {
            model.addElement(cd);
        }
        this.fillComboBoxKhoaHoc();
    }

    //Đổ mã chuyên đề vào combobox
    public void fillComboBoxKhoaHoc() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cbbKhoaHoc.getModel();
        model.removeAllElements();
        ChuyenDe chuyenDe = (ChuyenDe) cbbChuyenDe.getSelectedItem();
        if (chuyenDe != null) {
            List<KhoaHoc> list = _KhoaHocDAO.findByCD(chuyenDe.getMaCD());
            for (KhoaHoc kh : list) {
                model.addElement(kh);
            }
            this.fillTableHocVien(_trangHV);
        }
    }

    //Load dữ liệu từ DB lên table học viên
    public void fillTableHocVien(long trang) {
        
        _dModelHocVien.setRowCount(0);
        KhoaHoc khoaHoc = (KhoaHoc) cbbKhoaHoc.getSelectedItem();
        if (khoaHoc != null) {
            List<HocVien> list = _HocVienDAO.fillTop(khoaHoc.getMaKH(), trang);
            for (int i = 0; i < list.size(); i++) {
                HocVien hv = list.get(i);
                String hoTen = _NguoiHocDAO.findById(hv.getMaNH()).getHoTen();
                _dModelHocVien.addRow(new Object[]{i + 1, hv.getMaHV(), hv.getMaNH(), hoTen, hv.getDiem()});
            }
            this.fillTableNguoiHoc(_trang);
        } else {
            _dModelNguoiHoc.setRowCount(0);
        }
    }

    //Load dữ liệu từ DB lên table người học
    public void fillTableNguoiHoc(long trang) {
        _dModelNguoiHoc.setRowCount(0);
        KhoaHoc khoaHoc = (KhoaHoc) cbbKhoaHoc.getSelectedItem();
        if (khoaHoc != null) {
            String keyWord = txtTimKiem.getText();
            List<NguoiHoc> list = _NguoiHocDAO.selectNotlnCourse(khoaHoc.getMaKH(), keyWord, trang);
            for (NguoiHoc nh : list) {
                _dModelNguoiHoc.addRow(new Object[]{nh.getMaNH(), nh.getHoTen(), nh.isGioiTinh() ? "Nam" : "Nữ", nh.getNgaySinh(), nh.getDienThoai(), nh.getEmail()});
            }
        }
        
    }

    //Thêm mới 1 bản ghi từ form vào DB
    public void insert() {
        KhoaHoc khoaHoc = (KhoaHoc) cbbKhoaHoc.getSelectedItem();
        for (int row : tblNguoiHoc.getSelectedRows()) {
            HocVien hv = new HocVien();
            hv.setMaKH(khoaHoc.getMaKH());
            hv.setDiem(0);
            hv.setMaNH((String) tblNguoiHoc.getValueAt(row, 0));
            _HocVienDAO.insert(hv);
        }
        this.viewSoTrangHocVien();
        this.viewSoTrangNguoiHoc();
        this.tabs.setSelectedIndex(0);
    }

    //Xóa 1 bản ghi trong DB và update lại table
    public void delete() {
        if (!ShareHelper.isManager()) {
            DialogHelper.alert(this, "Bạn không có quyền xóa học viên !");
        } else {
            if (tblHocVien.getSelectedRow() < 0) {
                DialogHelper.alert(this, "Mời bạn chọn học viên muốn xóa !");
                return;
            }
            if (DialogHelper.confirm(this, "Bạn muốn xóa các học viên được chọn ?")) {
                try {
                    for (int row : tblHocVien.getSelectedRows()) {
                        int maHV = (int) tblHocVien.getValueAt(row, 1);
                        _HocVienDAO.delete(maHV);
                    }
                    this.viewSoTrangHocVien();
                    this.viewSoTrangNguoiHoc();
                    DialogHelper.alert(this, "Xóa thành công !");
                } catch (Exception e) {
                    e.printStackTrace();
                    DialogHelper.alert(this, "Xóa thất bại !");
                }
            }
        }
    }

    //Sửa 1 bản ghi theo mã học viên và update table
    public void update() {
        try {
            for (int i = 0; i < tblHocVien.getRowCount(); i++) {
                int maHV = (int) tblHocVien.getValueAt(i, 1);
                double updateDiem = Double.parseDouble(tblHocVien.getValueAt(i, 4).toString());
                HocVien hv = _HocVienDAO.selectById(maHV);
                hv.setDiem(updateDiem);
                _HocVienDAO.update(hv);
                
            }
            this.viewSoTrangHocVien();
            this.viewSoTrangNguoiHoc();
            DialogHelper.alert(this, "Cập nhật điểm thành công");
        } catch (Exception e) {
            e.printStackTrace();
            DialogHelper.alert(this, "Cập nhật không thành công");
        }
    }

    private void cbbChuyenDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbChuyenDeActionPerformed
        fillComboBoxKhoaHoc();
    }//GEN-LAST:event_cbbChuyenDeActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        update();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        delete();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
        insert();
    }//GEN-LAST:event_btnInsertActionPerformed

    private void btnFirst2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirst2ActionPerformed
        _trang = 1;
        this.fillTableNguoiHoc(_trang);
        lbl_trang.setText("Trang: " + _trang);
        lbl_soTrang.setText(_trang + "/" + _soTrang);
    }//GEN-LAST:event_btnFirst2ActionPerformed

    private void btnPrev3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrev3ActionPerformed
        if (_trang > 1) {
            _trang--;
            this.fillTableNguoiHoc(_trang);
            lbl_trang.setText("Trang: " + _trang);
            lbl_soTrang.setText(_trang + "/" + _soTrang);
        }
    }//GEN-LAST:event_btnPrev3ActionPerformed

    private void btnNext2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNext2ActionPerformed
        if (_trang < _soTrang) {
            _trang++;
            this.fillTableNguoiHoc(_trang);
            lbl_trang.setText("Trang: " + _trang);
            lbl_soTrang.setText(_trang + "/" + _soTrang);
        }
    }//GEN-LAST:event_btnNext2ActionPerformed

    private void btnLast2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLast2ActionPerformed
        _trang = _soTrang;
        this.fillTableNguoiHoc(_trang);
        lbl_trang.setText("Trang: " + _trang);
        lbl_soTrang.setText(_trang + "/" + _soTrang);
    }//GEN-LAST:event_btnLast2ActionPerformed

    private void btnFirst3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirst3ActionPerformed
        _trangHV = 1;
        this.fillTableHocVien(_trangHV);
        lbl_trang1.setText("Trang: " + _trangHV);
        lbl_soTrang1.setText(_trangHV + "/" + _soTrangHV);
    }//GEN-LAST:event_btnFirst3ActionPerformed

    private void btnPrev4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrev4ActionPerformed
        if (_trangHV > 1) {
            _trangHV--;
            this.fillTableHocVien(_trangHV);
            lbl_trang1.setText("Trang: " + _trangHV);
            lbl_soTrang1.setText(_trangHV + "/" + _soTrangHV);
        }
    }//GEN-LAST:event_btnPrev4ActionPerformed

    private void btnNext3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNext3ActionPerformed
        if (_trangHV < _soTrangHV) {
            _trangHV++;
            this.fillTableHocVien(_trangHV);
            lbl_trang1.setText("Trang: " + _trangHV);
            lbl_soTrang1.setText(_trangHV + "/" + _soTrangHV);
        }
    }//GEN-LAST:event_btnNext3ActionPerformed

    private void btnLast3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLast3ActionPerformed
        _trangHV = _soTrangHV;
        this.fillTableHocVien(_trangHV);
        lbl_trang1.setText("Trang: " + _trangHV);
        lbl_soTrang1.setText(_trangHV + "/" + _soTrangHV);
    }//GEN-LAST:event_btnLast3ActionPerformed

    private void cbbKhoaHocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbKhoaHocActionPerformed
        _trang = 1;
        _trangHV = 1;
        this.viewSoTrangHocVien();
        this.viewSoTrangNguoiHoc();
        this.fillTableHocVien(_trangHV);
        this.fillTableNguoiHoc(_trang);
    }//GEN-LAST:event_cbbKhoaHocActionPerformed

    private void tblHocVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHocVienMouseClicked
        if (evt.getClickCount() == 2) {
//            this._row = tblNhanVien.rowAtPoint(evt.getPoint()); // lấy vị trị dòng được chọn
//            if (this._row >= 0) {
//                this.edit();
//                tabs.setSelectedIndex(0);
//            }
            int indexRow = tblHocVien.getSelectedRow();
            String diem = DialogHelper.prompt(this, "Mời bạn nhập điểm !");
            if (diem != null) {
                if (UtilityHelper.checkSo1(diem)) {
                    double Ddiem = Double.parseDouble(diem);
                    if (Ddiem < 0 || Ddiem > 10) {
                        DialogHelper.alert(this, "Điểm nằm trong khoảng từ 0 - 10 !");
                        return;
                    }
                    tblHocVien.setValueAt(Ddiem, indexRow, 4);
                }
            }
            
        }
    }//GEN-LAST:event_tblHocVienMouseClicked

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
            java.util.logging.Logger.getLogger(HocVienJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HocVienJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HocVienJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HocVienJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                HocVienJDialog dialog = new HocVienJDialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnFirst2;
    private javax.swing.JButton btnFirst3;
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton btnLast2;
    private javax.swing.JButton btnLast3;
    private javax.swing.JButton btnNext2;
    private javax.swing.JButton btnNext3;
    private javax.swing.JButton btnPrev3;
    private javax.swing.JButton btnPrev4;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cbbChuyenDe;
    private javax.swing.JComboBox<String> cbbKhoaHoc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_soTrang;
    private javax.swing.JLabel lbl_soTrang1;
    private javax.swing.JLabel lbl_trang;
    private javax.swing.JLabel lbl_trang1;
    private javax.swing.JTabbedPane tabs;
    private javax.swing.JTable tblHocVien;
    private javax.swing.JTable tblNguoiHoc;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
