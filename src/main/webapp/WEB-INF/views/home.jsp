<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
</head>
<body>
    <div id="app">
        <h1>
            홈 화면
            {{text}}
        </h1>
        
        <h2> 현재 기온은 {{weather.temp}}℃ 입니다.</h2>
        <h2> 현재 습도는 {{weather.humid}}% 입니다.</h2>
        <h2> 현재 풍속은 {{weather.wind}}m/s 입니다.</h2>
        
        <h2 v-if="weather.rainType == 0"> 맑은 날씨입니다.</h2>
        <h2 v-if="weather.rainType == 1"> 비가 내리고있습니다.</h2>
        <h2 v-if="weather.rainType == 2"> 눈과 비가 내리고있습니다..</h2>
        <h2 v-if="weather.rainType == 3"> 눈이 내리고있습니다.</h2>
        <h2 v-if="weather.rainType == 5"> 빗방울이 떨어지고있습니다.</h2>
        <h2 v-if="weather.rainType == 6"> 빗방울과 눈날림이있습니다.</h2>
        <h2 v-if="weather.rainType == 7"> 눈날림이 있습니다..</h2>
        
        <h2 v-if="weather.rainType != 0">현재 시간당 강수량은 {{weather.rainAmount}}mm 입니다.</h2>
        <h2>{{answer}}</h2>
        <button v-on:click="getAnswer()">Create</button>
        <img src="kakao.png" alt="Kakao Image">
    </div>

    <script src="${pageContext.request.contextPath}/node_modules/vue/dist/vue.global.js"></script>
    <script src="${pageContext.request.contextPath}/node_modules/axios/dist/axios.min.js"></script>

    <script>
        const app = Vue.createApp({
            data() {
                return {
                    text: "vueJS 시작",
                    weather : {
                    	temp : 0,
                    	rainType : 0,
                    	rainAmount : 0,
                    	humid : 0,
                    	wind : 0
                    },
                    
                    answer : null,
                };
            },
            computed: {

            },
            
            methods: {
				async getWeather(){
					const url = "/weather/";
					const resp = await axios.get(url);
					this.weather = resp.data;
				},
				
				async getAnswer(){
					const url = "/chat/";
					const data = this.weather;
					const resp = await axios.post(url, data);
					this.answer = resp.data;
				},
            },
            watch: {

            },
            created(){
                console.log("안녕하세요")
                this.getWeather();
            },
        }).mount('#app')

    </script>
</body>
</html>