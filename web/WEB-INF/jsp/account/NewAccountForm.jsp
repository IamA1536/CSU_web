<%@ include file="../common/IncludeTop.jsp" %>

<div id="Catalog">
    <form action="newaccountform" method="post">
        <h3>User Information</h3>
        <table>
            <tr>
                <td>User ID*:</td>
                <td><input id="UserName" type="text" name="username"/>
                </td>
                <td style="">
                    <font color="#FF0000">
                        <small id="UserError">
                        </small>
                    </font>
                </td>
            </tr>
            <tr>
                <td>New password*:</td>
                <td><input id="Pw" type="password" name="password"/>
                </td>
                <td>
                    <font color="#FF0000">
                        <small id="PwError">
                        </small>
                    </font>
                </td>
            </tr>
            <tr>
                <td>Repeat password*:</td>
                <td><input id="RepeatPw" type="password"/>
                </td>
                <td>
                    <font color="#FF0000">
                        <small id="RepeatPwError">
                        </small>
                    </font>
                </td>
            </tr>
        </table>
        <%@ include file="IncludeAccountFields.jsp" %>
        <tr>
            <td>
                <div id="warning" class="ui-state-highlight ui-corner-all" style="margin-top: 20px; padding: 0 .7em;">
                    <p>
                        <span class="ui-icon ui-icon-info" style="float: left; margin-right: .3em;"></span>
                        <strong>*</strong> is required
                    </p>
                </div>

            </td>
        </tr>

        <input id="SubNew" type="submit" name="newAccount" value="Save Account Information" style="visibility: hidden"/>
        <script src="js/SignForm.js"></script>
    </form>

</div>

<%@ include file="../common/IncludeBottom.jsp" %>