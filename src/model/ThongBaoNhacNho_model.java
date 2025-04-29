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
public class ThongBaoNhacNho_model extends Database_model{
    private int maTaiKhoan;

    public ThongBaoNhacNho_model() {
    }

    public int getMaTaiKhoan() {
        return maTaiKhoan;
    }

    public void setMaTaiKhoan(int maTaiKhoan) {
        this.maTaiKhoan = maTaiKhoan;
    }
public ArrayList<String> dsQuaHan() {
     ArrayList<String> ds = new ArrayList<>();
    try {
        Connection connection = this.getConnection();
            String query = "SELECT maPhieuMuon, ngayMuon, ngayTra, soLuongSachMuon FROM PhieuMuon WHERE maTaiKhoan = ? AND trangThai =N'Đã quá hạn'";
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setInt(1, maTaiKhoan);
            ResultSet rs = pstmt.executeQuery();

            // Duyệt qua ResultSet
            while (rs.next()) {
                String maPhieuMuon = rs.getString("maPhieuMuon");
                String ngayMuon = rs.getString("ngayMuon");
                String ngayTra = rs.getString("ngayTra");
                String SL = rs.getString("soLuongSachMuon");
                ds.add(maPhieuMuon);
                ds.add(ngayMuon);
                ds.add(ngayTra);
                ds.add(SL);
            }
            rs.close(); // Đóng ResultSet
            pstmt.close(); // Đóng PreparedStatement
           
        connection.close(); // Đóng kết nối sau khi hoàn tất
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return ds ;
}
   public ArrayList<String> dsMuonTra() {
     ArrayList<String> ds = new ArrayList<>();
    try {
        Connection connection = this.getConnection();
            String query = "SELECT maPhieuMuon, ngayMuon, ngayTra, soLuongSachMuon FROM PhieuMuon WHERE maTaiKhoan = ? AND trangThai =N'Chưa đến hạn'";
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setInt(1, maTaiKhoan);
            ResultSet rs = pstmt.executeQuery();

            // Duyệt qua ResultSet
            while (rs.next()) {
                String maPhieuMuon = rs.getString("maPhieuMuon");
                String ngayMuon = rs.getString("ngayMuon");
                String ngayTra = rs.getString("ngayTra");
                String SL = rs.getString("soLuongSachMuon");
                ds.add(maPhieuMuon);
                ds.add(ngayMuon);
                ds.add(ngayTra);
                ds.add(SL);
            }
            rs.close(); // Đóng ResultSet
            pstmt.close(); // Đóng PreparedStatement
           
        connection.close(); // Đóng kết nối sau khi hoàn tất
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return ds ;
}
   
}
