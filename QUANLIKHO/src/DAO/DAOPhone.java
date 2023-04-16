/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import quanlikho.Phone;
import Database.ConnecttoSQL;
/**
 *
 * @author thanh ha
 */
public class DAOPhone implements DAOInterface <Phone> {
    
    public static DAOPhone getInstance()
    {
        return new DAOPhone();
    }
    
    @Override
    public int insert(Phone t) {
        String connectionUrl =
                "jdbc:sqlserver://localhost:1433;"
                        + "database=KHODIENTHOAI;"
                        + "user=sa;"
                        + "password=123;"
                        + "encrypt=true;"
                        + "trustServerCertificate=true;"
                        + "loginTimeout=30;";
        int rows=0;
        
        try (Connection connection = DriverManager.getConnection(connectionUrl); 
             Statement stm = connection.createStatement();) {
            // Code here.
            String selectSql = "SELECT* FROM DIENTHOAINHAP";
            ResultSet rs = stm.executeQuery(selectSql);
            
            String sqlInsert ="INSERT INTO DIENTHOAINHAP (MA, TEN, HEDIEUHANH, MAU, DUNGLUONG, SOLUONG, DONGIA)" 
                               + "VALUES ('"+t.getMa()+ 
                               "' , '"+t.getTen()+ 
                               "' , '"+ t.getHedieuhanh()+ 
                               "' , '"+t.getMau()+ 
                               "' , '"+t.getDungluong()+
                               "' , '"+t.getSoluong()+ 
                               "' , '"+t.getDongia()+ "')";
            
            rows = stm.executeUpdate(sqlInsert);
            System.out.println("INSERT DIEN THOAI THANH CONG!");
          
            
            while (rs.next())
            {
                System.out.println(rs.getString(1) +" "  +rs.getString(2) +" " + rs.getString(3) +" " + rs.getString(4) +" "+ rs.getString(5) +" "+rs.getString(6)+" "+rs.getString(7) );
            }
            
            connection.close();
            
        }
        // Handle any errors that may have occurred.
        catch (SQLException e) {
            System.out.println(" ");
        }
        return rows;
    }

    @Override
    public int update(Phone t) {
        String connectionUrl =
                "jdbc:sqlserver://localhost:1433;"
                        + "database=KHODIENTHOAI;"
                        + "user=sa;"
                        + "password=123;"
                        + "encrypt=true;"
                        + "trustServerCertificate=true;"
                        + "loginTimeout=30;";
        int rows=0;
        
        try (Connection connection = DriverManager.getConnection(connectionUrl); 
             Statement stm = connection.createStatement();) {
            // Code here.
            String selectSql = "SELECT* FROM DIENTHOAINHAP";
            ResultSet rs = stm.executeQuery(selectSql);
            
            String sqlUpdate ="UPDATE DIENTHOAINHAP "
                            + "SET TEN ='" + t.getTen() + "'"
                            + ", HEDIEUHANH ='" + t.getHedieuhanh()
                            + ", MAU ='" + t.getMau()
                            + ", DUNGLUONG ='" + t.getDungluong()
                            + ", SOLUONG =" + t.getSoluong()
                            + ", DONGIA =" + t.getDongia()
                            + " WHERE MA ='" + t.getMa() + "\'";
            
            rows = stm.executeUpdate(sqlUpdate);
            System.out.println("UPDATE THANH CONG!");
          
            
            while (rs.next())
            {
                System.out.println(rs.getString(1) +" "  +rs.getString(2) +" " + rs.getString(3) +" " + rs.getString(4) +" "+ rs.getString(5) +" "+rs.getString(6)+" "+rs.getString(7) );
            }
            
            connection.close(); 
            
        }
        // Handle any errors that may have occurred.
        catch (SQLException e) {
            System.out.println(" ");
        }
        return rows;
    }

