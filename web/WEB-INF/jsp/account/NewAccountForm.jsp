<%@ include file="../common/IncludeTop.jsp" %>

<div id="Catalog">
    <form action="newaccountform" method="post">
        <h3>User Information</h3>
        <table>
            <tr>
                <td>User ID*:</td>
                <td><input id="UserName" type="text" name="username"/></td>
            </tr>
            <tr>
                <td>New password*:</td>
                <td><input id="Pw" type="password" name="password"/></td>
            </tr>
            <tr>
                <td>Repeat password*:</td>
                <td><input id="RepeatPw" type="password"/></td>
            </tr>
        </table>
        <%@ include file="IncludeAccountFields.jsp" %>
        <tr>
            <td>
                <small>* is required</small>
            </td>
        </tr>
        <font color="#FF0000">
            <small>
                <p id="Error">

                </p>
            </small>
        </font>
        <input id="SubNew" type="submit" name="newAccount" value="Save Account Information" style="visibility: hidden"/>
        <script src="js/SignForm.js"></script>
    </form>

</div>

<%@ include file="../common/IncludeBottom.jsp" %>