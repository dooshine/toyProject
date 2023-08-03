<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
</head>
<body>
    <div id="app">
        <h1>
            홈 화면
            {{ text }}
        </h1>
        <img src="kakao.png" alt="Kakao Image">
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