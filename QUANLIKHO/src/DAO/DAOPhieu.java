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
import java.util.Date;
import java.util.Scanner;
import quanlikho.Phieu;
import quanlikho.Phone;

/**
 *
 * @author thanh ha
 */
public class DAOPhieu implements DAOInterface <Phieu> {
     public static DAOPhieu getInstance()
    {
        return new DAOPhieu();
    }
    
    
    public int insertPN(Phieu t) {
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
            String selectSql = "SELECT* FROM PHIEUNHAP";
            ResultSet rs = stm.executeQuery(selectSql);
            
            String sqlInsert ="INSERT INTO PHIEUNHAP (MAPHIEU, MA, TENNCC, NGAYNHAP)" 
                               + "VALUES ('"+t.getMaPhieu()+ 
                               "' , '"+t.getMa()+ 
                               "' , '"+ t.getTenNcc()+ 
                               "' , '"+t.getNgayNhap()+ 
                              "')";
            
            rows = stm.executeUpdate(sqlInsert);
            System.out.println("INSERT PHIEU NHAP THANH CONG!");
          
            while (rs.next())
            {
                System.out.println(rs.getString(1) +
                        " "  +rs.getString(2) +" " 
                        + rs.getString(3) +" " 
                        + rs.getString(4)  );
                
               
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
    public int update(Phieu t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int delete(Phieu t) {
       Scanner input = new Scanner (System.in);
        System.out.println("Nhap ma phieu nhap can xoa: ");
        String maPhieu = input.nextLine();
        
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
            
            String selectSql = "SELECT* FROM PHIEUNHAP";
            ResultSet rs = stm.executeQuery(selectSql);
            
            String sqlInsert ="DELETE from PHIEUNHAP "+
                             " WHERE MAPHIEU='"+maPhieu+"'";
            
            rows = stm.executeUpdate(sqlInsert);
            System.out.println("DELETE PHIEU NHAP THANH CONG!");
       
            connection.close();
            
        }
        // Handle any errors that may have occurred.
        catch (SQLException e) {
             e.printStackTrace();
        }
        return rows;
    }

    
    public ArrayList<Phieu> selectAllPN() {
       String connectionUrl =
                "jdbc:sqlserver://localhost:1433;"
                        + "database=KHODIENTHOAI;"
                        + "user=sa;"
                        + "password=123;"
                        + "encrypt=true;"
                        + "trustServerCertificate=true;"
                        + "loginTimeout=30;";
   
        ArrayList <Phieu> rows = new ArrayList<Phieu>();
        try (Connection connection = DriverManager.getConnection(connectionUrl); 
             Statement stm = connection.createStatement();) {
            // Code here.
            
            String sql = "SELECT PHIEUNHAP.MAPHIEU, "
                        + "PHIEUNHAP.TENNCC, "
                        + "PHIEUNHAP.NGAYNHAP, "
                        + "DIENTHOAINHAP.TEN, "
                        + "DIENTHOAINHAP.HEDIEUHANH, "
                        + "DIENTHOAINHAP.MAU,"
                        + "DIENTHOAINHAP.DUNGLUONG,"
                        + "DIENTHOAINHAP.SOLUONG, "
                        + "DIENTHOAINHAP.DONGIA \n" 
                        +"FROM PHIEUNHAP INNER JOIN DIENTHOAINHAP ON PHIEUNHAP.MA = DIENTHOAINHAP.MA";
            ResultSet rs3 = stm.executeQuery(sql);
            
            while (rs3.next()) {
                String maPhieu = rs3.getString(1);
                String tenNcc = rs3.getString(2);
                String ngayNhap = rs3.getString(3);
                String ten = rs3.getString(4);
                String heDieuHanh = rs3.getString(5);
                String mau = rs3.getString(6);
                String dungLuong = rs3.getString(7);
                double soLuong = rs3.getDouble(8);
                double donGia = rs3.getDouble(9);
            
            Phieu ph = new Phieu(maPhieu,tenNcc,ngayNhap);
            rows.add(ph);
            
            System.out.format("%-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s\n", 
                        "MAPHIEU",
                        "TENNCC",
                        "NGAY NHAP",
                        "TEN",
                        "HEDIEUHANH",
                        "MAU",
                        "DUNGLUONG",
                        "SOLUONG",
                        "DONGIA"
                        );
             
             System.out.format("%-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s\n", 
                        maPhieu,
                        tenNcc,
                        ngayNhap,
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
            e.printStackTrace();
        }
        return rows;
    }

   

    @Override
    public Phieu selectById(Phieu t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Phieu selectByTen(Phieu t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    

    @Override
    public int insert(Phieu t) {
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
            String selectSql = "SELECT* FROM PHIEUXUAT";
            ResultSet rs = stm.executeQuery(selectSql);
            
            String sqlInsert ="INSERT INTO PHIEUXUAT (MAPHIEU, MA, CONGTY, NGAYXUAT)" 
                               + "VALUES ('"+t.getMaPhieu()+ 
                               "' , '"+t.getMa()+ 
                               "' , '"+ t.getTenNcc()+ 
                               "' , '"+t.getNgayNhap()+ 
                              "')";
            
            rows = stm.executeUpdate(sqlInsert);
            System.out.println("INSERT PHIEU XUAT THANH CONG!");
          
            while (rs.next())
            {
                System.out.println(rs.getString(1) +
                        " "  +rs.getString(2) +" " 
                        + rs.getString(3) +" " 
                        + rs.getString(4)  );
                
               
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
    public ArrayList<Phieu> selectAll() {
         String connectionUrl =
                "jdbc:sqlserver://localhost:1433;"
                        + "database=KHODIENTHOAI;"
                        + "user=sa;"
                        + "password=123;"
                        + "encrypt=true;"
                        + "trustServerCertificate=true;"
                        + "loginTimeout=30;";
   
        ArrayList <Phieu> rows = new ArrayList<Phieu>();
        try (Connection connection = DriverManager.getConnection(connectionUrl); 
             Statement stm = connection.createStatement();) {
            // Code here.
            
            String sql = "SELECT PHIEUXUAT.MAPHIEU, "
                        + "PHIEUXUAT.CONGTY, "
                        + "PHIEUXUAT.NGAYXUAT, "
                        + "DIENTHOAIXUAT.TEN, "
                        + "DIENTHOAIXUAT.HEDIEUHANH, "
                        + "DIENTHOAIXUAT.MAU,"
                        + "DIENTHOAIXUAT.DUNGLUONG,"
                        + "DIENTHOAIXUAT.SOLUONG, "
                        + "DIENTHOAIXUAT.DONGIA \n" 
                        +"FROM PHIEUXUAT INNER JOIN DIENTHOAIXUAT ON PHIEUXUAT.MA = DIENTHOAIXUAT.MA";
            ResultSet rs3 = stm.executeQuery(sql);
            
            while (rs3.next()) {
                String maPhieu = rs3.getString(1);
                String tenNcc = rs3.getString(2);
                String ngayNhap = rs3.getString(3);
                String ten = rs3.getString(4);
                String heDieuHanh = rs3.getString(5);
                String mau = rs3.getString(6);
                String dungLuong = rs3.getString(7);
                double soLuong = rs3.getDouble(8);
                double donGia = rs3.getDouble(9);
            
            Phieu ph = new Phieu(maPhieu,ngayNhap,tenNcc);
            rows.add(ph);
            
            System.out.format("%-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s\n", 
                        "MAPHIEU",
                        "CONGTY",
                        "NGAY NHAP",
                        "TEN",
                        "HEDIEUHANH",
                        "MAU",
                        "DUNGLUONG",
                        "SOLUONG",
                        "DONGIA"
                        );
             
             System.out.format("%-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s\n", 
                        maPhieu,
                        tenNcc,
                        ngayNhap,
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
            e.printStackTrace();
        }
        return rows;
    }

   
    public int deletePX(Phieu t) {
       Scanner input = new Scanner (System.in);
        System.out.println("Nhap ma phieu nhap can xoa: ");
        String maPhieu = input.nextLine();
        
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
            
            String selectSql = "SELECT* FROM PHIEUXUAT";
            ResultSet rs = stm.executeQuery(selectSql);
            
            String sqlInsert ="DELETE from PHIEUXUAT "+
                             " WHERE MAPHIEU='"+maPhieu+"'";
            
            rows = stm.executeUpdate(sqlInsert);
            System.out.println("DELETE PHIEU XUAT THANH CONG!");
       
            connection.close();
            
        }
        // Handle any errors that may have occurred.
        catch (SQLException e) {
             e.printStackTrace();
        }
        return rows;
    }
}
