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
public class QuanLyMuonSach_model extends Database_model{
    private int maTaiKhoan;
    private String dlTimKiem;

    public QuanLyMuonSach_model() {
    }

    public String getDlTimKiem() {
        return dlTimKiem;
    }

    public void setDlTimKiem(String dlTimKiem) {
        this.dlTimKiem = dlTimKiem;
    }

    public int getMaTaiKhoan() {
        return maTaiKhoan;
    }

    public void setMaTaiKhoan(int maTaiKhoan) {
        this.maTaiKhoan = maTaiKhoan;
    }
    
     public DefaultTableModel loadSach(JTable table) {
             
              DefaultTableModel tableModel = null;
        try {
            Connection connection = this.getConnection();
             String query = "SELECT p.maPhieuMuon, p.maTaiKhoan, t.tenTaiKhoan, p.ngayMuon, p.ngayTra, p.daGiaHan, p.soLuongSachMuon ,p.trangThai " +
            "FROM PHIEUMUON AS p " +
            "INNER JOIN TAIKHOAN AS t ON p.maTaiKhoan = t.maTaiKhoan WHERE p.maTaiKhoan = "+maTaiKhoan;
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
           connection.close();  
        } catch (SQLException e) {
            e.printStackTrace();
        }
      return tableModel;
    }
      public DefaultTableModel timKiem(JTable table){
           String query = null;
           try{
               int maSach = Integer.valueOf(this.dlTimKiem);
            query = "SELECT p.maPhieuMuon, p.maTaiKhoan, t.tenTaiKhoan, p.ngayMuon, p.ngayTra, p.daGiaHan, p.soLuongSachMuon ,p.trangThai " +
            "FROM PHIEUMUON AS p " +
            "INNER JOIN TAIKHOAN AS t ON p.maTaiKhoan = t.maTaiKhoan WHERE p.maPhieuMuon = "+maSach;
           }catch(Exception ex){
               query = "Select * from Sach Where tenSach = N'"+this.dlTimKiem+"'";
           }
             DefaultTableModel tableModel = null;
        try {
            Connection connection = this.getConnection();
            
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
           connection.close();  
        } catch (SQLException e) {
            e.printStackTrace();
        }
      return tableModel;
} 
          public ArrayList<String> layTenSachMuon(int maPhieuMuon) {
    ArrayList<String> danhSachSachMuon = new ArrayList<>();
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
                danhSachSachMuon.add(tenSach);
            }
            rs.close(); // Đóng ResultSet
            pstmt.close(); // Đóng PreparedStatement
           
        connection.close(); // Đóng kết nối sau khi hoàn tất
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return danhSachSachMuon;
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
          
          public void giaHanPhieuMuon(int maPhieuMuon){
               try {
        Connection connection = this.getConnection();
            String query = "UPDATE PhieuMuon " +
            "SET ngayTra = DATEADD(DAY, 7, ngayTra), " +
            "    daGiaHan = 1 " +
            "WHERE maPhieuMuon = ?;";
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setInt(1, maPhieuMuon);
            pstmt.executeUpdate();
            pstmt.close(); // Đóng PreparedStatement
           
        connection.close(); // Đóng kết nối sau khi hoàn tất
    } catch (SQLException e) {
        e.printStackTrace();
    }
          }
         
}
