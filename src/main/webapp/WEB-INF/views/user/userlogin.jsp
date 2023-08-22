<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<div class="row" id="inner-app">
    <div class="col-6 offset-3 mt-5">
        <div class="mb-3">
            <h1>로그인</h1>
        </div>
        <form method="post" action="login">
            <div class="input-group">
                <span class="input-group-text">아이디</span>
                <input type="text" name="userId" class="form-control">
            </div>
        </form>    
    </div>
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