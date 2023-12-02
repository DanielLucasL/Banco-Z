/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import entidade.Administrador;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.AdministradorDAO;

/**
 *
 * @author User Equipe BancoZ
 */
@WebServlet(name = "RegistrarControllerAdmin", urlPatterns = {"/RegistrarControllerAdmin"})
public class RegistrarControllerAdmin extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher rd;
        rd = request.getRequestDispatcher("/views/registro/formRegistro.jsp");
        rd.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher rd;
        request.setAttribute("msgOperacaoRealizada", "Operação não implementada");//implementar registro admin
        request.setAttribute("link", "home");
        rd = request.getRequestDispatcher("/views/comum/showMessage.jsp");
        rd.forward(request, response);

    }

}
