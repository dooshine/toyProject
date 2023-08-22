<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="col-2 dev-nav" id="nav-app">
    <div class="row">
        <a href="/dev/">개발홈</a>
    </div>
    <div class="row">
        <a href="/dev/db">디비테스트</a>
    </div>
    <div class="row">
        <a href="/dev/imp">import테스트</a>
    </div>
    <div class="row">
        <a href="/dev/template">템플릿테스트</a>
    </div>
</div>
<script>
    const devAsideApp = Vue.createApp({
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
    }).mount('#nav-app')
</script>