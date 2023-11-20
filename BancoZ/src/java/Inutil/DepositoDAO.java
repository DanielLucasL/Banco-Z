/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Inutil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import entidade.Deposito;

/**
 *
 * @author User
 */
public class DepositoDAO implements Dao<Deposito> {
    @Override
    public Deposito get(int id) {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("SELECT * FROM Depositos WHERE ID = ? ");
            sql.setInt(1, id);
            ResultSet resultado = sql.executeQuery();
            Deposito deposito = new Deposito();

            if (resultado != null) {
                while (resultado.next()) {
                    deposito.setId(Integer.parseInt(resultado.getString("ID")));
                    deposito.setDeposito(resultado.getString("DEPOSITO"));
                    deposito.setData(resultado.getString("DATA"));
                    deposito.setId(Integer.parseInt(resultado.getString("IDUSUARIO")));
                }
            }
            return deposito;

        } catch (SQLException e) {
            throw new RuntimeException("Query de select (get deposito) incorreta");
        } finally {
            conexao.closeConexao();
        }
    }

    @Override
    public void insert(Deposito t) {

        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("INSERT INTO Deposito (deposito, data, idusuario) VALUES (?,?,?)");
            sql.setString(1, t.getDeposito());
            sql.setString(2, t.getData());
            sql.setInt(3, t.getIdusuario());
            sql.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Query de insert (deposito) incorreta");
        } finally {
            conexao.closeConexao();
        }
    }

    @Override
    public void update(Deposito t) {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("UPDATE Contas SET deposito = ?, data = ?, idusuario = ?, senha = ?  WHERE ID = ? ");
            sql.setString(1, t.getDeposito());
            sql.setString(2, t.getData());
            sql.setInt(3, t.getIdusuario());

            sql.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Query de update (alterar deposito) incorreta");
        } finally {
            conexao.closeConexao();
        }
    }

    @Override
    public void delete(int id) {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("DELETE FROM Depositos WHERE ID = ? ");
            sql.setInt(1, id);
            sql.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Query de delete (excluir deposito) incorreta");
        } finally {
            conexao.closeConexao();
        }
    }

    @Override
    public ArrayList<Deposito> getAll() {

        ArrayList<Deposito> meusDepositos = new ArrayList();
        Conexao conexao = new Conexao();
        try {
            String selectSQL = "SELECT * FROM Depositos";
            PreparedStatement preparedStatement;
            preparedStatement = conexao.getConexao().prepareStatement(selectSQL);
            ResultSet resultado = preparedStatement.executeQuery();
            if (resultado != null) {
                while (resultado.next()) {
                    Deposito Deposito = new Deposito(resultado.getInt("ID"),resultado.getString("DEPOSITO"),
                            resultado.getString("DATA"),
                            resultado.getInt("IDUSUARIO"),
                            resultado.getInt("IDCATEGORIA")
                    );
                    meusDepositos.add(Deposito);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Query de select (GetAll) incorreta");
        } finally {
            conexao.closeConexao();
        }
        return meusDepositos;
    }
}
