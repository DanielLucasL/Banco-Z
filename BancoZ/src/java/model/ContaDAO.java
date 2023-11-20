package model;

import entidade.Conta;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import entidade.Conta;


public class ContaDAO{
    
    public void Inserir(Conta conta) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("INSERT INTO contas (cpf, saldo)"
                    + " VALUES (?,?)");
            sql.setString(1, conta.getCpf());
            sql.setDouble(2, conta.getSaldo());
            sql.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException();
        } finally {
            conexao.closeConexao();
        }
    }

    public Conta getConta(int id) throws Exception {
        Conexao conexao = new Conexao();
        try {
            Conta conta = new Conta();
            PreparedStatement sql = conexao.getConexao().prepareStatement("SELECT * FROM contas WHERE ID = ? ");
            sql.setInt(1, id);
            ResultSet resultado = sql.executeQuery();
            if (resultado != null) {
                while (resultado.next()) {
                    conta.setNumConta(Integer.parseInt(resultado.getString("NUMCONTA")));
                    conta.setCpf(resultado.getString("CPF"));
                    conta.setSaldo(Double.parseDouble(resultado.getString("SALDO")));
                }
            }
            return conta;

        } catch (SQLException e) {
            throw new RuntimeException("Query de select (get) incorreta");
        } finally {
            conexao.closeConexao();
        }
    }

    public void Alterar(Conta conta) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("UPDATE contas SET cpf = ?, saldo = ?  WHERE NUMCONTA = ? ");
            sql.setString(1, conta.getCpf());
            sql.setDouble(2, conta.getSaldo());
            sql.setInt(3, conta.getNumConta());
            sql.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Query de update (alterar) incorreta");
        } finally {
            conexao.closeConexao();
        }
    }

    public void Excluir(Conta conta) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("DELETE FROM contas WHERE NUMCONTA = ? ");
            sql.setInt(1, conta.getNumConta());
            sql.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Query de delete (excluir) incorreta");
        } finally {
            conexao.closeConexao();
        }
    }

    public ArrayList<Conta> ListaDeConta() {
        ArrayList<Conta> minhasContas = new ArrayList();
        Conexao conexao = new Conexao();
        try {
            String selectSQL = "SELECT * FROM contas order by nome";
            PreparedStatement preparedStatement;
            preparedStatement = conexao.getConexao().prepareStatement(selectSQL);
            ResultSet resultado = preparedStatement.executeQuery();
            if (resultado != null) {
                while (resultado.next()) {
                    Conta conta = new Conta(
                            resultado.getString("CPF"),
                            Integer.parseInt(resultado.getString("SALDO")));
                    conta.setNumConta(Integer.parseInt(resultado.getString( "NUMCONTA")));
                    minhasContas.add(conta);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Query de select (ListaDeConta) incorreta");
        } finally {
            conexao.closeConexao();
        }
        return minhasContas;
    }
}
