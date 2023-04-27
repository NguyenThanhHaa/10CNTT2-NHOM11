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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import quanlikho.PhieuNhap;
import quanlikho.PhieuXuat;
import java.sql.*;
import java.sql.Date;

/**
 *
 * @author thanh ha
 */
public class DAOPhieuXuat implements DAOPhieuInterface <PhieuXuat> {
    
    public static DAOPhieuXuat getInstance()
    {
        return new DAOPhieuXuat();
    }
    
    public void  insert(PhieuXuat t) {
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
        PhieuXuat px = new PhieuXuat();
        
        try (Connection connection = DriverManager.getConnection(connectionUrl); 
             Statement stm = connection.createStatement();) {
            // Code here.
            String selectSql = "SELECT* FROM PHIEUXUAT";
            ResultSet rs = stm.executeQuery(selectSql);
            
                System.out.println("Nhap ma phieu: ");
                String maPhieu = input.nextLine();
                System.out.println("Nhap ma san pham: ");
                String ma = input.nextLine();
                System.out.println("Nhap ten cong ty: ");
                String congTy = input.nextLine();
                
                int ngay;
                do{
                    System.out.println("Nhap ngay: ");
                    ngay = input.nextInt();
                } while (ngay>31 || ngay<0);

                int thang;
                do{
                    System.out.println("Nhap thang: ");
                    thang = input.nextInt();
                }while (thang>12 || thang<0);

                int nam;
                do{
                    System.out.println("Nhap nam: ");
                    nam = input.nextInt();
                }while (nam<1000 || nam>2023);
                
                LocalDate ngayNhap = LocalDate.of(nam, thang, ngay);
               
                
            
            String sqlInsert ="INSERT INTO PHIEUXUAT (MAPHIEU, MA, CONGTY, NGAYXUAT)" 
                               + "VALUES ('"+maPhieu+ 
                               "' , '"+ma+ 
                               "' , '"+congTy+ 
                               "' , '"+Date.valueOf(ngayNhap)+ 
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
        
    }

}
