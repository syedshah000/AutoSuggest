package com.elasticsearch.ElasticIntergration;

import com.elasticsearch.ElasticIntergration.service.elasticService;
import org.springframework.web.bind.annotation.*;
import java.util.concurrent.atomic.AtomicLong;

@RestController

public class elasticController {


    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }


    @CrossOrigin(origins = "*")
    @GetMapping("/search")
    public String search(@RequestParam("str") String str, @RequestParam("var") String var) {

        elasticService objSer = new elasticService();
        return objSer.searchEL(str,var);
    }

    }

