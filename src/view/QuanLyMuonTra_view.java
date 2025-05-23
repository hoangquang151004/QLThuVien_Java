/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.awt.List;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import model.QuanLyMuonTra_model;

/**
 *
 * @author hq151
 */
public class QuanLyMuonTra_view extends javax.swing.JFrame {
        QuanLyMuonTra_model model ;
        
    /**
     * Creates new form QuanLyMuonTra_view
     */
    public QuanLyMuonTra_view() {
        this.setTitle("Form Quản lý mượn trả");
        initComponents();
        this.setVisible(true);
        model = new QuanLyMuonTra_model();
        loadPhieuMuon();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtMaTaiKhoan = new javax.swing.JTextField();
        cmbTrangThai = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lstDanhSachSach = new java.awt.List();
        txtNgayMuon = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        btnTimKiem = new javax.swing.JButton();
        txtTenTaiKhoan = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        btnTraSach = new javax.swing.JButton();
        txtTimKiem = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtNgayTra = new javax.swing.JTextField();
        txtMaPhieuMuon = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTraSach = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnTao = new javax.swing.JButton();
        lblSoLuongSachMuon = new javax.swing.JLabel();
        btnChinhSua = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        txtGiaHan = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuQuanLySach = new javax.swing.JMenu();
        MenuQuanLyBanDoc = new javax.swing.JMenu();
        menuQuanLyPhieuViPham = new javax.swing.JMenu();
        menuQuanLyBaoCao = new javax.swing.JMenu();
        menuQuanLyMuonTra = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cmbTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chưa đến hạn", "Đã trả", "Đã quá hạn" }));

        jLabel12.setText("Ngày Trả:");

        jLabel9.setText("Mã Tài Khoản:");

        jLabel10.setText("Trạng Thái:");

        jLabel8.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel8.setText("Quản lý mượn trả");

        btnTimKiem.setText("Tìm Kiếm ");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        jLabel11.setText("Ngày Mượn:");

        btnTraSach.setText("Xác nhận trả sách");
        btnTraSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTraSachActionPerformed(evt);
            }
        });

        txtTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiemActionPerformed(evt);
            }
        });

        jLabel13.setText("Tên Tài Khoản:");

        tblTraSach.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã Phiếu Mượn", "Mã Bạn Đọc ", "Tên Bạn Đọc", "Ngày Mượn", "Ngày Trả", "Gia hạn", "Số Lượng Sách Mượn", "Trạng thái"
            }
        ));
        tblTraSach.setMinimumSize(new java.awt.Dimension(100, 100));
        tblTraSach.setRowHeight(30);
        tblTraSach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTraSachMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblTraSach);

        jLabel1.setText("Số lượng sách mượn : ");

        jLabel2.setText("Mã Phiếu Mượn:");

        btnTao.setText("Tạo");
        btnTao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoActionPerformed(evt);
            }
        });

        lblSoLuongSachMuon.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblSoLuongSachMuon.setText("0");

        btnChinhSua.setText("Chỉnh sửa");
        btnChinhSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChinhSuaActionPerformed(evt);
            }
        });

        jLabel14.setText("Gia hạn:");

        menuQuanLySach.setText("Quản lý sách");
        menuQuanLySach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuQuanLySachMouseClicked(evt);
            }
        });
        jMenuBar1.add(menuQuanLySach);

        MenuQuanLyBanDoc.setText("Quản lý bạn đọc");
        MenuQuanLyBanDoc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenuQuanLyBanDocMouseClicked(evt);
            }
        });
        jMenuBar1.add(MenuQuanLyBanDoc);

        menuQuanLyPhieuViPham.setText("Quản lý phiếu vi phạm");
        menuQuanLyPhieuViPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuQuanLyPhieuViPhamMouseClicked(evt);
            }
        });
        jMenuBar1.add(menuQuanLyPhieuViPham);

        menuQuanLyBaoCao.setText("Quản lý báo cáo");
        menuQuanLyBaoCao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuQuanLyBaoCaoMouseClicked(evt);
            }
        });
        jMenuBar1.add(menuQuanLyBaoCao);

        menuQuanLyMuonTra.setText("Quản lý mượn trả");
        menuQuanLyMuonTra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuQuanLyMuonTraMouseClicked(evt);
            }
        });
        jMenuBar1.add(menuQuanLyMuonTra);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel9)
                                            .addComponent(jLabel13))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtMaTaiKhoan, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                                            .addComponent(txtMaPhieuMuon, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                                            .addComponent(txtTenTaiKhoan)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(75, 75, 75)
                                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(11, 11, 11)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtNgayMuon, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                                            .addComponent(txtNgayTra)
                                            .addComponent(txtGiaHan)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(26, 26, 26)
                                        .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(42, 42, 42)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnTraSach, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(btnChinhSua, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnTao, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel8)
                                .addGap(214, 214, 214)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(lblSoLuongSachMuon, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lstDanhSachSach, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(lblSoLuongSachMuon))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lstDanhSachSach, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 42, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnTimKiem)
                            .addComponent(btnTao))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnChinhSua)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtMaPhieuMuon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(txtNgayMuon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnTraSach))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtMaTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)
                            .addComponent(txtNgayTra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(txtTenTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14)
                            .addComponent(cmbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtGiaHan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
    timKiemPhieuMuon();
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void btnTraSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTraSachActionPerformed
            xacNhanTraSach();
            this.loadPhieuMuon();
    }//GEN-LAST:event_btnTraSachActionPerformed

    private void txtTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimKiemActionPerformed

    private void tblTraSachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTraSachMouseClicked
      this.layDuLieuTrongBangBanDoc();
      this.loadSachMuon();
    }//GEN-LAST:event_tblTraSachMouseClicked

    private void btnTaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoActionPerformed
        new taoPhieuMuon_view();
        this.dispose();// TODO add your handling code here:
    }//GEN-LAST:event_btnTaoActionPerformed

    private void btnChinhSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChinhSuaActionPerformed
        suaPhieuMuon(); 
        this.loadPhieuMuon();// TODO add your handling code here:
    }//GEN-LAST:event_btnChinhSuaActionPerformed

    private void menuQuanLySachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuQuanLySachMouseClicked
        new QuanLySach_view();
     this.dispose();
    }//GEN-LAST:event_menuQuanLySachMouseClicked

    private void MenuQuanLyBanDocMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuQuanLyBanDocMouseClicked
      new QuanLyBanDoc_view();
      this.dispose();
    }//GEN-LAST:event_MenuQuanLyBanDocMouseClicked

    private void menuQuanLyMuonTraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuQuanLyMuonTraMouseClicked
        new QuanLyMuonTra_view();
    this.dispose();// TODO add your handling code here:
    }//GEN-LAST:event_menuQuanLyMuonTraMouseClicked

    private void menuQuanLyPhieuViPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuQuanLyPhieuViPhamMouseClicked
       new QuanLyPhieuViPham_view();
       this.dispose();
    }//GEN-LAST:event_menuQuanLyPhieuViPhamMouseClicked

    private void menuQuanLyBaoCaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuQuanLyBaoCaoMouseClicked
           new QuanLyBaoCao_view();
           this.dispose(); // TODO add your handling code here:
    }//GEN-LAST:event_menuQuanLyBaoCaoMouseClicked

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
            java.util.logging.Logger.getLogger(QuanLyMuonTra_view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLyMuonTra_view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLyMuonTra_view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLyMuonTra_view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuanLyMuonTra_view().setVisible(true);
            }
        });
    }
    public void loadPhieuMuon(){
        tblTraSach.setModel(model.loadPhieuMuon(tblTraSach));
    }
    public void loadSachMuon(){
        lstDanhSachSach.clear();
        model.setMaPhieuMuon(Integer.valueOf(txtMaPhieuMuon.getText()));
        model.layTenSachMuon();
       for(int i = 0 ; i < model.layTenSachMuon().size(); i ++){
           lstDanhSachSach.add((i+1)+". "+model.layTenSachMuon().get(i));
       }
       
    }
     public void layDuLieuTrongBangBanDoc(){
        int selectedRow = tblTraSach.getSelectedRow();
        if (selectedRow != -1) {
                    // Lấy dữ liệu của các cột tại dòng được chọn
                    Object maPhieuMuon = tblTraSach.getValueAt(selectedRow, 0);
                    Object maTaiKhoan = tblTraSach.getValueAt(selectedRow, 1);
                    Object tenTaiKhoan = tblTraSach.getValueAt(selectedRow, 2);
                    Object ngayMuon = tblTraSach.getValueAt(selectedRow, 3);
                    Object ngayTra = tblTraSach.getValueAt(selectedRow, 4);
                    Object daGiaHan = tblTraSach.getValueAt(selectedRow, 5);
                    Object soLuongSachMuon = tblTraSach.getValueAt(selectedRow, 6);
                    Object trangThai = tblTraSach.getValueAt(selectedRow, 7);
                      
                        this.txtMaPhieuMuon.setText(maPhieuMuon.toString());
                        this.txtMaTaiKhoan.setText(maTaiKhoan.toString());
                        this.txtTenTaiKhoan.setText(tenTaiKhoan.toString());
                        this.txtNgayMuon.setText(ngayMuon.toString());
                        this.txtNgayTra.setText(ngayTra.toString());
                        this.lblSoLuongSachMuon.setText(soLuongSachMuon.toString());
                        this.txtGiaHan.setText(daGiaHan.toString());
                        this.cmbTrangThai.setSelectedItem(trangThai.toString());

                } else {
                    // Nếu không có dòng nào được chọn
                    JOptionPane.showMessageDialog(this, "Chưa chọn dòng nào.");
                }
     }
     public void xacNhanTraSach(){
         model.xacNhanTraSach(Integer.valueOf(txtMaPhieuMuon.getText()));
          JOptionPane.showMessageDialog(this, "Trả sách thành công.");
          
          ArrayList<Integer> ds = model.layMaSachMuon(Integer.valueOf(txtMaPhieuMuon.getText()));
         for(int i = 0 ; i < ds.size(); i ++){
            model.traChiTietSach(ds.get(i));
            System.out.println(ds.get(i));
       }
         System.out.println("hehe");
     }
     public void suaPhieuMuon(){
         model.setNgayMuon(txtNgayMuon.getText());
         model.setNgayTra(txtNgayTra.getText());
         boolean daGiaHan = false;
         if(txtGiaHan.getText().equals("true")){
             daGiaHan = true;
         }
         model.setGiaHan(daGiaHan);
         model.setTrangThai(cmbTrangThai.getSelectedItem().toString());
         model.setMaPhieuMuon(Integer.valueOf(txtMaPhieuMuon.getText()));
         model.suaPhieuMuon();
     }
     public void timKiemPhieuMuon(){
         this.tblTraSach.setModel(model.timKiemPhieuMuon(txtTimKiem.getText(), tblTraSach));
     }
       

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu MenuQuanLyBanDoc;
    private javax.swing.JButton btnChinhSua;
    private javax.swing.JButton btnTao;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnTraSach;
    private javax.swing.JComboBox<String> cmbTrangThai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblSoLuongSachMuon;
    private java.awt.List lstDanhSachSach;
    private javax.swing.JMenu menuQuanLyBaoCao;
    private javax.swing.JMenu menuQuanLyMuonTra;
    private javax.swing.JMenu menuQuanLyPhieuViPham;
    private javax.swing.JMenu menuQuanLySach;
    private javax.swing.JTable tblTraSach;
    private javax.swing.JTextField txtGiaHan;
    private javax.swing.JTextField txtMaPhieuMuon;
    private javax.swing.JTextField txtMaTaiKhoan;
    private javax.swing.JTextField txtNgayMuon;
    private javax.swing.JTextField txtNgayTra;
    private javax.swing.JTextField txtTenTaiKhoan;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
