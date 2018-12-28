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
                    <a class="button" id="btn" href="">
                        change to another one
                    </a>
                    <font color="red">${requestScope.imageMess}</font>
                    <br/>
                </td>
            </tr>
        </p>

        <input type="submit" name="signon" value="Login"/>
    </form>

    Need a user name and password?
    <a href="newaccountform">
        Register Now!
    </a>
</div>

<script src="js/LoginForm.js"></script>
<%--<script type="text/javascript">--%>
    <%--document.getElementById("btn").onclick = function () {--%>
        <%--// 获取img元素--%>
        <%--// 为了让浏览器发送请求到servlet, 所以一定要改变src--%>
        <%--document.getElementsByTagName("img")[0].src = "verifycode?time=" + new Date().getTime();--%>
    <%--};--%>
<%--</script>--%>

<%@ include file="../common/IncludeBottom.jsp" %>

