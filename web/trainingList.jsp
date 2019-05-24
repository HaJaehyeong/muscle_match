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
    <table class="table">
        <tbody>
        <tr>
            <td>胸</td>
            <td>2019/5/23</td>
            <td>渋谷</td>
            <td>キンジー</td>
            <td>ボタン</td>
        </tr>
        <tr>
            <td>胸</td>
            <td>2019/5/23</td>
            <td>渋谷</td>
            <td>キンジー</td>
            <td>ボタン</td>
        </tr>
        <tr>
            <td>胸</td>
            <td>2019/5/23</td>
            <td>渋谷</td>
            <td>キンジー</td>
            <td>ボタン</td>
        </tr>
        </tbody>
    </table>
</div>

<jsp:include page="common/insertScripts.jsp"/>

</body>
</html>
