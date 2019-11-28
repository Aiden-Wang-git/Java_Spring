package com.exchange.used.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "lists")
public class List {

    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Id
    private String listid;
    private String fksaverid;
    private String fkgoodsid;
    private String listdesc;
    private Date listtime;
    private Integer listnum;

    public String getListid() {
        return listid;
    }

    public void setListid(String listid) {
        this.listid = listid;
    }

    public String getFksaverid() {
        return fksaverid;
    }

    public void setFksaverid(String fksaverid) {
        this.fksaverid = fksaverid;
    }

    public String getFkgoodsid() {
        return fkgoodsid;
    }

    public void setFkgoodsid(String fkgoodsid) {
        this.fkgoodsid = fkgoodsid;
    }

    public String getListdesc() {
        return listdesc;
    }

    public void setListdesc(String listdesc) {
        this.listdesc = listdesc;
    }

    public Date getListtime() {
        return listtime;
    }

    public void setListtime(Date listtime) {
        this.listtime = listtime;
    }

    public Integer getListnum() {
        return listnum;
    }

    public void setListnum(Integer listnum) {
        this.listnum = listnum;
    }
}
