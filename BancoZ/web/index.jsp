<%-- 
    Document   : index
    Created on : 30 de nov. de 2023, 19:57:04
    Author     : danie
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <title>TODO supply a title</title>
   <meta charset="UTF-8">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <link href="assets/css/bootstrap.css" rel="stylesheet">
   <link href="assets/css/all.css" rel="stylesheet">
   <link href="assets/css/styles.css" rel="stylesheet">
   <link rel="stylesheet" href="assets/css/bootstrap.rtl.min.css" type="text/css"/>
   <link rel="stylesheet" href="assets/css/bootstrap.min.css" type="text/css">
    </head>
    <body class="bg-success">
        <div class="container text-primary-emphasis bg-primary-subtle border border-primary-subtle">
<nav class="navbar navbar-expand-lg text-info-emphasis bg-info-subtle border border-info-subtle">
  <div class="container-fluid">
    <a class="navbar-brand" href="#"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-bank" viewBox="0 0 16 16">
  <path d="m8 0 6.61 3h.89a.5.5 0 0 1 .5.5v2a.5.5 0 0 1-.5.5H15v7a.5.5 0 0 1 .485.38l.5 2a.498.498 0 0 1-.485.62H.5a.498.498 0 0 1-.485-.62l.5-2A.501.501 0 0 1 1 13V6H.5a.5.5 0 0 1-.5-.5v-2A.5.5 0 0 1 .5 3h.89L8 0ZM3.777 3h8.447L8 1 3.777 3ZM2 6v7h1V6H2Zm2 0v7h2.5V6H4Zm3.5 0v7h1V6h-1Zm2 0v7H12V6H9.5ZM13 6v7h1V6h-1Zm2-1V4H1v1h14Zm-.39 9H1.39l-.25 1h13.72l-.25-1Z"/>
</svg> Banco Z</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="#login">Login</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#missao">Missão</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#visao">Visão</a>
        </li>
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="#valores">Valores</a>
        </li>
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="#contatos">Contatos</a>
        </li>
      </ul>
    </div>
  </div>
</nav>           
            <br>
                <%
                    String msgError = (String) request.getAttribute("msgError");
                    if ((msgError != null) && (!msgError.isEmpty())) {%>
                <div class="alert alert-danger" role="alert">
                    <%= msgError%>
                </div>
                <% }%>
        <form id="login" action="/BancoZ/controller/Login<%= request.getParameter("tipo") %>Controller" method="POST">
  <select class="form-select" aria-label="Default select example"id="tipo" name="tipo">
  <option selected value="cliente">Cliente</option>
  <option value="administrator">Administrator</option>
</select>     
  <div class="mb-3">
    <label for="CPF" class="form-label">CPF</label>
    <input type="text" class="form-control" name="cpf">
  </div>
  <div class="mb-3">
    <label for="Senha" class="form-label">Senha</label>
    <input type="password" class="form-control" name="senha">
  </div>
  <button type="submit" class="btn btn-primary" value="<%=acao%>">Submeter</button>
</form>
        <br>
  <div id="missao" class="card">
  <div class="card-header">
    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-clipboard2" viewBox="0 0 16 16">
  <path d="M3.5 2a.5.5 0 0 0-.5.5v12a.5.5 0 0 0 .5.5h9a.5.5 0 0 0 .5-.5v-12a.5.5 0 0 0-.5-.5H12a.5.5 0 0 1 0-1h.5A1.5 1.5 0 0 1 14 2.5v12a1.5 1.5 0 0 1-1.5 1.5h-9A1.5 1.5 0 0 1 2 14.5v-12A1.5 1.5 0 0 1 3.5 1H4a.5.5 0 0 1 0 1h-.5Z"/>
  <path d="M10 .5a.5.5 0 0 0-.5-.5h-3a.5.5 0 0 0-.5.5.5.5 0 0 1-.5.5.5.5 0 0 0-.5.5V2a.5.5 0 0 0 .5.5h5A.5.5 0 0 0 11 2v-.5a.5.5 0 0 0-.5-.5.5.5 0 0 1-.5-.5Z"/>
</svg> Missão
  </div>
  <div class="card-body text-secondary-emphasis bg-secondary-subtle border border-secondary">
    <p class="card-text">No Banco Z, nossa missão é capacitar indivíduos, empresas e comunidades, fornecendo soluções financeiras inovadoras que promovam o crescimento econômico e a prosperidade. Estamos empenhados em construir relacionamentos duradouros baseados em confiança, integridade e transparência. Através do compromisso com a excelência, buscamos ser um catalisador para mudanças positivas, oferecendo serviços financeiros que atendam às necessidades em constante evolução de nossos clientes e contribuam para o bem-estar geral da sociedade.</p>
  </div>
