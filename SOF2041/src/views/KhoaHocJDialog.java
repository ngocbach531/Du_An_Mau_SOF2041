/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import DAO.ChuyenDeDAO;
import DAO.KhoaHocDAO;
import Entity.ChuyenDe;
import Entity.KhoaHoc;
import Helper.DateHelper;
import Helper.DialogHelper;
import Helper.Image;
import Helper.ShareHelper;
import Helper.UtilityHelper;
import static java.awt.Color.pink;
import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author BUI_QUANG_HIEU
 */
public class KhoaHocJDialog extends javax.swing.JDialog {

    ChuyenDeDAO _ChuyenDeDAO = new ChuyenDeDAO();
    KhoaHocDAO _KhoaHocDAO = new KhoaHocDAO();
    int _row = 0;
    int _maKH;
    int _trang = 1, _soTrang;

    /**
     * Creates new form NewJDialog
     */
    public KhoaHocJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        init();

    }

    public void init() {
        setLocationRelativeTo(null);
        setIconImage(Image.getAppIcon());
        setResizable(true);
        fillComboBoxChuyenDe();
        selectChuyenDe();
//        txtHocPhi.setEnabled(false);
//        txtThoiLuong.setEnabled(false);
//        txtNguoiTao.setEnabled(false);
//        txtNgayTao.setEnabled(false);      
        txtKhaiGiang.setDateFormatString("dd/MM/yyyy");
        if (tblKhoaHoc.getRowCount() == 0) {
            this.setStatus(true);
        } else {
            this.setStatus(false);
            tblKhoaHoc.setRowSelectionInterval(0, 0);
        }
    }

    public void viewSoTrang() {
        ChuyenDe chuyenDe = (ChuyenDe) cbbChuyenDe.getSelectedItem();
        if (chuyenDe == null) {
            return;
        }
        List<KhoaHoc> list = _KhoaHocDAO.findByCD(chuyenDe.getMaCD()); //Add list khóa học thông qua mã chuyên đề
        if (_KhoaHocDAO.countDB(chuyenDe.getMaCD()) % 10 == 0) {
            _soTrang = _KhoaHocDAO.countDB(chuyenDe.getMaCD()) / 10;
        } else {
            _soTrang = _KhoaHocDAO.countDB(chuyenDe.getMaCD()) / 10 + 1;
        }
        this.fillTable(1);
        if (_soTrang == 0) {
            lbl_soTrang.setText("0/0");
            lbl_Trang.setText("Trang: 0");
        } else {
            lbl_soTrang.setText("1/" + _soTrang);
            lbl_Trang.setText("Trang: 1");
        }
    }

    //Đổ tên chuyên đề và combobox
    public void fillComboBoxChuyenDe() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cbbChuyenDe.getModel();
        model.removeAllElements();
        try {
            List<ChuyenDe> list = _ChuyenDeDAO.selectAll();
            for (ChuyenDe cd : list) {
                model.addElement(cd);
            }
        } catch (Exception e) {
            e.printStackTrace();
            DialogHelper.alert(this, "Lỗi truy vấn dữ liệu");
        }
    }

    //Đổ thông tin của chuyên đề được chọn lên form
    public void selectChuyenDe() {
        ChuyenDe chuyenDe = (ChuyenDe) cbbChuyenDe.getSelectedItem();
        if (chuyenDe == null) {
            return;
        }
        List<KhoaHoc> list = _KhoaHocDAO.findByCD(chuyenDe.getMaCD()); //Add list khóa học thông qua mã chuyên đề
        lblTenCD.setText(chuyenDe.getTenCD());
        txtHocPhi.setText(chuyenDe.getHocPhi() + "");
        txtThoiLuong.setText(chuyenDe.getThoiLuong() + "");
        txtGhiChu.setText(chuyenDe.getTenCD());
        if (list.size() > 0) { //nếu list sau khi check ở trên > 0 thì đổ dữ liệu của khóa học theo mã chuyên đề lên form
            for (KhoaHoc khoaHoc : list) {
                txtKhaiGiang.setDate(khoaHoc.getNgayKG());
                txtNgayTao.setText(DateHelper.toString(khoaHoc.getNgayTao()));
                txtNguoiTao.setText(khoaHoc.getMaNV());
            }
        } else { //nếu list null thì các ô khai giảng, ngày tạo, người tạo null
            txtKhaiGiang.setDate(null);
            txtNgayTao.setText(DateHelper.toString(DateHelper.now()));
            txtNguoiTao.setText(ShareHelper.USER.getMaNV()); // người tạo khóa học sẽ là người đang đăng nhập
        }
//        this.fillTable();
        this.viewSoTrang();
        _row = -1;
        tabs.setSelectedIndex(1); //chuyển sang tab danh sách
    }

    //Load dữ liệu từ DB lên table
    public void fillTable(int trang) {
        DefaultTableModel model = (DefaultTableModel) tblKhoaHoc.getModel();
        model.setRowCount(0);
        try {
            ChuyenDe cd = (ChuyenDe) cbbChuyenDe.getSelectedItem();
//            List<KhoaHoc> list = _KhoaHocDAO.findByCD(cd.getMaCD());
            List<KhoaHoc> list = _KhoaHocDAO.fillTop(trang, cd.getMaCD());
            for (KhoaHoc kh : list) {
                Object[] row = {kh.getMaKH(), kh.getThoiLuong(), kh.getHocPhi(), DateHelper.toString(kh.getNgayKG()),
                    kh.getMaNV(), DateHelper.toString(kh.getNgayTao())};
                model.addRow(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
            DialogHelper.alert(this, "Lỗi truy vấn dữ liệu table");
        }

    }

    //Thêm 1 bản ghi từ from vào DB và update lại table
    public void insert() {
        KhoaHoc model = getForm();
//        System.out.println(model);
        model.setNgayTao(DateHelper.now());
        try {
            _KhoaHocDAO.insert(model);
//            this.fillTable();
            this.viewSoTrang();
            this.clearForm();
            tabs.setSelectedIndex(1);
            DialogHelper.alert(this, "Thêm mới thành công!");
        } catch (HeadlessException e) {
            e.printStackTrace();
            DialogHelper.alert(this, "Thêm mới thất bại!");
        }
    }

    //Cập nhật 1 bản ghi từ form và update lại table
    public void update() {
        KhoaHoc model = getForm();
        if (_maKH == -1) {
            DialogHelper.alert(this, "Mời bạn chọn đối tượng cần sửa");
            return;
        }
        try {
            _KhoaHocDAO.update(model);
//            this.fillTable();
            this.viewSoTrang();
            tabs.setSelectedIndex(1);
            DialogHelper.alert(this, "Cập nhật thành công!");
        } catch (Exception e) {
            e.printStackTrace();
            DialogHelper.alert(this, "Cập nhật thất bại!");
        }
    }

    //Xóa 1 bản ghi trong DB và update lại table
    public void delete() {
        if (DialogHelper.confirm(this, "Bạn thực sự muốn xóa khóa học này?")) {
            int makh = Integer.valueOf(cbbChuyenDe.getToolTipText()); //Lấy lại mã khóa học khi cbb thay đổi (setToolTipText khai báo ở phương thức setForm()
            try {
                _KhoaHocDAO.delete(makh);
//                this.fillTable();
                this.viewSoTrang();
                this.clearForm();
                DialogHelper.alert(this, "Xóa thành công!");
                tabs.setSelectedIndex(1);
            } catch (Exception e) {
                e.printStackTrace();
                DialogHelper.alert(this, "Xóa thất bại!");
            }
        }
    }

    //Đổ dữ liệu từ DB lên form
    public void setForm(KhoaHoc kh) {
        cbbChuyenDe.setToolTipText(String.valueOf(kh.getMaKH())); //Mã khóa học thay đổi khi Cbb thay đổi (nhớ tạm)
        cbbChuyenDe.getModel().setSelectedItem(_ChuyenDeDAO.selectById(kh.getMaCD()));
        txtKhaiGiang.setDate(kh.getNgayKG());
        txtHocPhi.setText(String.valueOf(kh.getHocPhi()));
        txtThoiLuong.setText(String.valueOf(kh.getThoiLuong()));
        txtNguoiTao.setText(kh.getMaNV());
        txtNgayTao.setText(DateHelper.toString(kh.getNgayTao()));
        txtGhiChu.setText(kh.getGhiChu());
    }

    //Khởi tạo 1 đối tượng và đổ dữ liệu các thuộc tính của đối tượng theo form
    public KhoaHoc getForm() {
        KhoaHoc kh = new KhoaHoc();
        ChuyenDe cd = (ChuyenDe) cbbChuyenDe.getSelectedItem();
        kh.setMaCD(cd.getMaCD());
        kh.setNgayKG(txtKhaiGiang.getDate());
        kh.setNgayTao(DateHelper.toDate(txtNgayTao.getText()));
        kh.setHocPhi(Double.parseDouble(txtHocPhi.getText()));
        kh.setThoiLuong(Integer.parseInt(txtThoiLuong.getText()));
        kh.setGhiChu(txtGhiChu.getText());
        kh.setMaNV(txtNguoiTao.getText());
//        System.out.println(cbbChuyenDe.getToolTipText());
        if (cbbChuyenDe.getToolTipText() != null) {
            kh.setMaKH(Integer.parseInt(cbbChuyenDe.getToolTipText())); //Lấy lại mã khóa học khi cbb thay đổi (setToolTipText khai báo ở phương thức setForm())
        }
        return kh;
    }

    //Xóa trắng thông tin trên form
    public void clearForm() {
        ChuyenDe chuyenDe = (ChuyenDe) cbbChuyenDe.getSelectedItem();
        List<KhoaHoc> list = _KhoaHocDAO.findByCD(chuyenDe.getMaCD());
        lblTenCD.setText(chuyenDe.getTenCD());
        txtHocPhi.setText(chuyenDe.getHocPhi() + "");
        txtThoiLuong.setText(chuyenDe.getThoiLuong() + "");
        txtGhiChu.setText("");
        for (KhoaHoc khoaHoc : list) {
            txtKhaiGiang.setDate(khoaHoc.getNgayKG());
            txtNgayTao.setText(DateHelper.toString(khoaHoc.getNgayTao()));
            txtNguoiTao.setText(khoaHoc.getMaNV());
        }
        txtKhaiGiang.setDate(null);
        txtNgayTao.setText(DateHelper.toString(DateHelper.now()));
        txtNguoiTao.setText(ShareHelper.USER.getMaNV());
        setStatus(true); //Chuyển chế độ
    }

    //Tạo trạng thái các nút
    public void setStatus(boolean insertable) {
        btnInsert.setEnabled(insertable);
        btnUpdate.setEnabled(!insertable);
        btnDelete.setEnabled(!insertable);
        boolean first = this._row > 0;
        boolean last = this._row < tblKhoaHoc.getRowCount() - 1;
        btnFirst.setEnabled(!insertable && first);
        btnPrev.setEnabled(!insertable && first);
        btnLast.setEnabled(!insertable && last);
        btnNext.setEnabled(!insertable && last);
    }

    //Dùng để check giữa ngày tạo khóa học và ngày khai giảng cách nhau 5 ngày
    public boolean check5ngay(String txt, String txt2) {
        Date date = DateHelper.toDate(txt);
        Date date2 = DateHelper.toDate(txt2);
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(date);
        c2.setTime(date2);
        long a = (c1.getTime().getTime() - c2.getTime().getTime()) / (24 * 3600 * 1000);
        if (a >= 5) {
            return true;
        } else {;
            DialogHelper.alert(this, "Ngày khai giảng phải sau cách ngày tạo ít nhất 5 ngày.");
            return false;
        }
    }

    //Lấy dữ liệu đổ lên form theo index
    public void edit() {
        try {
            Integer makh = (Integer) tblKhoaHoc.getValueAt(this._row, 0);
            KhoaHoc model = _KhoaHocDAO.findById(makh);
            if (model != null) {
                this.setForm(model);
                this.setStatus(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
            DialogHelper.alert(this, "Lỗi truy vấn dữ liệu!");
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

        jPanel3 = new javax.swing.JPanel();
        cbbChuyenDe = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        tabs = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtThoiLuong = new javax.swing.JTextField();
        txtNgayTao = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtGhiChu = new javax.swing.JTextArea();
        btnInsert = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnFirst = new javax.swing.JButton();
        btnPrev = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtNguoiTao = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtHocPhi = new javax.swing.JTextField();
        lblTenCD = new javax.swing.JLabel();
        txtKhaiGiang = new com.toedter.calendar.JDateChooser();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblKhoaHoc = new javax.swing.JTable();
        btnFirst1 = new javax.swing.JButton();
        btnPrev1 = new javax.swing.JButton();
        btnNext1 = new javax.swing.JButton();
        btnLast1 = new javax.swing.JButton();
        lbl_Trang = new javax.swing.JLabel();
        lbl_soTrang = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("EduSys - Quản lý khóa học");

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
                .addComponent(cbbChuyenDe, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbbChuyenDe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 0, 0));
        jLabel1.setText("CHUYÊN ĐỀ");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Khai giảng");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Thời lượng (giờ)");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Ngày tạo");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Ghi chú");

        txtThoiLuong.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtThoiLuong.setName("Thời lượng"); // NOI18N

        txtNgayTao.setEditable(false);
        txtNgayTao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtGhiChu.setColumns(20);
        txtGhiChu.setLineWrap(true);
        txtGhiChu.setRows(5);
        txtGhiChu.setWrapStyleWord(true);
        jScrollPane2.setViewportView(txtGhiChu);

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

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Chuyên đề");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Học phí");

        txtNguoiTao.setEditable(false);
        txtNguoiTao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Người tạo");

        txtHocPhi.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtHocPhi.setName("Học phí"); // NOI18N

        lblTenCD.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblTenCD.setForeground(new java.awt.Color(204, 0, 0));

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
                                .addComponent(btnInsert)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnUpdate)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnDelete)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnClear)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnFirst)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnPrev)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnNext)
                                .addGap(9, 9, 9)
                                .addComponent(btnLast))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblTenCD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtNguoiTao, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
                                    .addComponent(txtHocPhi))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtNgayTao)
                                    .addComponent(txtThoiLuong)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtKhaiGiang, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE))))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTenCD, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(txtKhaiGiang, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtHocPhi, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                    .addComponent(txtThoiLuong))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNguoiTao, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInsert)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelete)
                    .addComponent(btnClear)
                    .addComponent(btnFirst)
                    .addComponent(btnPrev)
                    .addComponent(btnNext)
                    .addComponent(btnLast))
                .addContainerGap())
        );

        tabs.addTab("CẬP NHẬT", jPanel1);

        tblKhoaHoc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MÃ KH", "THỜI LƯỢNG", "HỌC PHÍ", "KHAI GIẢNG", "TẠO BỞI", "NGÀY TẠO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblKhoaHoc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKhoaHocMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblKhoaHoc);

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

        lbl_Trang.setText("jLabel4");

        lbl_soTrang.setText("jLabel4");

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
                        .addComponent(lbl_Trang)
                        .addGap(24, 24, 24)
                        .addComponent(btnNext1)
                        .addGap(9, 9, 9)
                        .addComponent(btnLast1)
                        .addGap(18, 18, 18)
                        .addComponent(lbl_soTrang)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFirst1)
                    .addComponent(btnPrev1)
                    .addComponent(btnNext1)
                    .addComponent(btnLast1)
                    .addComponent(lbl_Trang)
                    .addComponent(lbl_soTrang))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        tabs.addTab("DANH SÁCH", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tabs, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tabs)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblKhoaHocMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKhoaHocMouseClicked
        try {
            this._row = tblKhoaHoc.rowAtPoint(evt.getPoint()); //lấy vị trí dòng trong bảng
            if (this._row >= 0) {
                this.edit();
                this.setStatus(false);
            }
            if (evt.getClickCount() == 2) {
                tabs.setSelectedIndex(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
            DialogHelper.alert(this, "Lỗi truy vấn dữ liệu");

        }
    }//GEN-LAST:event_tblKhoaHocMouseClicked

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
        if (txtKhaiGiang.getDate() == null) {
            DialogHelper.alert(this, "Mời bạn chọn ngày khai giảng !");
            return;
        }
        if (UtilityHelper.checkSoHocPhi(txtHocPhi)
                && UtilityHelper.checkSoThoiLuong(txtThoiLuong)
                && UtilityHelper.checkHocPhi(txtHocPhi)
                && UtilityHelper.checkThoiLuong(txtThoiLuong)
                && check5ngay(DateHelper.toString(txtKhaiGiang.getDate()), String.valueOf(txtNgayTao.getText()))) {

            insert();
        }
    }//GEN-LAST:event_btnInsertActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        if (_row == -1) {
            DialogHelper.alert(this, "Mời bạn chọn đối tượng trong bảng cần sửa");
            return;
        }
        if (txtKhaiGiang.getDate() == null) {
            DialogHelper.alert(this, "Mời bạn chọn ngày khai giảng !");
            return;
        }

        if (UtilityHelper.checkSoHocPhi(txtHocPhi)
                && UtilityHelper.checkSoThoiLuong(txtThoiLuong)
                && UtilityHelper.checkHocPhi(txtHocPhi)
                && UtilityHelper.checkThoiLuong(txtThoiLuong)
                && check5ngay(DateHelper.toString(txtKhaiGiang.getDate()), String.valueOf(txtNgayTao.getText()))) {
            update();
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        if (DialogHelper.confirm(this, "Bạn thực sự muốn clear ?")) {
            clearForm();
        }
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if (ShareHelper.USER.isVaiTro()) {
            delete();
        } else {
            DialogHelper.alert(this, "Chỉ trưởng phòng mới được phép xóa");
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

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
        this._row = tblKhoaHoc.getRowCount() - 1;
        this.edit();
    }//GEN-LAST:event_btnLastActionPerformed

    private void cbbChuyenDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbChuyenDeActionPerformed
        try {
            this.selectChuyenDe();
        } catch (Exception e) {
            e.printStackTrace();
            DialogHelper.alert(this, "Lỗi truy xuất ActionPerForm");
        }
        if (tblKhoaHoc.getRowCount() == 0) {
            this.setStatus(true);
        }

    }//GEN-LAST:event_cbbChuyenDeActionPerformed

    private void btnFirst1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirst1ActionPerformed
        _trang = 1;
        this.fillTable(_trang);
        lbl_Trang.setText("Trang: " + _trang);
        lbl_soTrang.setText(_trang + "/" + _soTrang);
    }//GEN-LAST:event_btnFirst1ActionPerformed

    private void btnPrev1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrev1ActionPerformed
        if (_trang > 1) {
            _trang--;
            this.fillTable(_trang);
            lbl_Trang.setText("Trang: " + _trang);
            lbl_soTrang.setText(_trang + "/" + _soTrang);
        }
    }//GEN-LAST:event_btnPrev1ActionPerformed

    private void btnNext1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNext1ActionPerformed
        if (_trang < _soTrang) {
            _trang++;
            this.fillTable(_trang);
            lbl_Trang.setText("Trang: " + _trang);
            lbl_soTrang.setText(_trang + "/" + _soTrang);
        }
    }//GEN-LAST:event_btnNext1ActionPerformed

    private void btnLast1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLast1ActionPerformed
        _trang = _soTrang;
        this.fillTable(_trang);
        lbl_Trang.setText("Trang: " + _trang);
        lbl_soTrang.setText(_trang + "/" + _soTrang);
    }//GEN-LAST:event_btnLast1ActionPerformed

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
            java.util.logging.Logger.getLogger(KhoaHocJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KhoaHocJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KhoaHocJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KhoaHocJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                KhoaHocJDialog dialog = new KhoaHocJDialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnFirst;
    private javax.swing.JButton btnFirst1;
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnLast1;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnNext1;
    private javax.swing.JButton btnPrev;
    private javax.swing.JButton btnPrev1;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cbbChuyenDe;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblTenCD;
    private javax.swing.JLabel lbl_Trang;
    private javax.swing.JLabel lbl_soTrang;
    private javax.swing.JTabbedPane tabs;
    private javax.swing.JTable tblKhoaHoc;
    private javax.swing.JTextArea txtGhiChu;
    private javax.swing.JTextField txtHocPhi;
    private com.toedter.calendar.JDateChooser txtKhaiGiang;
    private javax.swing.JTextField txtNgayTao;
    private javax.swing.JTextField txtNguoiTao;
    private javax.swing.JTextField txtThoiLuong;
    // End of variables declaration//GEN-END:variables
}
