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
public class QuanLyMuonTra_model extends Database_model {
    private int maPhieuMuon;
    private int maTaiKhoan;
    private String tenBanDoc;
    private String ngayMuon;
    private String ngayTra;
    private boolean giaHan;
    private String trangThai;
    private String dlTimKiem;
    private ArrayList<String> danhSachSachMuon;

    public QuanLyMuonTra_model() {
    }

    public QuanLyMuonTra_model(int maPhieuMuon, int maTaiKhoan, String tenBanDoc, String ngayMuon, String ngayTra, boolean giaHan, String trangThai, String dlTimKiem, ArrayList<String> danhSachSachMuon) {
        this.maPhieuMuon = maPhieuMuon;
        this.maTaiKhoan = maTaiKhoan;
        this.tenBanDoc = tenBanDoc;
        this.ngayMuon = ngayMuon;
        this.ngayTra = ngayTra;
        this.giaHan = giaHan;
        this.trangThai = trangThai;
        this.dlTimKiem = dlTimKiem;
        this.danhSachSachMuon = danhSachSachMuon;
    }
    
    
    public int getMaPhieuMuon() {
        return maPhieuMuon;
    }

    public void setMaPhieuMuon(int maPhieuMuon) {
        this.maPhieuMuon = maPhieuMuon;
    }

    public int getMaTaiKhoan() {
        return maTaiKhoan;
    }

    public void setMaTaiKhoan(int maTaiKhoan) {
        this.maTaiKhoan = maTaiKhoan;
    }

    public String getTenBanDoc() {
        return tenBanDoc;
    }

    public void setTenBanDoc(String tenBanDoc) {
        this.tenBanDoc = tenBanDoc;
    }

    public String getNgayMuon() {
        return ngayMuon;
    }

    public void setNgayMuon(String ngayMuon) {
        this.ngayMuon = ngayMuon;
    }

    public String getNgayTra() {
        return ngayTra;
    }

    public void setNgayTra(String ngayTra) {
        this.ngayTra = ngayTra;
    }

    public boolean isGiaHan() {
        return giaHan;
    }

    public void setGiaHan(boolean giaHan) {
        this.giaHan = giaHan;
    }

    public String getDlTimKiem() {
        return dlTimKiem;
    }

    public void setDlTimKiem(String dlTimKiem) {
        this.dlTimKiem = dlTimKiem;
    }

