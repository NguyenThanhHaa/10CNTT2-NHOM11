/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.util.ArrayList;

/**
 *
 * @author thanh ha
 */
public interface DAOInterface <T> 
{
    public  int     insert(T t);
    public  int     update(T t);
    public  int     delete(T t);
    
    public  ArrayList<T>    selectAll(); 
    public  T               selectById(T t);
    public  ArrayList<T>    selectByTen(T t);
    public  ArrayList<T>    selectBySoluongBetween();
    public  ArrayList<T>    selectBySoluong1000();
    public  ArrayList<T>    selectBySoluong5000();
    
    public  ArrayList<T>    sapXepTangDan();
    public  ArrayList<T>    sapXepGiamDan();  
    
}