</div>
        <br>
    <div id="visao" class="card">
  <div class="card-header">
    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-eye" viewBox="0 0 16 16">
  <path d="M16 8s-3-5.5-8-5.5S0 8 0 8s3 5.5 8 5.5S16 8 16 8zM1.173 8a13.133 13.133 0 0 1 1.66-2.043C4.12 4.668 5.88 3.5 8 3.5c2.12 0 3.879 1.168 5.168 2.457A13.133 13.133 0 0 1 14.828 8c-.058.087-.122.183-.195.288-.335.48-.83 1.12-1.465 1.755C11.879 11.332 10.119 12.5 8 12.5c-2.12 0-3.879-1.168-5.168-2.457A13.134 13.134 0 0 1 1.172 8z"/>
  <path d="M8 5.5a2.5 2.5 0 1 0 0 5 2.5 2.5 0 0 0 0-5zM4.5 8a3.5 3.5 0 1 1 7 0 3.5 3.5 0 0 1-7 0z"/>
</svg> Visão
  </div>
  <div class="card-body text-secondary-emphasis bg-secondary-subtle border border-secondary">
    <p class="card-text">O Banco Z vislumbra um futuro em que o empoderamento financeiro seja acessível a todos. Aspiramos ser uma força líder na formação de um ecossistema financeiro resiliente e inclusivo, no qual indivíduos e empresas prosperam. Nossa visão é ser reconhecido como o banco de escolha, distinguido por nosso compromisso inabalável com a satisfação do cliente, inovação tecnológica e responsabilidade social. Ao abraçar a mudança e antecipar as necessidades de nossos stakeholders, pretendemos estar na vanguarda das transformações positivas no cenário financeiro.</p>
  </div>
</div>
        <br>
  <div id="valores" class="card">
  <div class="card-header">
    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-heart-fill" viewBox="0 0 16 16">
  <path fill-rule="evenodd" d="M8 1.314C12.438-3.248 23.534 4.735 8 15-7.534 4.736 3.562-3.248 8 1.314z"/>
</svg> Valores
  </div>
  <div class="card-body text-light-emphasis bg-secondary-subtle border border-secondary">
<ol class="list-group list-group-numbered">
  <li class="list-group-item bg-light-subtle border border-secondary">Integridade: Mantemos os mais altos padrões de honestidade e conduta ética. A integridade é a base de nossos relacionamentos com clientes, colegas e as comunidades que servimos.</li>
  <li class="list-group-item bg-light-subtle border border-secondary">Orientação ao Cliente: Nossos clientes estão no centro de tudo o que fazemos. Comprometemo-nos a compreender suas necessidades e fornecer soluções personalizadas, ágeis e inovadoras que superem suas expectativas.
</li>
  <li class="list-group-item bg-light-subtle border border-secondary">Inovação: Abraçamos a inovação como um motor essencial do progresso. Ao explorar continuamente novas ideias e tecnologias, buscamos fornecer produtos e serviços financeiros de ponta que capacitem nossos clientes e melhorem seu bem-estar financeiro.</li>
  <li class="list-group-item bg-light-subtle border border-secondary">Colaboração: Acreditamos no poder da colaboração, tanto interna quanto externamente. Trabalhando em conjunto com nossos colegas, clientes e parceiros, criamos sinergias que amplificam nosso impacto e contribuem para o sucesso compartilhado.
</li>
<li class="list-group-item bg-light-subtle border border-secondary">Responsabilidade: Como cidadãos corporativos responsáveis, comprometemo-nos com a sustentabilidade ambiental, responsabilidade social e desenvolvimento comunitário. Procuramos ativamente maneiras de minimizar nosso impacto ambiental e contribuir para o bem-estar das comunidades em que operamos.
</li>
<li class="list-group-item bg-light-subtle border border-secondary">Excelência: Buscamos a excelência em todos os aspectos de nossas operações. Desde o atendimento ao cliente até a gestão financeira, estabelecemos padrões elevados para nós mesmos e nos esforçamos continuamente para superá-los, garantindo o sucesso e a satisfação de nossos clientes e stakeholders.
</li>
    </ol>
  </div>
</div>
        <br>
        <div id="contatos" class="card">
  <div class="card-header">
    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-chat-left-fill" viewBox="0 0 16 16">
  <path d="M2 0a2 2 0 0 0-2 2v12.793a.5.5 0 0 0 .854.353l2.853-2.853A1 1 0 0 1 4.414 12H14a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2z"/>
