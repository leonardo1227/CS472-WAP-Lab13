<%--
  Created by IntelliJ IDEA.
  User: Leonardo Samuel T C
  Date: 7/13/2018
  Time: 12:14 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="<c:url value='/resource/css/styles.css'/>" rel="stylesheet"/>
    <title>CONFIRMATION ORDER</title>
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
    <h2><c:out value="Order Successfuly Completed"/></h2>
    <p><c:out
            value="Thank you ${userLogged.name} for shopping with us! Complete information about your order following:"/></p>
    <div>
        <fieldset>
            <legend>Shipping Address</legend>
            <div><label><c:out value="Line1: ${order.shippingAddress.addressLine1}"/></label></div>
            <div><label><c:out value="Line2: ${order.shippingAddress.addressLine2}"/></label></div>
            <div><label><c:out value="City: ${order.shippingAddress.city}"/></label></div>
            <div><label><c:out value="State: ${order.shippingAddress.state}"/></label></div>
            <div><label><c:out value="Zipcode: ${order.shippingAddress.zipcode}"/></label></div>
        </fieldset>
    </div>
    <div>
        <fieldset>
            <legend>Billing Address</legend>
            <div><label><c:out value="Line1: ${order.billingAddress.addressLine1}"/></label></div>
            <div><label><c:out value="Line2: ${order.billingAddress.addressLine2}"/></label></div>
            <div><label><c:out value="City: ${order.billingAddress.city}"/></label></div>
            <div><label><c:out value="State: ${order.billingAddress.state}"/></label></div>
            <div><label><c:out value="Zipcode: ${order.billingAddress.zipcode}"/></label></div>
        </fieldset>
    </div>
    <div>
        <fieldset>
            <legend>Payment</legend>
            <div><label><c:out value="Card Number: ${order.payment.cardNumber}"/></label></div>
            <div><label><c:out value="Card CVC: ${order.payment.cardCVC}"/></label></div>
            <div><label><c:out value="Card Due Date: ${order.payment.cardDueDate}"/></label></div>
            <div><label><c:out value="Card Name Holder: ${order.payment.cardHolderName}"/></label></div>
            <div><label><c:out value="Card Type: ${order.payment.cardType}"/></label></div>
        </fieldset>
    </div>

    <div>
        <table id="itemList">
            <tr>
                <th class="rowItemList" width="60%"><c:out value="Product"/></th>
                <th class="rowItemList" width="10%"><c:out value="Quantity"/></th>
                <th class="rowItemList" width="15%"><c:out value="Unit Price"/></th>
                <th class="rowItemList" width="15%"><c:out value="Total Price"/></th>
            </tr>
            <c:forEach items="${order.shoppingCart.items}" var="item">
                <tr>
                    <td class="rowItemList"><c:out value="${item.product.description}"/></td>
                    <td class="rowItemList numberCellItemList"><c:out value="${item.quantity}"/></td>
                    <td class="rowItemList priceCellItemList"><c:out value="$ ${item.product.price}"/></td>
                    <td class="rowItemList priceCellItemList"><c:out value="$ ${item.totalPrice}"/></td>
                </tr>
            </c:forEach>
            <tr>
                <th colspan="2"><c:out value="Total Price"/></th>
                <td colspan="2" class="priceCellItemList"><c:out value="${order.shoppingCart.totalPrice}"/></td>
            </tr>
        </table>
    </div>

</div>

</body>
</html>
