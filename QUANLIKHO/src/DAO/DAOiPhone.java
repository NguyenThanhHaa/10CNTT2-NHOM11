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
import java.util.InputMismatchException;
import java.util.Scanner;
import quanlikho.Phone;
import quanlikho.iPhone;

/**
 *
 * @author thanh ha
 */

public class DAOiPhone implements DAOInterface <iPhone>
{
    public static DAOiPhone getInstance()
    {
        return new DAOiPhone();
    }

    @Override
    public int insert(iPhone t) {
        String connectionUrl =
                "jdbc:sqlserver://localhost:1433;"
                        + "database=KHODIENTHOAI;"
                        + "user=sa;"
                        + "password=123;"
                        + "encrypt=true;"
                        + "trustServerCertificate=true;"
                        + "loginTimeout=30;";
        int rows=0;
        Scanner input = new Scanner(System.in);
        iPhone ip = new iPhone();
        
         
        try (Connection connection = DriverManager.getConnection(connectionUrl); 
             Statement stm = connection.createStatement();) {
            // Code here.
           
            ResultSet rs = stm.executeQuery("SELECT * FROM iPHONE");
               
                System.out.println("Nhap ma san pham: ");
                String ma = input.nextLine();
                System.out.println("Nhap ten san pham: ");
                String ten = input.nextLine();
                System.out.println("Nhap he dieu hanh: ");
                String heDieuHanh = input.nextLine();
                System.out.println("Nhap mau: ");
                String mau = input.nextLine();
                System.out.println("Nhap dung luong: ");
                String dungLuong = input.nextLine();
                System.out.println("Nhap so luong: ");
                Double soLuong = input.nextDouble();
                System.out.println("Nhap don gia: ");
                Double donGia = input.nextDouble();
               
                
                String sqlInsert = "INSERT INTO iPHONE (MA, TEN, HEDIEUHANH, MAU, DUNGLUONG, SOLUONG, DONGIA)"
                        + "VALUES ('" + ma
                        + "' , '" + ten
                        + "' , '" + heDieuHanh
                        + "' , '" + mau
                        + "' , '" + dungLuong
                        + "' , '" + soLuong
                        + "' , '" + donGia + "')";

                rows = stm.executeUpdate(sqlInsert);
                System.out.println("----INSERT DIEN THOAI THANH CONG!----");

           
        connection.close();
        rs.close();
            
        }
        // Handle any errors that may have occurred.
        catch (SQLException e)  {
            System.out.print("Nhap du lieu chua chinh xac");
             
        }
        catch(InputMismatchException e)
        {
            System.out.println("Nhap du lieu chua chinh xac");
        }
       
        return rows;
    }

    @Override
    public int update(iPhone t) {
         String connectionUrl =
                "jdbc:sqlserver://localhost:1433;"
                        + "database=KHODIENTHOAI;"
                        + "user=sa;"
                        + "password=123;"
                        + "encrypt=true;"
                        + "trustServerCertificate=true;"
                        + "loginTimeout=30;";
        int rows=0;
        Scanner input = new Scanner (System.in);
        try (Connection connection = DriverManager.getConnection(connectionUrl); 
             Statement stm = connection.createStatement();) {
            // Code here.
            String selectSql = "SELECT* FROM iPHONE";
            ResultSet rs = stm.executeQuery(selectSql);
            
                System.out.println("Nhap ma san pham: ");
                String ma = input.nextLine();
                System.out.println("Nhap ten san pham: ");
                String ten = input.nextLine();
                System.out.println("Nhap he dieu hanh: ");
                String heDieuHanh = input.nextLine();
                System.out.println("Nhap mau: ");
                String mau = input.nextLine();
                System.out.println("Nhap dung luong: ");
                String dungLuong = input.nextLine();
                Double soLuong;
                do{
                    System.out.println("Nhap so luong: ");
                    soLuong = input.nextDouble();
                }while (soLuong<0);
                
                Double donGia;
                do{
                    System.out.println("Nhap don gia: ");
                    donGia = input.nextDouble();
                } while(donGia<0);
                
            
            String sqlUpdate  = "UPDATE iPHONE SET TEN=?, HEDIEUHANH=?, MAU=?, DUNGLUONG=?, SOLUONG=?, DONGIA=?  WHERE MA=?";
            
            rows = stm.executeUpdate(sqlUpdate);
            System.out.println("----UPDATE THANH CONG!----");
          
            connection.close(); 
            
        }
        
        // Handle any errors that may have occurred.
        catch (SQLException e) {
            System.out.println("Nhap du lieu chua chinh xac ");
        }
        return rows;
    }

