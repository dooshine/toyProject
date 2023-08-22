<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<div class="row dev-body" id="inner-app">
<%--    어사이드 --%>
    <jsp:include page="/WEB-INF/views/dev/devAside.jsp"></jsp:include>
<%--    본문 --%>
    <div class="col-10 dev-body">
        <h1>
            야임마
        </h1>
    </div>
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