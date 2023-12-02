/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import entidade.Cliente;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.ClienteDAO;

/**
 *
 * @author User equipe bancoZ
 */
@WebServlet(name = "AutenticaControllerCliente", urlPatterns = {"/AutenticaControllerCliente"})
public class AutenticaControllerCliente extends HttpServlet {

        

        @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        RequestDispatcher rd;
        rd = request.getRequestDispatcher("/views/autenticacao/formLogin.jsp");
        rd.forward(request, response);
    }

    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        RequestDispatcher rd;
        // pegando os parâmetros do request
        String cpf_user = request.getParameter("cpf");
        String senha_user = request.getParameter("senha");
        if (cpf_user.isEmpty() || senha_user.isEmpty()) {
            // dados não foram preenchidos retorna ao formulário
            request.setAttribute("msgError", "Usuário e/ou senha incorreto");
            rd = request.getRequestDispatcher("/views/autenticacao/formLogin.jsp");
            rd.forward(request, response);

        } else {
            Cliente clienteObtido;
            Cliente cliente = new Cliente(cpf_user, senha_user);
            ClienteDAO clienteDAO = new ClienteDAO();
            try {
                clienteObtido = clienteDAO.Logar(cliente);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                throw new RuntimeException("Falha na query para Logar");
            }

            if (clienteObtido.getId() != 0) {
                HttpSession session = request.getSession();
                session.setAttribute("usuario", clienteObtido);

                rd = request.getRequestDispatcher("/cliente/dashboard");
                rd.forward(request, response);

            } else {
                request.setAttribute("msgError", "Usuário e/ou senha incorreto");
                rd = request.getRequestDispatcher("/views/autenticacao/formLogin.jsp");
                rd.forward(request, response);

            }
        }
    }
    
    }

