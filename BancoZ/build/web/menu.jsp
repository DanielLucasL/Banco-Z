<%-- 
    Document   : menu
    Created on : 30 de nov. de 2023, 20:28:50
    Author     : danie
--%>


<%@page contentType="text/html" pageEncoding="UTF-8" import="entidade.Cliente"%>
   <%
                    HttpSession sessao = request.getSession(false);
                    if (sessao != null) {
                        Cliente clienteLogado = (Cliente) session.getAttribute("cliente");
                        if (clienteLogado != null) { %>
                        <div class="accordion" id="accordionExample">
                            <div class="accordion-item">
    <h2 class="accordion-header">
      <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
        Saldo e Extrato
      </button>
    </h2>
    <div id="collapseOne" class="accordion-collapse collapse show" data-bs-parent="#accordionExample">
      <div class="accordion-body">
          <iframe src="saldoeextrato.html" title="saldo&extrato" height="100" width="1075"></iframe>
      </div>
    </div>
  </div>
  <div class="accordion-item">
    <h2 class="accordion-header">
      <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
          Depósitos  
      </button>
    </h2>
    <div id="collapseTwo" class="accordion-collapse collapse" data-bs-parent="#accordionExample">
      <div class="accordion-body">
          <iframe src="depositos.html" title="depositos" height="300" width="1075"></iframe>
      </div>
    </div>
  </div>
  <div class="accordion-item">
    <h2 class="accordion-header">
      <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
        Saques
      </button>
    </h2>
    <div id="collapseThree" class="accordion-collapse collapse" data-bs-parent="#accordionExample">
      <div class="accordion-body">
      <iframe src="saques.html" title="saques" height="150" width="1075"></iframe>
      </div>
    </div>
  </div>
               <div class="accordion-item">
    <h2 class="accordion-header">
      <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseFour" aria-expanded="false" aria-controls="collapseFour">
          Transferências 
      </button>
    </h2>
    <div id="collapseFour" class="accordion-collapse collapse" data-bs-parent="#accordionExample">
      <div class="accordion-body">
          <iframe src="transferencias.html" title="transferencias" height="320" width="1075"></iframe>
      </div>
    </div>
  </div>
                  <div class="accordion-item">
    <h2 class="accordion-header">
      <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseFive" aria-expanded="false" aria-controls="collapseFive">
        Investimentos
      </button>
    </h2>
    <div id="collapseFive" class="accordion-collapse collapse" data-bs-parent="#accordionExample">
      <div class="accordion-body">
        <iframe src="investimentos.html" title="saques" height="150" width="1075"></iframe>
      </div>
    </div>
   </div>
  </div>
           <br><br><br>
 </div>
    <%  } else { %>
          
                           <div class="alert alert-warning" role="alerta">
  Acesso negado!
</div>
                <a class="nav-link" href="index.jsp">Login</a>
                <%    }
                    }%>      
  
