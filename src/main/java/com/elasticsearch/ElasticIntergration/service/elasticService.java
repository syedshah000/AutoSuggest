package com.elasticsearch.ElasticIntergration.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class elasticService {

    public Object searchEL(String str,String var){

        String request = "" +
                "{" +
                "    \"suggest\": {\n" +
                "        \"product-suggest\" : {\n" +
                "            \"prefix\" : \""+str+"\",\n" +
                "\n" +
                "            \"completion\" : { \n" +
                "                \"field\" : \"lang_en\",\n" +
                "        \"fuzzy\": {\n" +
                "          \"fuzziness\": \"AUTO\"\n" +
                "        }\n" +
                "            }\n" +
                "        }\n" +
                "    }\n" +
                "}";

        String URL = "http://localhost:9200/library_item/_search?pretty";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> req = new HttpEntity<String>(request, headers);

        RestTemplate restTemplate = new RestTemplate();


        ResponseEntity<ResponsePojo> response = restTemplate.postForEntity(URL,req,ResponsePojo.class);
        ResponsePojo res =response.getBody();
        res.setVar(var);
        return response;

    }

}
