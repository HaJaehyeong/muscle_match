<%--
  Created by IntelliJ IDEA.
  User: jaehyeong.ha
  Date: 2019-05-23
  Time: 17:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container">
        <a class="navbar-brand" href="#">
            <img src="static/img/muscle_match_logo3_white.png" height="30" alt="">
        </a>
        <div class="collapse navbar-collapse justify-content-center">
            <ul class="navbar-nav">
                <li class="nav-item active">
                    <a class="nav-link" href="#">${param.pageTitle}</a>
                </li>
            </ul>
        </div>
    </div>
</nav>