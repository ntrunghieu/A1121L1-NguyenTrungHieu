<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 26/11/2022
  Time: 10:39 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../../../resources/bootstrap4.6.0/css/homeuser.css">
    <link href="node_modules/plugins/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <style>
        #search-box{
            position: absolute;
            background-color: #71cd14;
            border-radius: 30px;
            /*top: 23px;*/
            /*right: 65px;*/
            /*top: 60%;*/
            z-index: 50;
            top: 11%;
            right: 11%;
            position: fixed;
        }
        #search-box #search-text{
            border: none;
            outline: none;
            background: none;
            font-size: 18px;
            width: 0;
            padding: 0;
            transition: all 0.25s ease-in-out;
        }
        #search-box:hover #search-text, #search-box #search-text:valid{
            width: 150px;
            padding: 10px 0px 10px 15px;

        }
        #search-box #search-btn{
            background: #71cd14;
            cursor: pointer;
            border: none;
            /*padding: 15px;*/
            padding: 15px;
            border-radius: 50%;
            font-size: 15px;
        }
        /*search box end*/

    </style>
</head>
<body>
<form  action="/user" id="search-box">
    <input name="kw"  type="text" id="search-text" required style=" border-radius: 5px">
    <button type="submit" id="search-btn"><i class="fa fa-search" aria-hidden="true"></i></button>
</form>
<div class="container">
    <div class="info">
        <h1>Article News Card</h1><span>Made with <i class='fa fa-heart animated infinite pulse'></i> by <a href='http://andy.design'>Andy Tran</a> | Designed by <a href='http://justinkwak.com'>JustinKwak</a></span>
    </div>
    <!-- Normal Demo-->
    <c:forEach items="${listBook}" var="book" varStatus="status">
        <div class="column">
            <div class="demo-title">Sản phẩm</div>
            <!-- Post-->
            <div class="post-module">
                <!-- Thumbnail-->
                <div class="thumbnail">
                    <div class="date">
                        <div class="day">27</div>
                        <div class="month">Mar</div>
                    </div><img src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/169963/photo-1429043794791-eb8f26f44081.jpeg"/>
                </div>
                <!-- Post Content-->
                <div class="post-content">
                    <div class="category">${book.bookCategoryId.categoryName}</div>
                    <h1 class="title">${book.bookAuthor}</h1>
                    <h4 class="title">${book.bookName}</h4>
                    <h2 class="sub_title">${book.bookPublisher}</h2>
                    <p class="description">${book.bookContent}</p>
                    <div class="post-meta"><span class="timestamp"><i class="fa fa-clock-">o</i> 6 mins ago</span><span class="comments"><i class="fa fa-comments"></i><a href="#"> 39 comments</a></span></div>
                </div>
            </div>
        </div>
    </c:forEach>

    <!-- Hover Demo-->
<%--    <div class="column">--%>
<%--        <div class="demo-title">Hover</div>--%>
<%--        <!-- Post-->--%>
<%--        <div class="post-module hover">--%>
<%--            <!-- Thumbnail-->--%>
<%--            <div class="thumbnail">--%>
<%--                <div class="date">--%>
<%--                    <div class="day">27</div>--%>
<%--                    <div class="month">Mar</div>--%>
<%--                </div><img src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/169963/photo-1429043794791-eb8f26f44081.jpeg"/>--%>
<%--            </div>--%>
<%--            <!-- Post Content-->--%>
<%--            <div class="post-content">--%>
<%--                <div class="category">Photos</div>--%>
<%--                <h1 class="title">City Lights in New York</h1>--%>
<%--                <h2 class="sub_title">The city that never sleeps.</h2>--%>
<%--                <p class="description">New York, the largest city in the U.S., is an architectural marvel with plenty of historic monuments, magnificent buildings and countless dazzling skyscrapers.</p>--%>
<%--                <div class="post-meta"><span class="timestamp"><i class="fa fa-clock-o"></i> 6 mins ago</span><span class="comments"><i class="fa fa-comments"></i><a href="#"> 39 comments</a></span></div>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>
</div>

<script>

    $(window).load(function() {
        $('.post-module').hover(function() {
            $(this).find('.description').stop().animate({
                height: "toggle",
                opacity: "toggle"
            }, 300);
        });
    });
</script>
</body>
</html>
