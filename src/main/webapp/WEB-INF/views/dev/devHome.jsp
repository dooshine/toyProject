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
      
      <div>
      	<input type="radio" v-model="gender" value="man">
      	<label>남자</label>
      	<input type="radio" v-model="gender" value="woman">
      	<label>여자</label>
      </div>
      
      <select v-model="city">
      	<option v-for="(item, index) in cities" :value="item">
      		{{item}}
      	</option>
      </select>
      <select v-model="detail">
      	<option v-for="(item, index) in details" :value="item">
      		{{item}}
      	</option>
      </select>
      
      <button v-on:click="getWeather()">날씨조회</button>
      <div v-if="weatherFlag">
	      <h2> 현재 기온은 {{weather.temp}}℃ 입니다.</h2>
	      <h2> 현재 습도는 {{weather.humid}}% 입니다.</h2>
	      
	      <h2 v-if="weather.rainType == 0"> 맑은 날씨입니다.</h2>
	      <h2 v-if="weather.rainType == 1"> 비가 내리고있습니다.</h2>
	      <h2 v-if="weather.rainType == 2"> 눈과 비가 내리고있습니다..</h2>
	      <h2 v-if="weather.rainType == 3"> 눈이 내리고있습니다.</h2>
	      <h2 v-if="weather.rainType == 5"> 빗방울이 떨어지고있습니다.</h2>
	      <h2 v-if="weather.rainType == 6"> 빗방울과 눈날림이있습니다.</h2>
	      <h2 v-if="weather.rainType == 7"> 눈날림이 있습니다..</h2>
	      
	      <h2 v-if="weather.rainType != 0">현재 시간당 강수량은 {{weather.rainAmount}}mm 입니다.</h2>
	  </div>
      <button v-show="!imgLoading && weatherFlag" v-on:click="genImage()">이미지생성</button>
      <img v-if="imgUrl != null" :src="imgUrl">
    </div>
  </div>
</div>

<script src="${pageContext.request.contextPath}/node_modules/vue/dist/vue.global.js"></script>
<script src="${pageContext.request.contextPath}/node_modules/axios/dist/axios.min.js"></script>

<script>
  const app = Vue.createApp({
    data() {
      return {
    	weatherFlag : false,
        text: "vueJS 시작",
        cities : null,
        details : null,
        city : null,
        detail : null,
        gender : "man",
        imgUrl : null,
        weather : {
        	temp : 0,
        	rainType : 0,
        	rainAmount : 0,
        	humid : 0,
        	wind : 0
        },
        testAnswer : null,
        imgLoading : false,
      };
    },
    computed: {

    },
    methods: {
		async getWeather(){
			const locationUrl = "/location/" + this.city + "/" + this.detail;
			const locationResp = await axios.get(locationUrl);
			const location = locationResp.data;
			
			const url = "/weather/"+location.locationNx+"/"+location.locationNy;
			const resp = await axios.get(url);
			this.weather = resp.data;
			if(!this.weatherFlag) this.weatherFlag = true;
		},
				
		async getLocation(){
			const url = "/location/" + this.city + "/" + this.detail;
			const resp = await axios.get(url);
			this.location = resp.data;
		},
		
		async getCities(){
			const url = "/location/city";
			const resp = await axios.get(url);
			this.cities = resp.data;
			this.city = this.cities[0];
		},
		
		async getDetails(){
			const url = "/location/detail/"+this.city;
			const resp = await axios.get(url);
			this.details = resp.data;
			this.detail = this.details[0];
		},
		
		async genImage(){
			this.imgLoading = true;
			const gptUrl = "/chat/";
			const gptData = this.weather;
			gptData.gender = this.gender;
			const answer = await axios.post(gptUrl, gptData);
			
			const url = "/karlo/";
			const data = answer.data;
			const resp = await axios.post(url, data);
			this.testAnswer = answer.data
			this.imgUrl = resp.data.images[0].image;
			this.imgLoading = false;
		}
		
    },
    watch: {
		city : function(){
			this.getDetails();
		}
    },
    created(){
      console.log("안녕하세요");
      this.getCities();
    },
  }).mount('#app')

</script>
</body>
</html>