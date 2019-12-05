package com.exchange.used.controler;

import com.exchange.used.configure.LayuiResult;
import com.exchange.used.entity.User;
import com.exchange.used.services.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

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
}
