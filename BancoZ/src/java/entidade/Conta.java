package entidade;

public class Conta {
    private int numConta;
    private String cpf;
    private double saldo;

    public Conta(String cpf, double saldo) {
        this.cpf = cpf;
        this.saldo = saldo;
    }
    
    public Conta() {
        this.numConta = 0;
        this.cpf = "";
        this.saldo = 0;
    }

    public int getNumConta() {
        return numConta;
    }

    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}