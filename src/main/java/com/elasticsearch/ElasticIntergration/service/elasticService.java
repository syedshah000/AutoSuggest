package com.elasticsearch.ElasticIntergration.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


public class elasticService {

    String URL = "http://localhost:9200/library_item/_search";

    // Method to Execute GET request from elasticSearch Cluster
    public String searchEL(String search_val, String keyCount) {

        // Adding the search value from the controller(search_val) into our Elastic Query
        String query ="\n" +
                "{\"stored_fields\" : [],\n" +
                "    \"suggest\": {\n" +
                "        \"product-suggest\" : {\n" +
                "            \"prefix\" : \"" + search_val + "\",\n" +
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

        //  Creating a header and assigning the response type to JSON, Setting the authorization using APIKey generated from elasticsearch
        //  Elastic search is not preemptive and requires the auth at every transaction

        HttpHeaders headers =  new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
       // headers.set("Authorization",authHeader);


        //  Joining the request body and header to be used in the restTemplate
        HttpEntity<String> request = new HttpEntity<String>(query, headers);
        RestTemplate restTemplate = new RestTemplate();


        //  Executing the POST method and storing the response in a List<String>
        ResponseEntity<String> response = restTemplate.postForEntity(URL,request,String.class);
        String  res = response.getBody();
//
//        ResponseEntity<String> response = restTemplate.postForEntity(URL,request,String.class);
//        ResponsePojo res = new ResponsePojo(keyCount, response.getBody());

        return res;

    }

}
