<%-- 
    Document   : areaprivadacliente
    Created on : 30 de nov. de 2023, 20:09:02
    Author     : danie
--%>


<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="entidade.Cliente"%>
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
                        Cliente clienteLogado = (Cliente) session.getAttribute("cliente");
                        if (clienteLogado != null) { %>
           <ul class="nav text-info-emphasis bg-info-subtle border border-info-subtle">
 <li class="nav-item">
    
     <%
                  Cliente clienteLogado = (Cliente) session.getAttribute("cliente");
                    out.println("<a class='nav-link disabled' href='#' tabindex='-1' aria-disabled='true'><svg xmlns='http://www.w3.org/2000/svg' width='16' height='16' fill='currentColor' class='bi bi-safe-fill' viewBox='0 0 16 16'>"
                            + "<path d='M9.778 9.414A2 2 0 1 1 6.95 6.586a2 2 0 0 1 2.828 2.828z'/> "
                            + "<path d='M2.5 0A1.5 1.5 0 0 0 1 1.5V3H.5a.5.5 0 0 0 0 1H1v3.5H.5a.5.5 0 0 0 0 1H1V12H.5a.5.5 0 0 0 0 1H1v1.5A1.5 1.5 0 0 0 2.5 16h12a1.5 1.5 0 0 0 1.5-1.5v-13A1.5 1.5 0 0 0 14.5 0h-12zm3.036 4.464 1.09 1.09a3.003 3.003 0 0 1 3.476 0l1.09-1.09a.5.5 0 1 1 .707.708l-1.09 1.09c.74 1.037.74 2.44 0 3.476l1.09 1.09a.5.5 0 1 1-.707.708l-1.09-1.09a3.002 3.002 0 0 1-3.476 0l-1.09 1.09a.5.5 0 1 1-.708-.708l1.09-1.09a3.003 3.003 0 0 1 0-3.476l-1.09-1.09a.5.5 0 1 1 .708-.708zM14 6.5v3a.5.5 0 0 1-1 0v-3a.5.5 0 0 1 1 0z'/>"
                            + "</svg> Usuário:"+clienteLogado.getNome()+ "</a>");
                %>
              <jsp:include page="menu.jsp" />  
               </li>
                 <li class="nav-item">
    <a class="nav-link" href="logout">Log out</a>
  </li>
</ul>
           <br>
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
 
     
       </div>   
   

   <script src="assets/js/jquery-3.3.1.js"></script>
   <script src="assets/js/popper.js"></script>
   <script src="assets/js/bootstrap.js"></script>
   <script src="assets/js/script.js"></script>
    <script src="assets/js/bootstrap.bundle.min.js"></script>
    </body>
</html>

