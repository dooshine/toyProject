package com.kh.toyproject.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.kh.toyproject.vo.ChatGptRequestVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ChatGptServiceImpl implements ChatGptService{

	@Value("${open-ai-key}")
	private String openAiKey;
	
	@Autowired
	private RestTemplate template;
	
	@Override
	public String chatRequest(ChatGptRequestVO requestVO) throws URISyntaxException {
		URI uri = new URI("https://api.openai.com/v1/chat/completions");
		
		StringBuilder question = new StringBuilder("The current temperature is " + requestVO.getTemp() + "degrees.");
		
		switch(requestVO.getRainType()) {
			case 1:
				question.append("It's raining and the hourly precipitation is " + requestVO.getRainAmount() + "mm.");
				break;
			case 2:
				question.append("Snow and rain are falling and precipitation per hour is " + requestVO.getRainAmount() + "mm.");
				break;
			case 3:
				question.append("It's snowing and the amount of snow per hour is " + requestVO.getRainAmount() + "mm.");
				break;
			case 5:
				question.append("Raindrops are falling and the hourly precipitation is " + requestVO.getRainAmount() + "mm.");
				break;
			case 6:
				question.append("Raindrops are falling, snowflakes are falling, and precipitation per hour is " + requestVO.getRainAmount() + "mm.");
				break;
			case 7:
				question.append("Snowflakes are falling and snowfall per hour is " + requestVO.getRainAmount() + "mm.");
				break;
		}
		
		question.append("The current humidity is " + requestVO.getHumid() + "%.");
		question.append("The current wind speed is " + requestVO.getWind() + "m/s.");
		question.append("My gender is a " + requestVO.getGender());
		question.append("Please recommend a top, bottom to wear now");
		question.append("When you recommend outfits, please specify the specific color and material");
		question.append("Please follow the example below for the format of your answer");
		question.append("\"\"\"");
		question.append("woman is wearing a white linen blouse and a black leather skirt.");
		question.append("\"\"\"");
		question.append("If the current temperature is below 22 degrees, add an outer clothing and Please follow the example below for the format of your answer.");
		question.append("\"\"\"");
		question.append("woman is wearing a white Oxford blouse, a brown leather jacket and black leather skirt.");
		question.append("\"\"\"");
		question.append("When the gender is a man, please write man instead of woman.");
		question.append("Please be sure to answer based on the weather we have informed you and pay attention to the format of the answer. And the color and material of the outfit must be present.");
		question.append("Please provide various materials, colors, and types of clothes.");
		question.append("If the current temperature is below 22 degrees, Must recommend an outer clothing.");
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Bearer " + openAiKey);
		headers.add("Content-Type", "application/json");
		
		Map<String, Object> message = new HashMap<>();
        message.put("role", "user");
        message.put("content", question);

        List<Map<String, Object>> messages = new ArrayList<>();
        messages.add(message);

        JSONObject body = new JSONObject();
        body.put("model", "gpt-3.5-turbo");
        body.put("messages", messages);
        body.put("temperature", 0.5);
        
        HttpEntity<String> requestEntity = new HttpEntity<>(body.toString(), headers);

        String response = template.postForObject(uri, requestEntity, String.class);
        JSONObject jsonObject = new JSONObject(response);
		JSONArray choices = jsonObject.getJSONArray("choices");
		JSONObject item = choices.getJSONObject(0);
		JSONObject responseMessage = item.getJSONObject("message");
		String content = responseMessage.getString("content");
		
		return content;
	}

}