    @Override
    public int delete(Phone t) {
        Scanner input = new Scanner (System.in);
        System.out.println("Nhap ma dien thoai can xoa: ");
        String ma = input.nextLine();
        
        String connectionUrl =
                "jdbc:sqlserver://localhost:1433;"
                        + "database=KHODIENTHOAI;"
                        + "user=sa;"
                        + "password=123;"
                        + "encrypt=true;"
                        + "trustServerCertificate=true;"
                        + "loginTimeout=30;";
        int rows=0;
        
        try (Connection connection = DriverManager.getConnection(connectionUrl); 
             Statement stm = connection.createStatement();) {
            // Code here.
            
            String selectSql = "SELECT* FROM DIENTHOAINHAP";
            ResultSet rs = stm.executeQuery(selectSql);
            
            String sqlInsert ="DELETE from DIENTHOAINHAP "+
                             " WHERE MA='"+ma+"'";
            
            rows = stm.executeUpdate(sqlInsert);
            System.out.println("DELETE DIEN THOAI THANH CONG!");
       
            connection.close();
            
        }
        // Handle any errors that may have occurred.
        catch (SQLException e) {
             e.printStackTrace();
        }
        return rows;
    }

    @Override
    public ArrayList<Phone> selectAll() {
        String connectionUrl =
                "jdbc:sqlserver://localhost:1433;"
                        + "database=KHODIENTHOAI;"
                        + "user=sa;"
                        + "password=123;"
                        + "encrypt=true;"
                        + "trustServerCertificate=true;"
                        + "loginTimeout=30;";
   
        ArrayList <Phone> rows = new ArrayList<Phone>();
        try (Connection connection = DriverManager.getConnection(connectionUrl); 
             Statement stm = connection.createStatement();) {
            // Code here.
            String selectSql = "SELECT* FROM DIENTHOAINHAP";
            ResultSet rs = stm.executeQuery(selectSql);
            
            while (rs.next())
            {
                String ma = rs.getString(1);
                String ten = rs.getString(2);
                String heDieuHanh = rs.getString(3);
                String mau = rs.getString(4);
                String dungLuong = rs.getString(5);
                double soLuong = rs.getDouble(6);
                double donGia = rs.getDouble(7);
                Phone p = new Phone(ma, ten, heDieuHanh, mau,dungLuong,soLuong,donGia);
                rows.add(p);
            }
            
            connection.close();
        }
        // Handle any errors that may have occurred.
        catch (SQLException e) {
            System.out.println(" ");
        }
        return rows;
    }

    @Override
    public Phone selectById(Phone t) 
    {
      String connectionUrl =
                "jdbc:sqlserver://localhost:1433;"
                        + "database=KHODIENTHOAI;"
                        + "user=sa;"
                        + "password=123;"
                        + "encrypt=true;"
                        + "trustServerCertificate=true;"
                        + "loginTimeout=30;";
   
        
        Phone rows = null;
        
        try (Connection connection = DriverManager.getConnection(connectionUrl); 
             Statement stm = connection.createStatement();) {
            // Code here.
            String selectSql = "SELECT* FROM DIENTHOAINHAP WHERE MA='"+t.getMa()+"'";
            ResultSet rs = stm.executeQuery(selectSql);
            
            while (rs.next())
            {
                String ma = rs.getString(1);
                String ten = rs.getString(2);
                String heDieuHanh = rs.getString(3);
                String mau = rs.getString(4);
                String dungLuong = rs.getString(5);
                double soLuong = rs.getDouble(6);
                double donGia = rs.getDouble(7);
                rows = new Phone(ma, ten, heDieuHanh, mau,dungLuong,soLuong,donGia);
               
            }
            
            connection.close();
        }
        // Handle any errors that may have occurred.
        catch (SQLException e) {
            System.out.println(" ");;
        }
        return rows;
      
    }
    
    

