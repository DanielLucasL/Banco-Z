<%-- 
    Document   : extrato
    Created on : 1 de dez. de 2023, 19:14:21
    Author     : danie
--%>
<%@page import="entidade.Cliente"%>
<%@page import="entidade.Conta"%>
<%@page import="entidade.Transferencia"%>
<%@page import="entidade.Deposito"%>
<%@page import="entidade.Investimento"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <p>Extrato</p>
                <br>
                <p>Saída</p>
                <br>
                 <table class="table">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">Tipo</th>
      <th scope="col">Data</th>
      <th scope="col">CPF de destino(opcional)</th>
      <th scope="col">Valor</th>
    </tr>
  </thead>
  <tbody>
       <%
                                Cliente cliente = request.getAttribute("Cliente");
                                ArrayList<Saque> listaSaque = (ArrayList<Saque>) request.getAttribute("listaSaques");
                                ArrayList<Conta> listaConta = (ArrayList<Conta>) request.getAttribute("listaContas");
                                ArrayList<Transferencia> listaTransferencia = (ArrayList<Transferencia>) request.getAttribute("listaTransferencias");
                                ArrayList<Deposito> listaDeposito = (ArrayList<Deposito>) request.getAttribute("listaDeposito");
                                ArrayList<Investimento> listaInvestimento = (ArrayList<Investimento>) request.getAttribute("listaInvestimento");
                                int x=0;
                                for (Saque saque : listaSaque) {
                                if(cliente.getNumConta()==saque.getNumConta()){
                                    x=x+1;
                                    out.println("<tr>");
                                    out.println("<th scope='col'>" + x + "</th>");
                                    out.println("<th scope='col'>Saque</th>");
                                    out.println("<th scope='col'>" + saque.getData() + "</th>");
                                    out.println("<th scope='col'></th>");
                                    out.println("<th scope='col'>" + saque.getValor() + "</th>");
           }
           }
           for (Transferencia transferencia : listaTransferencia) {
                        if(cliente.getNumConta()==transferencia.getContaOrigem()){
                                    x=x+1;
                                    out.println("<tr>");
                                    out.println("<th scope='col'>" + x + "</th>");
                                    out.println("<th scope='col'>Transferência</th>");
                                    out.println("<th scope='col'>" + transferencia.getData() + "</th>");
                                    out.println("<th scope='col'>" + listaConta[transferencia.getContaDestino()].getCpf+ "</th>");
                                    out.println("<th scope='col'>" + transferencia.getValor() + "</th>");
           }
           }
           for (Deposito deposito : listaDeposito) {
           if(cliente.getNumConta()==deposito.getContaOrigem()){
                                    x=x+1;
                                    out.println("<tr>");
                                    out.println("<th scope='col'>" + x + "</th>");
                                    out.println("<th scope='col'>Depósito</th>");
                                    out.println("<th scope='col'>" + deposito.getData() + "</th>");
                                    out.println("<th scope='col'>" + listaConta[deposito.getContaDestino()].getCpf+ "</th>");
                                    out.println("<th scope='col'>" + deposito.getValor() + "</th>");
           }
           }
            for (Investimento investimento : listaInvestimento) {
            if(cliente.getNumConta()==investimento.getNumConta()){
                                    x=x+1;
                                    out.println("<tr>");
                                    out.println("<th scope='col'>" + x + "</th>");
                                    out.println("<th scope='col'>Investimento</th>");
                                    out.println("<th scope='col'>" + investimento.getData() + "</th>");
                                    out.println("<th scope='col'></th>");
                                    out.println("<th scope='col'>" + investimento.getValor() + "</th>");
           }
           }
                                    %>
  </tbody>
</table>
                 <br>
                <p>Entrada</p>
                <br>
  <table class="table">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">Tipo</th>
      <th scope="col">Data</th>
      <th scope="col">CPF de origem(opcional)</th>
      <th scope="col">Valor</th>
    </tr>
  </thead>
  <tbody>
     <%
           for (Transferencia transferencia : listaTransferencia) {
                        if(cliente.getNumConta()==transferencia.getContaDestino()){
                                    x=x+1;
                                    out.println("<tr>");
                                    out.println("<th scope='col'>" + x + "</th>");
                                    out.println("<th scope='col'>Transferência</th>");
                                    out.println("<th scope='col'>" + transferencia.getData() + "</th>");
                                    out.println("<th scope='col'>" + listaConta[transferencia.getContaOrigem()].getCpf+ "</th>");
                                    out.println("<th scope='col'>" + transferencia.getValor() + "</th>");
           }
           }
           for (Deposito deposito : listaDeposito) {
           if(cliente.getNumConta()==deposito.getContaDestino){
                                    x=x+1;
                                    out.println("<tr>");
                                    out.println("<th scope='col'>" + x + "</th>");
                                    out.println("<th scope='col'>Depósito</th>");
                                    out.println("<th scope='col'>" + deposito.getData() + "</th>");
                                    out.println("<th scope='col'>" + listaConta[deposito.getContaOrigem()].getCpf+ "</th>");
                                    out.println("<th scope='col'>" + deposito.getValor() + "</th>");
           }
           }
           }
                                    %>
  </tbody>
</table>
    </body>
</html>
