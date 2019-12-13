package com.exchange.used.controler;

import com.exchange.used.configure.LayuiResult;
import com.exchange.used.configure.search.*;
import com.exchange.used.entity.User;
import com.exchange.used.services.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Id;
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

    @RequestMapping(value = "/deleteuser/{id}",method = RequestMethod.POST)
    public LayuiResult deleteuser(@PathVariable String id){
        LayuiResult layuiResult = new LayuiResult();
        boolean flag = userServiceI.deleteuser(id);
        if (flag){
            layuiResult.setCode(0);
            layuiResult.setMsg("删除成功");
            return layuiResult;
        }
        else {
            layuiResult.setCode(-1);
            layuiResult.setMsg("删除失败");
            return layuiResult;
        }
    }

    @RequestMapping(value = "/username",method = RequestMethod.GET)
    public LayuiResult getusername(HttpServletRequest request){
        LayuiResult layuiResult = new LayuiResult();
        Object object = request.getSession().getAttribute("user");
        User user = (User) object;
        if (user!=null){
            layuiResult.setCode(0);
            layuiResult.setMsg(user.getUsername());
            layuiResult.getData().put(user.getUsername(),user);
            return layuiResult;
        }
        else {
            layuiResult.setCode(-1);
            layuiResult.setMsg("错误！");
            layuiResult.getData().put("未知用户名",null);
            return layuiResult;
        }
    }

    @RequestMapping(value = "/searchusers",method = RequestMethod.GET)
    public LayuiResult searchusers (@RequestParam String username,@RequestParam String power,@RequestParam Integer page,@RequestParam Integer limit){
        Condition condition = new Condition();
        condition.setTablename("users");
        condition.setPage(page);
        condition.setLimit(limit);
        if (username.length()>0){
            Where where1 = new Where();
            where1.setField("users.username");
            where1.setValue(username);
            where1.setSymbol(Symbol.E);
            condition.getWheres().add(where1);
        }
        if (power.length()>0){
            Where where2 = new Where();
            where2.setField("users.fkroleid");
            if (power.equals("管理员"))
            where2.setValue("1");
            else where2.setValue("2");
            where2.setSymbol(Symbol.D);
            condition.getWheres().add(where2);
        }
        SqlBulider sqlBulider = new SqlBulider(condition);
        return convertData(sqlBulider.getSql(),sqlBulider.getCountSql());
    }

    //更新用户数据
    @RequestMapping(value = "/modify/{id}",method = RequestMethod.POST)
    public LayuiResult modify(@RequestBody User user,@PathVariable String id){
        LayuiResult layuiResult = new LayuiResult();
        user.setUserid(id);
        boolean flag = userServiceI.modify(user);
        if (flag){
            layuiResult.setCode(0);
            layuiResult.setMsg("修改成功");
            return layuiResult;
        }
        else  {
          layuiResult.setCode(-1);
          layuiResult.setMsg("修改失败");
          return layuiResult;
        }
    }

    //根据ID查密码
    @RequestMapping(value = "getUserByID",method = RequestMethod.GET)
    public LayuiResult getUserByID(@RequestParam String id){
        return userServiceI.getuserbyID(id);
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
