<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="mensagem.jsp"/>
<div id="pagina">
<div id="conteudo">

<div id="ondestamos">
<h1>Onde estamos?</h1>
<ul>
  <li>Rua: Desconhecida n�40, proximo Av. das Amoreiras</li>
</ul>
<p>Acompanhe o mapa abaixo!</p>
<p>Horario de funcionamento: Seg a Sex das 09h as 17h e Sab e Dom das 08h ao 12h</p>
</div>

<h1>Contato</h1>
<p>Preencha os campos abaixo e envie sua duvida para n�s!</p>

<div id="formulario">


	<form id="duvida" action="DuvidaServlet" method="post">
					
			<c:if test="${not empty duvida}">
			<input type="hidden" name="idDuvida" value="${duvida.id_duvida}"/>
			</c:if>
			<p><label id="nome_contato" for="nome">Nome:</label><input id="nome" type="text" name="nome" value="${empty duvida ? param.nome : duvida.nome }"/></p>
			<p><label id="email_contato" for="email">Email:</label><input id="email" type="text" name="email" value="${empty duvida ? param.email : duvida.email}" /></p>
			<p><label id="mensagem_contato" for="mensagem" >Mensagem:</label></p>
			<textarea id="mensagem" name="mensagem" rows="6" cols="50" />${empty duvida ? param.mensagem : duvida.mensagem}</textarea><input type="hidden" name="status" value="${duvida.status}"/>
			<p><input type="submit" value="Enviar" id="botaum" /></p>
	</form>
</div>
<div id="mapacontato">
<img src="images/mapacontato.png" alt="Mapa contato"></img>
</div>
</div>
</div>