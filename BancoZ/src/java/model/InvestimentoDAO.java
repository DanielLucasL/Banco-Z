/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import entidade.Investimento;
/**
 *
 * @author User
 */
public class InvestimentoDAO implements Dao<Investimento> {
    @Override
    public Investimento get(int id) {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("SELECT * FROM Investimentos WHERE ID = ? ");
            sql.setInt(1, id);
            ResultSet resultado = sql.executeQuery();
            Investimento investimento = new Investimento();

            if (resultado != null) {
                while (resultado.next()) {
                    investimento.setId(Integer.parseInt(resultado.getString("ID")));
                    investimento.setInvestimento(resultado.getString("INVESTIMENTO"));
                    investimento.setData(resultado.getString("DATA"));
                    investimento.setId(Integer.parseInt(resultado.getString("IDUSUARIO")));
                }
            }
            return investimento;

        } catch (SQLException e) {
            throw new RuntimeException("Query de select (get investimento) incorreta");
        } finally {
            conexao.closeConexao();
        }
    }

    @Override
    public void insert(Investimento t) {

        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("INSERT INTO Investimento (investimento, data, idusuario) VALUES (?,?,?)");
            sql.setString(1, t.getInvestimento());
            sql.setString(2, t.getData());
            sql.setInt(3, t.getIdusuario());
            sql.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Query de insert (investimento) incorreta");
        } finally {
            conexao.closeConexao();
        }
    }

    @Override
    public void update(Investimento t) {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("UPDATE Contas SET investimento = ?, data = ?, idusuario = ?, senha = ?  WHERE ID = ? ");
            sql.setString(1, t.getInvestimento());
            sql.setString(2, t.getData());
            sql.setInt(3, t.getIdusuario());

            sql.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Query de update (alterar investimento) incorreta");
        } finally {
            conexao.closeConexao();
        }
    }

    @Override
    public void delete(int id) {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("DELETE FROM Investimentos WHERE ID = ? ");
            sql.setInt(1, id);
            sql.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Query de delete (excluir investimento) incorreta");
        } finally {
            conexao.closeConexao();
        }
    }

    @Override
    public ArrayList<Investimento> getAll() {

        ArrayList<Investimento> meusInvestimentos = new ArrayList();
        Conexao conexao = new Conexao();
        try {
            String selectSQL = "SELECT * FROM Investimentos";
            PreparedStatement preparedStatement;
            preparedStatement = conexao.getConexao().prepareStatement(selectSQL);
            ResultSet resultado = preparedStatement.executeQuery();
            if (resultado != null) {
                while (resultado.next()) {
                    Investimento Investimento = new Investimento(resultado.getInt("ID"),resultado.getString("INVESTIMENTO"),
                            resultado.getString("DATA"),
                            resultado.getInt("IDUSUARIO"),
                            resultado.getInt("IDCATEGORIA")
                    );
                    meusInvestimentos.add(Investimento);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Query de select (GetAll) incorreta");
        } finally {
            conexao.closeConexao();
        }
        return meusInvestimentos;
    }
}
