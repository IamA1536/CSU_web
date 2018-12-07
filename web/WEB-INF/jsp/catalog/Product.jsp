<%@ include file="../common/IncludeTop.jsp" %>


<div id="BackLink">
    <a href="vcategory?categoryId = ${sessionScope.product.categoryId}">Return to ${sessionScope.product.categoryId}</a>
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
                    <a href="vitem?itemId=${item.itemId}&productId=${item.product.productId}">${item.itemId}</a>
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
                    <a class="Button" href="#">Add to Cart</a>
                </td>
            </tr>
        </c:forEach>
        <tr>
            <td>
            </td>
        </tr>
    </table>

</div>

<%@ include file="../common/IncludeBottom.jsp" %>





