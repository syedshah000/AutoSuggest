package com.elasticsearch.ElasticIntergration.service;

import java.io.Serializable;

public class ResponsePojo implements Serializable {
    public int getTook() {
        return took;
    }

    public void setTook(int took) {
        this.took = took;
    }

    public boolean isTimed_out() {
        return timed_out;
    }

    public void setTimed_out(boolean timed_out) {
        this.timed_out = timed_out;
    }

    public String getVar() {
        return var;
    }

    public void setVar(String var) {
        this.var = var;
    }

    int took;
    boolean timed_out;
    String var;


    public Object getSuggest() {
        return suggest;
    }

    public void setSuggest(Object suggest) {
        this.suggest = suggest;
    }

    public Object suggest;

}
/*
        "took" : 2,
        "timed_out" : false,
        "_shards" : {
        "total" : 1,
        "successful" : 1,
        "skipped" : 0,
        "failed" : 0
        },
        "hits" : {
        "total" : {
        "value" : 0,
        "relation" : "eq"
        },
        "max_score" : null,
        "hits" : [ ]
        },
        "suggest" : {
        "product-suggest" : [
        {
        "text" : "w",
        "offset" : 0,
        "length" : 1,
        "options" : [
        {
        "text" : "Whistlez Jolly Jam",
        "_index" : "library_item",*/