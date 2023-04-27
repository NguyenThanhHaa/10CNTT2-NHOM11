/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlikho;

/**
 *
 * @author thanh ha
 */
public class PhieuXuat extends Phieu 
{   String ngayXuat;
    String congTy;

    public PhieuXuat(String ngayXuat, String congTy, String maPhieu, String ma) {
        super(maPhieu, ma);
        this.ngayXuat = ngayXuat;
        this.congTy = congTy;
    }

    

    public PhieuXuat() {
    }

    public String getMaPhieu() {
        return maPhieu;
    }

    public void setMaPhieu(String maPhieu) {
        this.maPhieu = maPhieu;
    }

    public String getNgayXuat() {
        return ngayXuat;
    }

    public void setNgayXuat(String ngayXuat) {
        this.ngayXuat = ngayXuat;
    }

    public String getCongTy() {
        return congTy;
    }

    public void setCongTy(String congTy) {
        this.congTy = congTy;
    }

    

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }
    
    
}
