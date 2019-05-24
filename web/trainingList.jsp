<%--
  Created by IntelliJ IDEA.
  User: jaehyeong.ha
  Date: 2019-05-23
  Time: 15:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="pageTitle" value="Trainings"/>
<html>
<head>
    <title>${pageTitle} | Muscle 💪 Match</title>
</head>
<jsp:include page="common/insertStyleSheets.jsp"/>
<body>

<c:import url="common/navbar.jsp">
    <c:param name="pageTitle" value="${pageTitle}"/>
</c:import>

<div class="container">
    <form class="form-inline">
        <label class="sr-only" for="inlineFormInputName2">Name</label>
        <input type="text" class="form-control mb-2 mr-sm-2" id="inlineFormInputName2" placeholder="Jane Doe">

        <label class="sr-only" for="inlineFormInputGroupUsername2">Username</label>
        <div class="input-group mb-2 mr-sm-2">
            <div class="input-group-prepend">
                <div class="input-group-text">@</div>
            </div>
            <input type="text" class="form-control" id="inlineFormInputGroupUsername2" placeholder="Username">
        </div>

        <div class="form-check mb-2 mr-sm-2">
            <input class="form-check-input" type="checkbox" id="inlineFormCheck">
            <label class="form-check-label" for="inlineFormCheck">
                Remember me
            </label>
        </div>

        <button type="submit" class="btn btn-primary mb-2">Submit</button>
    </form>
    <table class="table">
        <tbody>
        <tr>
            <td>胸</td>
            <td>2019/5/23</td>
            <td>渋谷</td>
            <td>
                <a href="/mm/profileController?trainee_id=2">TICH(id:2)</a>
            </td>
            <td>
                <a class="btn btn-primary" href="/mm/trainingController?action=join" role="button">JOIN</a>
            </td>
        </tr>
        <tr>
            <td>胸</td>
            <td>2019/5/23</td>
            <td>渋谷</td>
            <td>
                <a href="/mm/profileController?trainee_id=3">KINSYO(id:3)</a>
            </td>
            <td>
                <a class="btn btn btn-success" href="/mm/trainingController?action=cancel" role="button">JOINED</a>
            </td>
        </tr>
        <tr>
            <td>胸</td>
            <td>2019/5/23</td>
            <td>渋谷</td>
            <td>
                <a href="/mm/profileController?trainee_id=4">TENMA(id:4)</a>
            </td>
            <td>ボタン</td>
        </tbody>
    </table>
</div>

<jsp:include page="common/insertScripts.jsp"/>

</body>
</html>
