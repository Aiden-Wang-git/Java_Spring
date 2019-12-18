package com.exchange.used.configure.searchGood;

import com.exchange.used.entity.Goods;

import java.util.Date;

/**
 * ClassName:DataGood
 * Package:com.exchange.used.configure.searchGood
 * Description:
 *
 * @date:2019/12/18 18:30
 * @author:Wang Jun
 */
public class DataGood {
    private String goodID;
    private String seller;
    private String type;
    private double goodnum;
    private Date goodscreatetime;
    private String goodsdesc;
    private String goodsimg1;
    private String goodsimg2;
    private String goodsimg3;
    private String goodname;
    private double goodsprice;
    private String goodsunit;
    private double goodsstar;
    public DataGood(){};

    public DataGood(String goodID, String seller, String type, double goodnum, Date goodscreatetime, String goodsdesc, String goodsimg1, String goodsimg2, String goodsimg3, String goodname, double goodsprice, String goodsunit, double goodsstar) {
        this.goodID = goodID;
        this.seller = seller;
        this.type = type;
        this.goodnum = goodnum;
        this.goodscreatetime = goodscreatetime;
        this.goodsdesc = goodsdesc;
        this.goodsimg1 = goodsimg1;
        this.goodsimg2 = goodsimg2;
        this.goodsimg3 = goodsimg3;
        this.goodname = goodname;
        this.goodsprice = goodsprice;
        this.goodsunit = goodsunit;
        this.goodsstar = goodsstar;
    }

    public String getGoodID() {
        return goodID;
    }

    public void setGoodID(String goodID) {
        this.goodID = goodID;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getGoodnum() {
        return goodnum;
    }

    public void setGoodnum(double goodnum) {
        this.goodnum = goodnum;
    }

    public Date getGoodscreatetime() {
        return goodscreatetime;
    }

    public void setGoodscreatetime(Date goodscreatetime) {
        this.goodscreatetime = goodscreatetime;
    }

    public String getGoodsdesc() {
        return goodsdesc;
    }

    public void setGoodsdesc(String goodsdesc) {
        this.goodsdesc = goodsdesc;
    }

    public String getGoodsimg1() {
        return goodsimg1;
    }

    public void setGoodsimg1(String goodsimg1) {
        this.goodsimg1 = goodsimg1;
    }

    public String getGoodsimg2() {
        return goodsimg2;
    }

    public void setGoodsimg2(String goodsimg2) {
        this.goodsimg2 = goodsimg2;
    }

    public String getGoodsimg3() {
        return goodsimg3;
    }

    public void setGoodsimg3(String goodsimg3) {
        this.goodsimg3 = goodsimg3;
    }

    public String getGoodname() {
        return goodname;
    }

    public void setGoodname(String goodname) {
        this.goodname = goodname;
    }

    public double getGoodsprice() {
        return goodsprice;
    }

    public void setGoodsprice(double goodsprice) {
        this.goodsprice = goodsprice;
    }

    public String getGoodsunit() {
        return goodsunit;
    }

    public void setGoodsunit(String goodsunit) {
        this.goodsunit = goodsunit;
    }

    public double getGoodsstar() {
        return goodsstar;
    }

    public void setGoodsstar(double goodsstar) {
        this.goodsstar = goodsstar;
    }
}
