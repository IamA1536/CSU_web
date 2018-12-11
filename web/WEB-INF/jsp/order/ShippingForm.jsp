<%@ include file="../common/IncludeTop.jsp" %>

<div id="Catalog">
    <form action="#" method="post">

        <table>
            <tr>
                <th colspan=2>Shipping Address</th>
            </tr>

            <tr>
                <td>First name:</td>
                <td><input type="text" name="shiptofirstName"/></td>
            </tr>
            <tr>
                <td>Last name:</td>
                <td><input type="text" name="shiptolastName"/></td>
            </tr>
            <tr>
                <td>Address 1:</td>
                <td><input type="text" size="40" name="shipaddress1"/></td>
            </tr>
            <tr>
                <td>Address 2:</td>
                <td><input type="text" size="40" name="shipaddress2"/></td>
            </tr>
            <tr>
                <td>City:</td>
                <td><input type="text" name="shipcity"/></td>
            </tr>
            <tr>
                <td>State:</td>
                <td><input type="text" size="4" name="shipstate"/></td>
            </tr>
            <tr>
                <td>Zip:</td>
                <td><input type="text" size="10" name="shipzip"/></td>
            </tr>
            <tr>
                <td>Country:</td>
                <td><input type="text" size="15" name="shipcountry"/></td>
            </tr>


        </table>

        <input type="submit" name="newOrder" value="Continue"/>

    </form>
</div>

<%@ include file="../common/IncludeBottom.jsp" %>