<%@ page import="ua.itea.Authorizator" %>
<a href="signup.jsp">Sign-up</a> | <a href="index.jsp">Sign-in</a>
<%
	if(request.getParameter("logout") != null) {
		session.setAttribute("authorized" , null);
	}

	String loginFromSession = (String) session.getAttribute("authorized");
	boolean showForm = true;
	if(loginFromSession != null) {
		showForm = false;
	}
		else {
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		Authorizator auth = new Authorizator();
		String userName = auth.isAuthorized(login,password);
		if(userName != null){
		showForm = false;
		session.setAttribute("authorized",userName);
		loginFromSession = userName;
		out.write("<center><font color='green'>Acces granted</font><center>");
		
		}
	}
	
	if(showForm){
		
%>
<center>
<table>
<form action="index.jsp" , method='post'>

	<tr><td>Login : </td><td>	<input type='login' name ='login'> </td><tr>
	<tr><td>Password : </td><td>	<input type='password' name ='password'> </td><tr>
	<tr><td><input type='submit' value='SEND'> </td><tr>
	
</form>
</table>
</center>


<%
		}
		else{
				out.write("<center><font color='green'>Hello " + loginFromSession + "<a href='?logout'> Logout</a>" + " </font></center>");
		}

%>