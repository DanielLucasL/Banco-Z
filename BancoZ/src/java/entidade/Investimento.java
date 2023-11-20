package entidade;

public class Investimento {
    private int id;
    private int numConta;
    private double valor;
    private String tipo;

    public Investimento(int numConta, double valor, String tipo) {
        this.numConta = numConta;
        this.valor = valor;
        this.tipo = tipo;
    }
    
    public Investimento() {
        this.id = 0;
        this.numConta = 0;
        this.valor = 0;
        this.tipo = "";
    }
    
    public int getNumConta() {
        return numConta;
    }

    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
