package com.neo.chatbot.api;

import com.neo.chatbot.api.domain.ai.IOpenAI;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.io.IOException;


public class ApiTest {
    private Logger logger = LoggerFactory.getLogger(ApiTest.class);
    @Resource
    private IOpenAI openAI;

    @Test
    public void test_unit() throws IOException {

        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpPost httpPost=new HttpPost("https://keyue.cloud.baidu.com/online/core/v5/stream/query");
        httpPost.addHeader("token","8af15122-e555-4f1f-9f79-04879c8dc1c1");
        httpPost.addHeader("Content-Type","application/json");

        String JsonParam = "{\"queryText\":\"你好\",\"sessionId\":\"ecb95fcc-0e49-4ab0-b026-c20a8aac1585\"}";

        StringEntity stringEntity = new StringEntity(JsonParam, ContentType.create("tex/json","utf-8"));
        httpPost.setEntity(stringEntity);

        CloseableHttpResponse response = httpClient.execute(httpPost);
        if (response.getStatusLine().getStatusCode()== HttpStatus.SC_OK){
            String res = EntityUtils.toString(response.getEntity(),"utf-8");
            System.out.println(res);
        }else {
            System.out.println(response.getStatusLine().getStatusCode());
        }

    }
    @Test
    public void test() throws IOException {
        System.out.println("-------------------------");
        String response = openAI.doUnit("今天北京的天气怎么样");
        logger.info("测试结果为:{}",response);
    }


}
