package com.exchange.used.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "goods")
public class Goods {
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Id
    private String goodsid;
    private String goodsname;       //商品名称
    private Double goodsprice;      //价格
    private String goodsunit;       //单位
    private Double goodnum;         //商品剩余数量
    private String goodsstar;       //商品评分
    private String goodsimg1;       //商品图片1
    private String goodsimg2;       //商品图片2
    private String goodsimg3;       //商品图片3
    private String goodsdesc;       //描述
    private Date goodscreatetime;   //创建时间
    private String fksellerid;      //发布用户
    private String fktypeid;        //商品类别

    public String getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(String goodsid) {
        this.goodsid = goodsid;
    }

    public String getGoodsname() {
        return goodsname;
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname;
    }

    public Double getGoodsprice() {
        return goodsprice;
    }

    public void setGoodsprice(Double goodsprice) {
        this.goodsprice = goodsprice;
    }

    public String getGoodsunit() {
        return goodsunit;
    }

    public void setGoodsunit(String goodsunit) {
        this.goodsunit = goodsunit;
    }

    public String getGoodsdesc() {
        return goodsdesc;
    }

    public void setGoodsdesc(String goodsdesc) {
        this.goodsdesc = goodsdesc;
    }

    public Date getGoodscreatetime() {
        return goodscreatetime;
    }

    public void setGoodscreatetime(Date goodscreatetime) {
        this.goodscreatetime = goodscreatetime;
    }

    public String getFksellerid() {
        return fksellerid;
    }

    public void setFksellerid(String fksellerid) {
        this.fksellerid = fksellerid;
    }

    public String getFktypeid() {
        return fktypeid;
    }

    public void setFktypeid(String fktypeid) {
        this.fktypeid = fktypeid;
    }

    public Double getGoodnum() {
        return goodnum;
    }

    public void setGoodnum(Double goodnum) {
        this.goodnum = goodnum;
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

    public String getGoodsstar() {
        return goodsstar;
    }

    public void setGoodsstar(String goodsstar) {
        this.goodsstar = goodsstar;
    }
}
