<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="col-2 newObject-nav" id="newObject-nav-app">
    <div class="row">
        <a href="/newObject/">항목 홈</a>
    </div>
    <div class="row">
        <a href="/newObject/1">항목1</a>
    </div>
    <div class="row">
        <a href="/newObject/2">항목2</a>
    </div>
    <div class="row">
        <a href="/newObject/3">항목3</a>
    </div>
</div>
<script>
    const newObjectAsideApp = Vue.createApp({
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
    }).mount('#newObject-nav-app')
</script>