    @Override
    public int delete(iPhone t) {
        Scanner input = new Scanner (System.in);
        
        
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
            
            String selectSql = "SELECT* FROM iPHONE";
            ResultSet rs = stm.executeQuery(selectSql);
            
            
                
                System.out.println("Nhap ma iPhone can xuat: ");
                String ma = input.nextLine();
                
                String sqlInsert = "DELETE from iPHONE "
                        + " WHERE MA='" + ma + "'";

                rows = stm.executeUpdate(sqlInsert);
                
            
            
            System.out.println("XUAT DIEN THOAI THANH CONG!");
       
            connection.close();
            
        }
        
        // Handle any errors that may have occurred.
        catch (SQLException e) {
             System.out.print("Nhap du lieu chua chinh xac");
        }
        
        catch(InputMismatchException e)
        {
            System.out.println("Nhap du lieu chua chinh xac");
        }
        
        return rows;
    }

    @Override
    public ArrayList<iPhone> selectAll() {
        String connectionUrl =
                "jdbc:sqlserver://localhost:1433;"
                        + "database=KHODIENTHOAI;"
                        + "user=sa;"
                        + "password=123;"
                        + "encrypt=true;"
                        + "trustServerCertificate=true;"
                        + "loginTimeout=30;";
   
        ArrayList <iPhone> rows = new ArrayList<iPhone>();
        try (Connection connection = DriverManager.getConnection(connectionUrl); 
             Statement stm = connection.createStatement();) {
            // Code here.
            String selectSql = "SELECT* FROM iPHONE";
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
                iPhone ip = new iPhone(ma, ten, heDieuHanh, mau,dungLuong,soLuong,donGia);
                rows.add(ip);
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
    public iPhone selectById(iPhone t) {
        String connectionUrl =
                "jdbc:sqlserver://localhost:1433;"
                        + "database=KHODIENTHOAI;"
                        + "user=sa;"
                        + "password=123;"
                        + "encrypt=true;"
                        + "trustServerCertificate=true;"
                        + "loginTimeout=30;";
   
        
        iPhone rows = null;
       
        
        try (Connection connection = DriverManager.getConnection(connectionUrl); 
             Statement stm = connection.createStatement();) {
            // Code here.
            
            Scanner input = new Scanner(System.in);
            System.out.println("Nhap ma can tim: ");
            String ma = input.nextLine();
            String selectSql = "SELECT* FROM iPHONE WHERE MA='"+ma+"'";
            ResultSet rs = stm.executeQuery(selectSql);
            
            while (rs.next())
            {
                ma = rs.getString(1);
                String ten = rs.getString(2);
                String heDieuHanh = rs.getString(3);
                String mau = rs.getString(4);
                String dungLuong = rs.getString(5);
                double soLuong = rs.getDouble(6);
                double donGia = rs.getDouble(7);
                rows = new iPhone(ma, ten, heDieuHanh, mau,dungLuong,soLuong,donGia);
                
                 System.out.format("%-15s %-40s %-20s %-15s %-15s %-15s %-15s\n",
                "MA SP",
                "TEN",
                "HE DIEU HANH",
                "MAU",
                "DUNG LUONG",
                "SO LUONG",
                "DON GIA"
        );
        System.out.format("%-15s %-40s %-20s %-15s %-15s %-15s %-15s\n",
                ma,
                ten,
                heDieuHanh,
                mau,
                dungLuong,
                soLuong,
                donGia
        );
               
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
    public ArrayList<iPhone> selectBySoluongBetween() {
       String connectionUrl =
                "jdbc:sqlserver://localhost:1433;"
                        + "database=KHODIENTHOAI;"
                        + "user=sa;"
                        + "password=123;"
                        + "encrypt=true;"
                        + "trustServerCertificate=true;"
                        + "loginTimeout=30;";
   
        ArrayList <iPhone> rows = new ArrayList<iPhone>();
        try (Connection connection = DriverManager.getConnection(connectionUrl); 
             Statement stm = connection.createStatement();) {
            // Code here.
            String selectSql = "SELECT* FROM iPHONE WHERE SOLUONG BETWEEN 1000 AND 5000";
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
                iPhone ip = new iPhone(ma, ten, heDieuHanh, mau,dungLuong,soLuong,donGia);
                rows.add(ip);
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
    public ArrayList<iPhone> selectBySoluong1000() {
         String connectionUrl =
                "jdbc:sqlserver://localhost:1433;"
                        + "database=KHODIENTHOAI;"
                        + "user=sa;"
                        + "password=123;"
                        + "encrypt=true;"
                        + "trustServerCertificate=true;"
                        + "loginTimeout=30;";
   
        ArrayList <iPhone> rows = new ArrayList<iPhone>();
        try (Connection connection = DriverManager.getConnection(connectionUrl); 
             Statement stm = connection.createStatement();) {
            // Code here.
            String selectSql = "SELECT* FROM iPHONE WHERE SOLUONG < 1000";
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
                iPhone ip = new iPhone(ma, ten, heDieuHanh, mau,dungLuong,soLuong,donGia);
                rows.add(ip);
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
    public ArrayList<iPhone> selectBySoluong5000() {
         String connectionUrl =
                "jdbc:sqlserver://localhost:1433;"
                        + "database=KHODIENTHOAI;"
                        + "user=sa;"
                        + "password=123;"
                        + "encrypt=true;"
                        + "trustServerCertificate=true;"
                        + "loginTimeout=30;";
   
        ArrayList <iPhone> rows = new ArrayList<iPhone>();
        try (Connection connection = DriverManager.getConnection(connectionUrl); 
             Statement stm = connection.createStatement();) {
            // Code here.
            String selectSql = "SELECT* FROM iPHONE WHERE SOLUONG > 5000";
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
                iPhone ip = new iPhone(ma, ten, heDieuHanh, mau,dungLuong,soLuong,donGia);
                rows.add(ip);
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
    public ArrayList<iPhone> selectByTen(iPhone t) {
        String connectionUrl =
                "jdbc:sqlserver://localhost:1433;"
                        + "database=KHODIENTHOAI;"
                        + "user=sa;"
                        + "password=123;"
                        + "encrypt=true;"
                        + "trustServerCertificate=true;"
                        + "loginTimeout=30;";
   
        ArrayList <iPhone> rows = new ArrayList<iPhone>();
        try (Connection connection = DriverManager.getConnection(connectionUrl); 
             Statement stm = connection.createStatement();) {
            // Code here.
            Scanner input = new Scanner(System.in);
            System.out.println("Nhap ten can tim: ");
            String ten = input.nextLine();
            String selectSql = "SELECT* FROM iPHONE WHERE TEN='"+ten+"'";
            ResultSet rs = stm.executeQuery(selectSql);
            
            while (rs.next())
            {
                String ma = rs.getString(1);
                ten = rs.getString(2);
                String heDieuHanh = rs.getString(3);
                String mau = rs.getString(4);
                String dungLuong = rs.getString(5);
                double soLuong = rs.getDouble(6);
                double donGia = rs.getDouble(7);
                iPhone ip = new iPhone(ma, ten, heDieuHanh, mau,dungLuong,soLuong,donGia);
                rows.add(ip);
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
    public ArrayList<iPhone> sapXepTangDan() {
        String connectionUrl =
                "jdbc:sqlserver://localhost:1433;"
                        + "database=KHODIENTHOAI;"
                        + "user=sa;"
                        + "password=123;"
                        + "encrypt=true;"
                        + "trustServerCertificate=true;"
                        + "loginTimeout=30;";
   
        ArrayList <iPhone> rows = new ArrayList<iPhone>();
        try (Connection connection = DriverManager.getConnection(connectionUrl); 
             Statement stm = connection.createStatement();) {
            // Code here.
            String selectSql = "SELECT* FROM iPHONE ORDER BY SOLUONG ASC";
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
                iPhone ip = new iPhone(ma, ten, heDieuHanh, mau,dungLuong,soLuong,donGia);
                rows.add(ip);
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
    public ArrayList<iPhone> sapXepGiamDan() {
        String connectionUrl =
                "jdbc:sqlserver://localhost:1433;"
                        + "database=KHODIENTHOAI;"
                        + "user=sa;"
                        + "password=123;"
                        + "encrypt=true;"
                        + "trustServerCertificate=true;"
                        + "loginTimeout=30;";
   
        ArrayList <iPhone> rows = new ArrayList<iPhone>();
        try (Connection connection = DriverManager.getConnection(connectionUrl); 
             Statement stm = connection.createStatement();) {
            // Code here.
            String selectSql = "SELECT* FROM iPHONE ORDER BY SOLUONG DESC";
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
                iPhone ip = new iPhone(ma, ten, heDieuHanh, mau,dungLuong,soLuong,donGia);
                rows.add(ip);
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

    
    
    
    

