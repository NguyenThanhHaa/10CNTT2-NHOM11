/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlikho;

import DAO.DAOOppo;
import DAO.DAOPhieuNhap;
import DAO.DAOPhieuXuat;
import java.util.ArrayList;
import java.util.Scanner;
import DAO.DAOSamsung;
import DAO.DAOXiaomi;
import DAO.DAOiPhone;

/**
 *
 * @author thanh ha
 */
public class QuanLi 
{
    public void MENU()
    {
        Scanner input = new Scanner(System.in);
        
        iPhone ip;
        Samsung ss;
        Oppo op;
        Xiaomi xm;
        PhieuNhap phieuNhap;
        PhieuXuat phieuXuat;

        int chon;
       
        do {
            System.out.println("\n+---------------------MENU QUAN LY KHO DIEN THOAI CAO CAP---------------------------+");
            System.out.println("1. Nhap dien thoai");
            System.out.println("2. Xuat dien thoai");
            System.out.println("3. Hien thi danh sach dien thoai trong kho");
            System.out.println("4. Tim kiem");
            System.out.println("5. Sap xep");
            System.out.println("+------------------------------------------------------------------------------------+");

            System.out.print("\n Chon chuc nang: ");
            chon = input.nextInt();

            if (chon == 1) {
                System.out.println("\n+---------NHAP DIEN THOAI---------+");
                System.out.println("1. Nhap iPhone");
                System.out.println("2. Nhap Samsung");
                System.out.println("3. Nhap Oppo");
                System.out.println("4. Nhap Xiaomi");
                System.out.print("Vui long chon chuc nang: ");
                chon = input.nextInt();
                
                if (chon==1)
                {
                    DAOiPhone dp = new DAOiPhone();
                    ip = new iPhone();
                    DAOPhieuNhap dpn = new DAOPhieuNhap();
                    phieuNhap = new PhieuNhap();
                    
                    System.out.print("Nhap so lan nhap: ");
                    int n = input.nextInt();
                    
                    for (int i=1; i<=n;i++)
                    {       System.out.println("---Lan nhap thu "+i+" ---");
                            dpn.insert(phieuNhap);
                            dp.insert(ip);
                       
                    }
                    
                }
                else if (chon==2)
                {
                    DAOSamsung ds = new DAOSamsung();
                    ss = new Samsung();
                    DAOPhieuNhap dpn = new DAOPhieuNhap();
                    phieuNhap = new PhieuNhap();
                    
                    System.out.print("Nhap so lan nhap: ");
                    int n = input.nextInt();
                    
                    for (int i=1; i<=n;i++)
                    {       System.out.println("---Lan nhap thu "+i+" ---");
                            dpn.insert(phieuNhap);
                            ds.insert(ss);
                       
                    }

                }
                else if(chon==3)
                {
                    DAOOppo dop = new DAOOppo();
                    op = new Oppo();
                    DAOPhieuNhap dpn = new DAOPhieuNhap();
                    phieuNhap = new PhieuNhap();
                    
                    System.out.print("Nhap so lan nhap: ");
                    int n = input.nextInt();
                    
                    for (int i=1; i<=n;i++)
                    {       System.out.println("---Lan nhap thu "+i+" ---");
                            dpn.insert(phieuNhap);
                            dop.insert(op);
                       
                    }
                    
                }
                
                else if (chon==4)
                {
                    DAOXiaomi dxm = new DAOXiaomi();
                    xm = new Xiaomi();
                     DAOPhieuNhap dpn = new DAOPhieuNhap();
                    phieuNhap = new PhieuNhap();
                    
                    System.out.print("Nhap so lan nhap: ");
                    int n = input.nextInt();
                    
                    for (int i=1; i<=n;i++)
                    {       System.out.println("---Lan nhap thu "+i+" ---");
                            dpn.insert(phieuNhap);
                            dxm.insert(xm);
                       
                    }
                    
                }
                
                
            }
            else if (chon==2)
            {
                System.out.println("\n+---------XUAT DIEN THOAI---------+");
                System.out.println("1.Xuat iPHONE");
                System.out.println("2.Xuat SAMSUNG");
                System.out.println("3.Xuat OPPO");
                System.out.println("4.Xuat XIAOMI");
                System.out.print("Vui long chon chuc nang: ");
                chon = input.nextInt();
                
                if (chon==1)
                {
                    ip = new iPhone();
                    DAOiPhone dp = new DAOiPhone();
                    phieuXuat = new PhieuXuat();
                    DAOPhieuXuat dpx = new DAOPhieuXuat();
                    
                    System.out.print("Nhap so lan xuat san pham: ");
                    int n = input.nextInt();
                    
                    for (int i=1; i<=n;i++)
                    {       System.out.println("---Lan thu "+i+" ---");
                            dpx.insert(phieuXuat);
                            dp.delete(ip);
                       
                    }
                    
                }
                else if (chon==2)
                {
                    ss = new Samsung();
                    DAOSamsung ds = new DAOSamsung();
                    phieuXuat = new PhieuXuat();
                    DAOPhieuXuat dpx = new DAOPhieuXuat();
                    
                    System.out.print("Nhap so lan xuat san pham: ");
                    int n = input.nextInt();
                    
                    for (int i=1; i<=n;i++)
                    {       System.out.println("---Lan thu "+i+" ---");
                            dpx.insert(phieuXuat);
                            ds.delete(ss);
                       
                    }
                    
                }
                else if (chon==3)
                {
                    op = new Oppo();
                    DAOOppo dop = new DAOOppo();
                    phieuXuat = new PhieuXuat();
                    DAOPhieuXuat dpx = new DAOPhieuXuat();
                    
                    System.out.print("Nhap so lan xuat san pham: ");
                    int n = input.nextInt();
                    
                    for (int i=1; i<=n;i++)
                    {       System.out.println("---Lan thu "+i+" ---");
                            dpx.insert(phieuXuat);
                            dop.delete(op);
                       
                    }
                    
                    
                }
                else if (chon==4)
                {
                    xm = new Xiaomi();
                    DAOXiaomi dxm = new DAOXiaomi();
                    phieuXuat = new PhieuXuat();
                    DAOPhieuXuat dpx = new DAOPhieuXuat();
                    
                    System.out.print("Nhap so lan xuat san pham: ");
                    int n = input.nextInt();
                    
                    for (int i=1; i<=n;i++)
                    {       System.out.println("---Lan thu "+i+" ---");
                            dpx.insert(phieuXuat);
                            dxm.delete(xm);
                       
                    }
                    
                }
                
                
            }

            else if (chon == 3) {
                System.out.println("+---------HIEN THI DANH SACH TRONG KHO-------------+");
                System.out.println("1.Hien thi danh sach dien thoai iPHONE");
                System.out.println("2.Hien thi danh sach dien thoai Samsung");
                System.out.println("3.Hien thi danh sach dien thoai Oppo");
                System.out.println("4.Hien thi danh sach dien thoai Xiaomi");
                
                System.out.println("Chon chuc nang: ");
                chon = input.nextInt();
                
                if(chon==1)
                {     System.out.println("+---------HIEN THI DANH SACH iPHONE---------+");
                      System.out.println("1.Hien thi danh sach tat ca");
                      System.out.println("2.Hien thi danh sach so luong tu 1000 - 5000");
                      System.out.println("3.Hien thi danh sach so luong < 1000");
                      System.out.println("4.Hien thi danh sach so luong > 5000");
                      System.out.println("Chon chuc nang: ");
                      chon = input.nextInt();
                      
                      if (chon==1)
                      {
                            ArrayList<iPhone> list = DAOiPhone.getInstance().selectAll();
                            for (iPhone p : list)
                            {
                                p.Hien();
                            }     
                      }
                      else if (chon==2)
                      {
                            ArrayList<iPhone> list = DAOiPhone.getInstance().selectBySoluongBetween();
                            for (iPhone p : list)
                            {
                                p.Hien();
                            }     
                      }
                      else if (chon==3)
                      {
                            ArrayList<iPhone> list = DAOiPhone.getInstance().selectBySoluong1000();
                            for (iPhone p : list)
                            {
                                p.Hien();
                            } 
                      }
                      else if (chon==4)
                      {
                          ArrayList<iPhone> list = DAOiPhone.getInstance().selectBySoluong5000();
                            for (iPhone p : list)
                            {
                                p.Hien();
                            } 
                      }
                      
                              
                }
                else if(chon==2)
                {
                    System.out.println("+---------HIEN THI DANH SACH SAMSUNG---------+");
                    System.out.println("1.Hien thi danh sach tat ca");
                    System.out.println("2.Hien thi danh sach so luong tu 1000 - 5000");
                    System.out.println("3.Hien thi danh sach so luong < 1000");
                    System.out.println("4.Hien thi danh sach so luong > 5000");
                    System.out.println("Chon chuc nang: ");
                    chon = input.nextInt();
                    
                    if (chon==1)
                    {
                         ArrayList<Samsung> list = DAOSamsung.getInstance().selectAll();
                            for (Samsung p : list)
                            {
                                p.Hien();
                            }    
                    }
                    else if (chon==2)
                    {
                        ArrayList<Samsung> list = DAOSamsung.getInstance().selectBySoluongBetween();
                            for (Samsung p : list)
                            {
                                p.Hien();
                            }  
                    }
                    else if (chon==3)
                    {
                        ArrayList<Samsung> list = DAOSamsung.getInstance().selectBySoluong1000();
                            for (Samsung p : list)
                            {
                                p.Hien();
                            }  
                    }
                    else if (chon==4)
                    {
                         ArrayList<Samsung> list = DAOSamsung.getInstance().selectBySoluong5000();
                            for (Samsung p : list)
                            {
                                p.Hien();
                            }  
                    }
                }
                
                else if (chon==3)
                {
                    System.out.println("+---------HIEN THI DANH SACH OPPO---------+");
                    System.out.println("1.Hien thi danh sach tat ca");
                    System.out.println("2.Hien thi danh sach so luong tu 1000 - 5000");
                    System.out.println("3.Hien thi danh sach so luong < 1000");
                    System.out.println("4.Hien thi danh sach so luong > 5000");
                    System.out.println("Chon chuc nang: ");
                    chon = input.nextInt();
                    
                    if (chon==1)
                    {
                        ArrayList<Oppo> list = DAOOppo.getInstance().selectAll();
                            for (Oppo p : list)
                            {
                                p.Hien();
                            }    
                    }
                    else if (chon==2)
                    {
                        ArrayList<Oppo> list = DAOOppo.getInstance().selectBySoluong1000();
                            for (Oppo p : list)
                            {
                                p.Hien();
                            }  
                    }
                    else if (chon==3)
                    {
                        ArrayList<Oppo> list = DAOOppo.getInstance().selectBySoluong5000();
                            for (Oppo p : list)
                            {
                                p.Hien();
                            }  
                    }
                
                }
                else if(chon==4)
                {
                    System.out.println("+---------HIEN THI DANH SACH XIAOMI---------+");
                    System.out.println("1.Hien thi danh sach tat ca");
                    System.out.println("2.Hien thi danh sach so luong tu 1000 - 5000");
                    System.out.println("3.Hien thi danh sach so luong < 1000");
                    System.out.println("4.Hien thi danh sach so luong > 5000");
                    System.out.println("Chon chuc nang: ");
                    chon = input.nextInt();
                    
                    if (chon==1)
                    {
                        ArrayList<Xiaomi> list = DAOXiaomi.getInstance().selectAll();
                            for (Xiaomi p : list)
                            {
                                p.Hien();
                            }    
                    }
                    else if (chon==2)
                    {
                        ArrayList<Xiaomi> list = DAOXiaomi.getInstance().selectBySoluong1000();
                            for (Xiaomi p : list)
                            {
                                p.Hien();
                            }  
                    }
                    else if (chon==3)
                    {
                        ArrayList<Xiaomi> list = DAOXiaomi.getInstance().selectBySoluong5000();
                            for (Xiaomi p : list)
                            {
                                p.Hien();
                            }  
                    }
                    
                    
                }
                
            } 
            else if (chon == 4) {
                System.out.println("+---------TIM KIEM DIEN THOAI TRONG KHO---------+");
                System.out.println("1.Tim kiem iPHONE");
                System.out.println("2.Tim kiem Samsung");
                System.out.println("3.Tim kiem Oppo");
                System.out.println("4.Tim kiem Xiaomi");
                System.out.print("Vui long chon chuc nang: ");
                chon = input.nextInt();
                    
                    if (chon==1)
                    {     System.out.println("+---------TIM KIEM iPHONE---------+");
                          System.out.println("1.Tim kiem theo ma");
                          System.out.println("2.Tim kiem theo ten");
                          System.out.print("Vui long chon chuc nang: ");
                          chon = input.nextInt();
                          
                          if (chon==1)
                          {
                                input.nextLine();   
                                DAOiPhone dp = new DAOiPhone();
                                ip = new iPhone();
                                dp.selectById(ip);
                          }
                          else if (chon==2)
                          {
                                ip = new iPhone();
                                ArrayList<iPhone> list = DAOiPhone.getInstance().selectByTen(ip);
                                for (iPhone p : list)
                                {
                                    p.Hien();
                                }     
                                
                          }
                     
                    } 
                    else if (chon==2)
                    {
                          System.out.println("+---------TIM KIEM SAMSUNG---------+");
                          System.out.println("1.Tim kiem theo ma");
                          System.out.println("2.Tim kiem theo ten");
                          System.out.print("Vui long chon chuc nang: ");
                          chon = input.nextInt();
                          
                          if (chon==1)
                          {
                                input.nextLine();   
                                DAOSamsung ds = new DAOSamsung();
                                ss = new Samsung();
                                ds.selectAll();
                          }
                          else if (chon==2)
                          {
                                ss = new Samsung();
                                ArrayList<Samsung> list = DAOSamsung.getInstance().selectByTen(ss);
                                for (Samsung p : list)
                                {
                                    p.Hien();
                                }     
                                
                          }
                    }
                    else if (chon==3)
                    {
                            System.out.println("+---------TIM KIEM OPPO---------+");
                            System.out.println("1.Tim kiem theo ma");
                            System.out.println("2.Tim kiem theo ten");
                            System.out.print("Vui long chon chuc nang: ");
                            chon = input.nextInt();
                            
                             if (chon==1)
                          {
                                input.nextLine();   
                                DAOOppo dop = new DAOOppo();
                                op = new Oppo();
                                dop.selectAll();
                          }
                          else if (chon==2)
                          {
                                op = new Oppo();
                                ArrayList<Oppo> list = DAOOppo.getInstance().selectByTen(op);
                                for (Oppo p : list)
                                {
                                    p.Hien();
                                }     
                                
                          }
                         
                    }
                    else if (chon==4)
                    {
                            System.out.println("+---------TIM KIEM XIAOMI---------+");
                            System.out.println("1.Tim kiem theo ma");
                            System.out.println("2.Tim kiem theo ten");
                            System.out.print("Vui long chon chuc nang: ");
                            chon = input.nextInt();
                            
                            if (chon==1)
                          {
                                input.nextLine();   
                                DAOXiaomi dxm = new DAOXiaomi();
                                xm = new Xiaomi();
                                dxm.selectAll();
                          }
                          else if (chon==2)
                          {
                                xm = new Xiaomi();
                                ArrayList<Xiaomi> list = DAOXiaomi.getInstance().selectByTen(xm);
                                for (Xiaomi p : list)
                                {
                                    p.Hien();
                                }     
                                
                          }
                            
                    }
                   
                
                } 
            
            
            
            
            else if (chon==5)
            {   System.out.println("+---------SAP XEP ---------+");
                System.out.println("1.Sap xep iPHONE");
                System.out.println("2.Sap xep Samsung");
                System.out.println("3.Sap xep Oppo");
                System.out.println("4.Sap xep Xiaomi");
                System.out.print("Vui long chon chuc nang: ");
                chon = input.nextInt();
                
                if (chon==1)
                {
                    System.out.println("+---------SAP XEP iPHONE ---------+");
                    System.out.println("1.Sap xep so luong tang dan");
                    System.out.println("2.Sap xep so luong giam dan");
                    System.out.print("Vui long chon chuc nang: ");
                    chon = input.nextInt();
                    
                    if (chon==1)
                    {
                            ArrayList<iPhone> list = DAOiPhone.getInstance().sapXepTangDan();
                            for (iPhone p : list)
                            {
                               p.Hien();
                            }  
                    }
                    else if (chon==2)
                    {
                            ArrayList<iPhone> list = DAOiPhone.getInstance().sapXepGiamDan();
                            for (iPhone p : list)
                            {
                               p.Hien();
                            }  
                    }
                }
                else if (chon==2)
                {
                    System.out.println("+---------SAP XEP SAMSUNG----------+");
                    System.out.println("1.Sap xep so luong tang dan");
                    System.out.println("2.Sap xep so luong giam dan");
                    System.out.print("Vui long chon chuc nang: ");
                    chon = input.nextInt();
                    
                    if (chon==1)
                    {
                        ArrayList<Samsung> list = DAOSamsung.getInstance().sapXepTangDan();
                            for (Samsung p : list)
                            {
                               p.Hien();
                            }  
                    }
                    else if (chon==2)
                    {
                            ArrayList<Samsung> list = DAOSamsung.getInstance().sapXepGiamDan();
                            for (Samsung p : list)
                            {
                               p.Hien();
                            }  
                    }
                }
                else if (chon==3)
                {
                    System.out.println("+---------SAP XEP OPPO----------+");
                    System.out.println("1.Sap xep so luong tang dan");
                    System.out.println("2.Sap xep so luong giam dan");
                    System.out.print("Vui long chon chuc nang: ");
                    chon = input.nextInt();
                    
                    if (chon==1)
                    {
                        ArrayList<Oppo> list = DAOOppo.getInstance().sapXepTangDan();
                            for (Oppo p : list)
                            {
                               p.Hien();
                            }  
                    }
                    else if (chon==2)
                    {
                            ArrayList<Oppo> list = DAOOppo.getInstance().sapXepGiamDan();
                            for (Oppo p : list)
                            {
                               p.Hien();
                            }  
                    }
                }
                else if (chon==4)
                {
                    System.out.println("+---------SAP XEP XIAOMI----------+");
                    System.out.println("1.Sap xep so luong tang dan");
                    System.out.println("2.Sap xep so luong giam dan");
                    System.out.print("Vui long chon chuc nang: ");
                    chon = input.nextInt();
                    
                    if (chon==1)
                    {
                        ArrayList<Xiaomi> list = DAOXiaomi.getInstance().sapXepTangDan();
                            for (Xiaomi p : list)
                            {
                               p.Hien();
                            }  
                    }
                    else if (chon==2)
                    {
                            ArrayList<Xiaomi> list = DAOXiaomi.getInstance().sapXepGiamDan();
                            for (Xiaomi p : list)
                            {
                               p.Hien();
                            }  
                    }

                }

            }
 

        } while (chon!= 0);

    }
 }



