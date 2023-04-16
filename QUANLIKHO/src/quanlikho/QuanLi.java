/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlikho;

import DAO.DAOPhone;
import java.util.ArrayList;
import java.util.Scanner;
import DAO.DAOPhieu;

/**
 *
 * @author thanh ha
 */
public class QuanLi 
{
    public void MENU()
    {
        Scanner input = new Scanner(System.in);
        
        Phone phone;
        Phieu phieuNhap;
        Phieu phieuXuat;

        int chon;
       
        do {
            System.out.println("+---------------------MENU QUAN LY KHO DIEN THOAI CAO CAP---------------------------+");
            System.out.println("1. Phieu Nhap");
            System.out.println("2. Phieu Xuat");
            System.out.println("3. Hien thi danh sach trong kho");
            System.out.println("4. Tim kiem");
            System.out.println("5. Xoa");
            System.out.println("+------------------------------------------------------------------------------------+");

            System.out.print("\n Chon chuc nang: ");
            chon = input.nextInt();

            if (chon == 1) {
                System.out.println("\n+---------PHIEU NHAP DIEN THOAI---------+");
                DAOPhieu dpn = new DAOPhieu();
                DAOPhone dp = new DAOPhone();
                phieuNhap = new Phieu();
                phone = new Phone();
                
                phieuNhap.NhapPhieuNhap();
                phone.NhapPhone();
                
                dpn.insertPN(phieuNhap);
                dp.insert(phone);
                
            }
            else if (chon==2)
            {
                System.out.println("\n+---------PHIEU XUAT DIEN THOAI---------+");
                //Xuất hàng thì phải xóa hàng 
                DAOPhieu dpx = new DAOPhieu();
                DAOPhone dp = new DAOPhone();
                phieuXuat = new Phieu();
                phone = new Phone();
                
                phieuXuat.NhapPhieuXuat();
                phone.NhapPhone();
                
                dpx.insert(phieuXuat);
                dp.insertPhoneXuat(phone);
            }

            else if (chon == 3) {
                System.out.println("+---------HIEN THI DANH SACH TRONG KHO---------+");
                System.out.println("1.Hien thi danh sach dien thoai nhap");
                System.out.println("2.Hien thi danh sach dien thoai xuat");
                System.out.println("3.Hien thi danh sach phieu nhap");
                System.out.println("4.Hien thi thong tin phieu xuat");
                
                System.out.println("Chon chuc nang: ");
                chon = input.nextInt();
                
                if(chon==1)
                {
                    ArrayList<Phone> list = DAOPhone.getInstance().selectAll();
                    for (Phone p : list)
                    {
                        p.Hien();
                    }               
                }
                else if(chon==2)
                {
                    ArrayList<Phone> list = DAOPhone.getInstance().selectAllPhoneXuat();
                    for (Phone p : list)
                    {
                        p.Hien();
                    }   
                }
                
                else if (chon==3)
                {
                    DAOPhieu dpn = new DAOPhieu();
                    dpn.selectAllPN();
                
                }
                else if(chon==4)
                {
                    DAOPhieu dpx = new DAOPhieu();
                    dpx.selectAll();
                    
                }
                
            } 
            else if (chon == 4) {
                System.out.println("+---------TIM KIEM DIEN THOAI TRONG KHO---------+");
               
                System.out.println("1.Tim kiem theo ma");
                System.out.println("2.Tim kiem theo ten");
                System.out.println("Chon chuc nang: ");
                chon = input.nextInt();
                    
                    if (chon==1)
                    {
                        input.nextLine();   
                        Phone find = new Phone();
                        System.out.println("Nhap ma can tim: ");
                        String ma = input.nextLine();
                        find.setMa(ma);
                        Phone ip2 = DAOPhone.getInstance().selectById(find);
                        ip2.Hien(); 
                    } 
                    else if (chon==2)
                    {
                        input.nextLine();   
                        Phone find = new Phone();
                        System.out.println("Nhap ten can tim: ");
                        String ten = input.nextLine();
                        find.setTen(ten);
                        Phone ip2 = DAOPhone.getInstance().selectByTen(find);
                        ip2.Hien(); 
                       
                    }
                   
                
                } 
            
            else if (chon==5)
                {  System.out.println("+--------------XOA-------------+");
                   System.out.println("1.Xoa dien thoai");
                   System.out.println("2.Xoa phieu nhap");
                   System.out.println("3.Xoa phieu xuat");
                   System.out.println("Chon chuc nang: ");
                   chon = input.nextInt();
                   
                   if(chon==1)
                   {
                        phone = new Phone();
                        DAOPhone dp = new DAOPhone();
                        dp.delete(phone);
                   }
                   else if (chon==2)
                   {
                       phieuNhap = new Phieu();
                       DAOPhieu dp = new DAOPhieu();
                       dp.delete(phieuNhap);
                   }
                   else if (chon==3)
                   {
                       phieuXuat = new Phieu();
                       DAOPhieu dp = new DAOPhieu();
                       dp.deletePX(phieuXuat);
                   }
                  
                }
 

        } while (chon!= 0);

    }
 }



