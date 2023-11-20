/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author User
 */
public class Transferencia {
    private int id;
    private int idcontadoremetente;
    private String nomedoremetente;
    private int cpfdoremetente;
    private double valor;
    private int banco;
    private int agencia;
    private int contadobeneficiado;
    private String tipodaconta;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdcontadoremetente() {
        return idcontadoremetente;
    }

    public void setIdcontadoremetente(int idcontadoremetente) {
        this.idcontadoremetente = idcontadoremetente;
    }

    public String getNomedoremetente() {
        return nomedoremetente;
    }

    public void setNomedoremetente(String nomedoremetente) {
        this.nomedoremetente = nomedoremetente;
    }

    public int getCpfdoremetente() {
        return cpfdoremetente;
    }

    public void setCpfdoremetente(int cpfdoremetente) {
        this.cpfdoremetente = cpfdoremetente;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getBanco() {
        return banco;
    }

    public void setBanco(int banco) {
        this.banco = banco;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public int getContadobeneficiado() {
        return contadobeneficiado;
    }

    public void setContadobeneficiado(int contadobeneficiado) {
        this.contadobeneficiado = contadobeneficiado;
    }

    public String getTipodaconta() {
        return tipodaconta;
    }

    public void setTipodaconta(String tipodaconta) {
        this.tipodaconta = tipodaconta;
    }
}
