<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="site.vo.Paciente" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<script src='http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js'></script>
<script type='text/javascript' src="menu_jquery.js"></script>
<link rel="stylesheet" type="text/css" href="estilos.css"/>
<title>Hue - Laboratorio Medicinal</title>
</head>
<body>
	
	<%@include file="inicio.jsp" %>
	<%@include file="paginasjsp/menu.jsp" %>
	<jsp:include page="mensagem.jsp"/>
	
<c:if test="${empty loginUsuario}">

<jsp:forward page="gestor1.jsp"/>  

</c:if>
<div id="pagina">
<div id="conteudo">
  <p>
    <a href="gestor1.jsp"><img src="images/botaopaciente.png"></img></a> 
  </p>

<c:choose>
  <c:when test="${empty pacientes}">
    <p>Nenhum Paciente cadastrado!</p>
  </c:when>
  <c:otherwise>
  <table border="1">
    <tr>    
      <th>Paciente</th>
      <th>C�digo de Verifica��o</th>
      <th>RG</th>
      <th>CPF</th>
      <th>Data de nascimento</th>
      <th>Rua</th>
      <th>N�mero</th>
      <th>Bairro</th>
      <th>CEP</th>
      <th>Telefone</th>
      <th>Email</th>
      <th>Conv�nio</th>
    	<th colspan="2">A��es</th>
    </tr>
    
    <c:forEach var="paciente" items="${pacientes}">    
  
    <tr>

      <td>      
        ${paciente.nome_paciente}
      </td>
          <td>
    	${paciente.cod_verif}
    </td>
      <td>      
        ${paciente.rg_paciente}
      </td>
      <td>
      	${paciente.cpf_paciente}
      </td>
      <td>
      	${paciente.datanasc_paciente}
      </td>
      <td>
      	${paciente.endereco_rua}
      </td>
      <td>
      	${paciente.endereco_num}
      </td>
      <td>
      	${paciente.endereco_bairro}
      </td>
		<td>
			${paciente.cep}
		</td>
		<td>
			${paciente.telefone_paciente}
		</td>
		<td>
			${paciente.email_paciente}
		</td>
		<td>
			${paciente.convenio_paciente}
		</td>		
      <td>
      	<a href="ObterPacienteServlet?paciente=${paciente.id}"><img src="images/botaoeditar.png"></img></a>
      </td>
      <td>      	
      	<a href="DeletarPacienteServlet?paciente=${paciente.id}"><img src="images/botaodeletar.png"></img></a>
      </td>
    </tr>
    
    </c:forEach>
    
  </table>  

  </c:otherwise>
 </c:choose>


</div>
</div>
<%@include file="paginas/rodape.html" %>
</body>
</html>