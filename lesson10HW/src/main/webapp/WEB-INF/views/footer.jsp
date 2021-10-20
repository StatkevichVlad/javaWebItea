<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

					
			  </div>
            
				<div id="sidebar">
					<table border=1>
                    <tr>
                    <td width="252" align="left">
                    <font color=white>
        <c:choose>
            	<c:when test="${sessionScope.authorized!=null}">
                    Вы авторизировались как ${sessionScope.authorized}	<br />
                   	В вашей корзине <span id ='cartSize'>
                   	${(sessionScope.productCartMapSize==null?"0":""+sessionScope.productCartMapSize)} </span>
                   	товаров.
                </c:when>
                	<c:otherwise>
					 Вы не авторизировались.
					 В вашей корзине 
					 <span id='cartSize'>
                   	${(sessionScope.productCartMapSize==null?"0":""+sessionScope.productCartMapSize)}
                   	</span>
                   	товаров.
					</c:otherwise>
        </c:choose>
                    </font>
                    </td>
                    </tr>
                    </table>
                    <h2>Боковое меню</h2>
					<ul>
						<li><a href="ProductController?category=Plan">Training plan</a></li>
						<li><a href="ProductController?category=Meal">Meal Plan</a></li>
						<li><a href="ProductController?category=Online">Online personal workout</a></li>
						<li><a href="RegistrationController">Регистрация</a></li>
						<li><a href="AuthController">Вход</a></li>
						<li><a href="CartController">Корзина</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
</div>
<div id="footer">
	<p>Copyright (c) 2021</p>
</div>
<!-- end #footer -->
</body>
<script>
	function sum(id,data){
	var val1= document.getElementById(id).value;
		if((+val1 + +data) > 0){
		document.getElementById(id).value = +document.getElementById(id).value + +data;
		}
	}
	
	function sendParamChange(id,prodId){
		var val1=document.getElementById(id).value;
		$.ajax({
		url: 'CartController', /* Куда пойдет запрос */
		method: 'post', /* Метод передачи (post или get) */
		data: "change=" + prodId + "&quntity=" + +val1	 , /* Параметры передаваемые в запросе. */
		success: function(data){ /* функция которая будет выполнена после успешного запроса. */
		document.getElementById("cartSize").innerHTML=data; /* В переменной data содержится ответ от index.php. */
		}})
	}
	
	function sendParam(id,prodId){
		var val1=document.getElementById(id).value;
		$.ajax({
		url: 'CartController', /* Куда пойдет запрос */
		method: 'post', /* Метод передачи (post или get) */
		data: "buy=" + prodId + "&quntity=" + +val1	 , /* Параметры передаваемые в запросе. */
		success: function(data){ /* функция которая будет выполнена после успешного запроса. */
		document.getElementById("cartSize").innerHTML=data;
		 /* В переменной data содержится ответ от index.php. */
		}})
	}
</script>
</html>


