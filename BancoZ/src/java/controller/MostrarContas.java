/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import entidade.Conta;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ContaDAO;

/**
 *
 * @author User Equipe BancoZ
 */
@WebServlet(name = "MostrarContas", urlPatterns = {"/MostrarContas"})
public class MostrarContas extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                   ContaDAO contaDAO = new ContaDAO();
            try {
                ArrayList<Conta> listaContas = contaDAO.getAll();
                request.setAttribute("listaConta", listaContas);
                RequestDispatcher rd = request.getRequestDispatcher("/views/public/contas.jsp");
                rd.forward(request, response);
                
                
            } catch (IOException | ServletException ex) {
                System.out.println(ex.getMessage());
                throw new RuntimeException("Falha na query listar contas (mostrarContas) ");
            }
    }

}
