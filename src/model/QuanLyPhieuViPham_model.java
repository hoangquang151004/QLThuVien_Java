/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hq151
 */
public class QuanLyPhieuViPham_model extends Database_model{
    private int maPhieuViPham;
    private int maTaiKhoan;
    private String tenTaiKhoan;
    private String nguoiTao;
    private String ngayViPham;
    private ArrayList<String> danhSachViPham;
    private String dlTimKiem;

    public QuanLyPhieuViPham_model(){
    }

    public int getMaPhieuViPham() {
        return maPhieuViPham;
    }

    public void setMaPhieuViPham(int maPhieuViPham) {
        this.maPhieuViPham = maPhieuViPham;
    }

    public int getMaTaiKhoan() {
        return maTaiKhoan;
    }

    public void setMaTaiKhoan(int maTaiKhoan) {
        this.maTaiKhoan = maTaiKhoan;
    }

    public String getTenTaiKhoan() {
        return tenTaiKhoan;
    }

    public void setTenTaiKhoan(String tenTaiKhoan) {
        this.tenTaiKhoan = tenTaiKhoan;
    }

    public String getNguoiTao() {
        return nguoiTao;
    }

    public void setNguoiTao(String nguoiTao) {
        this.nguoiTao = nguoiTao;
    }

    public String getNgayViPham() {
        return ngayViPham;
    }

    public void setNgayViPham(String ngayViPham) {
        this.ngayViPham = ngayViPham;
    }

    public ArrayList<String> getDanhSachViPham() {
        return danhSachViPham;
    }

    public void setDanhSachViPham(ArrayList<String> danhSachViPham) {
        this.danhSachViPham = danhSachViPham;
    }

    public String getDlTimKiem() {
        return dlTimKiem;
    }

    public void setDlTimKiem(String dlTimKiem) {
        this.dlTimKiem = dlTimKiem;
    }
    
   public DefaultTableModel loadPhieuViPham(JTable table) {
             
              DefaultTableModel tableModel = null;
        try {
            Connection connection = this.getConnection();
            String query = "SELECT p.maPhieuViPham, p.maTaiKhoan, t.tenTaiKhoan, p.nguoiTao, p.ngayViPham, p.soLuongViPham  " +
            "FROM PHIEUVIPHAM AS p " +
            "INNER JOIN TAIKHOAN AS t ON p.maTaiKhoan = t.maTaiKhoan";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            // Lấy mô hình của bảng JTable
            tableModel = (DefaultTableModel) table.getModel();
            
            // Xóa dữ liệu cũ trên bảng nếu có
            tableModel.setRowCount(0);

            // Lấy số lượng cột trong ResultSet
            int columnCount = rs.getMetaData().getColumnCount();

            // Duyệt qua ResultSet và thêm vào mô hình bảng
            while (rs.next()) {
                Object[] row = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    row[i - 1] = rs.getObject(i);
                }
                tableModel.addRow(row);
            } 
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
      return tableModel;
}
    public void suaPhieuViPham() {
    String query = null;
    try {
        Connection connection = this.getConnection();
        PreparedStatement pstmt = null;
            query = "UPDATE PHIEUVIPHAM SET nguoiTao =? , ngayViPham =?  WHERE maPhieuViPham = ?";
            pstmt = connection.prepareStatement(query);
            pstmt.setString(1,nguoiTao);
            pstmt.setString(2,ngayViPham);
            pstmt.setInt(3,maPhieuViPham);
           int rowsAffected = pstmt.executeUpdate();
           System.out.println("Sua thanh cong");
           connection.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    }
    
    public DefaultTableModel timKiemPhieuViPham(String thongTin, JTable table) {
    DefaultTableModel tableModel = null;
    String query = null;
    try {
        Connection connection = this.getConnection();
        PreparedStatement pstmt = null;
    try {
            int maSach = Integer.parseInt(thongTin.trim());
            query = "SELECT p.maPhieuViPham, p.maTaiKhoan, t.tenTaiKhoan, p.nguoiTao, p.ngayViPham, p.soLuongViPham  " +
            "FROM PHIEUVIPHAM AS p " +
            "INNER JOIN TAIKHOAN AS t ON p.maTaiKhoan = t.maTaiKhoan WHERE maPhieuViPham = ?";
            pstmt = connection.prepareStatement(query);
            pstmt.setInt(1, maSach);
           
        } catch (NumberFormatException ex) {
             query = "SELECT p.maPhieuViPham, p.maTaiKhoan, t.tenTaiKhoan, p.nguoiTao, p.ngayViPham, p.soLuongViPham  " +
            "FROM PHIEUVIPHAM AS p " +
            "INNER JOIN TAIKHOAN AS t ON p.maTaiKhoan = t.maTaiKhoan WHERE tenTaiKhoan = ?";
            pstmt = connection.prepareStatement(query);
            pstmt.setString(1, thongTin.trim());
        }

        ResultSet rs = pstmt.executeQuery();

        // Lấy mô hình của bảng JTable
        tableModel = (DefaultTableModel) table.getModel();

        // Xóa dữ liệu cũ trên bảng nếu có
        tableModel.setRowCount(0);

        // Lấy số lượng cột trong ResultSet
        int columnCount = rs.getMetaData().getColumnCount();

        // Duyệt qua ResultSet và thêm vào mô hình bảng
        while (rs.next()) {
            Object[] row = new Object[columnCount];
            for (int i = 1; i <= columnCount; i++) {
                row[i - 1] = rs.getObject(i);
            }
            tableModel.addRow(row);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return tableModel;
}
     public String xoaPhieuViPham(int maPhieuMuon) {
    Connection conn = null;
    PreparedStatement pstmt = null;
    try {
        conn = this.getConnection();
        String query = "DELETE CHITIETPHIEUVIPHAM WHERE maPhieuViPham = ?";
        pstmt = conn.prepareStatement(query);
        pstmt.setInt(1, maPhieuMuon);
        
        int rowsAffected = pstmt.executeUpdate();
        
        query = "DELETE PHIEUVIPHAM WHERE maPhieuViPham = ?";
        pstmt = conn.prepareStatement(query);
        pstmt.setInt(1, maPhieuMuon);
        rowsAffected = pstmt.executeUpdate();

        if (rowsAffected > 0) {
            return "Trả sách thành công!";
        } else {
            return "Không tìm thấy phiếu mượn!";
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
        return "Trả sách thất bại!";
    } finally {
        // Đảm bảo đóng tài nguyên
        try {
            if (pstmt != null) pstmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
     public ArrayList<String> layTenLoaiViPham() {
    this.danhSachViPham = new ArrayList<>();
    try {
        Connection connection = this.getConnection();
            String query = "SELECT l.tenViPham "
                    + "FROM CHITIETPHIEUVIPHAM c JOIN LOAIVIPHAM l "
                    + " ON c.maLoaiViPham = l.maLoaiViPham "
                    + " WHERE c.maPhieuViPham = ? ";
            
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setInt(1, maPhieuViPham);
            ResultSet rs = pstmt.executeQuery();

            // Duyệt qua ResultSet
            while (rs.next()) {
                String tenSach = rs.getString("tenViPham"); // Hoặc rs.getString(1) nếu bạn chắc chắn cột đầu tiên là TenSach
                this.danhSachViPham.add(tenSach);
            }
            rs.close(); // Đóng ResultSet
            pstmt.close(); // Đóng PreparedStatement
           
        connection.close(); // Đóng kết nối sau khi hoàn tất
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return this.danhSachViPham;
}
     
}
