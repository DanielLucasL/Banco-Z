/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class Cliente extends Usuario {
    private List <Integer> idconta= new ArrayList<>();
    
  
    public void setIdconta(int idconta) {
        this.idconta.add(idconta);
    }

    public int getIdconta(int id) {
        return idconta.get(id);
    }

}
