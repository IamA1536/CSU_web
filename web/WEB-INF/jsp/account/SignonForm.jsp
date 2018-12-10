<%@ include file="../common/IncludeTop.jsp" %>

<div id="Catalog">
    <form action="signonform" method="post">


        <p>Please enter your username and password.</p>
        <p>
            Username:<input type="text" name="username" value="IamA"><br/>
            Password:<input type="password" name="password" value="">
        </p>

        <input type="submit" name="signon" value="Login"/>
    </form>

    Need a user name and password?
    <a href="../account/NewAccountForm.jsp">
        Register Now!
    </a>
</div>

<%@ include file="../common/IncludeBottom.jsp" %>

