package com.elasticsearch.ElasticIntergration.service;

import java.io.Serializable;

public class ResponsePojo implements Serializable {


    public String suggest;
    int took;
    boolean timed_out;
    String var;

    public String getSuggest() {
        return suggest;
    }

    public void setSuggest(String suggest) {
        this.suggest = suggest;
    }


    public ResponsePojo(String var, String responseBody) {
        this.var = var;
        this.suggest = responseBody;

    }


    public ResponsePojo(String var) {
        this.var = var;

    }




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


}