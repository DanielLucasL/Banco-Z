/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Transferencia;
/**
 *
 * @author User
 */
public class TransferenciaDAO implements Dao<Transferencia> {
    @Override
    public Transferencia get(int id) {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("SELECT * FROM Transferencias WHERE ID = ? ");
            sql.setInt(1, id);
            ResultSet resultado = sql.executeQuery();
            Transferencia transferencia = new Transferencia();

            if (resultado != null) {
                while (resultado.next()) {
                    transferencia.setId(Integer.parseInt(resultado.getString("ID")));
                    transferencia.setSaque(resultado.getString("TRANSFERENCIA"));
                    transferencia.setData(resultado.getString("DATA"));
                    transferencia.setId(Integer.parseInt(resultado.getString("IDUSUARIO")));
                }
            }
            return transferencia;

        } catch (SQLException e) {
            throw new RuntimeException("Query de select (get transferencia) incorreta");
        } finally {
            conexao.closeConexao();
        }
    }

    @Override
    public void insert(Transferencia t) {

        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("INSERT INTO Transferencia (transferencia, data, idusuario) VALUES (?,?,?)");
            sql.setString(1, t.getTransferencia());
            sql.setString(2, t.getData());
            sql.setInt(3, t.getIdusuario());
            sql.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Query de insert (transferencia) incorreta");
        } finally {
            conexao.closeConexao();
        }
    }

    @Override
    public void update(Transferencia t) {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("UPDATE Transferencias SET transferencia = ?, data = ?, idusuario = ?, senha = ?  WHERE ID = ? ");
            sql.setString(1, t.getTransferencia());
            sql.setString(2, t.getData());
            sql.setInt(3, t.getIdusuario());

            sql.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Query de update (alterar transferencia) incorreta");
        } finally {
            conexao.closeConexao();
        }
    }

    @Override
    public void delete(int id) {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("DELETE FROM Transferencias WHERE ID = ? ");
            sql.setInt(1, id);
            sql.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Query de delete (excluir transferencia) incorreta");
        } finally {
            conexao.closeConexao();
        }
    }

    @Override
    public ArrayList<Transferencia> getAll() {

        ArrayList<Transferencia> minhasTransferencias = new ArrayList();
        Conexao conexao = new Conexao();
        try {
            String selectSQL = "SELECT * FROM Transferencias";
            PreparedStatement preparedStatement;
            preparedStatement = conexao.getConexao().prepareStatement(selectSQL);
            ResultSet resultado = preparedStatement.executeQuery();
            if (resultado != null) {
                while (resultado.next()) {
                    Transferencia Transferencia = new Transferencia(resultado.getInt("ID"),resultado.getString("TRANSFERENCIA"),
                            resultado.getString("DATA"),
                            resultado.getInt("IDUSUARIO"),
                            resultado.getInt("IDCATEGORIA")
                    );
                    minhasTransferencias.add(Transferencia);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Query de select (GetAll) incorreta");
        } finally {
            conexao.closeConexao();
        }
        return minhasTransferencias;
    }
}
