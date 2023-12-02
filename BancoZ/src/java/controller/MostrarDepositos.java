/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import entidade.Deposito;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DepositoDAO;

/**
 *
 * @author User Equipe BancoZ
 */
@WebServlet(name = "MostrarDepositos", urlPatterns = {"/MostrarDepositos"})
public class MostrarDepositos extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                   DepositoDAO depositoDAO = new DepositoDAO();
            try {
                ArrayList<Deposito> listaDepositos = DepositoDAO.getAll();
                request.setAttribute("listaDeposito", listaDepositos);
                RequestDispatcher rd = request.getRequestDispatcher("/views/public/depositos.jsp");
                rd.forward(request, response);
                
                
            } catch (IOException | ServletException ex) {
                System.out.println(ex.getMessage());
                throw new RuntimeException("Falha na query listar depositos (mostrarDeposito) ");
            }
    }
}


