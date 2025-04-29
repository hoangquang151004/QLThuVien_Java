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
import javax.swing.table.TableModel;

/**
 *
 * @author hq151
 */
public class QuanLySach_model extends Database_model{
    private int maSach;
    private String tenSach;
    private String nhaXuatBan;
    private String viTri;
    private int namXuatBan;
    private String theLoai;
    private String ngonNgu;
    private int soLuong;
    private String duLieuSach;

    public QuanLySach_model() {
    }

    public QuanLySach_model(int maSach, String tenSach, String nhaXuatBan, String viTri, int namXuatBan, String theLoai, String ngonNgu, int soLuong, String duLieuSach) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.nhaXuatBan = nhaXuatBan;
        this.viTri = viTri;
        this.namXuatBan = namXuatBan;
        this.theLoai = theLoai;
        this.ngonNgu = ngonNgu;
        this.soLuong = soLuong;
        this.duLieuSach = duLieuSach;
    }

    public int getMaSach() {
        return maSach;
    }

    public void setMaSach(int maSach) {
        this.maSach = maSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getNhaXuatBan() {
        return nhaXuatBan;
    }

    public void setNhaXuatBan(String nhaXuatBan) {
        this.nhaXuatBan = nhaXuatBan;
    }

    public String getViTri() {
        return viTri;
    }

    public void setViTri(String viTri) {
        this.viTri = viTri;
    }

    public int getNamXuatBan() {
        return namXuatBan;
    }

    public void setNamXuatBan(int namXuatBan) {
        this.namXuatBan = namXuatBan;
    }

    public String getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(String theLoai) {
        this.theLoai = theLoai;
    }

    public String getNgonNgu() {
        return ngonNgu;
    }

    public void setNgonNgu(String ngonNgu) {
        this.ngonNgu = ngonNgu;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getDuLieuSach() {
        return duLieuSach;
    }

    public void setDuLieuSach(String duLieuSach) {
        this.duLieuSach = duLieuSach;
    }

   
    
     // load dữ liệu 
         public DefaultTableModel loadSach(JTable table) {
             
              DefaultTableModel tableModel = null;
        try {
            Connection connection = this.getConnection();
            String query = "SELECT * FROM Sach";
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
    public String themDLSach() {
        String query = "INSERT INTO Sach (maSach, tenSach, theLoai, nhaXuatBan, viTri, namXuatBan, ngonNgu, soLuong) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection connection = this.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            
            preparedStatement.setInt(1, maSach);
            preparedStatement.setString(2, tenSach);
            preparedStatement.setString(3, theLoai);
            preparedStatement.setString(4, nhaXuatBan);
            preparedStatement.setString(5, viTri);
            preparedStatement.setInt(6, namXuatBan);   
            preparedStatement.setString(7, ngonNgu); 
            preparedStatement.setInt(8, soLuong); 
            
            int rowsAffected = preparedStatement.executeUpdate();
            return "Thêm DL thành công! \n" + rowsAffected + " bản ghi đã được thêm.";
        } catch (SQLException e) {
            return "Thêm DL Thất Bại "+e.toString();
        }
    }
    // Sua Du Lieu
      public String suaDLSach() {
        String query = "UPDATE Sach SET maSach =?, tenSach= ?, theLoai=?, nhaXuatBan=?, viTri=?, namXuatBan=?, ngonNgu=?, soLuong=? WHERE maSach =? ";
        
        try (Connection connection = this.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            
            preparedStatement.setInt(1, maSach);
            preparedStatement.setString(2, tenSach);
            preparedStatement.setString(3, theLoai);
            preparedStatement.setString(4, nhaXuatBan);
            preparedStatement.setString(5, viTri);
            preparedStatement.setInt(6, namXuatBan);   
            preparedStatement.setString(7, ngonNgu); 
            preparedStatement.setInt(8, soLuong);
            preparedStatement.setInt(9, maSach);
            
            int rowsAffected = preparedStatement.executeUpdate();
            connection.close();
           return "Sửa DL thành công! \n" + rowsAffected + " bản ghi đã được thêm.";
        } catch (SQLException e) {
            return "Thêm DL Thất Bại "+e.toString();
        }
        
    }
        // xoa du lieu
       public String xoaDLSach() {
        String query = "DELETE FROM Sach WHERE maSach = ?";
        
        try (Connection connection = this.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            
            preparedStatement.setInt(1, this.maSach);
            
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
               int maSach = Integer.valueOf(this.duLieuSach);
               query = "Select * from Sach Where maSach = "+maSach;
           }catch(Exception ex){
               query = "Select * from Sach Where tenSach = N'"+this.duLieuSach+"'";
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
