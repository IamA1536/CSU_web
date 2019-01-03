<%@ include file="../common/IncludeTop.jsp" %>

<div id="Catalog">
    <form action="signonform" method="post">
        <p>Please enter your username and password.</p>
        <p>
            <tr>
                <td>
                    Username:<input type="text" name="username" value=""><br/>
                </td>
                <td>
                    Password:<input type="password" name="password" value=""><br/>
                </td>
                <td>
                    VerifyCode:<input type="text" name="image">
                    <br/>
                    <%--<img src="img/vc.gif">--%>
                    <img src="verifycode">
                    <%--<br/>--%>
                    <a id="btn" href="">
                        <small>change to another one</small>
                    </a>
                    <font color="red">${requestScope.imageMess}</font>
                    <br/>
                </td>
            </tr>
        </p>

        <input type="submit" name="signon" value="Login"/>
    </form>

    Need a username and password?
    <a href="newaccountform">
        Register Now!
    </a>
</div>

<script src="js/LoginForm.js"></script>

<%@ include file="../common/IncludeBottom.jsp" %>

