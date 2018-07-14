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
    <form method="post" action="confirmationOrder">
        <div id="checkoutInformation">
            <div>
                <fieldset>
                    <legend><c:out value="Shipping Address"/></legend>
                    <div class="checkoutFieldsetDiv">
                        <div class="fieldCheckout">
                            <label><c:out value="Address Line 1:"/></label>
                            <input type="text" name="shippingAddressLine1" required size="50">
                        </div>
                        <div class="fieldCheckout">
                            <label><c:out value="Address Line 2:"/></label>
                            <input type="text" name="shippingAddressLine2" size="50">
                        </div>
                        <div class="fieldCheckout">
                            <label><c:out value="City:"/></label>
                            <input type="text" name="shippingCity" required>
                        </div>
                        <div class="fieldCheckout">
                            <label><c:out value="State:"/></label>
                            <input type="text" name="shippingState" required>
                        </div>
                        <div class="fieldCheckout">
                            <label><c:out value="Zipcode:"/></label>
                            <input type="text" name="shippingZipcode" required pattern="\d{5}" maxlength="5">
                        </div>
                    </div>
                </fieldset>
            </div>

            <div>
                <fieldset>
                    <legend><c:out value="Billing Address"/></legend>
                    <div class="checkoutFieldsetDiv">
                        <div class="fieldCheckout">
                            <label><c:out value="Address Line 1:"/></label>
                            <input type="text" name="billingAddressLine1" required size="50">
                        </div>
                        <div class="fieldCheckout">
                            <label><c:out value="Address Line 2:"/></label>
                            <input type="text" name="billingAddressLine2" size="50">
                        </div>
                        <div class="fieldCheckout">
                            <label><c:out value="City:"/></label>
                            <input type="text" name="billingCity" required>
                        </div>
                        <div class="fieldCheckout">
                            <label><c:out value="State:"/></label>
                            <input type="text" name="billingState" required>
                        </div>
                        <div class="fieldCheckout">
                            <label><c:out value="Zipcode:"/></label>
                            <input type="text" name="billingZipcode" required maxlength="5">
                        </div>
                    </div>
                </fieldset>
            </div>

            <div>
                <fieldset>
                    <legend><c:out value="Payment"/></legend>
                    <div class="checkoutFieldsetDiv">
                        <div class="fieldCheckout">
                            <label><c:out value="Card Number:"/></label>
                            <input type="text" name="cardNumber" required pattern="\d{16}" maxlength="16">
                        </div>
                        <div class="fieldCheckout">
                            <label><c:out value="Card CV Number:"/></label>
                            <input type="text" name="cardCVNumber" required pattern="\d{2,3}" maxlength="3">
                        </div>
                        <div class="fieldCheckout">
                            <label><c:out value="Card Due Date:"/></label>
                            <input type="text" name="cardDueDate" required pattern="^\d{2}\/\d{4}" maxlength="7">
                        </div>
                        <div class="fieldCheckout">
                            <label><c:out value="Card Holder Name:"/></label>
                            <input type="text" name="cardHolderName" required/>
                        </div>
                        <div class="fieldCheckout">
                            <label><c:out value="Card Type:"/></label>
                            <select name="cardType" required>
                                <option selected disabled>Select One</option>
                                <option value="Credit">Credit</option>
                                <option value="Debit">Debit</option>
                            </select>
                        </div>
                    </div>
                </fieldset>
            </div>

        </div>
        <div id="checkoutCommands">
            <button type="submit">Confirm</button>
        </div>
    </form>
</div>

</body>
</html>
