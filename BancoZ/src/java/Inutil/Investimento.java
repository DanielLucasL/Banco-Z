/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Inutil;

/**
 *
 * @author User
 */
public class Investimento {
    private int id;
    private String nomedoinvestidor;
    private int iddaconta;
    private int cpf;
    private double valor;
    private String tipo;

    public int getId() {
        return id;
    }

    public String getNomedoinvestidor() {
        return nomedoinvestidor;
    }

    public int getIddaconta() {
        return iddaconta;
    }

    public int getCpf() {
        return cpf;
    }

    public double getValor() {
        return valor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNomedoinvestidor(String nomedoinvestidor) {
        this.nomedoinvestidor = nomedoinvestidor;
    }

    public void setIddaconta(int iddaconta) {
        this.iddaconta = iddaconta;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
