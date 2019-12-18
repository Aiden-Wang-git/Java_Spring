package com.exchange.used.services;

import com.exchange.used.configure.LayuiResult;
import com.exchange.used.entity.Goods;
import com.exchange.used.entity.User;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName:GoodService
 * Package:com.exchange.used.services.implments
 * Description:
 *
 * @date:2019/12/17 20:49
 * @author:Wang Jun
 */
public interface GoodServiceI {
    LayuiResult searchallgood();
    LayuiResult searchgoodnameAndID(String name,String ID);
    List<Goods> getAllGoods(String sql);
    int total(String sql);
    String getGoodTypeByID(String typeID);
    User getSeller(String fksellerid);
}
