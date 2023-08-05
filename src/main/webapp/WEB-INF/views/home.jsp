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
    </style>
</head>
<body>
    <div id="app">
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
                홈 화면
                {{ text }}
            </h1>
            <img src="kakao.png" alt="Kakao Image">
        </div>
    </div>

    <script src="${pageContext.request.contextPath}/node_modules/vue/dist/vue.global.js"></script>

    <script>
        const app = Vue.createApp({
            data() {
                return {
                    text: "vueJS 시작",
                };
            },
            computed: {

            },
            methods: {

            },
            watch: {

            },
            created(){
                console.log("안녕하세요")
            },
        }).mount('#app')

    </script>
</body>
</html>