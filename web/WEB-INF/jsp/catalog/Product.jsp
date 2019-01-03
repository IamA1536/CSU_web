<%@ include file="../common/IncludeTop.jsp" %>


<div id="BackLink">
    <a href="vcategory?categoryId = ${sessionScope.product.categoryId}&account=${sessionScope.account}">Return
        to ${sessionScope.product.categoryId}</a>
</div>

<div id="Catalog">

    <h2>${sessionScope.product.name}</h2>

    <table>
        <tr>
            <th>Item ID</th>
            <th>Product ID</th>
            <th>Description</th>
            <th>List Price</th>
            <th>&nbsp;</th>
        </tr>
        <c:forEach var="item" items="${sessionScope.itemList}">
            <tr>
                <td>
                    <a class="button" id="product">${item.itemId}</a>
                        <%--href="vitem?itemId=${item.itemId}&productId=${item.product.productId}&account=${sessionScope.account}">--%>


                </td>
                <td>
                        ${item.product.productId}
                </td>
                <td>${item.attribute1} ${item.attribute2} ${item.attribute3}
                        ${item.attribute4} ${item.attribute5} ${sessionScope.product.name}
                </td>
                <td><fmt:formatNumber value="${item.listPrice}"
                                      pattern="$#,##0.00"/>
                </td>
                <td>
                    <a class="Button" href="AddItemToCart?workingItemId=${item.itemId}&account=${sessionScope.account}">
                        Add to Cart</a>
                </td>
            </tr>
        </c:forEach>
        <c:forEach var="item" items="${sessionScope.itemList}">
            <div>
                <table id="choiceWindow" class=${item.itemId}>
                    <tr>
                        <td>${item.product.description}</td>
                    </tr>
                    <tr>
                        <td><b> ${item.itemId} </b></td>
                    </tr>
                    <tr>
                        <td>
                            <b><font size="4">
                                    ${item.attribute1}
                                    ${item.attribute2} ${item.attribute3}
                                    ${item.attribute4} ${item.attribute5}
                                    ${sessionScope.product.name}
                            </font>
                            </b>
                        </td>
                    </tr>
                    <tr>
                        <td>${item.product.name}</td>
                    </tr>
                    <tr>
                        <td>
                            <c:if test="${item.quantity <= 0}">
                                Back ordered.
                            </c:if>
                            <c:if test="${item.quantity > 0}">
                                ${item.quantity} in stock.
                            </c:if>
                        </td>
                    </tr>
                    <tr>
                        <td><fmt:formatNumber value="${item.listPrice}" pattern="$#,##0.00"/></td>
                    </tr>
                </table>
            </div>
            <div id="backGround"></div>
        </c:forEach>
    </table>
    <script src="js/Product.js"></script>
</div>

<%@ include file="../common/IncludeBottom.jsp" %>



