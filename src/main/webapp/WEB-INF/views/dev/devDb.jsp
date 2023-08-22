<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<div class="row">
    <h1>
        Dev DB테스트
        {{ text }}
    </h1>
</div>

<div class="row" id="inner-app">
    <h1>
        {{ text }}
    </h1>
</div>

<script>
    const innerApp = Vue.createApp({
        data() {
            return {
                text: "Oracle 테스트",
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
    }).mount('#inner-app')
</script>
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>