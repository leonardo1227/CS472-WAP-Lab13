<%--
  Created by IntelliJ IDEA.
  User: Leonardo Samuel T C
  Date: 7/12/2018
  Time: 2:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="<c:url value='/resource/css/styles.css'/>" rel="stylesheet"/>
    <title>Products</title>
</head>
<body>

<div id="headerPage">
    <div>
        <c:out value="Hi, "/>
        <c:choose>
            <c:when test="${userLogged!=null}">
                <c:out value="${userLogged.name}!"/>
            </c:when>
            <c:otherwise>
                <c:out value="guest!"/>
            </c:otherwise>
        </c:choose>
        <c:out value="Welcome to LAB13th Store."/>
    </div>

    <div id="headerButtons">
        <a href="shoppingCart"/>ShoppingCart</a>
        <c:choose>
            <c:when test="${userLogged!=null}">
                <form method="post" action="logout">
                    <button type="submit">Logout</button>
                </form>

            </c:when>
            <c:otherwise>
                <a href="login"><button>Login</button></a>
            </c:otherwise>
        </c:choose>
    </div>

</div>

<div class="contentPage productsView">
    <c:forEach items="${productList}" var="product">
        <form method="post" action="addShoppingCart">
            <div class="product">
                <img src="lab13/${product.value.picture}"/>

                <div>
                    <c:out value="${product.value.description}"/>
                </div>
                <div>
                    <strong>
                        <c:out value="Price: $${product.value.price}"/>
                    </strong>
                </div>
                <div>
                    <label>Quantity:</label>
                    <select name="quantity">
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                        <option value="5">5</option>
                    </select>
                </div>
                <div>
                    <button type="submit" value="${product.value.id}" name="addButton">Add to Shopping Cart</button>
                </div>
            </div>
        </form>

    </c:forEach>
</div>
</body>
</html>
