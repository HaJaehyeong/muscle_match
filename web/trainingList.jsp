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
    <form class="form-row">
        <div class="form-group col-md-3">
            <label class="sr-only" for="inlineFormInputPart">Name</label>
            <select class="form-control mb-2 mr-sm-2" id="inlineFormInputPart" placeholder="部位">
                <option selected>部位</option>
                <option>1</option>
                <option>2</option>
                <option>3</option>
                <option>4</option>
                <option>5</option>
            </select>
        </div>
        <div class="form-group col-md-3">
            <label class="sr-only" for="inlineFormInputDate">Date</label>
            <select class="form-control mb-2 mr-sm-2" id="inlineFormInputDate" placeholder="日時">
                <option selected>日時</option>
                <option>1</option>
                <option>2</option>
                <option>3</option>
                <option>4</option>
                <option>5</option>
            </select>
        </div>
        <div class="form-group col-md-3">
            <label class="sr-only" for="inlineFormInputPlace">Place</label>
            <select class="form-control mb-2 mr-sm-2" id="inlineFormInputPlace" placeholder="場所">
                <option selected>場所</option>
                <option>1</option>
                <option>2</option>
                <option>3</option>
                <option>4</option>
                <option>5</option>
            </select>
        </div>
        <div class="form-group col-md-3">
            <button type="submit" class="btn btn-primary mb-2">Submit</button>
        </div>
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
                <a class="btn btn-primary" href="/mm/trainingController?action=join&training_id=11&trainee_id=1" role="button">JOIN</a>
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
                <a class="btn btn btn-success" href="/mm/trainingController?action=cancel&training_id=11&trainee_id=1" role="button">JOINED</a>
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
