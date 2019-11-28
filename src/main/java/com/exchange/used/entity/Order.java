package com.exchange.used.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "orders")
public class Order {
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Id
    private String orderid;
    private Double orderprice;  //交易总价格
    private Date ordertime;     //下单时间
    private Date finishtime;    //完成时间
    private String orderdesc;   //订单备注
    private String fkstateid;   //交易状态
    private String fkbuyerid;   //购买用户
    private String fkaddressid; //交易地址

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public Double getOrderprice() {
        return orderprice;
    }

    public void setOrderprice(Double orderprice) {
        this.orderprice = orderprice;
    }

    public String getOrderdesc() {
        return orderdesc;
    }

    public void setOrderdesc(String orderdesc) {
        this.orderdesc = orderdesc;
    }

    public String getFkstateid() {
        return fkstateid;
    }

    public void setFkstateid(String fkstateid) {
        this.fkstateid = fkstateid;
    }

    public String getFkbuyerid() {
        return fkbuyerid;
    }

    public void setFkbuyerid(String fkbuyerid) {
        this.fkbuyerid = fkbuyerid;
    }

    public String getFkaddressid() {
        return fkaddressid;
    }

    public void setFkaddressid(String fkaddressid) {
        this.fkaddressid = fkaddressid;
    }

    public Date getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(Date ordertime) {
        this.ordertime = ordertime;
    }

    public Date getFinishtime() {
        return finishtime;
    }

    public void setFinishtime(Date finishtime) {
        this.finishtime = finishtime;
    }
}
