/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.util.ArrayList;
/**
 *
 * @author User
 */
public interface Dao<T> {
    
   public T get(int id);   
   public ArrayList<T> getAll();
   public void insert(T t);
   public void update(T t);
   public void delete(int id);
}
