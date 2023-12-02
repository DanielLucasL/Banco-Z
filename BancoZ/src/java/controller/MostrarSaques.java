/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import entidade.Saque;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.SaqueDAO;

/**
 *
 * @author User Equipe BancoZ
 */
@WebServlet(name = "MostrarSaques", urlPatterns = {"/MostrarSaques"})
public class MostrarSaques extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                   SaqueDAO saqueDAO = new SaqueDAO();
            try {
                ArrayList<Saque> listaSaques = SaqueDAO.getAll();
                request.setAttribute("listaSaque", listaSaques);
                RequestDispatcher rd = request.getRequestDispatcher("/views/public/saques.jsp");
                rd.forward(request, response);
                
                
            } catch (IOException | ServletException ex) {
                System.out.println(ex.getMessage());
                throw new RuntimeException("Falha na query listar saques (mostrarSaque)");
            }
    }
}
