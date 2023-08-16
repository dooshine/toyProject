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
    <!-- <script src="${pageContext.request.contextPath}/static/node_modules/vue/dist/vue.global.js"></script> -->
    <!-- 부트스트랩(bootstrap) css import -->
    <!-- <link href="${pageContext.request.contextPath}/static/node_modules/bootstrap/dist/css/bootstrap.css" rel="stylesheet"> -->
    <!-- Axios import -->
    <!-- <script src="${pageContext.request.contextPath}/static/node_modules/axios/dist/axios.min.js"></script> -->

<!-- 테스트 import -->
<!-- <script src="/node_modules/test.js"></script> -->

    
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

    <div class="row">
        <h1>
            Dev import 테스트
            {{ text }}
        </h1>
    </div>

    <div class="row" id="inner-app">
        <h1>
            {{ text }}
        </h1>
    </div>

<script>
    // const innerApp = Vue.createApp({
    //     data() {
    //         return {
    //             text: "Oracle 테스트",
    //         };
    //     },
    //     computed: {

    //     },
    //     methods: {

    //     },
    //     watch: {

    //     },
    //     created(){
    //         console.log("안녕하세요")
    //     },
    // }).mount('#inner-app')
</script>
</div>

<script>
//   const app = Vue.createApp({
//     data() {
//       return {
//         text: "vueJS 시작",
//       };
//     },
//     computed: {

//     },
//     methods: {

//     },
//     watch: {

//     },
//     created(){
//       console.log("안녕하세요")
//     },
//   }).mount('#body-app')

</script>
<!-- 부트스트랩(bootstrap) js cdn import -->
<!-- <script src="${pageContext.request.contextPath}/static/node_modules/bootstrap/dist/js/bootstrap.js"></script> -->

<script src="${pageContext.request.contextPath}/js/test.js"></script>


</body>
</html>