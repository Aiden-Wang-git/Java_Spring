package com.exchange.used.controler;

import com.exchange.used.configure.LayuiResult;
import com.exchange.used.configure.searchGood.DataGood;
import com.exchange.used.configure.searchUser.*;
import com.exchange.used.entity.Goods;
import com.exchange.used.repository.GoodsRepository;
import com.exchange.used.services.GoodServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName:GoodController
 * Package:com.exchange.used.controler
 * Description:
 *
 * @date:2019/12/17 20:50
 * @author:Wang Jun
 */
@Controller
@RequestMapping(value = "/system")
public class GoodController {
    @Autowired
    GoodServiceI goodServiceI;

    @RequestMapping(value = "/allgood",method = RequestMethod.POST)
    public LayuiResult allgood(){
        return goodServiceI.searchallgood();
    }

    @RequestMapping(value = "/searchgood",method = RequestMethod.GET)
    public LayuiResult searchgood(@RequestParam String goodID,@RequestParam String goodName,@RequestParam Integer page,@RequestParam Integer limit)
    {
        Condition condition = new Condition();
        condition.setPage(page);
        condition.setLimit(limit);
        condition.setTablename("goods");
        if (goodID.length()>0){
            Where where1 = new Where();
            where1.setField("goods.goodsid");
            where1.setValue(goodID);
            where1.setSymbol(Symbol.D);
            condition.getWheres().add(where1);
        }
        if (goodName.length()>0){
            Where where2 = new Where();
            where2.setField("goods.goodsname");
            where2.setField(goodName);
            where2.setSymbol(Symbol.E);
            condition.getWheres().add(where2);
        }
        SqlBulider sqlBulider = new SqlBulider(condition);
        return convertData(sqlBulider.getSql(),sqlBulider.getCountSql());

    }

    public LayuiResult convertData(String sql, String countsql){
        LayuiResult result = new LayuiResult();
        java.util.List<Goods> list = goodServiceI.getAllGoods(sql);
        List<DataGood> dataGoodList = new ArrayList<>();
        if (list != null){
            for (int i = 0;i<list.size();++i){
                dataGoodList.add(converGoods(list.get(i)));
            }
            result.setCode(0);
            result.setMsg("全部商品的信息");
            result.setCount(goodServiceI.total(countsql));
            result.getData().put("goods", dataGoodList);
        }else {
            result.setCode(-1);
            result.setMsg("获取商品信息错误");
        }
        return result;
    }

    public DataGood converGoods(Goods goods){
        DataGood dataGood = new DataGood();
        dataGood.setGoodID(goods.getGoodsid());
        if (goods.getFksellerid()!=null) dataGood.setSeller(goodServiceI.getSeller(goods.getFksellerid()).getUsername());
        if (goods.getFktypeid()!=null) dataGood.setType(goods.getFktypeid());
        if (goods.getGoodnum()!=null) dataGood.setGoodnum(goods.getGoodnum());
        if (goods.getGoodscreatetime()!=null) dataGood.setGoodscreatetime(goods.getGoodscreatetime());
        if (goods.getGoodsdesc()!=null) dataGood.setGoodsdesc(goods.getGoodsdesc());
        if (goods.getGoodsimg1()!=null) dataGood.setGoodsimg1(goods.getGoodsimg1());
        if (goods.getGoodsimg2()!=null) dataGood.setGoodsimg1(goods.getGoodsimg2());
        if (goods.getGoodsimg3()!=null) dataGood.setGoodsimg3(goods.getGoodsimg3());
        if (goods.getGoodsname()!=null) dataGood.setGoodname(goods.getGoodsname());
        if (goods.getGoodsprice()!=null) dataGood.setGoodsprice(goods.getGoodsprice());
        if (goods.getGoodsunit()!=null) dataGood.setGoodsunit(goods.getGoodsunit());
        if (goods.getGoodsstar()!=null) dataGood.setGoodsstar(goods.getGoodsstar());
        return dataGood;
    }

}
