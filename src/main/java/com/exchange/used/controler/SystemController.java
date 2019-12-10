package com.exchange.used.controler;

import com.exchange.used.configure.LayuiResult;
import com.exchange.used.configure.search.Condition;
import com.exchange.used.configure.search.DataUser;
import com.exchange.used.configure.search.SqlBulider;
import com.exchange.used.entity.User;
import com.exchange.used.services.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/system")
public class SystemController {
    @Autowired
    UserServiceI userServiceI;

    @RequestMapping(value = "/login/{username}/{password}", method = RequestMethod.GET)
    public LayuiResult login(@PathVariable String username, @PathVariable String password, HttpServletRequest request) {
        LayuiResult layuiResult = userServiceI.login(username, password);
        if (layuiResult.getCode() == 0) {
            request.getSession().setAttribute("user", layuiResult.getData().get("user"));
        }
        return layuiResult;
    }

    @RequestMapping(value = "/namever/{username}", method = RequestMethod.GET)
    public LayuiResult namever(@PathVariable String username) {
        LayuiResult layuiResult = new LayuiResult();
        boolean flag = userServiceI.namever(username);
        if (flag) {
            layuiResult.setCode(0);
            layuiResult.setMsg("用户名可用");
        } else {
            layuiResult.setCode(-1);
            layuiResult.setMsg("用户已存在");
        }
        return layuiResult;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public LayuiResult register(@RequestBody User user) {
        LayuiResult layuiResult = new LayuiResult();
        user.setFkroleid("2");
        if (userServiceI.add(user)) {
            layuiResult.setCode(0);
            layuiResult.setMsg("添加成功");
        } else {
            layuiResult.setCode(-1);
            layuiResult.setMsg("添加失败");
        }
        return layuiResult;
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public LayuiResult getUsers(@RequestParam Integer page,@RequestParam Integer limit){
        Condition condition = new Condition();
        condition.setTablename("users");
        condition.setPage(page);
        condition.setLimit(limit);
        SqlBulider sqlBulider = new SqlBulider(condition);
        return convertData(sqlBulider.getSql(),sqlBulider.getCountSql());
    }

    public LayuiResult convertData(String sql, String countsql){
        LayuiResult result = new LayuiResult();
        java.util.List<User> list = userServiceI.getAllUsers(sql);
        List<DataUser> dataUserList = new ArrayList<>();
        if (dataUserList != null){
            for (int i = 0;i<list.size();++i){
                dataUserList.add(SystemController.converUser(list.get(i)));
            }
            result.setCode(0);
            result.setMsg("全部用户的信息");
            result.setCount(userServiceI.total(countsql));
            result.getData().put("users", dataUserList);
        }else {
            result.setCode(-1);
            result.setMsg("获取人员信息错误");
        }
        return result;
    }

    public static DataUser converUser(User user){
        DataUser dataUser = new DataUser();
        dataUser.setId(user.getUserid());
        dataUser.setUsername(user.getUsername());
        if (user.getAge()!=null) dataUser.setSex(user.getSex());
        if (user.getEmail()!=null) dataUser.setEmail(user.getEmail());
        if (user.getPhone()!=null) dataUser.setRealname(user.getPhone());
        if (user.getRealname()!=null) dataUser.setRealname(user.getRealname());
        if (user.getFkroleid().equals("1")) dataUser.setPower("管理员");
        else dataUser.setPower("一般用户");
        return dataUser;
    }
}
