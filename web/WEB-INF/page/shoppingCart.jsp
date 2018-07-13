<%--
  Created by IntelliJ IDEA.
  User: Leonardo Samuel T C
  Date: 7/12/2018
  Time: 10:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="<c:url value='/resource/css/styles.css'/>" rel="stylesheet"/>
    <title>Shopping Cart</title>
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
                <a href="login">
                    <button>Login</button>
                </a>
            </c:otherwise>
        </c:choose>
    </div>
</div>

<div class="contentPage">
    <div>
        <a href="checkout">CHECKOUT</a>
    </div>
    <table id="itemList">
        <tr>
            <th><c:out value="Product"/></th>
            <th><c:out value="Quantity"/></th>
            <th><c:out value="Total Price"/></th>
            <th><c:out value="Action"/></th>
        </tr>
        <c:forEach items="${shoppingCart.items}" var="item">
            <tr>
                <td><c:out value="${item.product.description}"/></td>
                <td><c:out value="${item.quantity}"/></td>
                <td><c:out value="${item.totalPrice}"/></td>
                <td>
                    <form method="post" action="removeShoppingCart">
                        <button type="submit" name="removeButton" value="${item.id}">Remove</button>
                    </form>
                </td>

            </tr>
        </c:forEach>
        <tr>
            <th colspan="2"><c:out value="Total Price"/></th>
            <td colspan="2"><c:out value="${shoppingCart.totalPrice}"/></td>
        </tr>

    </table>

</div>

</body>
</html>
