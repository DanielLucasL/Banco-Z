/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Saque;
/**
 *
 * @author User
 */
public class SaqueDAO implements Dao<Saque> {
    @Override
    public Saque get(int id) {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("SELECT * FROM Saques WHERE ID = ? ");
            sql.setInt(1, id);
            ResultSet resultado = sql.executeQuery();
            Saque saque = new Saque();

            if (resultado != null) {
                while (resultado.next()) {
                    saque.setId(Integer.parseInt(resultado.getString("ID")));
                    saque.setSaque(resultado.getString("SAQUE"));
                    saque.setData(resultado.getString("DATA"));
                    saque.setId(Integer.parseInt(resultado.getString("IDUSUARIO")));
                }
            }
            return saque;

        } catch (SQLException e) {
            throw new RuntimeException("Query de select (get saque) incorreta");
        } finally {
            conexao.closeConexao();
        }
    }

    @Override
    public void insert(Saque t) {

        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("INSERT INTO Saque (saque, data, idusuario) VALUES (?,?,?)");
            sql.setString(1, t.getSaque());
            sql.setString(2, t.getData());
            sql.setInt(3, t.getIdusuario());
            sql.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Query de insert (saque) incorreta");
        } finally {
            conexao.closeConexao();
        }
    }

    @Override
    public void update(Saque t) {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("UPDATE Saques SET saque = ?, data = ?, idusuario = ?, senha = ?  WHERE ID = ? ");
            sql.setString(1, t.getSaque());
            sql.setString(2, t.getData());
            sql.setInt(3, t.getIdusuario());

            sql.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Query de update (alterar saque) incorreta");
        } finally {
            conexao.closeConexao();
        }
    }

    @Override
    public void delete(int id) {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("DELETE FROM Saques WHERE ID = ? ");
            sql.setInt(1, id);
            sql.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Query de delete (excluir saque) incorreta");
        } finally {
            conexao.closeConexao();
        }
    }

    @Override
    public ArrayList<Saque> getAll() {

        ArrayList<Saque> meusSaques = new ArrayList();
        Conexao conexao = new Conexao();
        try {
            String selectSQL = "SELECT * FROM Saques";
            PreparedStatement preparedStatement;
            preparedStatement = conexao.getConexao().prepareStatement(selectSQL);
            ResultSet resultado = preparedStatement.executeQuery();
            if (resultado != null) {
                while (resultado.next()) {
                    Saque Saque = new Saque(resultado.getInt("ID"),resultado.getString("SAQUE"),
                            resultado.getString("DATA"),
                            resultado.getInt("IDUSUARIO"),
                            resultado.getInt("IDCATEGORIA")
                    );
                    meusSaques.add(Saque);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Query de select (GetAll) incorreta");
        } finally {
            conexao.closeConexao();
        }
        return meusSaques;
    }
}
