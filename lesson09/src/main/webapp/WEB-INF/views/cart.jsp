<%@include file="header.jsp"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored = "false" %>

<title>Insert title here</title>
</head>
<body>

<c:forEach var="product" items="${sessionScope.productCartMap}">
 	<table>
 		<tr><td><h1>${product.key.name}</h1></td><td></td></tr>
 		<tr><td><a href="ProductController?id=${product.key.id}"><img  src="static/images/${product.key.id}.jpeg" width="150" heigth ="200"></a></td><td>${product.key.description}</td></tr>
 	 	<tr><td><h1>${product.key.price} UAH</h1></td><td><h1>${product.value} position(s)</h1></td></tr>
 		<td><form action="CartController">
 		<input type ='text' size = '2' name='quntity' value='1'/>
 		<input type = 'hidden' name ='remove' value='${product.key.id}'/>
 		<input type ='submit' value='Remove'/></td></tr>
 		</form></a></td>
 	</table> </br></br>
</c:forEach>
	<c:if test="${sessionScope.allPrice != null && sessionScope.allPrice != 0}">
	<h2>All price: ${sessionScope.allPrice}  UAH</h2>
	</c:if>
</body>



<%@include file="footer.jsp" %>