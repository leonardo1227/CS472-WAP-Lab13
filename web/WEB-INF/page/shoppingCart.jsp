<%--
  Created by IntelliJ IDEA.
  User: Leonardo Samuel T C
  Date: 7/12/2018
  Time: 10:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
        <a href="products" title="Home">
            <img src="<c:url value='/resource/icon/home.png'/> "/>
        </a>
        <a href="shoppingCart" title="Shopping Cart">
            <img src="<c:url value='/resource/icon/shopping-cart.png'/> ">
        </a>

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

    <c:choose>
        <c:when test="${shoppingCart!=null && shoppingCart.items!=null && fn:length(shoppingCart.items)>0}">
            <div id="shoppingCartLinks">
                <a id="checkoutLink" href="checkout" title="Checkout">
                    <img src="<c:url value='/resource/icon/checkout.png'/>" alt="<c:out value='Checkout'/>">
                </a>
            </div>
            <table id="itemList">
                <tr>
                    <th class="rowItemList" width="50%"><c:out value="Product"/></th>
                    <th class="rowItemList" width="10%"><c:out value="Quantity"/></th>
                    <th class="rowItemList" width="15%"><c:out value="Unit Price"/></th>
                    <th class="rowItemList" width="15%"><c:out value="Total Price"/></th>
                    <th class="rowItemList" width="10%"><c:out value="Action"/></th>
                </tr>
                <c:forEach items="${shoppingCart.items}" var="item">
                    <tr>
                        <td class="rowItemList"><c:out value="${item.product.description}"/></td>
                        <td class="rowItemList numberCellItemList"><c:out value="${item.quantity}"/></td>
                        <td class="rowItemList priceCellItemList"><c:out value="$ ${item.product.price}"/></td>
                        <td class="rowItemList priceCellItemList"><c:out value="$ ${item.totalPrice}"/></td>
                        <td class="rowItemList actionCellItemList">
                            <form method="post" action="removeShoppingCart">
                                <button type="submit" name="removeButton" value="${item.id}">Remove</button>
                            </form>
                        </td>

                    </tr>
                </c:forEach>
                <tr>
                    <th colspan="2"><c:out value="Total Price"/></th>
                    <td colspan="2" class="priceCellItemList"><c:out value="$ ${shoppingCart.totalPrice}"/></td>
                </tr>
            </table>
        </c:when>
        <c:otherwise>
            <h2 id="emptyShoppingCartMsg"><c:out value="There is not any item in your Shopping Cart!"/></h2>
        </c:otherwise>

    </c:choose>


</div>

</body>
</html>
