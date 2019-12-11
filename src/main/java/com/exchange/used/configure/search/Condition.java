package com.exchange.used.configure.search;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * ClassName:Condition
 * Package:com.exchange.used.configure
 * Description:
 *
 * @date:2019/12/10 16:25
 * @author:Wang Jun
 */
public class Condition {
    private String tablename;
    private Map<String,String> relationship = new LinkedHashMap<>();//两个string都是表明.字段名
    private Order order;
    private Integer page;
    private Integer limit;
    private List<Where> wheres = new ArrayList<>();

    public Condition(String tablename, Map<String, String> relationship, Order order, Integer page, Integer limit) {
        this.tablename = tablename;
        this.relationship = relationship;
        this.order = order;
        this.page = page;
        this.limit = limit;
    }

    public Condition(){}

    public String getTablename() {
        return tablename;
    }

    public void setTablename(String tablename) {
        this.tablename = tablename;
    }

    public Map<String, String> getRelationship() {
        return relationship;
    }

    public void setRelationship(Map<String, String> relationship) {
        this.relationship = relationship;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public List<Where> getWheres() {
        return wheres;
    }

    public void setWheres(List<Where> wheres) {
        this.wheres = wheres;
    }
}
