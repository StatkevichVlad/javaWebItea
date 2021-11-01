<%@include file="header.jsp"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored = "false" %>

<c:choose>
	<c:when test="${sessionScope.authorized==null}">
	<table>
	<form action="login" , method='post'>		
	
	<center>
	<tr><td>Login : </td><td>	<input type='login' name ='login' value="<%=(request.getParameter("login") != null) ? request.getParameter("login") : ""%>">  </td><tr>
	<tr><td>Password : </td><td>	<input type='password' name ='password'> </td><tr>
	<tr><td><input type='submit' value='SEND'> </td></tr>
	<h1>${result}</h1>
	</center>
	</form>
	</table>	
	</c:when> 
		<c:otherwise>
		<center><h1>Hello ,${sessionScope.authorized} !</h1></center>
		<center><a href='?logout'><h1>Logout</a></center>
		</c:otherwise>
</c:choose>
			
<%@include file="footer.jsp" %>
					