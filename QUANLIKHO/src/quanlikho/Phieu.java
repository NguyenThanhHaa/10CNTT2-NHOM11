/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlikho;

import java.util.Scanner;

/**
 *
 * @author thanh ha
 */
public class Phieu 
{
    public String maPhieu;
    public String ngayNhap;
    public String tenNcc;
    public String ma;

    public Phieu(String maPhieu, String ngayNhap, String tenNcc) {
        this.maPhieu = maPhieu;
        this.ngayNhap = ngayNhap;
        this.tenNcc = tenNcc;
        this.ma = ma;
    }

    public Phieu() {
    }

    public String getMaPhieu() {
        return maPhieu;
    }

    public void setMaPhieu(String maPhieu) {
        this.maPhieu = maPhieu;
    }

    public String getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(String ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public String getTenNcc() {
        return tenNcc;
    }

    public void setTenNcc(String tenNcc) {
        this.tenNcc = tenNcc;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    
    public void NhapPhieuNhap()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhap ma phieu: ");
        maPhieu = input.nextLine();
        System.out.println("Nhap ma san pham: ");
        ma = input.nextLine();
        System.out.println("Nhap ten nha cung cap: ");
        tenNcc = input.nextLine();
        System.out.println("Nhap ngay nhap: ");
        ngayNhap = input.nextLine();
    }
    
    public void HienPhieuNhap()
    {
         System.out.format("%-20s %-20s %-40s  %-20s\n",
                "MA PHIEU",
                "MA",
                "TENNCC",
                "NGAY NHAP"
        );
        System.out.format("%-20s %-20s %-40s %-20s \n",
                maPhieu,
                ma,
                tenNcc,
                ngayNhap
        );
    }
    
    public void NhapPhieuXuat()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhap ma phieu: ");
        maPhieu = input.nextLine();
        System.out.println("Nhap ma san pham: ");
        ma = input.nextLine();
        System.out.println("Nhap ten cong ty: ");
        tenNcc = input.nextLine();
        System.out.println("Nhap ngay xuat: ");
        ngayNhap = input.nextLine();
    }
}
