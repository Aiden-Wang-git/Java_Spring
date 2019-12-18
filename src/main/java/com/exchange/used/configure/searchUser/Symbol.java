package com.exchange.used.configure.searchUser;

/**
 * ClassName:Symbol
 * Package:com.exchange.used.configure.search
 * Description:
 *
 * @date:2019/12/10 18:26
 * @author:Wang Jun
 */
public enum Symbol {
    A(" is not null "),
    B(" is null "),
    C("！="),
    D("="),
    E(" like ") ;
    private String mark;

    Symbol(String string) {
        this.mark = string;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }
}
