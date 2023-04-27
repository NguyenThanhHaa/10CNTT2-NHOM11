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
import quanlikho.Oppo;
import quanlikho.Samsung;
import quanlikho.iPhone;


/**
 *
 * @author thanh ha
 */
public class DAOOppo implements DAOInterface <Oppo> {
    
    public static DAOOppo getInstance()
    {
        return new DAOOppo();
    }
    
    @Override
    public int insert(Oppo t) {
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
        Oppo op = new Oppo();
        
         
        try (Connection connection = DriverManager.getConnection(connectionUrl); 
             Statement stm = connection.createStatement();) {
            // Code here.
           
            ResultSet rs = stm.executeQuery("SELECT * FROM OPPO");
            
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
               
                
                String sqlInsert = "INSERT INTO OPPO (MA, TEN, HEDIEUHANH, MAU, DUNGLUONG, SOLUONG, DONGIA)"
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
    public int update(Oppo t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int delete(Oppo t) {
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
            
            String selectSql = "SELECT* FROM OPPO";
            ResultSet rs = stm.executeQuery(selectSql);
           
                
                
                System.out.println("Nhap ma Oppo: ");
                String ma = input.nextLine();
                
                String sqlInsert = "DELETE from OPPO "
                        + " WHERE MA='" + ma + "'";

                rows = stm.executeUpdate(sqlInsert);
                
            
                
       
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
    public ArrayList<Oppo> selectAll() {
         String connectionUrl =
                "jdbc:sqlserver://localhost:1433;"
                        + "database=KHODIENTHOAI;"
                        + "user=sa;"
                        + "password=123;"
                        + "encrypt=true;"
                        + "trustServerCertificate=true;"
                        + "loginTimeout=30;";
   
        ArrayList <Oppo> rows = new ArrayList<Oppo>();
        try (Connection connection = DriverManager.getConnection(connectionUrl); 
             Statement stm = connection.createStatement();) {
            // Code here.
            String selectSql = "SELECT* FROM OPPO";
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
                Oppo op = new Oppo(ma, ten, heDieuHanh, mau,dungLuong,soLuong,donGia);
                rows.add(op);
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
    public Oppo selectById(Oppo t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   

    @Override
    public ArrayList<Oppo> selectBySoluongBetween() {
         String connectionUrl =
                "jdbc:sqlserver://localhost:1433;"
                        + "database=KHODIENTHOAI;"
                        + "user=sa;"
                        + "password=123;"
                        + "encrypt=true;"
                        + "trustServerCertificate=true;"
                        + "loginTimeout=30;";
   
        ArrayList <Oppo> rows = new ArrayList<Oppo>();
        try (Connection connection = DriverManager.getConnection(connectionUrl); 
             Statement stm = connection.createStatement();) {
            // Code here.
            String selectSql = "SELECT* FROM OPPO WHERE SOLUONG BETWEEN 1000 AND 5000";
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
                Oppo op = new Oppo(ma, ten, heDieuHanh, mau,dungLuong,soLuong,donGia);
                rows.add(op);
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
    public ArrayList<Oppo> selectBySoluong1000() {
        String connectionUrl =
                "jdbc:sqlserver://localhost:1433;"
                        + "database=KHODIENTHOAI;"
                        + "user=sa;"
                        + "password=123;"
                        + "encrypt=true;"
                        + "trustServerCertificate=true;"
                        + "loginTimeout=30;";
   
        ArrayList <Oppo> rows = new ArrayList<Oppo>();
        try (Connection connection = DriverManager.getConnection(connectionUrl); 
             Statement stm = connection.createStatement();) {
            // Code here.
            String selectSql = "SELECT* FROM OPPO WHERE SOLUONG < 1000";
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
                Oppo op = new Oppo(ma, ten, heDieuHanh, mau,dungLuong,soLuong,donGia);
                rows.add(op);
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
    public ArrayList<Oppo> selectBySoluong5000() {
        String connectionUrl =
                "jdbc:sqlserver://localhost:1433;"
                        + "database=KHODIENTHOAI;"
                        + "user=sa;"
                        + "password=123;"
                        + "encrypt=true;"
                        + "trustServerCertificate=true;"
                        + "loginTimeout=30;";
   
        ArrayList <Oppo> rows = new ArrayList<Oppo>();
        try (Connection connection = DriverManager.getConnection(connectionUrl); 
             Statement stm = connection.createStatement();) {
            // Code here.
            String selectSql = "SELECT* FROM OPPO WHERE SOLUONG > 5000";
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
                Oppo op = new Oppo(ma, ten, heDieuHanh, mau,dungLuong,soLuong,donGia);
                rows.add(op);
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
    public ArrayList<Oppo> selectByTen(Oppo t) {
        String connectionUrl =
                "jdbc:sqlserver://localhost:1433;"
                        + "database=KHODIENTHOAI;"
                        + "user=sa;"
                        + "password=123;"
                        + "encrypt=true;"
                        + "trustServerCertificate=true;"
                        + "loginTimeout=30;";
   
        ArrayList <Oppo> rows = new ArrayList<Oppo>();
        try (Connection connection = DriverManager.getConnection(connectionUrl); 
             Statement stm = connection.createStatement();) {
            // Code here.
            Scanner input = new Scanner(System.in);
            System.out.println("Nhap ten can tim: ");
            String ten = input.nextLine();
            String selectSql = "SELECT* FROM OPPO WHERE TEN='"+ten+"'";
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
                Oppo op = new Oppo(ma, ten, heDieuHanh, mau,dungLuong,soLuong,donGia);
                rows.add(op);
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
    public ArrayList<Oppo> sapXepTangDan() {
        String connectionUrl =
                "jdbc:sqlserver://localhost:1433;"
                        + "database=KHODIENTHOAI;"
                        + "user=sa;"
                        + "password=123;"
                        + "encrypt=true;"
                        + "trustServerCertificate=true;"
                        + "loginTimeout=30;";
   
        ArrayList <Oppo> rows = new ArrayList<Oppo>();
        try (Connection connection = DriverManager.getConnection(connectionUrl); 
             Statement stm = connection.createStatement();) {
            // Code here.
            String selectSql = "SELECT* FROM OPPO ORDER BY SOLUONG ASC";
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
                Oppo op = new Oppo(ma, ten, heDieuHanh, mau,dungLuong,soLuong,donGia);
                rows.add(op);
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
    public ArrayList<Oppo> sapXepGiamDan() {
        String connectionUrl =
                "jdbc:sqlserver://localhost:1433;"
                        + "database=KHODIENTHOAI;"
                        + "user=sa;"
                        + "password=123;"
                        + "encrypt=true;"
                        + "trustServerCertificate=true;"
                        + "loginTimeout=30;";
   
        ArrayList <Oppo> rows = new ArrayList<Oppo>();
        try (Connection connection = DriverManager.getConnection(connectionUrl); 
             Statement stm = connection.createStatement();) {
            // Code here.
            String selectSql = "SELECT* FROM OPPO ORDER BY SOLUONG DESC";
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
                Oppo op = new Oppo(ma, ten, heDieuHanh, mau,dungLuong,soLuong,donGia);
                rows.add(op);
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

   
