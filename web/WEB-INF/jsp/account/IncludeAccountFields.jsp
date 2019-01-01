<h3>Account Information</h3>

<table>
    <tr>
        <td>First name:</td>
        <td>
            <input type="text" name="firstName" value="${sessionScope.account.firstName}"/>
        </td>
        <td></td>
    </tr>
    <tr>
        <td>Last name:</td>
        <td><input type="text" name="lastName" value="${sessionScope.account.lastName}"/></td>
        <td></td>
    </tr>
    <tr>
        <td>Email*:</td>
        <td><input id="Email" type="text" size="40" name="email" value="${sessionScope.account.email}"/>
            <%--<font color="#FF0000">--%>
            <%--<small>--%>
            <%--<p id="EmailError"></p>--%>
            <%--</small>--%>
            <%--</font>--%>
        </td>
        <td>
            <font color="#FF0000">
                <small id="EmailError">
                    <%--<p id="EmailError"></p>--%>
                </small>
            </font>
        </td>
    </tr>
    <tr>
        <td>Phone:</td>
        <td><input type="text" name="phone" value="${sessionScope.account.phone}"/></td>
        <td></td>
    </tr>
    <tr>
        <td>Address 1:</td>
        <td><input type="text" size="40" name="address1" value="${sessionScope.account.address1}"/></td>
        <td></td>
    </tr>
    <tr>
        <td>Address 2:</td>
        <td><input type="text" size="40" name="address2" value="${sessionScope.account.address2}"/></td>
        <td></td>
    </tr>
    <tr>
        <td>City:</td>
        <td><input type="text" name="city" value="${sessionScope.account.city}"/></td>
        <td></td>
    </tr>
    <tr>
        <td>State:</td>
        <td><input type="text" size="4" name="state" value="${sessionScope.account.state}"/></td>
        <td></td>
    </tr>
    <tr>
        <td>Zip:</td>
        <td><input type="text" size="10" name="zip" value="${sessionScope.account.zip}"/></td>
        <td></td>
    </tr>
    <tr>
        <td>Country:</td>
        <td>
            <input type="text" size="15" name="country" value="${sessionScope.account.country}"/>
        </td>
        <td></td>
    </tr>
</table>

<h3>Profile Information</h3>

<table>
    <tr>
        <td>Language Preference:</td>
        <td>
            <select name="languagePreference">
                <option value="">${sessionScope.account.languagePreference}</option>
                <option value="English">English</option>
                <option value="中文">中文</option>
                <%--<option value="日本語">日本語</option>--%>
                <%--<option value="русский язык">русский язык</option>--%>
                <%--<option value="????">????</option>--%>
                <option value="Deutsch">Deutsch</option>
                <%--<option value="Fran?ais">Fran?ais</option>--%>
                <%--<option value="???.">???.</option>--%>
            </select>
        </td>
    </tr>
    <tr>
        <td>Favourite Category:</td>
        <td>
            <select name="favouriteCategoryId">
                <option selected="selected" value="${sessionScope.account.favouriteCategoryId}"></option>
                <option value="FISH">FISH</option>
                <option value="REPTILES">REPTILES</option>
                <option value="CATS">CATS</option>
                <option value="BIRDS">BIRDS</option>
            </select>
        </td>
    </tr>

    <tr>
        <td>Enable MyList</td>
        <td>
            <c:if test="${sessionScope.account.listOption != null}">
                <input type="checkbox" name="listoption" value="1"/>
            </c:if>
            <c:if test="!${sessionScope.account.listOption == null}">
                <input type="checkbox" name="listoption" value="0"/>
            </c:if>
        </td>
    </tr>
    <tr>
        <td>Enable MyBanner</td>
        <td>
            <c:if test="${sessionScope.account.bannerOption != null}">
                <input type="checkbox" name="banneroption" value="true"/>
            </c:if>
            <c:if test="!${sessionScope.account.bannerOption == null}">
                <input type="checkbox" name="banneroption" value="true"/>
            </c:if>
        </td>
    </tr>

</table>
