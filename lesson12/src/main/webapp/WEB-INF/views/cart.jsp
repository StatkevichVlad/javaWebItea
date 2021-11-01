<%@include file="header.jsp"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored = "false" %>

<title>Insert title here</title>
</head>
<body>
	<c:if test="${sessionScope.productCartMap != null }">

<c:forEach var="product" items="${sessionScope.productCartMap}">
 	<table>
 		<tr><td><h1>${product.key.name}</h1></td><td></td></tr>
 		<tr><td><a href="product?id=${product.key.id}"><img  src="static/images/${product.key.id}.jpeg" width="150" heigth ="200"></a></td><td>${product.key.description}</td></tr>
 	 	<tr><td><h1>${product.key.price} UAH</h1></td><td><h1>
 	 	</td></tr>
 		<td><form action="cart" method='post'>
 		
 		<input id="a${product.key.id}" type="text" name='quntity' size ="2" value="${product.value}"/>
		<input onclick="sendParamChange('a${product.key.id}','${product.key.id}')" type="button" value="change"/></td></tr>
 		

 		</form></a></td>
 	</table> </br></br>
</c:forEach>
	<c:if test="${sessionScope.allPrice != null && sessionScope.allPrice != 0}">
<h2>All price: ${sessionScope.allPrice}  UAH</h2> 
	</c:if>
	
	</c:if>
</body>



<%@include file="footer.jsp" %>