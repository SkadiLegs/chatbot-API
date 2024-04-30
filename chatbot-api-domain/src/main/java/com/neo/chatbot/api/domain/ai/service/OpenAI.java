package com.neo.chatbot.api.domain.ai.service;


import com.alibaba.fastjson.JSON;
import com.neo.chatbot.api.domain.ai.IOpenAI;
import com.neo.chatbot.api.domain.ai.model.aggregates.AIAnswer;
import com.neo.chatbot.api.domain.ai.model.vo.AnswerDTO;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;


@Service
public class OpenAI implements IOpenAI {
    private Logger logger= LoggerFactory.getLogger(OpenAI.class);

    @Value("${unitBot-api.ApiKey}")
    private String apiKey;
    @Override
    public String doUnit(String question) throws IOException {

        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpPost httpPost=new HttpPost("https://keyue.cloud.baidu.com/online/core/v5/stream/query");
        httpPost.addHeader("token",apiKey);
        httpPost.addHeader("Content-Type","application/json");

        String JsonParam = "{\"queryText\":\""+question+"\",\"sessionId\":\"ecb95fcc-0e49-4ab0-b026-c20a8aac1585\"}";

        StringEntity stringEntity = new StringEntity(JsonParam, ContentType.create("tex/json","utf-8"));
        httpPost.setEntity(stringEntity);

        CloseableHttpResponse response = httpClient.execute(httpPost);
        if (response.getStatusLine().getStatusCode()== HttpStatus.SC_OK){
            String jsonStr = EntityUtils.toString(response.getEntity(),"utf-8");
            AIAnswer AIAnswer = JSON.parseObject(jsonStr, AIAnswer.class);
            StringBuilder answers = new StringBuilder();
            List<AnswerDTO> answerDTOs = AIAnswer.getAnswer();
            for (AnswerDTO answerDTO : answerDTOs){
                answers.append(answerDTO.getReply().getText());
            }
            return answers.toString();
        }else {
           throw  new RuntimeException("api.unit.com Err Code is :"+response.getStatusLine().getStatusCode());
        }
    }
}
