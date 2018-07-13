<%--
  Created by IntelliJ IDEA.
  User: Leonardo Samuel T C
  Date: 7/12/2018
  Time: 11:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="<c:url value='/resource/css/styles.css'/>" rel="stylesheet"/>
    <title>CHECKOUT</title>
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
    <form method="post" action="confirmationOrder">
        <div>
            <div>
                <fieldset>
                    <legend><c:out value="Shipping Address"/></legend>
                    <div>
                        <label><c:out value="Address Line 1:"/></label>
                        <input type="text" name="shippingAddressLine1">
                    </div>
                    <div>
                        <label><c:out value="Address Line 2:"/></label>
                        <input type="text" name="shippingAddressLine2">
                    </div>
                    <div>
                        <label><c:out value="City:"/></label>
                        <input type="text" name="shippingCity">
                    </div>
                    <div>
                        <label><c:out value="State:"/></label>
                        <input type="text" name="shippingState">
                    </div>
                    <div>
                        <label><c:out value="Zipcode:"/></label>
                        <input type="text" name="shippingZipcode">
                    </div>
                </fieldset>
            </div>

            <div>
                <fieldset>
                    <legend><c:out value="Billing Address"/></legend>
                    <div>
                        <label><c:out value="Address Line 1:"/></label>
                        <input type="text" name="billingAddressLine1">
                    </div>
                    <div>
                        <label><c:out value="Address Line 2:"/></label>
                        <input type="text" name="billingAddressLine2">
                    </div>
                    <div>
                        <label><c:out value="City:"/></label>
                        <input type="text" name="billingCity">
                    </div>
                    <div>
                        <label><c:out value="State:"/></label>
                        <input type="text" name="billingState">
                    </div>
                    <div>
                        <label><c:out value="Zipcode:"/></label>
                        <input type="text" name="billingZipcode">
                    </div>
                </fieldset>
            </div>

            <div>
                <fieldset>
                    <legend><c:out value="Payment"/></legend>
                    <div>
                        <label><c:out value="Card Number:"/></label>
                        <input type="text" name="cardNumber">
                    </div>
                    <div>
                        <label><c:out value="Card Due Date:"/></label>
                        <input type="text" name="cardDueDate">
                    </div>
                    <div>
                        <label><c:out value="Card Holder Name:"/></label>
                        <input type="text" name="cardHolderName"/>
                    </div>
                </fieldset>
            </div>
            <div>
                <button type="submit">Confirm</button>
            </div>

        </div>
    </form>
</div>

</body>
</html>
