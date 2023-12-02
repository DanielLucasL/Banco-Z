<%-- 
    Document   : areaprivadaadministrador
    Created on : 1 de dez. de 2023, 16:56:24
    Author     : danie
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="entidade.Administrador" %>
<%@page import="entidade.Cliente"%>
<%@page import="entidade.Conta"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Area Privada</title>
          <meta charset="UTF-8">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <link href="assets/css/bootstrap.css" rel="stylesheet">
   <link href="assets/css/all.css" rel="stylesheet">
   <link href="assets/css/styles.css" rel="stylesheet">
   <link rel="stylesheet" href="assets/css/bootstrap.rtl.min.css" type="text/css"/>
   <link rel="stylesheet" href="assets/css/bootstrap.min.css" type="text/css">


    </head>
    <body class="bg-success">
          <div class="container-lg text-primary-emphasis bg-primary-subtle border border-primary-subtle">
                   <%
                    HttpSession sessao = request.getSession(false);
                    if (sessao != null) {
                        Administrador administradorLogado = (Administrador) session.getAttribute("admininstrador");
                        if (administradorLogado != null) { %>
           <ul class="nav text-info-emphasis bg-info-subtle border border-info-subtle">
 <li class="nav-item">
            <%
                  Administrador administradorLogado = (Administrador) session.getAttribute("administrador");
                    out.println("<a class='nav-link disabled' href='#' tabindex='-1' aria-disabled='true'><svg xmlns='http://www.w3.org/2000/svg' width='16' height='16' fill='currentColor' class='bi bi-safe-fill' viewBox='0 0 16 16'>"
                            + "<path d='M9.778 9.414A2 2 0 1 1 6.95 6.586a2 2 0 0 1 2.828 2.828z'/> "
                            + "<path d='M2.5 0A1.5 1.5 0 0 0 1 1.5V3H.5a.5.5 0 0 0 0 1H1v3.5H.5a.5.5 0 0 0 0 1H1V12H.5a.5.5 0 0 0 0 1H1v1.5A1.5 1.5 0 0 0 2.5 16h12a1.5 1.5 0 0 0 1.5-1.5v-13A1.5 1.5 0 0 0 14.5 0h-12zm3.036 4.464 1.09 1.09a3.003 3.003 0 0 1 3.476 0l1.09-1.09a.5.5 0 1 1 .707.708l-1.09 1.09c.74 1.037.74 2.44 0 3.476l1.09 1.09a.5.5 0 1 1-.707.708l-1.09-1.09a3.002 3.002 0 0 1-3.476 0l-1.09 1.09a.5.5 0 1 1-.708-.708l1.09-1.09a3.003 3.003 0 0 1 0-3.476l-1.09-1.09a.5.5 0 1 1 .708-.708zM14 6.5v3a.5.5 0 0 1-1 0v-3a.5.5 0 0 1 1 0z'/>"
                            + "</svg> Usuário:"+administradorLogado.getNome()+ "</a>");
                %>
</li>
  <li class="nav-item">
    <a class="nav-link" href="#">Log out</a>
  </li>
</ul>           
              <table class="table">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">Nome Completo</th>
      <th scope="col">Cpf</th>
      <th scope="col">Senha</th>
      <th scope="col">Email</th>
      <th scope="col">Saldo</th>
      <th scope="col">Extrato</th>
    </tr>
  </thead>
  <tbody>
   <%
                                ArrayList<Cliente> listaCliente = (ArrayList<Cliente>) request.getAttribute("listaClientes");
                                ArrayList<Conta> listaConta = (ArrayList<Conta>) request.getAttribute("listaContas");
                                
                                for (Cliente cliente : listaClientes) {
                                    out.println("<tr>");
                                    out.println("<th scope='col'>" + cliente.getId() + "</th>");
                                    out.println("<th scope='col'>" + cliente.getCpf() + "</th>");
                                    out.println("<th scope='col'>" + cliente.getSenha() + "</th>");
                                    out.println("<th scope='col'>" + cliente.getEmail() + "</th>");
                                     out.println("<th scope='col'>" + listaContas[cliente.getNumConta()].getSaldo() + "</th>");
                                    %>
                            <td>
                            <a href="/ClienteController?acao=Alterar&id=<%=cliente.getId()%>" class="btn btn-warning">Alterar</a>
                            <a href="/ClienteController?acao=Excluir&id=<%=cliente.getId()%>" class="btn btn-danger">Excluir</a></td>
                            
      <td>
          <form id="extrato" class="d-grid gap-2 needs-validation" action="/BancoZ/controller/ExtratoController" method="POST" style="min-height:50%">
           <div class="col-12">
           <div class="d-grid gap-2" style="min-height:50%"> 
           <input type="hidden" id="numConta" value="<%=cliente.getnumConta()%>">    
           <button class="btn btn-info" type="submit" value="<%=acao%>">Extrato</button>
           </div>
           </div>
</form>
      </td>
                            <%   out.println("</tr>");
                                }
                            %>

    <tr>
    <tr>
      <th scope="row">?</th>
      <td colspan="6"><div class="d-grid gap-1">
     <button class="btn btn-primary" type="button" data-bs-toggle="modal" data-bs-target="#exampleModal">+</button>
       </div></td>
    </tr>
  </tbody>
</table>
              <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h1 class="modal-title fs-5" id="exampleModalLabel">Cadastrar Cliente</h1>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <jsp:include page="registracliente.jsp" />  
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>
             </div>
        
        <div class="modal" id="ModalErroBD" tabindex="-1" role="dialog" aria-labelledby="fetchErrorModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="fetchErrorModalLabel">
                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-database-fill-exclamation" viewBox="0 0 16 16">
  <path d="M8 1c-1.573 0-3.022.289-4.096.777C2.875 2.245 2 2.993 2 4s.875 1.755 1.904 2.223C4.978 6.711 6.427 7 8 7s3.022-.289 4.096-.777C13.125 5.755 14 5.007 14 4s-.875-1.755-1.904-2.223C11.022 1.289 9.573 1 8 1Z"/>
  <path d="M2 7v-.839c.457.432 1.004.751 1.49.972C4.722 7.693 6.318 8 8 8s3.278-.307 4.51-.867c.486-.22 1.033-.54 1.49-.972V7c0 .424-.155.802-.411 1.133a4.51 4.51 0 0 0-4.815 1.843A12.31 12.31 0 0 1 8 10c-1.573 0-3.022-.289-4.096-.777C2.875 8.755 2 8.007 2 7Zm6.257 3.998L8 11c-1.682 0-3.278-.307-4.51-.867-.486-.22-1.033-.54-1.49-.972V10c0 1.007.875 1.755 1.904 2.223C4.978 12.711 6.427 13 8 13h.027a4.552 4.552 0 0 1 .23-2.002Zm-.002 3L8 14c-1.682 0-3.278-.307-4.51-.867-.486-.22-1.033-.54-1.49-.972V13c0 1.007.875 1.755 1.904 2.223C4.978 15.711 6.427 16 8 16c.536 0 1.058-.034 1.555-.097a4.507 4.507 0 0 1-1.3-1.905Z"/>
  <path d="M16 12.5a3.5 3.5 0 1 1-7 0 3.5 3.5 0 0 1 7 0Zm-3.5-2a.5.5 0 0 0-.5.5v1.5a.5.5 0 0 0 1 0V11a.5.5 0 0 0-.5-.5Zm0 4a.5.5 0 1 0 0-1 .5.5 0 0 0 0 1Z"/>
</svg>
Erro de Banco de Dados</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>Infelizmente,foi encontrado um erro ao tentar-se atualizar o banco de dados. Por favor, tente novamente.</p>
            </div>
        </div>
    </div>
</div>
        <div class="modal" id="ModalSucesso" tabindex="-1" role="dialog" aria-labelledby="successModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="successModalLabel"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-check-circle-fill" viewBox="0 0 16 16">
  <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zm-3.97-3.03a.75.75 0 0 0-1.08.022L7.477 9.417 5.384 7.323a.75.75 0 0 0-1.06 1.06L6.97 11.03a.75.75 0 0 0 1.079-.02l3.992-4.99a.75.75 0 0 0-.01-1.05z"/>
</svg> Cliente registrado com sucesso.</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>Cliente registrado feito com sucesso.</p>
            </div>
        </div>
    </div>
</div>

<!-- Modal for Failed Submission -->
<div class="modal" id="ModalErro" tabindex="-1" role="dialog" aria-labelledby="errorModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="errorModalLabel"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-exclamation-circle-fill" viewBox="0 0 16 16">
  <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zM8 4a.905.905 0 0 0-.9.995l.35 3.507a.552.552 0 0 0 1.1 0l.35-3.507A.905.905 0 0 0 8 4zm.002 6a1 1 0 1 0 0 2 1 1 0 0 0 0-2z"/>
</svg> Erro para submeter formulário.</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>Houve um erro para submeter o formulário. Por favor, tente novamente.</p>
            </div>
        </div>
    </div>
</div>
<div class="modal" id="ModalSucessoExtrato" tabindex="-1" role="dialog" aria-labelledby="successModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="successModalLabel"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-check-circle-fill" viewBox="0 0 16 16">
  <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zm-3.97-3.03a.75.75 0 0 0-1.08.022L7.477 9.417 5.384 7.323a.75.75 0 0 0-1.06 1.06L6.97 11.03a.75.75 0 0 0 1.079-.02l3.992-4.99a.75.75 0 0 0-.01-1.05z"/>
</svg> Extrato obtido com sucesso.</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                 <jsp:include page="extrato.jsp" />  
            </div>
        </div>
    </div>
</div>
       <%  } else { %>
  <ul class="nav text-info-emphasis bg-info-subtle border border-info-subtle">
       <li class="nav-item">
                           <div class="alert alert-warning" role="alerta">
  Acesso negado!
</div>
           </li>
      <li class="nav-item">
                <a class="nav-link" href="index.jsp">Login</a>
                </li>
      </ul>
                <%    }
                    }%>

   <script src="assets/js/jquery-3.3.1.js"></script>
   <script src="assets/js/popper.js"></script>
   <script src="assets/js/bootstrap.js"></script>
   <script src="assets/js/bootstrap.bundle.min.js"></script>
   <script src="assets/js/script.js"></script>
    </body>
</html>

