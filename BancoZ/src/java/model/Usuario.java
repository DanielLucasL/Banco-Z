/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author User
 */
public abstract class Usuario {
    private int id;
    private int cpf;
    private Tipo tipo;
    private String nome;
    private String senha;
    

     public int getId() {
        return id;
    }
     public int getCpf() {
        return cpf;
    }
   
    public void setCpf(int cpf) {
        this.cpf = cpf;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getTipo() {
        return tipo.getTipo();
    }

    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setTipo(String tipo) {
       this.tipo = new Tipo(tipo);
        
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
 
}