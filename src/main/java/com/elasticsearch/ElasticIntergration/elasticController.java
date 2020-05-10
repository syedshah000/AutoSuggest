package com.elasticsearch.ElasticIntergration;

import com.elasticsearch.ElasticIntergration.service.elasticService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController

public class elasticController {


    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }


    @RequestMapping("/syed")
    public String ss(){

        syed sense = new syed();
        return sense.getSyed();

    }

    @GetMapping("/search")
    public Object ss(@RequestParam("str") String str,@RequestParam("var") String var){
        System.out.println(" Reached here ");
        elasticService objSer = new elasticService();
        return objSer.searchEL(str,var);

    }

    }

