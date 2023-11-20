package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import entidade.Deposito;

public class DepositoDAO{
    
    public void Inserir(Deposito deposito) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("INSERT INTO contas (contadepositante, contadepositario, valor)"
                    + " VALUES (?,?,?)");
            sql.setInt(1, deposito.getContaDepositante());
            sql.setInt(2, deposito.getContaDepositario());
            sql.setDouble(3, deposito.getValor());
            sql.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException();
        } finally {
            conexao.closeConexao();
        }
    }

    public Deposito getConta(int id) throws Exception {
        Conexao conexao = new Conexao();
        try {
            Deposito deposito = new Deposito();
            PreparedStatement sql = conexao.getConexao().prepareStatement("SELECT * FROM contas WHERE ID = ? ");
            sql.setInt(1, id);
            ResultSet resultado = sql.executeQuery();
            if (resultado != null) {
                while (resultado.next()) {
                    deposito.setId(Integer.parseInt(resultado.getString("ID")));
                    deposito.setContaDepositante(Integer.parseInt(resultado.getString("ContaDepositante")));
                    deposito.setContaDepositario(Integer.parseInt(resultado.getString("ContaDepositario")));
                    deposito.setValor(Double.parseDouble(resultado.getString("VALOR")));
                }
            }
            return deposito;

        } catch (SQLException e) {
            throw new RuntimeException("Query de select (get) incorreta");
        } finally {
            conexao.closeConexao();
        }
    }

    public void Alterar(Deposito deposito) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("UPDATE contas SET contadepositante = ?, contadepositario = ?, valor = ?  WHERE ID = ? ");
            sql.setInt(1, deposito.getContaDepositante());
            sql.setInt(2, deposito.getContaDepositario());
            sql.setDouble(3, deposito.getValor());
            sql.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Query de update (alterar) incorreta");
        } finally {
            conexao.closeConexao();
        }
    }

    public void Excluir(Deposito deposito) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("DELETE FROM contas WHERE ID = ? ");
            sql.setInt(1, deposito.getId());
            sql.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Query de delete (excluir) incorreta");
        } finally {
            conexao.closeConexao();
        }
    }

    public ArrayList<Deposito> ListaDeDeposito() {
        ArrayList<Deposito> meusDepositos = new ArrayList();
        Conexao conexao = new Conexao();
        try {
            String selectSQL = "SELECT * FROM contas order by nome";
            PreparedStatement preparedStatement;
            preparedStatement = conexao.getConexao().prepareStatement(selectSQL);
            ResultSet resultado = preparedStatement.executeQuery();
            if (resultado != null) {
                while (resultado.next()) {
                    Deposito deposito = new Deposito(
                            Integer.parseInt(resultado.getString("ContaDepositante")),
                            Integer.parseInt(resultado.getString("ContaDepositario")),
                            Double.parseDouble(resultado.getString("VALOR")));
                    deposito.setId(Integer.parseInt(resultado.getString( "ID")));
                    meusDepositos.add(deposito);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Query de select (ListaDeConta) incorreta");
        } finally {
            conexao.closeConexao();
        }
        return meusDepositos;
    }
}
