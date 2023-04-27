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
public class PhieuNhap extends Phieu
{   public String ngayNhap;
    public String tenNcc;

    public PhieuNhap(String ngayNhap, String tenNcc, String maPhieu, String ma) {
        super(maPhieu, ma);
        this.ngayNhap = ngayNhap;
        this.tenNcc = tenNcc;
    }

    

    public PhieuNhap() {
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
    
  
    
}
