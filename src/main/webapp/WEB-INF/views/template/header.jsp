<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <%-- common.css import --%>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/common.css" />
    <%-- doo.css import --%>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/doo.css" />
    
    <!-- 뷰(vue) js import -->
    <script src="${pageContext.request.contextPath}\node_modules\vue\dist\vue.global.js"></script>
    <!-- 부트스트랩(bootstrap) css import -->
    <link href="${pageContext.request.contextPath}/node_modules/bootstrap/dist/css/bootstrap.css" rel="stylesheet">
    <!-- Axios import -->
    <script src="${pageContext.request.contextPath}/node_modules/axios/dist/axios.min.js"></script>
</head>
<body>
<div id="body-app">
    <div class="row temp-header">
        <div class="col">
            <button class="btn btn-secondary">
                <a class="no-de-a" href="${pageContext.request.contextPath}/">홈으로</a>
            </button>
            <button class="btn btn-secondary">
                <a class="no-de-a" href="${pageContext.request.contextPath}/dev/home">개발테스트 페이지로</a>
            </button>
            <button class="btn btn-secondary">
                <a class="no-de-a" href="${pageContext.request.contextPath}/user/">유저 페이지로</a>
            </button>
            <button class="ms-auto btn btn-secondary">
                <a class="no-de-a" href="${pageContext.request.contextPath}/user/">로그인</a>
            </button>
            
        </div>
    </div>