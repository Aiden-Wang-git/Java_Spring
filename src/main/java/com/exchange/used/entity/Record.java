package com.exchange.used.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "records")
public class Record {
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Id
    private String recordid;
    private String fkgoodsid;   //购买商品
    private Double recordnum;   //购买该商品的数量
    private Double recordprice; //购买该商品的总价格
    private String fkorderid;   //属于哪一订单
    private String remark;      //商品评价
    private Date remarktime;    //评价时间
    private Double star;        //星级

    public String getRecordid() {
        return recordid;
    }

    public void setRecordid(String recordid) {
        this.recordid = recordid;
    }

    public String getFkgoodsid() {
        return fkgoodsid;
    }

    public void setFkgoodsid(String fkgoodsid) {
        this.fkgoodsid = fkgoodsid;
    }

    public Double getRecordnum() {
        return recordnum;
    }

    public void setRecordnum(Double recordnum) {
        this.recordnum = recordnum;
    }

    public Double getRecordprice() {
        return recordprice;
    }

    public void setRecordprice(Double recordprice) {
        this.recordprice = recordprice;
    }

    public String getFkorderid() {
        return fkorderid;
    }

    public void setFkorderid(String fkorderid) {
        this.fkorderid = fkorderid;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getRemarktime() {
        return remarktime;
    }

    public void setRemarktime(Date remarktime) {
        this.remarktime = remarktime;
    }

    public Double getStar() {
        return star;
    }

    public void setStar(Double star) {
        this.star = star;
    }
}
