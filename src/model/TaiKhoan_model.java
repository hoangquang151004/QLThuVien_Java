/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author hq151
 */
public class TaiKhoan_model extends Database_model{
    private int maTaiKhoan;
    private String tenTaiKhoan;
    private String matKhau;
    private String hoTen;
    private String ngaySinh;
    private int SDT;
    private String diaChi;

    public TaiKhoan_model(int maTaiKhoan) {
        this.maTaiKhoan = maTaiKhoan;
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

    public int getSDT() {
        return SDT;
    }

    public void setSDT(int SDT) {
        this.SDT = SDT;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }
    

    public String suaThongTin(){
        String query = "UPDATE TaiKhoan SET maTaiKhoan=?,tenTaiKhoan=?, matKhau = ?,hoTen=?,NgaySinh=?,DiaChi=?,SDT=? WHERE maTaiKhoan =? ";
        
        try (Connection connection = this.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            
            preparedStatement.setInt(1, maTaiKhoan);
            preparedStatement.setString(2, tenTaiKhoan);
            preparedStatement.setString(3, matKhau);
            preparedStatement.setString(4, hoTen);
            preparedStatement.setString(5, ngaySinh );
            preparedStatement.setString(6, diaChi);
            preparedStatement.setInt(7, SDT);   
            preparedStatement.setInt(8, maTaiKhoan);
            
            int rowsAffected = preparedStatement.executeUpdate();
            connection.close();
           return "Sửa DL thành công! \n" + rowsAffected + " bản ghi đã được thêm.";
        } catch (SQLException e) {
            return "Thêm DL Thất Bại "+e.toString();
        }
    }
    public ArrayList<String> loadThongTin(int maTaiKhoan){
    ArrayList<String> tt = new ArrayList<>(); 
        try {
        Connection connection = this.getConnection();
            String query = "SELECT tenTaiKhoan, matKhau, hoTen, ngaySinh, SDT, diaChi FROM TAIKHOAN WHERE maTaiKhoan = ? ";
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setInt(1, maTaiKhoan);
            ResultSet rs = pstmt.executeQuery();

            // Duyệt qua ResultSet
            while (rs.next()) {
                String tenTaiKhoan = rs.getString("tenTaiKhoan"); 
                String matKhau = rs.getString("matKhau"); 
                String hoTen = rs.getString("hoTen"); 
                String ngaySinh = rs.getString("ngaySinh"); 
                String SDT = rs.getString("SDT"); 
                String diaChi = rs.getString("diaChi"); 
                tt.add(tenTaiKhoan);
                tt.add(matKhau);
                tt.add(hoTen);
                tt.add(ngaySinh);
                tt.add(SDT);
                tt.add(diaChi);
            }
            rs.close(); // Đóng ResultSet
            pstmt.close(); // Đóng PreparedStatement
           
        connection.close(); // Đóng kết nối sau khi hoàn tất
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return tt;
}
}
