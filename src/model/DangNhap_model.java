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
public class DangNhap_model extends Database_model{
   private int maTaiKhoan;
   private String taiKhoan;
   private String matKhau;
   private ArrayList<String> listTaiKhoan;
   private ArrayList<String> listMatKhau;
   ArrayList<Integer> maTK;

    public DangNhap_model() {
    }

    public String getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(String taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public int getMaTaiKhoan() {
        return maTaiKhoan;
    }

    public void setMaTaiKhoan(int maTaiKhoan) {
        this.maTaiKhoan = maTaiKhoan;
    }
    
   public boolean kiemTra(){
            maTK = new ArrayList<>();
            listMatKhau = new ArrayList<>();
            listTaiKhoan = new ArrayList<>();
        try {
            Connection connection = this.getConnection();
            String query = "SELECT maTaiKhoan,tenTaiKhoan, MatKhau FROM TaiKhoan";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            // Duyệt qua ResultSet và thêm vào mô hình bảng
            while (rs.next()) {
                String maTaiKhoan = rs.getString("maTaiKhoan");
                String tenTaiKhoan = rs.getString("tenTaiKhoan");
                String matKhau = rs.getString("matKhau");
               maTK.add(Integer.valueOf(maTaiKhoan));
               listTaiKhoan.add(tenTaiKhoan);
               listMatKhau.add(matKhau);
            } 
           connection.close();  
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for(int i = 0 ; i < listTaiKhoan.size() ; i ++){
            if(taiKhoan.equals(listTaiKhoan.get(i)) && matKhau.equals(listMatKhau.get(i))){
                this.setMaTaiKhoan(maTK.get(i));
                return true;
            }
        }
       return false;
   }
}
