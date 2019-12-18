package com.exchange.used.services.implments;

import com.exchange.used.configure.LayuiResult;
import com.exchange.used.entity.Goods;
import com.exchange.used.entity.Type;
import com.exchange.used.entity.User;
import com.exchange.used.repository.GoodsRepository;
import com.exchange.used.repository.TypeRepository;
import com.exchange.used.repository.UserRepository;
import com.exchange.used.services.GoodServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName:GoodService
 * Package:com.exchange.used.services.implments
 * Description:
 *
 * @date:2019/12/17 20:55
 * @author:Wang Jun
 */
@Service
public class GoodService implements GoodServiceI {
    @Autowired
    GoodsRepository goodsRepository;
    @Autowired
    TypeRepository typeRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public LayuiResult searchallgood() {
        LayuiResult layuiResult = new LayuiResult();
        ArrayList<Goods> list = (ArrayList<Goods>) goodsRepository.findAll();
        for (Goods goods:list){
            layuiResult.getData().put(goods.getGoodsid(),goods);
        }
        return layuiResult;
    }

    @Override
    public LayuiResult searchgoodnameAndID(String name, String ID) {
        return null;
    }

    @Override
    public List<Goods> getAllGoods(String sql) {
        try {
            List<Goods> list = new ArrayList<>();
            list = jdbcTemplate.query(sql,new Object[]{},new BeanPropertyRowMapper<>(Goods.class));
            if (list.size()>0)
                return list;
            else return null;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int total(String sql) {
        try {
            return jdbcTemplate.queryForObject(sql,Integer.class);
        }catch (Exception e){
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public String getGoodTypeByID(String typeID) {
        try {
            return (typeRepository.getTypeByTypeid(typeID)).getTypename();
        }catch (Exception e){
            e.printStackTrace();
        }
        return "商品类型不存在";
    }

    @Override
    public User getSeller(String fksellerid) {
        try {
            User user = userRepository.getByUserid(fksellerid);
            if (user!=null)
                return user;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


}
