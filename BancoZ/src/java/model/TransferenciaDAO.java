package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import entidade.Transferencia;

public class TransferenciaDAO{

        public void Inserir(Transferencia transferencia) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("INSERT INTO contas (contadestino, contaorigem, valor)"
                    + " VALUES (?,?,?)");
            sql.setInt(1, transferencia.getContaDestino());
            sql.setInt(2, transferencia.getContaOrigem());
            sql.setDouble(3, transferencia.getValor());
            sql.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException();
        } finally {
            conexao.closeConexao();
        }
    }

    public Transferencia getConta(int id) throws Exception {
        Conexao conexao = new Conexao();
        try {
            Transferencia transferencia = new Transferencia();
            PreparedStatement sql = conexao.getConexao().prepareStatement("SELECT * FROM contas WHERE ID = ? ");
            sql.setInt(1, id);
            ResultSet resultado = sql.executeQuery();
            if (resultado != null) {
                while (resultado.next()) {
                    transferencia.setId(Integer.parseInt(resultado.getString("ID")));
                    transferencia.setContaDestino(Integer.parseInt(resultado.getString("ContaDestino")));
                    transferencia.setContaOrigem(Integer.parseInt(resultado.getString("ContaOrigem")));
                    transferencia.setValor(Double.parseDouble(resultado.getString("VALOR")));
                }
            }
            return transferencia;

        } catch (SQLException e) {
            throw new RuntimeException("Query de select (get) incorreta");
        } finally {
            conexao.closeConexao();
        }
    }

    public void Alterar(Transferencia transferencia) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("UPDATE contas SET contadestino = ?, contaorigem = ?, valor = ?  WHERE ID = ? ");
            sql.setInt(1, transferencia.getContaDestino());
            sql.setInt(2, transferencia.getContaOrigem());
            sql.setDouble(3, transferencia.getValor());
            sql.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Query de update (alterar) incorreta");
        } finally {
            conexao.closeConexao();
        }
    }

    public void Excluir(Transferencia transferencia) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("DELETE FROM contas WHERE ID = ? ");
            sql.setInt(1, transferencia.getId());
            sql.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Query de delete (excluir) incorreta");
        } finally {
            conexao.closeConexao();
        }
    }

    public ArrayList<Transferencia> ListaDeTransferencia() {
        ArrayList<Transferencia> minhasTransferencias = new ArrayList();
        Conexao conexao = new Conexao();
        try {
            String selectSQL = "SELECT * FROM contas order by nome";
            PreparedStatement preparedStatement;
            preparedStatement = conexao.getConexao().prepareStatement(selectSQL);
            ResultSet resultado = preparedStatement.executeQuery();
            if (resultado != null) {
                while (resultado.next()) {
                    Transferencia transferencia = new Transferencia(
                            Integer.parseInt(resultado.getString("ContaDestino")),
                            Integer.parseInt(resultado.getString("ContaOrigem")),
                            Double.parseDouble(resultado.getString("VALOR")));
                    transferencia.setId(Integer.parseInt(resultado.getString( "ID")));
                    minhasTransferencias.add(transferencia);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Query de select (ListaDeConta) incorreta");
        } finally {
            conexao.closeConexao();
        }
        return minhasTransferencias;
    }
}
