<%-- 
    Document   : registracliente
    Created on : 1 de dez. de 2023, 22:06:03
    Author     : danie
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<form id="registracliente" action="/BancoZ/controller/RegistraClienteController" method="POST">
     <%
                    String msgError = (String) request.getAttribute("msgError");
                    if ((msgError != null) && (!msgError.isEmpty())) {%>
                <div class="alert alert-danger" role="alert">
                    <%= msgError%>
                </div>
                <% }%>
          <div class="mb-3">
            <label for="nome" class="col-form-label">Nome Completo</label>
            <input type="text" class="form-control" id="nome">
          </div>
          <div class="mb-3">
            <label for="cpf" class="col-form-label">CPF</label>
            <input type="text" class="form-control" id="cpf">
          </div>
            <div class="mb-3">
            <label for="email" class="col-form-label">Email</label>
            <input type="text" class="form-control" id="email">
          </div>
            <div class="mb-3">
            <label for="cpf" class="col-form-label">Senha</label>
            <input type="password" class="form-control" id="senha">
          </div>
            <div class="col-12">
    <button class="btn btn-primary" type="submit" value="<%=acao%>">Submit form</button>
  </div>
        </form>