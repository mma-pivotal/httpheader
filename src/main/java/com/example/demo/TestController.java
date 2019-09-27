package com.example.demo;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @RequestMapping(value= "/", method = RequestMethod.GET)
    @ResponseBody
    public String getRootPath() throws ClientProtocolException, IOException {

    CloseableHttpClient client = HttpClients.createDefault();
    HttpPost httpPost = new HttpPost("https://goapp.cfapps-13.haas-59.pez.pivotal.io");
 
    String json = "{\"name\":ba,\"address\":\"John\"}";
    StringEntity entity = new StringEntity(json);
    httpPost.setEntity(entity);
    httpPost.setHeader("Accept", "application/json");
    httpPost.setHeader("Content-type", "application/json");
    httpPost.setHeader("Host", "goapp.cfapps-13.haas-59.pez.pivotal.io:443");

    
    CloseableHttpResponse response = client.execute(httpPost);
    client.close();
    String res = response.getEntity().toString();
    return(res);
  }
}