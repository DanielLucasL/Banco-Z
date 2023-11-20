/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Inutil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import entidade.Cliente;
/**
 *
 * @author User
 */
public class ClienteDAO {
    public void Inserir(Cliente cliente) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("INSERT INTO usuarios (nome, cpf, endereco, senha)"
                    + " VALUES (?,?,?,?)");
            sql.setString(1, cliente.getNome());
            sql.setString(2, cliente.getCpf());
            sql.setString(3, cliente.getEndereco());
            sql.setString(4, cliente.getSenha());
            sql.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException();
        } finally {
            conexao.closeConexao();
        }
    }

    public Cliente getCliente(int id) throws Exception {
        Conexao conexao = new Conexao();
        try {
            Cliente cliente = new Cliente();
            PreparedStatement sql = conexao.getConexao().prepareStatement("SELECT * FROM clientes WHERE ID = ? ");
            sql.setInt(1, id);
            ResultSet resultado = sql.executeQuery();
            if (resultado != null) {
                while (resultado.next()) {
                    cliente.setId(Integer.parseInt(resultado.getString("ID")));
                    cliente.setNome(resultado.getString("NOME"));
                    cliente.setCpf(resultado.getString("CPF"));
                    cliente.setEndereco(resultado.getString("ENDERECO"));
                    cliente.setSenha(resultado.getString("SENHA"));
                }
            }
            return cliente;

        } catch (SQLException e) {
            throw new RuntimeException("Query de select (get) incorreta");
        } finally {
            conexao.closeConexao();
        }
    }

    public void Alterar(Cliente Cliente) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("UPDATE usuarios SET nome = ?, cpf = ?, endereco = ?, senha = ?  WHERE ID = ? ");
            sql.setString(1, Cliente.getNome());
            sql.setString(2, Cliente.getCpf());
            sql.setString(3, Cliente.getEndereco());
            sql.setString(4, Cliente.getSenha());
            sql.setInt(5, Cliente.getId());
            sql.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Query de update (alterar) incorreta");
        } finally {
            conexao.closeConexao();
        }
    }

    public void Excluir(Cliente Cliente) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("DELETE FROM clientes WHERE ID = ? ");
            sql.setInt(1, Cliente.getId());
            sql.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Query de delete (excluir) incorreta");
        } finally {
            conexao.closeConexao();
        }
    }

    public ArrayList<Cliente> ListaDeCliente() {
        ArrayList<Cliente> meusClientes = new ArrayList();
        Conexao conexao = new Conexao();
        try {
            String selectSQL = "SELECT * FROM clientes order by nome";
            PreparedStatement preparedStatement;
            preparedStatement = conexao.getConexao().prepareStatement(selectSQL);
            ResultSet resultado = preparedStatement.executeQuery();
            if (resultado != null) {
                while (resultado.next()) {
                    Cliente cliente = new Cliente(resultado.getString("NOME"),
                            resultado.getString("CPF"),
                            resultado.getString("ENDERECO"),
                            resultado.getString("SENHA"));
                    cliente.setId(Integer.parseInt(resultado.getString("id")));
                    meusClientes.add(cliente);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Query de select (ListaDeCliente) incorreta");
        } finally {
            conexao.closeConexao();
        }
        return meusClientes;
    }

    public Cliente Logar(Cliente cliente) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("SELECT * FROM clientes WHERE cpf=? and senha =? LIMIT 1");
            sql.setString(1, cliente.getCpf());
            sql.setString(2, cliente.getSenha());
            ResultSet resultado = sql.executeQuery();
            Cliente usuarioObtido = new Cliente();
            if (resultado != null) {
                while (resultado.next()) {
                    clienteObtido.setId(Integer.parseInt(resultado.getString("ID")));
                    clienteObtido.setNome(resultado.getString("NOME"));
                    clienteObtido.setCpf(resultado.getString("CPF"));
                    clienteObtido.setEndereco(resultado.getString("ENDERECO"));
                    clienteObtido.setSenha(resultado.getString("SENHA"));
                }
            }
            return clienteObtido;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException("Query de select (get) incorreta");
        } finally {
            conexao.closeConexao();
        }
    }

}
