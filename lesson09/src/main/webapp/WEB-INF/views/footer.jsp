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
                   	В вашей корзине 
                   	${(sessionScope.productCartMapSize==null?"0":""+sessionScope.productCartMapSize)}
                   	товаров.
                </c:when>
                	<c:otherwise>
					 Вы не авторизировались.
					 В вашей корзине 
                   	${(sessionScope.productCartMapSize==null?"0":""+sessionScope.productCartMapSize)}
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
</html>