    @Override
    public Phone selectByTen(Phone t) {
        String connectionUrl =
                "jdbc:sqlserver://localhost:1433;"
                        + "database=KHODIENTHOAI;"
                        + "user=sa;"
                        + "password=123;"
                        + "encrypt=true;"
                        + "trustServerCertificate=true;"
                        + "loginTimeout=30;";
   
        Phone rows = null;
        
        try (Connection connection = DriverManager.getConnection(connectionUrl); 
             Statement stm = connection.createStatement();) {
            // Code here.
            String selectSql = "SELECT* FROM DIENTHOAINHAP WHERE TEN='"+t.getTen()+"'";
            ResultSet rs = stm.executeQuery(selectSql);
            
            while (rs.next())
            {
                String ma = rs.getString(1);
                String ten = rs.getString(2);
                String heDieuHanh = rs.getString(3);
                String mau = rs.getString(4);
                String dungLuong = rs.getString(5);
                double soLuong = rs.getDouble(6);
                double donGia = rs.getDouble(7);
                rows = new Phone(ma, ten, heDieuHanh, mau,dungLuong,soLuong,donGia);
               
            }
            
            connection.close();
        }
        // Handle any errors that may have occurred.
        catch (SQLException e) {
            System.out.println(" ");;
        }
        return rows;
    }

    
    
    public int insertPhoneXuat(Phone t)
    {
        String connectionUrl =
                "jdbc:sqlserver://localhost:1433;"
                        + "database=KHODIENTHOAI;"
                        + "user=sa;"
                        + "password=123;"
                        + "encrypt=true;"
                        + "trustServerCertificate=true;"
                        + "loginTimeout=30;";
        int rows=0;
        
        try (Connection connection = DriverManager.getConnection(connectionUrl); 
             Statement stm = connection.createStatement();) {
            // Code here.
            String selectSql = "SELECT* FROM DIENTHOAIXUAT";
            ResultSet rs = stm.executeQuery(selectSql);
            
            String sqlInsert ="INSERT INTO DIENTHOAIXUAT (MA, TEN, HEDIEUHANH, MAU, DUNGLUONG, SOLUONG, DONGIA)" 
                               + "VALUES ('"+t.getMa()+ 
                               "' , '"+t.getTen()+ 
                               "' , '"+ t.getHedieuhanh()+ 
                               "' , '"+t.getMau()+ 
                               "' , '"+t.getDungluong()+
                               "' , '"+t.getSoluong()+ 
                               "' , '"+t.getDongia()+ "')";
            
            rows = stm.executeUpdate(sqlInsert);
            System.out.println("INSERT DIEN THOAI THANH CONG!");
          
            
            while (rs.next())
            {
                System.out.println(rs.getString(1) +" "  +rs.getString(2) +" " + rs.getString(3) +" " + rs.getString(4) +" "+ rs.getString(5) +" "+rs.getString(6)+" "+rs.getString(7) );
            }
            
            connection.close(); 
            
        }
        // Handle any errors that may have occurred.
        catch (SQLException e) {
            System.out.println(" ");;
        }
        return rows;
    }
    
    public ArrayList<Phone> selectAllPhoneXuat() {
        String connectionUrl =
                "jdbc:sqlserver://localhost:1433;"
                        + "database=KHODIENTHOAI;"
                        + "user=sa;"
                        + "password=123;"
                        + "encrypt=true;"
                        + "trustServerCertificate=true;"
                        + "loginTimeout=30;";
   
        ArrayList <Phone> rows = new ArrayList<Phone>();
        try (Connection connection = DriverManager.getConnection(connectionUrl); 
             Statement stm = connection.createStatement();) {
            // Code here.
            String selectSql = "SELECT* FROM DIENTHOAIXUAT";
            ResultSet rs = stm.executeQuery(selectSql);
            
            while (rs.next())
            {
                String ma = rs.getString(1);
                String ten = rs.getString(2);
                String heDieuHanh = rs.getString(3);
                String mau = rs.getString(4);
                String dungLuong = rs.getString(5);
                double soLuong = rs.getDouble(6);
                double donGia = rs.getDouble(7);
                Phone p = new Phone(ma, ten, heDieuHanh, mau,dungLuong,soLuong,donGia);
                rows.add(p);
            }
            
            connection.close();
        }
        // Handle any errors that may have occurred.
        catch (SQLException e) {
            System.out.println(" ");
        }
        return rows;
    }

   
}
