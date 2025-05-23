/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import model.QuanLyBanDoc_model;

/**
 *
 * @author hq151
 */
public class QuanLyBanDoc_view extends javax.swing.JFrame {
        QuanLyBanDoc_model model;
    /**
     * Creates new form QuanLyBanDoc_view
     */
    public QuanLyBanDoc_view() {
        this.setTitle("Form Quản lý bạn đọc");
        initComponents();
        this.model = new QuanLyBanDoc_model();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Quản Lý Bạn đọc");
        this.loadBanDoc(tblQuanLyBanDoc);
        this.setVisible(true);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tblQuanLyBanDoc = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnXoa = new javax.swing.JButton();
        btnChinhSua = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        btnTimKiem = new javax.swing.JButton();
        cmbQuyenHan = new javax.swing.JComboBox<>();
        txtTenTaiKhoan = new javax.swing.JTextField();
        txtTimKiem = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtNgaySinh = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtHoTen = new javax.swing.JTextField();
        txtDiaChi = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();
        txtMaTaiKhoan = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuQuanLySach = new javax.swing.JMenu();
        menuQuanLyBanDoc = new javax.swing.JMenu();
        menuQuanLyPhieuViPham = new javax.swing.JMenu();
        menuQuanLyBaoCao = new javax.swing.JMenu();
        menuQuanLyMuonTra = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblQuanLyBanDoc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã tài khoản", "Tên tài khoản", "Họ tên", "Ngày sinh", "Địa chỉ", "SDT", "Quyền hạn"
            }
        ));
        tblQuanLyBanDoc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblQuanLyBanDocMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblQuanLyBanDoc);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Quản lý bạn đọc");

        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnChinhSua.setText("Chỉnh sửa");
        btnChinhSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChinhSuaActionPerformed(evt);
            }
        });

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnTimKiem.setText("Tìm kiếm");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        cmbQuyenHan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "Bạn đọc", " " }));

        jLabel7.setText("Họ tên:");

        jLabel8.setText("Quyền hạn:");

        jLabel2.setText("Mã tài khoản: ");

        jLabel3.setText("Địa chỉ:");

        jLabel4.setText("Tên tài khoản: ");

        jLabel5.setText("Ngày sinh:");

        jLabel6.setText("SDT:");

        menuQuanLySach.setText("Quản lý sách");
        menuQuanLySach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuQuanLySachMouseClicked(evt);
            }
        });
        jMenuBar1.add(menuQuanLySach);

        menuQuanLyBanDoc.setText("Quản lý bạn đọc");
        menuQuanLyBanDoc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuQuanLyBanDocMouseClicked(evt);
            }
        });
        jMenuBar1.add(menuQuanLyBanDoc);

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
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(237, 237, 237)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtMaTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTenTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(93, 93, 93)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbQuyenHan, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnThem)
                        .addGap(58, 58, 58)
                        .addComponent(btnChinhSua))
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnTimKiem))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                        .addComponent(btnXoa)))
                .addGap(43, 43, 43))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMaTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnTimKiem)
                                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTenTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel8)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbQuyenHan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThem)
                    .addComponent(btnChinhSua)
                    .addComponent(btnXoa))
                .addGap(42, 42, 42)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        this.themBanDoc();
        this.loadBanDoc(tblQuanLyBanDoc);        // TODO add your handling code here:
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnChinhSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChinhSuaActionPerformed
        this.suaBanDoc();
        this.loadBanDoc(tblQuanLyBanDoc);  // TODO add your handling code here:
    }//GEN-LAST:event_btnChinhSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        this.xoaBanDoc();
        this.loadBanDoc(tblQuanLyBanDoc);        // TODO add your handling code here:
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
      this.timKiemBanDoc();  // TODO add your handling code here:
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void tblQuanLyBanDocMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblQuanLyBanDocMouseClicked
        this.layDuLieuTrongBang();        // TODO add your handling code here:
    }//GEN-LAST:event_tblQuanLyBanDocMouseClicked

    private void menuQuanLySachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuQuanLySachMouseClicked
       new QuanLySach_view();
     this.dispose(); // TODO add your handling code here:
    }//GEN-LAST:event_menuQuanLySachMouseClicked

    private void menuQuanLyBanDocMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuQuanLyBanDocMouseClicked
     new QuanLyBanDoc_view();
    this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_menuQuanLyBanDocMouseClicked

    private void menuQuanLyPhieuViPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuQuanLyPhieuViPhamMouseClicked
        new QuanLyPhieuViPham_view();
    this.dispose();// TODO add your handling code here:
    }//GEN-LAST:event_menuQuanLyPhieuViPhamMouseClicked

    private void menuQuanLyBaoCaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuQuanLyBaoCaoMouseClicked
       new QuanLyBaoCao_view();
    this.dispose(); // TODO add your handling code here:
    }//GEN-LAST:event_menuQuanLyBaoCaoMouseClicked

    private void menuQuanLyMuonTraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuQuanLyMuonTraMouseClicked
        new QuanLyMuonTra_view();
    this.dispose();// TODO add your handling code here:
    }//GEN-LAST:event_menuQuanLyMuonTraMouseClicked

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
            java.util.logging.Logger.getLogger(QuanLyBanDoc_view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLyBanDoc_view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLyBanDoc_view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLyBanDoc_view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuanLyBanDoc_view().setVisible(true);
            }
        });
    }
    public void loadBanDoc(JTable jtable){
       this.tblQuanLyBanDoc.setModel( this.model.loadBanDoc(jtable));
    }
    public void themBanDoc(){
        this.model.setMaTaiKhoan(Integer.valueOf(txtMaTaiKhoan.getText()));
        this.model.setTenTaiKhoan(txtTenTaiKhoan.getText());
        this.model.setHoTen(txtHoTen.getText());
        this.model.setNgaySinh(txtNgaySinh.getText());
        this.model.setDiaChi(txtDiaChi.getText());
        this.model.setSDT(Integer.valueOf(txtSDT.getText()));
        this.model.setQuyenHan(cmbQuyenHan.getSelectedItem().toString());
        String s = this.model.themDLBanDoc();
    }
    public void suaBanDoc(){
         this.model.setMaTaiKhoan(Integer.valueOf(txtMaTaiKhoan.getText()));
        this.model.setTenTaiKhoan(txtTenTaiKhoan.getText());
        this.model.setHoTen(txtHoTen.getText());
        this.model.setNgaySinh(txtNgaySinh.getText());
        this.model.setDiaChi(txtDiaChi.getText());
        this.model.setSDT(Integer.valueOf(txtSDT.getText()));
        this.model.setQuyenHan(cmbQuyenHan.getSelectedItem().toString());
         String s = this.model.suaDLBanDoc();  
         JOptionPane.showMessageDialog(this,s);
    }
     public void xoaBanDoc(){
        this.model.setMaTaiKhoan(Integer.valueOf(txtMaTaiKhoan.getText()));
        String s = this.model.xoaDLBanDoc();
        JOptionPane.showMessageDialog(this,"Xóa thành công\n"+s);
    }
    public void layDuLieuTrongBang(){
        int selectedRow = tblQuanLyBanDoc.getSelectedRow();
        if (selectedRow != -1) {
                    // Lấy dữ liệu của các cột tại dòng được chọn
                    Object maTaiKhoan = tblQuanLyBanDoc.getValueAt(selectedRow, 0);
                    Object tenTaiKhoan = tblQuanLyBanDoc.getValueAt(selectedRow, 1);
                    Object hoTen = tblQuanLyBanDoc.getValueAt(selectedRow, 2);
                    Object ngaySinh = tblQuanLyBanDoc.getValueAt(selectedRow, 3);
                    Object diaChi = tblQuanLyBanDoc.getValueAt(selectedRow, 4);
                    Object SDT = tblQuanLyBanDoc.getValueAt(selectedRow, 5);
                    Object quyenHan = tblQuanLyBanDoc.getValueAt(selectedRow, 6);
                   
                    // Hiển thị dữ liệu ra textbox
                    txtMaTaiKhoan.setText(maTaiKhoan.toString());
                    txtTenTaiKhoan.setText(tenTaiKhoan.toString());
                    txtHoTen.setText(hoTen.toString());
                    txtHoTen.setText(hoTen.toString());
                    txtNgaySinh.setText(ngaySinh.toString());
                    txtDiaChi.setText(diaChi.toString());
                    txtSDT.setText(SDT.toString());
                    cmbQuyenHan.setSelectedItem(quyenHan.toString());
                    
                } else {
                    // Nếu không có dòng nào được chọn
                    JOptionPane.showMessageDialog(this, "Chưa chọn dòng nào.");
                }
        }
     public void timKiemBanDoc(){
            this.model.setDlTimKiem(txtTimKiem.getText());
            this.tblQuanLyBanDoc.setModel(this.model.timKiem(tblQuanLyBanDoc));        
        }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChinhSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cmbQuyenHan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenu menuQuanLyBanDoc;
    private javax.swing.JMenu menuQuanLyBaoCao;
    private javax.swing.JMenu menuQuanLyMuonTra;
    private javax.swing.JMenu menuQuanLyPhieuViPham;
    private javax.swing.JMenu menuQuanLySach;
    private javax.swing.JTable tblQuanLyBanDoc;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtMaTaiKhoan;
    private javax.swing.JTextField txtNgaySinh;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTenTaiKhoan;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