    public ArrayList<String> getDanhSachSachMuon() {
        return danhSachSachMuon;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
    

    public ArrayList<String> layTenSachMuon() {
    this.danhSachSachMuon = new ArrayList<>();
    try {
        Connection connection = this.getConnection();
            String query = "SELECT s.tenSach " +
            "FROM ChiTietPhieuMuon ctp " +
            "JOIN Sach s ON ctp.maSach = s.maSach " +
            "WHERE ctp.maPhieuMuon = ?;";
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setInt(1, maPhieuMuon);
            ResultSet rs = pstmt.executeQuery();

            // Duyệt qua ResultSet
            while (rs.next()) {
                String tenSach = rs.getString("TenSach"); // Hoặc rs.getString(1) nếu bạn chắc chắn cột đầu tiên là TenSach
                this.danhSachSachMuon.add(tenSach);
            }
            rs.close(); // Đóng ResultSet
            pstmt.close(); // Đóng PreparedStatement
           
        connection.close(); // Đóng kết nối sau khi hoàn tất
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return this.danhSachSachMuon;
}
       public ArrayList<Integer> layMaSachMuon(int maPhieuMuon) {
    ArrayList<Integer> ds = new ArrayList<>();
    try {
        Connection connection = this.getConnection();
            String query = "SELECT s.maSach " +
            "FROM ChiTietPhieuMuon ctp " +
            "JOIN Sach s ON ctp.maSach = s.maSach " +
            "WHERE ctp.maPhieuMuon = ?;";
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setInt(1, maPhieuMuon);
            ResultSet rs = pstmt.executeQuery();

            // Duyệt qua ResultSet
            while (rs.next()) {
                String tenSach = rs.getString("maSach"); // Hoặc rs.getString(1) nếu bạn chắc chắn cột đầu tiên là TenSach
                ds.add(Integer.valueOf(tenSach.trim()));
            }
            rs.close(); // Đóng ResultSet
            pstmt.close(); // Đóng PreparedStatement
           
        connection.close(); // Đóng kết nối sau khi hoàn tất
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return ds;
}

   
 public String xacNhanTraSach(int maPhieuMuon) {
    this.maPhieuMuon = maPhieuMuon;
    Connection conn = null;
    PreparedStatement pstmt = null;

    try {
        conn = this.getConnection();
        String query = "UPDATE PHIEUMUON SET trangThai = N'Đã trả' WHERE maPhieuMuon = ?";
        pstmt = conn.prepareStatement(query);
        pstmt.setInt(1, this.maPhieuMuon);
        
        int rowsAffected = pstmt.executeUpdate(); // Sử dụng executeUpdate để xóa

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
 public String traChiTietSach(int maSach){
    Connection conn = null;
    PreparedStatement pstmt = null;

    try {
        conn = this.getConnection();
        String query = "UPDATE SACH SET soLuong = (soLuong+1) WHERE maSach = ?";
        pstmt = conn.prepareStatement(query);
        pstmt.setInt(1, maSach);
        
        int rowsAffected = pstmt.executeUpdate(); // Sử dụng executeUpdate để xóa

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


public DefaultTableModel timKiemPhieuMuon(String thongTin, JTable table) {
    DefaultTableModel tableModel = null;
    String query = null;
    try {
        Connection connection = this.getConnection();
        PreparedStatement pstmt = null;
    try {
            int maSach = Integer.parseInt(thongTin.trim());
            query = "SELECT p.maPhieuMuon, p.maTaiKhoan, t.tenTaiKhoan, p.ngayMuon, p.ngayTra, p.daGiaHan, p.soLuongSachMuon ,p.trangThai " +
            "FROM PHIEUMUON AS p " +
            "INNER JOIN TAIKHOAN AS t ON p.maTaiKhoan = t.maTaiKhoan WHERE p.maPhieuMuon = ?";
            pstmt = connection.prepareStatement(query);
            pstmt.setInt(1, maSach);
           
        } catch (NumberFormatException ex) {
             query = "SELECT p.maPhieuMuon, p.maTaiKhoan, t.tenTaiKhoan, p.ngayMuon, p.ngayTra, p.daGiaHan, p.soLuongSachMuon ,p.trangThai " +
            "FROM PHIEUMUON AS p " +
            "INNER JOIN TAIKHOAN AS t ON p.maTaiKhoan = t.maTaiKhoan WHERE t.TenTaiKhoan = ?";
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
 public DefaultTableModel loadPhieuMuon(JTable table) {
             
              DefaultTableModel tableModel = null;
        try {
            Connection connection = this.getConnection();
            String query = "SELECT p.maPhieuMuon, p.maTaiKhoan, t.tenTaiKhoan, p.ngayMuon, p.ngayTra, p.daGiaHan, p.soLuongSachMuon ,p.trangThai " +
            "FROM PHIEUMUON AS p " +
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
    public void suaPhieuMuon() {
    String query = null;
    try {
        Connection connection = this.getConnection();
        PreparedStatement pstmt = null;
            query = "UPDATE PHIEUMUON SET ngayMuon =?, ngayTra = ?, daGiaHan = ?, trangThai = ? WHERE maPhieuMuon = ?";
            pstmt = connection.prepareStatement(query);
            pstmt.setString(1,ngayMuon);
            pstmt.setString(2,ngayTra);
            pstmt.setBoolean(3,giaHan);
            pstmt.setString(4,trangThai);
            pstmt.setInt(5,maPhieuMuon);
           int rowsAffected = pstmt.executeUpdate();
           System.out.println("Sua thanh cong");
           connection.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    }
}
