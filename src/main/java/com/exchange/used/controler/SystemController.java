package com.exchange.used.controler;

import com.exchange.used.configure.LayuiResult;
import com.exchange.used.services.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/system")
public class SystemController {
    @Autowired
    UserServiceI userServiceI;
    @ResponseBody
    @RequestMapping(value = "/login/{username}/{password}",method = RequestMethod.GET)
    public LayuiResult login(@PathVariable String username, @PathVariable String password, HttpServletRequest request){
        LayuiResult layuiResult = userServiceI.login(username,password);
        if (layuiResult.getCode()==0){
            request.getSession().setAttribute("user",layuiResult.getData().get("user"));
        }
        return layuiResult;
    }
}