</svg> Contatos
  </div>
  <div class="card-body text-secondary-emphasis bg-secondary-subtle border border-secondary">
    <p class="card-text"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-telephone-fill" viewBox="0 0 16 16">
  <path fill-rule="evenodd" d="M1.885.511a1.745 1.745 0 0 1 2.61.163L6.29 2.98c.329.423.445.974.315 1.494l-.547 2.19a.678.678 0 0 0 .178.643l2.457 2.457a.678.678 0 0 0 .644.178l2.189-.547a1.745 1.745 0 0 1 1.494.315l2.306 1.794c.829.645.905 1.87.163 2.611l-1.034 1.034c-.74.74-1.846 1.065-2.877.702a18.634 18.634 0 0 1-7.01-4.42 18.634 18.634 0 0 1-4.42-7.009c-.362-1.03-.037-2.137.703-2.877L1.885.511z"/>
</svg><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-telegram" viewBox="0 0 16 16">
  <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zM8.287 5.906c-.778.324-2.334.994-4.666 2.01-.378.15-.577.298-.595.442-.03.243.275.339.69.47l.175.055c.408.133.958.288 1.243.294.26.006.549-.1.868-.32 2.179-1.471 3.304-2.214 3.374-2.23.05-.012.12-.026.166.016.047.041.042.12.037.141-.03.129-1.227 1.241-1.846 1.817-.193.18-.33.307-.358.336a8.154 8.154 0 0 1-.188.186c-.38.366-.664.64.015 1.088.327.216.589.393.85.571.284.194.568.387.936.629.093.06.183.125.27.187.331.236.63.448.997.414.214-.02.435-.22.547-.82.265-1.417.786-4.486.906-5.751a1.426 1.426 0 0 0-.013-.315.337.337 0 0 0-.114-.217.526.526 0 0 0-.31-.093c-.3.005-.763.166-2.984 1.09z"/>
</svg><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-whatsapp" viewBox="0 0 16 16">
  <path d="M13.601 2.326A7.854 7.854 0 0 0 7.994 0C3.627 0 .068 3.558.064 7.926c0 1.399.366 2.76 1.057 3.965L0 16l4.204-1.102a7.933 7.933 0 0 0 3.79.965h.004c4.368 0 7.926-3.558 7.93-7.93A7.898 7.898 0 0 0 13.6 2.326zM7.994 14.521a6.573 6.573 0 0 1-3.356-.92l-.24-.144-2.494.654.666-2.433-.156-.251a6.56 6.56 0 0 1-1.007-3.505c0-3.626 2.957-6.584 6.591-6.584a6.56 6.56 0 0 1 4.66 1.931 6.557 6.557 0 0 1 1.928 4.66c-.004 3.639-2.961 6.592-6.592 6.592zm3.615-4.934c-.197-.099-1.17-.578-1.353-.646-.182-.065-.315-.099-.445.099-.133.197-.513.646-.627.775-.114.133-.232.148-.43.05-.197-.1-.836-.308-1.592-.985-.59-.525-.985-1.175-1.103-1.372-.114-.198-.011-.304.088-.403.087-.088.197-.232.296-.346.1-.114.133-.198.198-.33.065-.134.034-.248-.015-.347-.05-.099-.445-1.076-.612-1.47-.16-.389-.323-.335-.445-.34-.114-.007-.247-.007-.38-.007a.729.729 0 0 0-.529.247c-.182.198-.691.677-.691 1.654 0 .977.71 1.916.81 2.049.098.133 1.394 2.132 3.383 2.992.47.205.84.326 1.129.418.475.152.904.129 1.246.08.38-.058 1.171-.48 1.338-.943.164-.464.164-.86.114-.943-.049-.084-.182-.133-.38-.232z"/>
</svg> (XX)XXXXX-XXXX</p>
    
    <p class="card-text"> <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-mailbox2-flag" viewBox="0 0 16 16">
  <path d="M10.5 8.5V3.707l.854-.853A.5.5 0 0 0 11.5 2.5v-2A.5.5 0 0 0 11 0H9.5a.5.5 0 0 0-.5.5v8h1.5Z"/>
  <path d="M4 3h4v1H6.646A3.99 3.99 0 0 1 8 7v6h7V7a3 3 0 0 0-3-3V3a4 4 0 0 1 4 4v6a1 1 0 0 1-1 1H1a1 1 0 0 1-1-1V7a4 4 0 0 1 4-4Zm.585 4.157C4.836 7.264 5 7.334 5 7a1 1 0 0 0-2 0c0 .334.164.264.415.157C3.58 7.087 3.782 7 4 7c.218 0 .42.086.585.157Z"/>
</svg> xxxxxxxx@xxxxx.com</p>
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
</svg> Login feito com sucesso.</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>Login feito com sucesso.</p>
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
<!-- Your script to handle form submission and show the modals goes here -->
   <script src="assets/js/jquery-3.3.1.js"></script>
   <script src="assets/js/popper.js"></script>
   <script src="assets/js/bootstrap.js"></script>
   <script src="assets/js/script.js"></script>
    <script src="src/java/Formusuario.java"></script>
    </body>
</html>

