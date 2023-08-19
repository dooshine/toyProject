package com.kh.toyproject.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.kh.toyproject.config.WeatherProp;
import com.kh.toyproject.vo.WeatherRequestVO;
import com.kh.toyproject.vo.WeatherResponseVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class WeatherServiceImpl implements WeatherService{
	
	@Autowired
	private RestTemplate template;
	
	@Autowired
	private WeatherProp props;
	
	@Override
	public WeatherResponseVO request(int nx, int ny) throws URISyntaxException {
		
		WeatherResponseVO responseVO = new WeatherResponseVO();
		LocalDateTime now = LocalDateTime.now();
		int min = now.getMinute();
		
		if(min <= 40) {
			now = now.minusHours(1);
		}
		
		DateTimeFormatter dateForm = DateTimeFormatter.ofPattern("yyyyMMdd");
		DateTimeFormatter timeForm = DateTimeFormatter.ofPattern("HHmm");
		String nowDate = now.format(dateForm);
		String nowTime = now.format(timeForm);
		
		
		StringBuilder uriStr = new StringBuilder("http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getUltraSrtNcst");
		uriStr.append("?serviceKey="+ props.getKey());
		uriStr.append("&pageNo=1");
		uriStr.append("&numOfRows=10");
		uriStr.append("&dataType=JSON");
		uriStr.append("&base_date=" + nowDate);
		uriStr.append("&base_time=" + nowTime);
		uriStr.append("&nx="+nx);
		uriStr.append("&ny="+ny);
		
		URI uri =new URI(uriStr.toString());
		
		String responseStr = template.getForObject(uri, String.class);
		
		JSONObject jsonObject = new JSONObject(responseStr);
		JSONObject response = jsonObject.getJSONObject("response");
        JSONObject body = response.getJSONObject("body");
        JSONObject items = body.getJSONObject("items");
        JSONArray jArray = items.getJSONArray("item");
        
        for(int i = 0; i < jArray.length(); i++) {
        	JSONObject item = jArray.getJSONObject(i);
        	String category = item.getString("category");
        	switch (category) {
        		case "T1H":
        			responseVO.setTemp(item.getDouble("obsrValue"));
        			break;
    			case "RN1":
    				responseVO.setRainAmount(item.getDouble("obsrValue"));
    				break;
    			case "REH":
    				responseVO.setHumid(item.getDouble("obsrValue"));
    				break;
    			case "PTY":
    				responseVO.setRainType(item.getInt("obsrValue"));
    				break;
    			case "WSD":
    				responseVO.setWind(item.getDouble("obsrValue"));
    				log.error(item.getString("baseTime"));
    				break;
        	}
        }
		
        return responseVO;
	}

}
