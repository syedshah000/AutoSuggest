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


    public Object getProduct_title() {
        return product_title;
    }

    public void setProduct_title(Object product_title) {
        this.product_title = product_title;
    }

    Object product_title;



    public Object suggest;

    public Object getSuggest() {
        return suggest;
    }

    public void setSuggest(Object suggest) {
        this.suggest = suggest;
    }





}
/*
        "took" : 2,
        "timed_out" : false,

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