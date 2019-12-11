package com.exchange.used.configure.search;

import java.util.Map;

import static com.exchange.used.configure.search.Symbol.*;

/**
 * ClassName:SqlBulider
 * Package:com.exchange.used.configure.search
 * Description:
 *
 * @date:2019/12/10 16:36
 * @author:Wang Jun
 */
public class SqlBulider {
    private StringBuilder sql;
    private Condition condition;

    public SqlBulider(Condition condition){
        if (condition.getTablename()==null)
            throw new RuntimeException("主表为空");
        this.condition = condition;
    }

    public String getSql(){
        sql = new StringBuilder("select * from "+condition.getTablename());
        setrelation();
        setwhere();
        setorder();
        setpage();
        return sql.toString();
    }

    public String getCountSql(){
        sql = new StringBuilder("select count(*) count from "+condition.getTablename());
        setrelation();
        setwhere();
        return sql.toString();
    }

    private void setrelation() {
        if (condition.getRelationship().size()>=1){
            for (Map.Entry<String,String> entry:condition.getRelationship().entrySet()){
                sql.append(" left join " + entry.getValue().split(".")[0]);
                sql.append(" on "+entry.getKey() + "=" +entry.getValue());
            }
        }
    }

    /**
     * is not null  A
     * is null      B
     * !=           C
     * =            D
     * like         E
     */
    private void setwhere() {
        if (condition.getWheres().size() < 1) return;
        sql.append(" where 1=1 ");
        for (Where where : condition.getWheres()) {
            if (where.getField() != null && !where.getField().isEmpty()) {
                sql.append("and " + where.getField());
                if (where.getSymbol() != null) {
                    switch (where.getSymbol()) {
                        case A:
                            sql.append(Symbol.A.getMark());
                            break;
                        case B:
                            sql.append(Symbol.B.getMark());
                            break;
                        case C:
                            sql.append(Symbol.C.getMark() + "'" + where.getValue().trim() + "' ");
                            break;
                        case D:
                            sql.append(Symbol.D.getMark() + "'" + where.getValue().trim() + "' ");
                            break;
                        case E:
                            sql.append(Symbol.E.getMark() + "'%" + where.getValue().trim() + "%' ");
                            break;
                    }
                } else {
                    throw new RuntimeException("检索条件状态值异常");
                }

            }
        }
    }

    private void setorder(){
        if (condition.getOrder() == null) return;
        sql.append(" order by "+condition.getOrder().getProperty());
        if (!condition.getOrder().isMethond()) sql.append(" desc ");
    }

    private void setpage(){
        if (condition.getPage()==null) return;
        sql.append(" limit "+ (condition.getPage()-1)*condition.getLimit()+','+condition.getLimit());
    }
}
