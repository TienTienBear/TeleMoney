/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.GuiTienModel;
import Model.MyStockBuyModel;
import Model.UserModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import View.MasterTeleMoneyView;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author xiaomi
 */
public class GuiTienDAO {
    private Connection con;
    private UserModel userModel;
    
    public GuiTienDAO() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/telemoney", "root", "");
//here sonoo is database name, root is username and password  

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void add(GuiTienModel guiTien){
        String sql = "INSERT INTO 'chovay' ('uid', 'ten', 'bank', 'tiengoc', 'laisuat', 'kyhan', 'ngaychovay') VALUES (?, ?, ?, ?, ?, ?, ?)";;
        try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setInt(1, userModel.getId());
            ps.setString(2, guiTien.getTen());
            ps.setString(3, guiTien.getBank());
            ps.setDouble(4, guiTien.getTiengoc());
            ps.setDouble(5, guiTien.getLaisuat());
            ps.setDouble(6, guiTien.getKyhan());
            ps.setTimestamp(7, guiTien.getNgaygui());
            
            int executeUpdate = ps.executeUpdate();
            System.out.println(guiTien.toString());
            System.out.println("thêm thành công");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public ArrayList<GuiTienModel> getAll(UserModel user) {
        String sql = "select * from chovay where uid=?";
        int x = user.getId();
        ResultSet rs;
        ArrayList<GuiTienModel> guiTienModels = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setInt(1, x);
            rs = ps.executeQuery();
            while (rs.next()) {
                GuiTienModel guiTienModel = new GuiTienModel();
                guiTienModel.setTen(rs.getString("ten"));
                guiTienModel.setBank(rs.getString("bank"));
                guiTienModel.setTiengoc(rs.getDouble("tiengoc"));
                guiTienModel.setLaisuat(rs.getDouble("laisuat"));
                guiTienModel.setKyhan(rs.getInt("kyhan"));
                guiTienModel.setNgaygui(rs.getTimestamp("ngaychovay"));
                guiTienModels.add(guiTienModel);
            }
        } catch (Exception e) {
        }
        return guiTienModels;
    }
}