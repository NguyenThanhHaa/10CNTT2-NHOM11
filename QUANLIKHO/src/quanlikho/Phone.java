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
public class Phone {

    protected   String    ma;
    protected   String    ten;
    protected   String    heDieuHanh;
    protected   String    mau;
    protected   String    dungLuong;
    protected   double    soLuong;
    protected   double    donGia;

    public Phone() {

    }

    public Phone(String ma, String ten, String heDieuHanh, String mau, String dungLuong, double soLuong, double donGia) {
        this.ma = ma;
        this.ten = ten;
        this.heDieuHanh = heDieuHanh;
        this.mau = mau;
        this.dungLuong = dungLuong;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }
   
    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getMau() {
        return mau;
    }

    public void setMau(String mau) {
        this.mau = mau;
    }

    public String getDungluong() {
        return dungLuong;
    }

    public void setDungluong(String dungLuong) {
        this.dungLuong = dungLuong;
    }

    public double getSoluong() {
        return soLuong;
    }

    public void setSoluong(double soLuong) {
        this.soLuong = soLuong;
    }

    public double getDongia() {
        return donGia;
    }

    public void setDongia(double donGia) {
        this.donGia = donGia;
    }

    public String getHedieuhanh() {
        return heDieuHanh;
    }

    public void setHedieuhanh(String heDieuHanh) {
        this.heDieuHanh = heDieuHanh;
    }
    

    public void NhapPhone() {
        Scanner input = new Scanner(System.in);
      
        System.out.println("Nhap ma san pham: ");
        ma = input.nextLine();
        System.out.println("Nhap ten san pham: ");
        ten = input.nextLine();
        System.out.println("Nhap he dieu hanh: ");
        heDieuHanh = input.nextLine();
        System.out.println("Nhap mau: ");
        mau = input.nextLine();
        System.out.println("Nhap dung luong: ");
        dungLuong = input.nextLine();
        System.out.println("Nhap so luong: ");
        soLuong = input.nextDouble();
        System.out.println("Nhap don gia: ");
        donGia = input.nextDouble();
        input.nextLine();

    }

    public void Hien() {
        System.out.format("%-15s %-30s %-20s %-15s %-15s %-15s %-15s\n",
                "MA SP",
                "TEN",
                "HE DIEU HANH",
                "MAU",
                "DUNG LUONG",
                "SO LUONG",
                "DON GIA"
        );
        System.out.format("%-15s %-30s %-20s %-15s %-15s %-15s %-15s\n",
                ma,
                ten,
                heDieuHanh,
                mau,
                dungLuong,
                soLuong,
                donGia
        );
    }

    
}
