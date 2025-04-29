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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hq151
 */
public class QuanLyBanDoc_model extends Database_model{
    private int maTaiKhoan;
    private String tenTaiKhoan;
    private String hoTen;
    private String ngaySinh;
    private String diaChi;
    private int SDT;
    private String quyenHan;
    private String dlTimKiem;

    public QuanLyBanDoc_model() {
    }

    public QuanLyBanDoc_model(int maTaiKhoan, String tenTaiKhoan, String hoTen, String ngaySinh, String diaChi, int SDT, String quyenHan, String dlTimKiem) {
        this.maTaiKhoan = maTaiKhoan;
        this.tenTaiKhoan = tenTaiKhoan;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.SDT = SDT;
        this.quyenHan = quyenHan;
        this.dlTimKiem = dlTimKiem;
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

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public int getSDT() {
        return SDT;
    }

    public void setSDT(int SDT) {
        this.SDT = SDT;
    }

    public String getQuyenHan() {
        return quyenHan;
    }

    public void setQuyenHan(String quyenHan) {
        this.quyenHan = quyenHan;
    }

    public String getDlTimKiem() {
        return dlTimKiem;
    }

    public void setDlTimKiem(String dlTimKiem) {
        this.dlTimKiem = dlTimKiem;
    }
    // load dữ liệu 
         public DefaultTableModel loadBanDoc(JTable table) {
             
              DefaultTableModel tableModel = null;
        try {
            Connection connection = this.getConnection();
            String query = "SELECT maTaiKhoan,tenTaiKhoan,hoTen,NgaySinh,DiaChi,SDT,quyenHan FROM TaiKhoan";
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
         
       // Them Du Lieu
    public String themDLBanDoc() {
        String query = "INSERT INTO TaiKhoan (maTaiKhoan,tenTaiKhoan,hoTen,NgaySinh,DiaChi,SDT,quyenHan) VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection connection = this.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            
            preparedStatement.setInt(1, maTaiKhoan);
            preparedStatement.setString(2, tenTaiKhoan);
            preparedStatement.setString(3, hoTen);
            preparedStatement.setString(4, ngaySinh );
            preparedStatement.setString(5, diaChi);
            preparedStatement.setInt(6, SDT);   
            preparedStatement.setString(7, quyenHan); 
         
            int rowsAffected = preparedStatement.executeUpdate();
            return "Thêm DL thành công! \n" + rowsAffected + " bản ghi đã được thêm.";
        } catch (SQLException e) {
            return "Thêm DL Thất Bại "+e.toString();
        }
    }
    // Sua Du Lieu
      public String suaDLBanDoc() {
        String query = "UPDATE TaiKhoan SET maTaiKhoan=?,tenTaiKhoan=?,hoTen=?,NgaySinh=?,DiaChi=?,SDT=?,quyenHan=? WHERE maTaiKhoan =? ";
        
        try (Connection connection = this.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            
            preparedStatement.setInt(1, maTaiKhoan);
            preparedStatement.setString(2, tenTaiKhoan);
            preparedStatement.setString(3, hoTen);
            preparedStatement.setString(4, ngaySinh );
            preparedStatement.setString(5, diaChi);
            preparedStatement.setInt(6, SDT);   
            preparedStatement.setString(7, quyenHan); 
            preparedStatement.setInt(8, maTaiKhoan);
            
            int rowsAffected = preparedStatement.executeUpdate();
            connection.close();
           return "Sửa DL thành công! \n" + rowsAffected + " bản ghi đã được thêm.";
        } catch (SQLException e) {
            return "Thêm DL Thất Bại "+e.toString();
        }
        
    }
        // xoa du lieu
       public String xoaDLBanDoc() {
        String query = "DELETE FROM TaiKhoan WHERE maTaiKhoan = ?";
        
        try (Connection connection = this.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            
            preparedStatement.setInt(1, this.maTaiKhoan);
            
            int rowsAffected = preparedStatement.executeUpdate();
             connection.close();
               return "Xóa DL thành công! \n" + rowsAffected + " bản ghi đã được thêm.";
        } catch (SQLException e) {
            return "Xóa DL Thất Bại "+e.toString();
        }
    }
       // tim kiem 
       public DefaultTableModel timKiem(JTable table){
           String query = null;
           try{
               int maSach = Integer.valueOf(this.dlTimKiem);
               query = "Select * from TaiKhoan Where maTaiKhoan = "+maSach;
           }catch(Exception ex){
               query = "Select * from TaiKhoan Where tenTaiKhoan = N'"+this.dlTimKiem+"'";
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
}
