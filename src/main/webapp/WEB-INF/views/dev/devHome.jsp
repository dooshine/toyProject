<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <title>Document</title>
</head>
<body>
<div id="app">
  <div class="container">
    <div class="row dev-header">
      <h1>개발테스트 헤더</h1>
    </div>
    <div class="row dev-body">
      <h1>
        개발테스트 본문
      </h1>
    </div>
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