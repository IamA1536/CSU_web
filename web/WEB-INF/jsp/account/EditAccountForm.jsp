<%@ include file="../common/IncludeTop.jsp" %>

<div id="Catalog">
    <form action="editaccountform" method="post">
        <h3>User Information</h3>
        <table>
            <tr>
                <td>User ID:</td>
                <td>${sessionScope.account.username}</td>
            </tr>
            <tr>
                <td>New password:</td>
                <td><input id="Pw" type="password" name="password"/></td>
            </tr>
            <tr>
                <td>Repeat password:</td>
                <td><input id="RePw" type="password" name="repeatedPassword"/></td>
            </tr>
            <p id="Error"></p>
        </table>
        <%@ include file="IncludeAccountFields.jsp" %>
        <input id="Sub" type="submit" name="editAccount" value="Save Account Information"/>
    </form>
    <a href="listorders?account=${sessionScope.account}">My Orders</a>
</div>
<script src="js/EditAccount.js"></script>
<%@ include file="../common/IncludeBottom.jsp" %>
