<%--
  Created by IntelliJ IDEA.
  User: IamA#1536
  Date: 2018/12/4
  Time: 21:10
  To change this template use File | Settings | File Templates.
--%>
</div>

<div id="Footer">

    <div id="PoweredBy">&nbsp<a href="www.csu.edu.cn">www.csu.edu.cn</a>
    </div>

    <div id="Banner">
        <c:if test="${sessionScope.account != null }">
                <c:if test="${sessionScope.account.bannerOption}">
                    ${sessionScope.account.bannerName}
                </c:if>
        </c:if>
    </div>

</div>

</body>
</html>
