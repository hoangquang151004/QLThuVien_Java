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
public class TaoPhieuViPham_model extends Database_model{
    private int maPhieuViPham;
    private int maTaiKhoan;
    private String tenTaiKhoan;
    private String nguoiTao;
    private String ngayViPham;
    private String dlBanDoc;
    private String dlViPham;
    ArrayList<Integer> danhSachViPham;
    private int soLuongViPham = 0;
    private int maLoaiViPham;

    public TaoPhieuViPham_model() {
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

    public void setNgayViPham(String ngayTao) {
        this.ngayViPham = ngayTao;
    }

    public String getDlBanDoc() {
        return dlBanDoc;
    }

    public void setDlBanDoc(String dlBanDoc) {
        this.dlBanDoc = dlBanDoc;
    }

    public String getDlViPham() {
        return dlViPham;
    }

    public void setDlViPham(String dlViPham) {
        this.dlViPham = dlViPham;
    }

    public ArrayList<Integer> getDanhSachViPham() {
        return danhSachViPham;
    }

    public void setDanhSachViPham(ArrayList<Integer> danhSachViPham) {
        this.danhSachViPham = danhSachViPham;
    }

    public int getSoLuongViPham() {
        return soLuongViPham;
    }

    public void setSoLuongViPham(int soLuongViPham) {
        this.soLuongViPham = soLuongViPham;
    }

    public int getMaPhieuViPham() {
        return maPhieuViPham;
    }

    public void setMaPhieuViPham(int maPhieuViPham) {
        this.maPhieuViPham = maPhieuViPham;
    }

    public int getMaLoaiViPham() {
        return maLoaiViPham;
    }

    public void setMaLoaiViPham(int maLoaiViPham) {
        this.maLoaiViPham = maLoaiViPham;
    }
    
    
    public String taoPhieuViPham(){
        Connection conn = this.getConnection();
          String query = "INSERT INTO PhieuViPham (maTaiKhoan, nguoiTao, NgayViPham , SoLuongViPham) VALUES (?, ?, ?, ?)";       
        try (Connection connection = conn;
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            
            preparedStatement.setInt(1, maTaiKhoan);
            preparedStatement.setString(2,nguoiTao );
            preparedStatement.setString(3, ngayViPham);
            preparedStatement.setInt(4, soLuongViPham);
            int rowsAffected = preparedStatement.executeUpdate();
            this.closeConnect();
            return "Thêm DL thành công! \n" + rowsAffected + " bản ghi đã được thêm.";
        } catch (SQLException e) {
            return "Thêm DL Thất Bại "+e.toString();
        } 
    }
     public String luuChiTietPhieuViPham(){
         Connection conn = this.getConnection();
          String query = "INSERT INTO ChiTietPhieuViPham(maPhieuViPham,maLoaiViPham) VALUES (?, ?)";       
        try (Connection connection = conn;
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            
            preparedStatement.setInt(1, maPhieuViPham);
            preparedStatement.setInt(2, maLoaiViPham);
           
            int rowsAffected = preparedStatement.executeUpdate();
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
    public DefaultTableModel loadLoaiViPham(JTable table) {
             
              DefaultTableModel tableModel = null;
        try {
            Connection connection = this.getConnection();
            String query = "SELECT * FROM LoaiViPham";
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
    public DefaultTableModel timLoaiViPham(JTable table) {
              DefaultTableModel tableModel = null;
        try {
            Connection connection = this.getConnection();
            String query = null;
            try{
                int maSach =Integer.valueOf(dlViPham);
                query =  "SELECT * FROM LoaiViPham where maLoaiViPham ='"+maSach+"'";
            }catch(Exception ex){
                query =  "SELECT * FROM LoaiViPham where where tenViPham =N'"+dlViPham+"'";
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
    public int layMaPhieuViPham() {
    Connection conn = this.getConnection();
    int maxMaPhieuMuon = 0;
    String query = "SELECT MAX(maPhieuViPham) AS maxValue FROM PhieuViPham";  // Lấy giá trị lớn nhất của cột MaPhieuMuon
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
