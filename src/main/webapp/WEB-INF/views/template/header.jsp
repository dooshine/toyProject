<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <style>
        .temp-header {
            background-color: forestgreen;
        }
        * {
            box-sizing: border-box;
        }
    </style>
    <!-- 뷰(vue) js import -->
    <script src="${pageContext.request.contextPath}node_modules\vue\dist\vue.global.js"></script>
    //C:\Users\Doo\Desktop\toyProject\src\main\resources\static\node_modules\vue\dist\vue.global.js
    <!-- 부트스트랩(bootstrap) css import -->
    <link href="${pageContext.request.contextPath}/node_modules/bootstrap/dist/css/bootstrap.css" rel="stylesheet">
    <!-- Axios import -->
    <script src="${pageContext.request.contextPath}/node_modules/axios/dist/axios.min.js"></script>
</head>
<body>
<div id="body-app">
    <div class="row temp-header">
        <button>
            <a href="${pageContext.request.contextPath}/">홈으로</a>
        </button>
        <button>
            <a href="${pageContext.request.contextPath}dev/home">개발테스트 페이지로</a>
        </button>
    </div>