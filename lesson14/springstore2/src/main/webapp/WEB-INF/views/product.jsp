<%@include file="header.jsp"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored = "false" %>

<title>Insert title here</title>
</head>
<body>


 	<table>
 		<tr><td><h2>${product.name}</h2></td><td></td></tr>
 		<tr><td><a href="product?id=${product.id}"><img  src="static/images/${product.id}.jpeg" width="250" heigth ="300"></a></td><td>${product.description}</td></tr>
 		<tr><td><h1>${product.price} UAH</h1></td><td><h1>
 		
 		<td><form action="cart" method="post">
 		<input type ='text' size = '2' name='quntity' value='1'/>
 		<input type = 'hidden' name ='buy' value='${product.id}'/>
 		<input type ='submit' value='Buy'/></td></tr>
 		</form></a></td>
 	</table> </br></br>

</body>

<%@include file="footer.jsp" %>