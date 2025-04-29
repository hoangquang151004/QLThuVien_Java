/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import com.mysql.cj.xdevapi.PreparableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hq151
 */
public class QuanLyBaoCao_model extends Database_model{
    private String tuNgay;
    private String denNgay;

    public QuanLyBaoCao_model() {
    }

    public String getTuNgay() {
        return tuNgay;
    }

    public void setTuNgay(String tuNgay) {
        this.tuNgay = tuNgay;
    }

    public String getDenNgay() {
        return denNgay;
    }

    public void setDenNgay(String denNgay) {
        this.denNgay = denNgay;
    }
    public DefaultTableModel loadSach(JTable table) {
             
              DefaultTableModel tableModel = null;
        try {
            Connection connection = this.getConnection();
            String query = "SELECT maSach, tenSach, ngonNgu, soLuong FROM Sach";
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
    public DefaultTableModel loadPhieuViPham(JTable table) {
             
              DefaultTableModel tableModel = null;
        try {
            Connection connection = this.getConnection();
            String query = "SELECT maPhieuViPham, maTaiKhoan, nguoiTao, ngayViPham, soLuongViPham FROM PhieuViPham";
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
    public DefaultTableModel loadPhieuMuon(JTable table) {
             
              DefaultTableModel tableModel = null;
        try {
            Connection connection = this.getConnection();
            String query = "SELECT maPhieuMuon, ngayMuon, ngayTra, daGiaHan, soLuongSachMuon, trangThai FROM PhieuMuon";
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
   
    public DefaultTableModel loadPhieuViPhamBaoCao(JTable table) {
             
              DefaultTableModel tableModel = null;
        try {
            Connection connection = this.getConnection();
            String query = "SELECT maPhieuViPham, maTaiKhoan, nguoiTao, ngayViPham, soLuongViPham FROM PhieuViPham WHERE ngayViPham BETWEEN ? AND ?";
            
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, tuNgay);
            preparedStatement.setString(2, denNgay);
            ResultSet rs = preparedStatement.executeQuery();

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
    public DefaultTableModel loadPhieuMuonBaoCao(JTable table) {
             
              DefaultTableModel tableModel = null;
        try {
            Connection connection = this.getConnection();
            String query = "SELECT maPhieuMuon, ngayMuon, ngayTra, daGiaHan, soLuongSachMuon, trangThai FROM PhieuMuon WHERE ngayMuon BETWEEN ? AND ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, tuNgay);
            preparedStatement.setString(2, denNgay);
            ResultSet rs = preparedStatement.executeQuery();


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
}
