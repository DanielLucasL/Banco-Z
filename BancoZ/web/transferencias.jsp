<%-- 
    Document   : transferencias
    Created on : 1 de dez. de 2023, 20:22:43
    Author     : danie
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html style="height: 100%; margin: 0; overflow:hidden">
    <head>
    <meta charset="UTF-8">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <link href="assets/css/bootstrap.css" rel="stylesheet">
   <link href="assets/css/all.css" rel="stylesheet">
   <link href="assets/css/styles.css" rel="stylesheet">
   <link rel="stylesheet" href="assets/css/bootstrap.rtl.min.css" type="text/css"/>
   <link rel="stylesheet" href="assets/css/bootstrap.min.css" type="text/css">
    </head>
    <body style="height: 100%; margin: 0; overflow:hidden">
         <form id="transferencia" class="row g-3 needs-validation" action="/BancoZ/controller/TransferenciaController" method="POST" style="min-height:100%; overflow:hidden">
              <%
                    String msgError = (String) request.getAttribute("msgError");
                    if ((msgError != null) && (!msgError.isEmpty())) {%>
                <div class="alert alert-danger" role="alert">
                    <%= msgError%>
                </div>
                <% }%>
            <div class="col-md-6">
    <label for="validationCustom01" class="form-label"> Nome completo do beneficiado</label>
    <input type="text" class="form-control" id="validationCustom01" required>
  </div>
            <div class="col-md-6">
    <label for="validationCustom01" class="form-label">CPF ou CNPJ do beneficiado</label>
    <input type="text" class="form-control" id="validationCustom01" required>
  </div>
            <div class="col-md-6">
    <label for="validationCustom01" class="form-label"> Valor</label>
    <input type="number" class="form-control" id="validationCustom01" required>
  </div>
  <div class="col-md-6">
    <label for="validationCustomUsername" class="form-label">Conta do Beneficiário</label>
    <div class="input-group has-validation">
      <input type="text" class="form-control" id="validationCustomUsername" aria-describedby="inputGroupPrepend" required>
    </div>
  </div>      
  <div class="col-12">
    <button class="btn btn-primary" type="submit" value="<%=acao%>">Submeter</button>
  </div>
</form>
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
</svg> Transferência feito com sucesso.</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>Transferência feito com sucesso.</p>
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
        <script src="assets/js/jquery-3.3.1.js"></script>
   <script src="assets/js/popper.js"></script>
   <script src="assets/js/bootstrap.js"></script>
   <script src="assets/js/script.js"></script>
    <script src="assets/js/bootstrap.bundle.min.js"></script>
    </body>
</html>

