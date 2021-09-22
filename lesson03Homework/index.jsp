<%
    boolean isError = false;
    String errorText = "<ul>";
    String email = request.getParameter("email");
    String password = request.getParameter("password");
    String passwordRepeat = request.getParameter("passwordRepeat");
    String gender = request.getParameter("gender");
    String region = request.getParameter("region");
    String comment = request.getParameter("comment");
    String browser = request.getParameter("browser");
	
	String pass = password = ""+ password;
	String repPass = ""+passwordRepeat ;
	
    if (email == null || email.isEmpty() || !email.matches("^[-0-9a-zA-Z.+_]+@[-0-9a-zA-Z.+_]+\\.[a-zA-Z]{2,4}")) {
        isError = true;
        errorText += "<li>Email error!</li>";
    }
	
	 String pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";
		
	
	if(!pass.equals(repPass) || !pass.matches(pattern)) {
			isError = true;
			errorText += "<li>Password error!</li>";
	}
	
	if(gender == null){
		isError = true;
		errorText += "<li>Choose gender!</li>";
	}
	
	if(comment == null || comment.isEmpty() ){
		isError = true;
		errorText += "<li>Enter your comment , please.</li>";
	}
	
	if(browser == null){
		isError = true;
		errorText += "<li>Check for install AMIGO BROWSER! THE BEST BROWSER IN THE WORLD.</li>";
	}
	
	
	
			
    errorText += "</ul>";
    if (!isError) {
        out.write("Registration succeeded.");
    } else {
       %>
<left>
<table>
<form action="index.jsp" method="post">
    <tr><td>Email:</td><td><input type="email" name="email"/></td><td><% out.write(errorText); %></td></tr>
    <tr><td>Password:</td><td><input type="password" name="password"/></td></tr>
    <tr><td>Repeat password:</td><td><input type="password" name="passwordRepeat"/></td></tr>
    <tr><td>Gender:</td><td>M<input type="radio" name="gender" value="M"/>F<input type="radio" name="gender" value="F"/></td></tr>
    <tr><td>Region:</td><td><select name="region">
        <option value="DNR">ДНР</option>
        <option value="LNR">ЛНР</option>
        <option value="Crimea">Крым</option>
    </select></td></tr>
    <tr><td>Comment:</td><td><textarea rows=10 cols=20 name="comment"/></textarea></td></tr>
    <tr><td>I agree to install an Amigo Browser:</td><td><input type="checkbox" name="browser" checked="false"/></td></tr>
    <tr><td> </td><td><input type="submit" value="SEND"/></td></tr>
</form>
</table>
</left> 
<%
    }
%>