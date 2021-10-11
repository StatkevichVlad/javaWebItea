<%@include file="header.jsp"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored = "false" %>

<title>Insert title here</title>
</head>
<body>

 <c:forEach items="${productList}" var="product" >
 	<table>
 		<tr><td>${product.name}</td><td></td></tr>
 		<tr><td><img  src="static/images/${product.id}.jpeg" width="150" heigth ="200"></td><td>${product.description}</td></tr>
 		<tr><td>${product.price}</td><td>Buy</td></tr>
 	</table> </br></br>
</c:forEach>
</body>

<%@include file="footer.jsp" %>