package com.exchange.used.configure.search;

/**
 * ClassName:Order
 * Package:com.exchange.used.configure.search
 * Description:
 *
 * @date:2019/12/10 16:28
 * @author:Wang Jun
 */
public class Order {
    private String property;
    private boolean methond = true;//默认升序

    public Order(String property, boolean methond) {
        this.property = property;
        this.methond = methond;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public boolean isMethond() {
        return methond;
    }

    public void setMethond(boolean methond) {
        this.methond = methond;
    }
}
