<%--
  Created by IntelliJ IDEA.
  User: IamA#1536
  Date: 2018/12/4
  Time: 21:13
  To change this template use File | Settings | File Templates.
--%>
<%@include file="../common/IncludeTop.jsp"%>

<div id="Welcome">
    <div id="WelcomeContent">
        Welcome to MyPetStore!
    </div>
</div>

<div id="Main">
    <div id="Sidebar">
        <div id="SidebarContent">
            <a href="vcategory?categoryId=FISH&account=${sessionScope.account}"><img src="img/fish_icon.gif" /></a>
            <br/> Saltwater, Freshwater <br/>
            <a href="vcategory?categoryId=DOGS&account=${sessionScope.account}"><img src="img/dogs_icon.gif" /></a>
            <br /> Various Breeds <br />
            <a href="vcategory?categoryId=CATS&account=${sessionScope.account}"><img src="img/cats_icon.gif" /></a>
            <br /> Various Breeds, Exotic Varieties <br />
            <a href="vcategory?categoryId=REPTILES&account=${sessionScope.account}"><img src="img/reptiles_icon.gif" /></a>
            <br /> Lizards, Turtles, Snakes <br />
            <a href="vcategory?categoryId=BIRDS&account=${sessionScope.account}"><img src="img/birds_icon.gif" /></a>
            <br /> Exotic Varieties
        </div>
    </div>

    <div id="MainImage">
        <div id="MainImageContent">
            <map name="estoremap">
                <area alt="Birds" coords="72,2,280,250" href="vcategory?categoryId=BIRDS&account=${sessionScope.account}" shape="rect" />
                <area alt="Fish" coords="2,180,72,250" href="vcategory?categoryId=FISH&account=${sessionScope.account}" shape="rect" />
                <area alt="Dogs" coords="60,250,130,320" href="vcategory?categoryId=DOGS&account=${sessionScope.account}" shape="rect" />
                <area alt="Reptiles" coords="140,270,210,340" href="vcategory?categoryId=REPTILES&account=${sessionScope.account}" shape="rect" />
                <area alt="Cats" coords="225,240,295,310" href="vcategory?categoryId=CATS&account=${sessionScope.account}" shape="rect" />
                <area alt="Birds" coords="280,180,350,250" href="vcategory?categoryId=BIRDS&account=${sessionScope.account}" shape="rect" />
            </map>
            <img height="355" src="img/splash.gif" align="middle" usemap="#estoremap" width="350" />
        </div>
    </div>
    <div id="Separator">&nbsp;</div>
</div>

<%@include file="../common/IncludeBottom.jsp"%>