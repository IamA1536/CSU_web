<%@ include file="../common/IncludeTop.jsp" %>

<div id="BackLink">
    <a href="main">
        Return to Main Menu
    </a>
</div>

<div id="Catalog">
    <table>
        <tr>
            <th>&nbsp;</th>
            <th>Product ID</th>
            <th>Name</th>
        </tr>
        <c:forEach var="product" items="${sessionScope.productList}">
            <tr>
                <td>
                    <a href="vproduct?productId=${product.productId}&account=${sessionScope.account}">
                            ${product.description}
                    </a>
                </td>
                <td>
                    <a href="vproduct?productId=${product.productId}&account=${sessionScope.account}">
                        <font color="BLACK"> ${product.productId} </font>
                    </a>
                </td>
                <td>${product.name}</td>
            </tr>
        </c:forEach>
        <tr>
            <td></td>
        </tr>
    </table>

</div>

<%@ include file="../common/IncludeBottom.jsp" %>




