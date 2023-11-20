/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Inutil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import entidade.Tipo;
/**
 *
 * @author User
 */
public class TipoDAO implements Dao<Tipo> {
    
    @Override
    public Tipo get(int id) {
        Conexao conexao = new Conexao();
        Tipo tipo = new Tipo();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("SELECT * FROM Tipos WHERE ID = ? ");
            sql.setInt(1, id);
            ResultSet resultado = sql.executeQuery();

            if (resultado != null) {
                while (resultado.next()) {
                    tipo.setId(Integer.parseInt(resultado.getString("ID")));
                    tipo.setDescricao(resultado.getString("DESCRICAO"));
                }
            }
        } catch (SQLException e) {
            System.err.println("Query de select (get tipo) incorreta");
        } finally {
            conexao.closeConexao();
        }
        return tipo;
    }

    @Override
    public void insert(Tipo t) {

        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("INSERT INTO Tipos (descricao) VALUES (?)");
            sql.setString(1, t.getDescricao());
            sql.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Query de insert (tipo) incorreta");
        } finally {
            conexao.closeConexao();
        }
    }

    @Override
    public void update(Tipo t) {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("UPDATE Tipos SET descricao = ?  WHERE ID = ? ");
            sql.setString(1, t.getDescricao());
            sql.setInt(2, t.getId());
            sql.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Query de update (alterar tipo) incorreta");
        } finally {
            conexao.closeConexao();
        }
    }

    @Override
    public void delete(int id) {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("DELETE FROM Tipos WHERE ID = ? ");
            sql.setInt(1, id);
            sql.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Query de delete (excluir tipo) incorreta");
        } finally {
            conexao.closeConexao();
        }
    }

    @Override
    public ArrayList<Tipo> getAll() {

        ArrayList<Tipo> meusTipos = new ArrayList();
        Conexao conexao = new Conexao();
        try {
            String selectSQL = "SELECT * FROM Tipos";
            PreparedStatement preparedStatement;
            preparedStatement = conexao.getConexao().prepareStatement(selectSQL);
            ResultSet resultado = preparedStatement.executeQuery();
            if (resultado != null) {
                while (resultado.next()) {
                    Tipo Tipo = new Tipo(
                            resultado.getInt("ID"),
                            resultado.getString("Descricao")
                    );
                    meusTipos.add(Tipo);
                }
            }
        } catch (SQLException e) {
            System.err.println("Query de select (GetAll - tipos) incorreta");
        } finally {
            conexao.closeConexao();
        }
        return meusTipos;
    }
}
