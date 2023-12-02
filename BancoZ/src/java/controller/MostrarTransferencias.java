/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import entidade.Transferencia;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.TransferenciaDAO;

/**
 *
 * @author User Equipe BancoZ
 */
@WebServlet(name = "MostrarTransferencias", urlPatterns = {"/MostrarTransferencias"})
public class MostrarTransferencias extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                   TransferenciaDAO transferenciaDAO = new TransferenciaDAO();
            try {
                ArrayList<Transferencia> listaTransferencias = TransferenciaDAO.getAll();
                request.setAttribute("listaTransferencia", listaTransferencias);
                RequestDispatcher rd = request.getRequestDispatcher("/views/public/transferencia.jsp");
                rd.forward(request, response);
                
                
            } catch (IOException | ServletException ex) {
                System.out.println(ex.getMessage());
                throw new RuntimeException("Falha na query listar transferencias (mostrarTransferencia)");
            }
    }
}