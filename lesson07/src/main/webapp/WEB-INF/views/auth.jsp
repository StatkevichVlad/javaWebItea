<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<a href="/second/authController">Sign-up</a> | <a href="/second/registrationController">Sign-in</a>
<body>
	<center>
		<table>
			<c:if test="${showForm}">

				<form action="" , method='post'>

					<tr>
						<td>Login :</td>
						<td><input type='login' name='login'></td>
					<tr>
					<tr>
						<td>Password :</td>
						<td><input type='password' name='password'></td>
					<tr>
					<tr>
						<td><input type='submit' value='SEND'></td>
					</tr>
				</form>
			</c:if>
				<h1>${result}</h1>
		</table>
	</center>
</body>