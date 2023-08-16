<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<div class="row">
    <h1>
        유저로그인 화면
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
                text: "유저 로그인 화면",
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