<%@ page contentType="text/html;charset=UTF-8" language="java" %>
  </div>
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
  }).mount('#body-app')

</script>
<!-- 부트스트랩(bootstrap) js import -->
<script src="${pageContext.request.contextPath}/node_modules/bootstrap/dist/js/bootstrap.js"></script>
</body>
</html>