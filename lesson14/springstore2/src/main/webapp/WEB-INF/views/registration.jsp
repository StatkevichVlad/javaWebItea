<%@include file="header.jsp" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<c:choose>
	<c:when test="${success==true}">
	<h3>${result}</h3>
	</c:when>
	
		
	<c:when test="${sessionScope.authorized!=null}">
	<h1>Hello ${sessionScope.authorized}</h1>
	</c:when>
	
	<c:otherwise>
<right>
<table>

<form action="registration" method="post">
		<h1>${result}</h1>
	<tr><td>Name:</td><td><input type="name" name="name" value =" <%=(request.getParameter("name") !=
	null) ? request.getParameter("name") : ""  %>"/></td><td></td></tr>
    <tr><td>Email:</td><td><input type="email" name="email" value ="<%=(request.getParameter("email") !=
	null) ? request.getParameter("email") : ""  %>"/></td><td></td></tr>
    <tr><td>Password:</td><td><input type="password" name="password" value ="<%=(request.getParameter("password") !=
	null) ? request.getParameter("password") : ""  %>""/></td></tr>
    <tr><td>Repeat password:</td><td><input type="password" name="passwordRepeat" value ="<%=(request.getParameter("passwordRepeat") !=
	null) ? request.getParameter("passwordRepeat") : ""  %>""/></td></tr>
    <tr><td>Gender:</td><td>M<input type="radio" name="gender" value="M" checked="true"/>
	F<input type="radio" name="gender" value="F" <%="F".equals(request.getParameter("gender")) ? "checked = 'true' ": ""  %>" /></td></tr>
    <tr><td>Region:</td><td><select name="region">
        <option value="DNR"  <%="DNR".equals(request.getParameter("region")) ? "selected = 'true' ": ""  %> >ДНР  </option>
        <option value="LNR" <%="LNR".equals(request.getParameter("region")) ? "selected = 'true' ": ""  %> >ЛНР</option>
        <option value="Crimea" <%="Crimea".equals(request.getParameter("region")) ? "selected = 'true' ": ""  %>>Крым</option>
    </select></td></tr>
    <tr><td>Comment:</td><td><textarea rows=10 cols=20 name="comment"><%=(request.getParameter("comment") != null)?request.getParameter("comment"):""%></textarea></td></tr>
    <tr><td>I agree to install an Amigo Browser:</td><td><input type="checkbox" name="browser" checked="false"/></td></tr>
    <tr><td> </td><td><input type="submit" value="SEND"/></td></tr>
</form>
</table>
	<ul>
	<c:forEach var="error" items="${errorText}">
    	<li><c:out value="${error}" /></li>
	</c:forEach>
	</ul>




	</c:otherwise>
</c:choose>
</right>
<%@include file="footer.jsp" %>