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
import java.sql.Date;
import java.util.Scanner;
import quanlikho.Phieu;
import quanlikho.PhieuNhap;
import java.sql.*;


/**
 *
 * @author thanh ha
 */
public class DAOPhieuNhap implements DAOPhieuInterface <PhieuNhap> {

    public static DAOPhieuNhap getInstance()
    {
        return new DAOPhieuNhap();
    }
    
    @Override
    public void insert(PhieuNhap t) {
        String connectionUrl
                = "jdbc:sqlserver://localhost:1433;"
                + "database=KHODIENTHOAI;"
                + "user=sa;"
                + "password=123;"
                + "encrypt=true;"
                + "trustServerCertificate=true;"
                + "loginTimeout=30;";
        int rows = 0;
        Scanner input = new Scanner(System.in);
        PhieuNhap pn = new PhieuNhap();

        try (Connection connection = DriverManager.getConnection(connectionUrl); Statement stm = connection.createStatement();) {
            // Code here.
            String selectSql = "SELECT* FROM PHIEUNHAP";
            ResultSet rs = stm.executeQuery(selectSql);

            System.out.println("Nhap ma phieu: ");
            String maPhieu = input.nextLine();
            System.out.println("Nhap ma san pham: ");
            String ma = input.nextLine();
            System.out.println("Nhap ten nha cung cap: ");
            String tenNcc = input.nextLine();
            
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

            String sqlInsert = "INSERT INTO PHIEUNHAP (MAPHIEU, MA, TENNCC, NGAYNHAP) VALUES (?,?,?,?)";

//            rows = stm.executeUpdate(sqlInsert);
            
            System.out.println("INSERT PHIEU NHAP THANH CONG!");

            PreparedStatement psm = connection.prepareStatement(sqlInsert);
            psm.setString(1, maPhieu);
            psm.setString(2, ma);
            psm.setString(3, tenNcc);
            psm.setDate(4, Date.valueOf(ngayNhap));
            psm.executeUpdate();
          
            connection.close();
            stm.close();
            return ;
            
        } // Handle any errors that may have occurred.
        catch (SQLException e) {
            System.out.println(" ");
        }


    }

   
}
