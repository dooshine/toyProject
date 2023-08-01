<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
</head>
<body>
    <h1>
        홈 화면
    </h1>
    <script src="/../node_modules/vue/dist/vue.cjs.js"></script>
    <script>
        new Vue({
            data: {
                test: "hello"
            },
            method: {
                test(){
                    console.log("hello");
                }
            },
            mounted(){
                console.log("안녕");
            }

        });
    </script>
</body>
</html>