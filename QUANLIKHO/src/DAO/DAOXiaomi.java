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
import quanlikho.Xiaomi;
import quanlikho.iPhone;


/**
 *
 * @author thanh ha
 */
public class DAOXiaomi implements DAOInterface <Xiaomi>
{   
    public static DAOXiaomi getInstance()
    {
        return new DAOXiaomi();
    }
    
    @Override
    public int insert(Xiaomi t) {
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
        Xiaomi xm = new  Xiaomi();
        
         
        try (Connection connection = DriverManager.getConnection(connectionUrl); 
             Statement stm = connection.createStatement();) {
            // Code here.
           
            ResultSet rs = stm.executeQuery("SELECT * FROM XIAOMI");
            
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
               
                
                String sqlInsert = "INSERT INTO XIAOMI (MA, TEN, HEDIEUHANH, MAU, DUNGLUONG, SOLUONG, DONGIA)"
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
    public int update(Xiaomi t) {
         Scanner input = new Scanner (System.in);
        System.out.println("Nhap ma Xiaomi can xoa: ");
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
            
            String selectSql = "SELECT* FROM XIAOMI";
            ResultSet rs = stm.executeQuery(selectSql);
            
            String sqlInsert ="DELETE from XIAOMI "+
                             " WHERE MA='"+ma+"'";
            
            rows = stm.executeUpdate(sqlInsert);
            System.out.println("DELETE DIEN THOAI THANH CONG!");
       
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
    public int delete(Xiaomi t) {
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
            
            String selectSql = "SELECT* FROM XIAOMI";
            ResultSet rs = stm.executeQuery(selectSql);
            System.out.println("Nhap so lan muon xuat san pham: ");
            int n = input.nextInt();
            input.nextLine();
            
            for (int i=1; i<=n; i++)
            {   System.out.println("-----Lan xoa thu " +i+"-----");
                
                
                System.out.println("Nhap ma Xiaomi: ");
                String ma = input.nextLine();
                
                String sqlInsert = "DELETE from XIAOMI "
                        + " WHERE MA='" + ma + "'";

                rows = stm.executeUpdate(sqlInsert);
                
            }
                
       
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
    public ArrayList<Xiaomi> selectAll() {
         String connectionUrl =
                "jdbc:sqlserver://localhost:1433;"
                        + "database=KHODIENTHOAI;"
                        + "user=sa;"
                        + "password=123;"
                        + "encrypt=true;"
                        + "trustServerCertificate=true;"
                        + "loginTimeout=30;";
   
        ArrayList <Xiaomi> rows = new ArrayList<Xiaomi>();
        try (Connection connection = DriverManager.getConnection(connectionUrl); 
             Statement stm = connection.createStatement();) {
            // Code here.
            String selectSql = "SELECT* FROM XIAOMI";
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
                Xiaomi xm = new Xiaomi(ma, ten, heDieuHanh, mau,dungLuong,soLuong,donGia);
                rows.add(xm);
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
    public Xiaomi selectById(Xiaomi t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


  

    @Override
    public ArrayList<Xiaomi> selectBySoluongBetween() {
        String connectionUrl =
                "jdbc:sqlserver://localhost:1433;"
                        + "database=KHODIENTHOAI;"
                        + "user=sa;"
                        + "password=123;"
                        + "encrypt=true;"
                        + "trustServerCertificate=true;"
                        + "loginTimeout=30;";
   
        ArrayList <Xiaomi> rows = new ArrayList<Xiaomi>();
        try (Connection connection = DriverManager.getConnection(connectionUrl); 
             Statement stm = connection.createStatement();) {
            // Code here.
            String selectSql = "SELECT* FROM XIAOMI WHERE SOLUONG BETWEEN 1000 AND 5000";
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
                Xiaomi xm = new Xiaomi(ma, ten, heDieuHanh, mau,dungLuong,soLuong,donGia);
                rows.add(xm);
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
    public ArrayList<Xiaomi> selectBySoluong1000() {
       String connectionUrl =
                "jdbc:sqlserver://localhost:1433;"
                        + "database=KHODIENTHOAI;"
                        + "user=sa;"
                        + "password=123;"
                        + "encrypt=true;"
                        + "trustServerCertificate=true;"
                        + "loginTimeout=30;";
   
        ArrayList <Xiaomi> rows = new ArrayList<Xiaomi>();
        try (Connection connection = DriverManager.getConnection(connectionUrl); 
             Statement stm = connection.createStatement();) {
            // Code here.
            String selectSql = "SELECT* FROM XIAOMI WHERE SOLUONG < 1000";
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
                Xiaomi xm = new Xiaomi(ma, ten, heDieuHanh, mau,dungLuong,soLuong,donGia);
                rows.add(xm);
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
    public ArrayList<Xiaomi> selectBySoluong5000() {
       String connectionUrl =
                "jdbc:sqlserver://localhost:1433;"
                        + "database=KHODIENTHOAI;"
                        + "user=sa;"
                        + "password=123;"
                        + "encrypt=true;"
                        + "trustServerCertificate=true;"
                        + "loginTimeout=30;";
   
        ArrayList <Xiaomi> rows = new ArrayList<Xiaomi>();
        try (Connection connection = DriverManager.getConnection(connectionUrl); 
             Statement stm = connection.createStatement();) {
            // Code here.
            String selectSql = "SELECT* FROM XIAOMI WHERE SOLUONG > 5000";
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
                Xiaomi xm = new Xiaomi(ma, ten, heDieuHanh, mau,dungLuong,soLuong,donGia);
                rows.add(xm);
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
    public ArrayList<Xiaomi> selectByTen(Xiaomi t) {
        String connectionUrl =
                "jdbc:sqlserver://localhost:1433;"
                        + "database=KHODIENTHOAI;"
                        + "user=sa;"
                        + "password=123;"
                        + "encrypt=true;"
                        + "trustServerCertificate=true;"
                        + "loginTimeout=30;";
   
        ArrayList <Xiaomi> rows = new ArrayList<Xiaomi>();
        try (Connection connection = DriverManager.getConnection(connectionUrl); 
             Statement stm = connection.createStatement();) {
            // Code here.
            Scanner input = new Scanner(System.in);
            System.out.println("Nhap ten can tim: ");
            String ten = input.nextLine();
            String selectSql = "SELECT* FROM XIAOMI WHERE TEN='"+ten+"'";
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
                Xiaomi xm = new Xiaomi(ma, ten, heDieuHanh, mau,dungLuong,soLuong,donGia);
                rows.add(xm);
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
    public ArrayList<Xiaomi> sapXepTangDan() {
        String connectionUrl =
                "jdbc:sqlserver://localhost:1433;"
                        + "database=KHODIENTHOAI;"
                        + "user=sa;"
                        + "password=123;"
                        + "encrypt=true;"
                        + "trustServerCertificate=true;"
                        + "loginTimeout=30;";
   
        ArrayList <Xiaomi> rows = new ArrayList<Xiaomi>();
        try (Connection connection = DriverManager.getConnection(connectionUrl); 
             Statement stm = connection.createStatement();) {
            // Code here.
            String selectSql = "SELECT* FROM XIAOMI ORDER BY SOLUONG ASC";
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
                Xiaomi xm = new Xiaomi(ma, ten, heDieuHanh, mau,dungLuong,soLuong,donGia);
                rows.add(xm);
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
    public ArrayList<Xiaomi> sapXepGiamDan() {
        String connectionUrl =
                "jdbc:sqlserver://localhost:1433;"
                        + "database=KHODIENTHOAI;"
                        + "user=sa;"
                        + "password=123;"
                        + "encrypt=true;"
                        + "trustServerCertificate=true;"
                        + "loginTimeout=30;";
   
        ArrayList <Xiaomi> rows = new ArrayList<Xiaomi>();
        try (Connection connection = DriverManager.getConnection(connectionUrl); 
             Statement stm = connection.createStatement();) {
            // Code here.
            String selectSql = "SELECT* FROM XIAOMI ORDER BY SOLUONG DESC";
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
                Xiaomi xm = new Xiaomi(ma, ten, heDieuHanh, mau,dungLuong,soLuong,donGia);
                rows.add(xm);
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

    

   

   
    
