<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="ko">
<head>
  	<meta charset="UTF-8">
  	<script src="${pageContext.request.contextPath}/node_modules/vue/dist/vue.global.js"></script>
	<script src="${pageContext.request.contextPath}/node_modules/axios/dist/axios.min.js"></script>
	<link href="${pageContext.request.contextPath}/node_modules/bootstrap/dist/css/bootstrap.css" rel="stylesheet">
</head>
<body>
<div id="app" class="container-sm mt-4">
  <div class="row">
    <div class="col-md-12">
      <div class="form-check form-check-inline">
        <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio1" v-model="gender" value="man">
        <label class="form-check-label" for="inlineRadio1">남자</label>
      </div>
      <div class="form-check form-check-inline">
        <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio2" v-model="gender" value="woman">
        <label class="form-check-label" for="inlineRadio2">여자</label>
      </div>
    </div>
  </div>

  <div class="row mt-3">
    <!-- Second Row: City Selection -->
    <div class="col-md-12">
      <div class="mb-3">
        <label for="citySelect" class="form-label">도시 선택</label>
        <select class="form-select" v-model="city" id="citySelect">
          <option v-for="(item, index) in cities" :value="item" :key="index">{{ item }}</option>
        </select>
      </div>
    </div>
  </div>

  <div class="row">
    <!-- Third Row: Detail Selection -->
    <div class="col-md-12">
      <div class="mb-3">
        <label for="detailSelect" class="form-label">상세 선택</label>
        <select class="form-select" v-model="detail" id="detailSelect">
          <option v-for="(item, index) in details" :value="item" :key="index">{{ item }}</option>
        </select>
      </div>
    </div>
  </div>

  <div class="row mt-3">
    <!-- Fourth Row: Weather Button (Moved to the Right) -->
    <div class="col-md-12">
      <div class="d-flex justify-content-end">
        <button type="button" class="btn btn-primary" v-on:click="getWeather()" :disabled="weatherLoading">날씨 조회</button>
      </div>
    </div>
  </div>
  
  <div class="row mt-3">
    <!-- Fourth Row: Weather Button (Moved to the Right) -->
    <div class="col-md-12">
      <div class="d-flex justify-content-end">
        <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#staticBackdrop" v-show="weatherFlag" v-on:click="genImage()" :disabled="imgLoading">이미지 생성</button>
      </div>
    </div>
  </div>

	<div v-if="weatherFlag" class="mt-4">
	  <div class="row">
	    <div class="col-md-4">
	      <div class="weather-info">
	        <h5>현재 기온</h5>
	        <p>{{ weather.temp }}℃</p>
	      </div>
	    </div>
	
	    <div class="col-md-4">
	      <div class="weather-info">
	        <h5>현재 습도</h5>
	        <p>{{ weather.humid }}%</p>
	      </div>
	    </div>
	
	    <div class="col-md-4">
	      <div class="weather-info">
	        <h5>날씨 상태</h5>
	        <p v-if="weather.rainType == 0">맑은 날씨입니다.</p>
	        <p v-else-if="weather.rainType == 1">비가 내리고 있습니다.</p>
	        <p v-else-if="weather.rainType == 2">눈과 비가 내리고 있습니다.</p>
	        <p v-else-if="weather.rainType == 3">눈이 내리고 있습니다.</p>
	        <p v-else-if="weather.rainType == 5">빗방울이 떨어지고 있습니다.</p>
	        <p v-else-if="weather.rainType == 6">빗방울과 눈이 날립니다.</p>
	        <p v-else-if="weather.rainType == 7">눈이 날립니다.</p>
	        <p v-if="weather.rainType != 0">현재 시간당 강수량: {{ weather.rainAmount }}mm</p>
	      </div>
	    </div>
	  </div>
	</div>
	
	<!-- Modal -->
	<div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" id="staticBackdropLabel">추천 의상</h5>
	        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
	      </div>
	      <div v-if="imgUrl" class="mt-4">
		    <img class="rounded mx-auto d-block img-fluid" :src="imgUrl" alt="Generated Image">
		  </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
	        <button type="button" class="btn btn-primary" v-on:click="genImage()" v-if="!imgLoading">재생성</button>
	        <div class="spinner-border text-primary" role="status" v-if="imgLoading"></div>
	      </div>
	    </div>
	  </div>
	</div>

  
</div>


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
        weatherLoading : false,
      };
    },
    computed: {

    },
    methods: {
		async getWeather(){
			this.weatherLoading = true;
			const locationUrl = "/location/" + this.city + "/" + this.detail;
			const locationResp = await axios.get(locationUrl);
			const location = locationResp.data;
			
			const url = "/weather/"+location.locationNx+"/"+location.locationNy;
			const resp = await axios.get(url);
			this.weather = resp.data;
			this.weatherLoading = false;
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
<script src="${pageContext.request.contextPath}/node_modules/bootstrap/dist/js/bootstrap.js"></script>
</body>
</html>