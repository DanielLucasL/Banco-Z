/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Inutil;

/**
 *
 * @author User
 */
public class Conta {
    private int id;
    private int numerodaconta;
    private double saldo;
    private String extrato;
    private int idcliente;

 
    public int getId() {
        return id;
    }
    
    public int getNumerodaconta() {
        return numerodaconta;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getExtrato() {
        return extrato;
    }

    public int getIdcliente() {
        return idcliente;
    }
    
    public void setId(int id) {
        this.id = id;
    }
     public void setNumerodaconta(int numerodaconta) {
        this.numerodaconta = numerodaconta;
    }


    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void setExtrato(String extrato) {
        this.extrato = extrato;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }
    public void decrementarsaldo(double valor){
       saldo=saldo-valor;
    }
}
