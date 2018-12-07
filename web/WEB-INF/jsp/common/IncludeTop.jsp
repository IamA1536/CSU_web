<%--
  Created by IntelliJ IDEA.
  User: IamA#1536
  Date: 2018/12/4
  Time: 21:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <link rel="StyleSheet" href="css/jpetstore.css" type="text/css"
          media="screen"/>

    <meta name="generator"
          content="HTML Tidy for Linux/x86 (vers 1st November 2002), see www.w3.org"/>
    <title>JPetStore Demo</title>
    <meta content="text/html; charset=windows-1252"
          http-equiv="Content-Type"/>
    <meta http-equiv="Cache-Control" content="max-age=0"/>
    <meta http-equiv="Cache-Control" content="no-cache"/>
    <meta http-equiv="expires" content="0"/>
    <meta http-equiv="Expires" content="Tue, 01 Jan 1980 1:00:00 GMT"/>
    <meta http-equiv="Pragma" content="no-cache"/>
</head>

<body>

<div id="Header">

    <div id="Logo">
        <div id="LogoContent">
            <a href="main"><img src="img/logo-topbar.gif"/></a>
        </div>
    </div>

    <div id="Menu">
        <div id="MenuContent">
            <a href="vcart"><img align="middle" name="img_cart" src="img/cart.gif"/></a>
            <img align="middle" src="img/separator.gif"/>
            <a href="../account/SignonForm.html">Sign In</a>
            <a href="#">Sign Out</a>
            <img align="middle" src="img/separator.gif"/>
            <a href="#">My Account</a>
            <img align="middle" src="img/separator.gif"/>
            <a href="../../../help.html">?</a>
        </div>
    </div>

    <div id="Search">
        <div id="SearchContent">
            <form action="search" method="post">
                <input type="text" name="keyword" size="14"/>
                <input type="submit" name="searchProducts" value="Search"/>
            </form>
        </div>
    </div>

    <div id="QuickLinks">
        <a href="vcategory?categoryId=FISH"><img src="img/sm_fish.gif"/></a>
        <img src="img/separator.gif"/>
        <a href="vcategory?categoryId=DOGS"><img src="img/sm_dogs.gif"/></a>
        <img src="img/separator.gif"/>
        <a href="vcategory?categoryId=REPTILES"><img src="img/sm_reptiles.gif"/></a>
        <img src="img/separator.gif"/>
        <a href="vcategory?categoryId=CATS"><img src="img/sm_cats.gif"/></a>
        <img src="img/separator.gif"/>
        <a href="vcategory?categoryId=BIRDS"><img src="img/sm_birds.gif"/></a>
    </div>

</div>

<div id="Content">