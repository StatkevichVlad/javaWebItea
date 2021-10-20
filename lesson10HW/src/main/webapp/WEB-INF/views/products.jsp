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
 			<img onclick="sum('a${product.id}',-1)" src="static/images/minus.jpg" width="25" height="25"/> 
			<input id="a${product.id}" type="text" name='quntity' size ="2" value="1"/>
			<img onclick="sum('a${product.id}',1)" src="static/images/plus.jpg" width="25" height="25"/> 
 			<input type = 'hidden' name ='buy' value='${product.id}'/>
 			<input onclick="sendParam('a${product.id}','${product.id}')" type="button" value="buy"/></td></tr>
 		</form></a></td>
 	</table> </br></br>
</c:forEach>
</body>

<%@include file="footer.jsp" %>