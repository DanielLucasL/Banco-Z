/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Inutil;

import java.util.Date;

/**
 *
 * @author User
 */
public class Deposito {
    private int id;
    private Date data;

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
    private int idcontadoremetente;
    private String nomedoremetente;
    private int cpfdoremetente;
    private double valor;
    private int agencia;
    private int contadobeneficiado;

    public int getId() {
        return id;
    }

    public int getIdcontadoremetente() {
        return idcontadoremetente;
    }

    public String getNomedoremetente() {
        return nomedoremetente;
    }

    public int getCpfdoremetente() {
        return cpfdoremetente;
    }

    public double getValor() {
        return valor;
    }

    public int getAgencia() {
        return agencia;
    }

    public int getContadobeneficiado() {
        return contadobeneficiado;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIdcontadoremetente(int idcontadoremetente) {
        this.idcontadoremetente = idcontadoremetente;
    }

    public void setNomedoremetente(String nomedoremetente) {
        this.nomedoremetente = nomedoremetente;
    }

    public void setCpfdoremetente(int cpfdoremetente) {
        this.cpfdoremetente = cpfdoremetente;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public void setContadobeneficiado(int contadobeneficiado) {
        this.contadobeneficiado = contadobeneficiado;
    }
}
