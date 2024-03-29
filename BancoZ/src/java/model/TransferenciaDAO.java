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
            PreparedStatement sql = conexao.getConexao().prepareStatement("INSERT INTO transferencias (contadestino, contaorigem, valor, data)"
                    + " VALUES (?,?,?)");
            sql.setInt(1, transferencia.getContaDestino());
            sql.setInt(2, transferencia.getContaOrigem());
            sql.setDouble(3, transferencia.getValor());
            sql.setTimestamp(4, transferencia.getData());
            sql.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException();
        } finally {
            conexao.closeConexao();
        }
    }

    public Transferencia getTranferencia(int id) throws Exception {
        Conexao conexao = new Conexao();
        try {
            Transferencia transferencia = new Transferencia();
            PreparedStatement sql = conexao.getConexao().prepareStatement("SELECT * FROM transferencias WHERE ID = ? ");
            sql.setInt(1, id);
            ResultSet resultado = sql.executeQuery();
            if (resultado != null) {
                while (resultado.next()) {
                    transferencia.setId(Integer.parseInt(resultado.getString("ID")));
                    transferencia.setContaDestino(Integer.parseInt(resultado.getString("ContaDestino")));
                    transferencia.setContaOrigem(Integer.parseInt(resultado.getString("ContaOrigem")));
                    transferencia.setValor(Double.parseDouble(resultado.getString("VALOR")));
                    transferencia.setData(resultado.getTimestamp("DATA"));
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
            PreparedStatement sql = conexao.getConexao().prepareStatement("UPDATE transferencias SET contadestino = ?, contaorigem = ?, valor = ?, data = ?  WHERE ID = ?");
            sql.setInt(1, transferencia.getContaDestino());
            sql.setInt(2, transferencia.getContaOrigem());
            sql.setDouble(3, transferencia.getValor());
            sql.setTimestamp(4, transferencia.getData());
            sql.setInt(5, transferencia.getId());
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
            PreparedStatement sql = conexao.getConexao().prepareStatement("DELETE FROM transferencias WHERE ID = ? ");
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
            String selectSQL = "SELECT * FROM transferencias order by data";
            PreparedStatement preparedStatement;
            preparedStatement = conexao.getConexao().prepareStatement(selectSQL);
            ResultSet resultado = preparedStatement.executeQuery();
            if (resultado != null) {
                while (resultado.next()) {
                    Transferencia transferencia = new Transferencia(
                            Integer.parseInt(resultado.getString("ContaDestino")),
                            Integer.parseInt(resultado.getString("ContaOrigem")),
                            Double.parseDouble(resultado.getString("VALOR")),
                            resultado.getTimestamp("DATA"));
                    transferencia.setId(Integer.parseInt(resultado.getString( "ID")));
                    minhasTransferencias.add(transferencia);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Query de select (ListaDeTranferencias) incorreta");
        } finally {
            conexao.closeConexao();
        }
        return minhasTransferencias;
    }
}
