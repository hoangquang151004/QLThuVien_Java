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
import javax.swing.table.TableModel;

/**
 *
 * @author hq151
 */
public class TaoPhieuMuon_model extends Database_model{
    private int maPhieuMuon;
    private String dlBanDoc;
    private String dlSach;
    private TableModel tblBanDoc;
    private TableModel tblSach;
    private int maTaiKhoan;
    private String tenBanDoc;
    private String ngayMuon;
    private String ngayTra;
    private int maSach;
    ArrayList<Integer> danhSachSachMuon;
    private int SoLuongSachMuon = 0;

    public TaoPhieuMuon_model() {
    }

    public int getMaSach() {
        return maSach;
    }

    public void setMaSach(int maSach) {
        this.maSach = maSach;
    }
    


    public int getMaPhieuMuon() {
        return maPhieuMuon;
    }

    public void setMaPhieuMuon(int maPhieuMuon) {
        this.maPhieuMuon = maPhieuMuon;
    }

    public int getSoLuongSachMuon() {
        return SoLuongSachMuon;
    }

    public void setSoLuongSachMuon(int SoLuongSachMuon) {
        this.SoLuongSachMuon = SoLuongSachMuon;
    }
    

    public String getDlBanDoc() {
        return dlBanDoc;
    }

    public void setDlBanDoc(String dlBanDoc) {
        this.dlBanDoc = dlBanDoc;
    }

    public String getDlSach() {
        return dlSach;
    }

    public void setDlSach(String dlSach) {
        this.dlSach = dlSach;
    }

    public TableModel getTblBanDoc() {
        return tblBanDoc;
    }

    public void setTblBanDoc(TableModel tblBanDoc) {
        this.tblBanDoc = tblBanDoc;
    }

    public TableModel getTblSach() {
        return tblSach;
    }

    public void setTblSach(TableModel tblSach) {
        this.tblSach = tblSach;
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

    public ArrayList<Integer> getDanhSachSachMuon() {
        return danhSachSachMuon;
    }

    public void setDanhSachSachMuon(ArrayList<Integer> danhSachSachMuon) {
        this.danhSachSachMuon = danhSachSachMuon;
    }
    public String taoPhieuMuon(){
        Connection conn = this.getConnection();
          String query = "INSERT INTO PhieuMuon (maTaiKhoan, NgayMuon, NgayTra , daGiaHan, SoLuongSachMuon, trangThai) VALUES (?, ?, ?, 0, ? ,N'Chưa đến hạn')";       
        try (Connection connection = conn;
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            
            preparedStatement.setInt(1, maTaiKhoan);
            preparedStatement.setString(2, ngayMuon);
            preparedStatement.setString(3, ngayTra);
            preparedStatement.setInt(4, danhSachSachMuon.size());
            int rowsAffected = preparedStatement.executeUpdate();
            this.closeConnect();
            return "Thêm DL thành công! \n" + rowsAffected + " bản ghi đã được thêm.";
        } catch (SQLException e) {
            return "Thêm DL Thất Bại "+e.toString();
        } 
    }
    public String luuChiTietPhieuMuon(){
         Connection conn = this.getConnection();
          String query = "INSERT INTO ChiTietPhieuMuon(maPhieuMuon,maSach) VALUES (?, ?)";       
        try (Connection connection = conn) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, maPhieuMuon);
            preparedStatement.setInt(2, maSach);
            
            int rowsAffected = preparedStatement.executeUpdate();
            query = "UPDATE Sach SET soLuong = (soLuong-1) WHERE maSach = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, maSach);
            preparedStatement.executeUpdate();
            
            this.closeConnect();
            return "Thêm DL thành công! \n" + rowsAffected + " bản ghi đã được thêm.";
        } catch (SQLException e) {
            return "Thêm DL Thất Bại "+e.toString();
        } 
    }
    
     public DefaultTableModel loadBanDoc(JTable table) {             
              DefaultTableModel tableModel = null;
        try {
            Connection connection = this.getConnection();
            String query = "SELECT maTaiKhoan, tenTaiKhoan, SDT FROM TaiKhoan";
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
     
     public DefaultTableModel loadSach(JTable table) {
             
              DefaultTableModel tableModel = null;
        try {
            Connection connection = this.getConnection();
            String query = "SELECT maSach, tenSach, soLuong FROM Sach";
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
   public DefaultTableModel timBanDoc(JTable table) {
             
              DefaultTableModel tableModel = null;
        try {
            Connection connection = this.getConnection();
            String query = null;
            try{
                int maTaiKhoan = Integer.valueOf(dlBanDoc);
                query = "SELECT maTaiKhoan, tenTaiKhoan, SDT FROM TaiKhoan where maTaiKhoan = '"+maTaiKhoan+"'";
            }catch(Exception ex){
                query = "SELECT maTaiKhoan, tenTaiKhoan, SDT FROM TaiKhoan where tenTaiKhoan = '"+dlBanDoc+"'";
            }
      
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
   
     public DefaultTableModel timSach(JTable table) {
              DefaultTableModel tableModel = null;
        try {
            Connection connection = this.getConnection();
            String query = null;
            try{
                int maSach =Integer.valueOf(dlSach);
                query =  "SELECT maSach, tenSach, soLuong FROM Sach where maSach ='"+maSach+"'";
            }catch(Exception ex){
                query =  "SELECT maSach, tenSach, soLuong FROM Sach where tenSach =N'"+dlSach+"'";
            }    
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
      public int layMaPhieuMuon() {
    Connection conn = this.getConnection();
    int maxMaPhieuMuon = 0;
    String query = "SELECT MAX(MaPhieuMuon) AS maxValue FROM PhieuMuon";  // Lấy giá trị lớn nhất của cột MaPhieuMuon
    try {
        PreparedStatement pstmt = conn.prepareStatement(query);
        ResultSet rs = pstmt.executeQuery();

        if (rs.next()) {
            // Lấy giá trị của cột maxValue
            maxMaPhieuMuon = rs.getInt("maxValue");
        }

        // Đóng tài nguyên
        rs.close();
        pstmt.close();
        conn.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return maxMaPhieuMuon+1;
}
   
}
