package com.exchange.used.configure.search;

/**
 * ClassName:Where
 * Package:com.exchange.used.configure.search
 * Description:
 *
 * @date:2019/12/10 16:50
 * @author:Wang Jun
 */
public class Where {
    private String field;//属性的格式，表名，字段名
    private String value;//字段的值
    private Symbol symbol;//使用枚举类

    public Where(String field, String value, Symbol symbol) {
        this.field = field;
        this.value = value;
        this.symbol = symbol;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }
}
