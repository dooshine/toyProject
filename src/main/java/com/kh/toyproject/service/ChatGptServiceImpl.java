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

import com.kh.toyproject.vo.WeatherResponseVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ChatGptServiceImpl implements ChatGptService{

	@Value("${open-ai-key}")
	private String openAiKey;
	
	@Autowired
	private RestTemplate template;
	
	@Override
	public String chatRequest(WeatherResponseVO weatherVO) throws URISyntaxException {
		URI uri = new URI("https://api.openai.com/v1/chat/completions");
		
		StringBuilder question = new StringBuilder("현재 기온은" + weatherVO.getTemp() + "℃ 이고");
		
		switch(weatherVO.getRainType()) {
			case 1:
				question.append("비가 오고 있으며 시간당 강수량은" + weatherVO.getRainAmount() + "mm 입니다.");
				break;
			case 2:
				question.append("눈과 비가 내리고 있으며 시간당 강수량은" + weatherVO.getRainAmount() + "mm 입니다.");
				break;
			case 3:
				question.append("눈이 내리고 있으며 시간당 적설량은" + weatherVO.getRainAmount() + "mm 입니다.");
				break;
			case 5:
				question.append("빗방울이 떨어지고 있으며 시간당 강수량은" + weatherVO.getRainAmount() + "mm 입니다.");
				break;
			case 6:
				question.append("빗방울과 눈날림이 있으며 시간당 강수량은" + weatherVO.getRainAmount() + "mm 입니다.");
				break;
			case 7:
				question.append("눈날림이 있으며 시간당 적설량은" + weatherVO.getRainAmount() + "mm 입니다.");
				break;
		}
		
		question.append("현재 습도는" + weatherVO.getHumid() + "% 이며");
		question.append("현재 풍속은" + weatherVO.getWind() + "m/s 입니다.");
		question.append("지금 입고 나갈 옷의 상의 하의 신발을 추천해주세요");
		question.append("의상을 추천할 때는 구체적인 색과 재질도 반드시 함께 명시해주세요");
		question.append("답변의 형식은 '상의 : ~ , 하의 : ~, 신발 : ~' 이와 같은 형식으로 답변해주시고 날씨에 따라 필요한 악세사리나 외투도 적어주세요. 만약 필요없다면 적지 않아도 됩니다. 예를들어 비가 온다면 '악세사리 : 우산 또는 우비' 날씨가 춥다면 '외투 : 코트' 이런식으로 추가해주세요.");
		question.append("현재 알려드린 날씨에 반드시 근거하여 답변해주시고 답변의 형식에 유의해주세요. 그리고 복장의 색상과 소재는 반드시 있어야 합니다.");
				
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
        body.put("temperature", 0.7);
        
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
