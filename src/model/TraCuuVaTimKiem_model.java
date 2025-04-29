/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hq151
 */
public class TraCuuVaTimKiem_model extends Database_model{
    private String duLieuSach;

    public TraCuuVaTimKiem_model() {
    }

    public String getDuLieuSach() {
        return duLieuSach;
    }

    public void setDuLieuSach(String duLieuSach) {
        this.duLieuSach = duLieuSach;
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
}
