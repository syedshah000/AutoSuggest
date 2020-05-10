package com.elasticsearch.ElasticIntergration.service;

import org.json.JSONException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.json.JSONObject;
import org.json.JSONArray;



public class elasticService {

    public Object searchEL(String str,String var) throws JSONException {

        String request ="\n" +
                "{\"stored_fields\" : [],\n" +
                "    \"suggest\": {\n" +
                "        \"product-suggest\" : {\n" +
                "            \"prefix\" : \"" + str + "\",\n" +
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
        ResponsePojo res = response.getBody();
        res.setVar(var);

        System.out.println(res.getSuggest());
        /*
        JSONObject obj = new JSONObject(res.getSuggest());

        try{

            Object p_title = obj.getJSONObject("product_suggest").getString("text");
            res.setProduct_title(p_title);
        } catch (JSONException e) {
            e.printStackTrace();
        }*/



        return response;

    }

}
