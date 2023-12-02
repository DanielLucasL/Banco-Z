/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import entidade.Investimento;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.InvestimentoDAO;

/**
 *
 * @author User Equipe BancoZ
 */
@WebServlet(name = "MostrarInvestimentos", urlPatterns = {"/MostrarInvestimentos"})
public class MostrarInvestimentos extends HttpServlet {

     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                   InvestimentoDAO investimentoDAO = new InvestimentoDAO();
            try {
                ArrayList<Investimento> listaInvestimentos = InvestimentoDAO.getAll();
                request.setAttribute("listaInvestimento", listaInvestimentos);
                RequestDispatcher rd = request.getRequestDispatcher("/views/public/investimentos.jsp");
                rd.forward(request, response);
                
                
            } catch (IOException | ServletException ex) {
                System.out.println(ex.getMessage());
                throw new RuntimeException("Falha na query listar investimentos (mostrarInvestimento)");
            }
    }
}
