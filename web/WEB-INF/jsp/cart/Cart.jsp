<%@ include file="../common/IncludeTop.jsp" %>

<div id="BackLink">
    <a href="main">
        Return to Main Menu
    </a>
</div>

<div id="Catalog">
    <div id="Cart">
        <h2>Shopping Cart</h2>
        <form action="updatecartquantities" method="post">
            <table>
                <tr>
                    <th><b>Item ID</b></th>
                    <th><b>Product ID</b></th>
                    <th><b>Description</b></th>
                    <th><b>In Stock?</b></th>
                    <th><b>Quantity</b></th>
                    <th><b>List Price</b></th>
                    <th><b>Total Cost</b></th>

                </tr>
                <c:if test="${sessionScope.cart.numberOfItems == 0}">
                    <tr>
                        <td colspan="8"><b>Your cart is empty.</b></td>
                    </tr>
                </c:if>
                <c:forEach var="cartItem" items="${sessionScope.cart.cartItems}">
                    <tr>
                        <td>
                            <a href="vitem?itemId=${cartItem.item.itemId}&account=${sessionScope.account}">
                                    ${cartItem.item.itemId}
                            </a>
                        </td>
                        <td>
                                ${cartItem.item.product.productId}
                        </td>
                        <td>
                                ${cartItem.item.attribute1} ${cartItem.item.attribute2}
                                ${cartItem.item.attribute3} ${cartItem.item.attribute4}
                                ${cartItem.item.attribute5} ${cartItem.item.product.name}
                        </td>
                        <td>${cartItem.inStock}</td>
                        <td>
                            <input id="quantity" type="text" name="${cartItem.item.itemId}"
                                   value="${cartItem.quantity}"/>
                        </td>
                        <td>
                            <fmt:formatNumber value="${cartItem.item.listPrice}" pattern="$#,##0.00"/>
                        </td>
                        <td>
                            <fmt:formatNumber value="${cartItem.total}" pattern="$#,##0.00"/>
                        </td>
                        <td>
                            <a id="Remove" class="Button" name="remove"
                               href="removeitemfromcart?workingItemId=${cartItem.item.itemId}&account=${sessionScope.account}">
                                Remove
                            </a>
                        </td>
                    </tr>
                </c:forEach>
                <tr>
                    <td colspan="7">Sub Total:<fmt:formatNumber value="${sessionScope.cart.subTotal}"
                                                                pattern="$#,##0.00"/>
                    </td>
                </tr>
            </table>
        </form>


        <c:if test="${sessionScope.cart.numberOfItems > 0}">

            <a class="Button" href="neworderform?cart=${sessionScope.cart}&account=${sessionScope.account}">
                Proceed to Checkout
            </a>
        </c:if>
    </div>
    <script src="js/Carts.js"></script>
    <div id="Separator">&nbsp;</div>
</div>


<%@ include file="../common/IncludeBottom.jsp" %>