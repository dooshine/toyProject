<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<div class="row newObject-body" id="newObject-body-app">
<%--    어사이드 --%>
    <jsp:include page="/WEB-INF/views/newObject/newObjectAside.jsp"></jsp:include>
<%--    본문 --%>
    <div class="col-10 newObject-body">
        <h1>
            본문구역
        </h1>
    </div>
</div>

<script>
    const newObjectApp = Vue.createApp({
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
    }).mount('#newObject-body-app')
</script>
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>