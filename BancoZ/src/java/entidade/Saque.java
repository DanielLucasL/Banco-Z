/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidade;

/**
 *
 * @author User
 */
public class Saque {
    private int id;
    private int iddaconta;
    private int cpf;
    private double valor;

    public int getId() {
        return id;
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

    public void setId(int id) {
        this.id = id;
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
}
