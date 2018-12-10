<%@ include file="../common/IncludeTop.jsp" %>

<div id="Catalog">
    <form action="#" method="post">
        <table>
            <tr>
                <th colspan=2>Payment Details</th>
            </tr>
            <tr>
                <td>Card Type:</td>
                <td>
                    <select name="order.cardType">
                        <option selected="selected" value="Visa">Visa</option>
                        <option value="MasterCard">MasterCard</option>
                        <option value="American Express">American Express</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Card Number:</td>
                <td><input name="order.creditCard" value="000 0000 0000 0000" type="text"> * Use a fake
                    number!
                </td>
            </tr>
            <tr>
                <td>Expiry Date (MM/YYYY):</td>
                <td><input name="order.expiryDate" value="12/03" type="text"></td>
            </tr>
            <tr>
                <th colspan=2>Billing Address</th>
            </tr>

            <tr>
                <td>First name:</td>
                <td><input type="text" name="order.billToFirstName" value="A"/></td>
            </tr>
            <tr>
                <td>Last name:</td>
                <td><input type="text" name="order.billToLastName" value="B"/></td>
            </tr>
            <tr>
                <td>Address 1:</td>
                <td><input type="text" size="40" name="order.billAddress1" value="CSU"/></td>
            </tr>
            <tr>
                <td>Address 2:</td>
                <td><input type="text" size="40" name="order.billAddress2" value="CSU"/></td>
            </tr>
            <tr>
                <td>City:</td>
                <td><input type="text" name="order.billCity" value="Changsha"/></td>
            </tr>
            <tr>
                <td>State:</td>
                <td><input type="text" size="4" name="order.billState" value="Hunan"/></td>
            </tr>
            <tr>
                <td>Zip:</td>
                <td><input type="text" size="10" name="order.billZip" value="421075"/></td>
            </tr>
            <tr>
                <td>Country:</td>
                <td><input type="text" size="15" name="order.billCountry" value="China"/></td>
            </tr>

            <tr>
                <td colspan=2><input type="checkbox" name="shippingAddressRequired" value="true"/>
                    Ship to different address...
                </td>
            </tr>

        </table>

        <input name="newOrder" value="Continue" type="submit">
    </form>
</div>

<%@ include file="../common/IncludeBottom.jsp" %>