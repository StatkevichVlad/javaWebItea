<%@include file="header.jsp"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored = "false" %>

<title>Insert title here</title>
</head>
<body>


 <c:forEach items="${productList}" var="product" >
 	<table>
 		<tr><td><h1>${product.name}</h1></td><td></td></tr>
 		<tr><td><a href="ProductController?id=${product.id}"><img  src="static/images/${product.id}.jpeg" width="150" heigth ="200"></a></td><td>${product.description}</td></tr>
 		<tr><td><h1>${product.price} UAH  </h1></td><td>
 		
 		<td><form action="CartController" method="post">
 		<input type ='text' size = '2' name='quntity' value='1'/>
 		<input type = 'hidden' name ='buy' value='${product.id}'/>
 		<input type ='submit' value='Buy'/></td></tr>
 		</form></a></td>
 	</table> </br></br>
</c:forEach>
</body>

<%@include file="footer.jsp" %>