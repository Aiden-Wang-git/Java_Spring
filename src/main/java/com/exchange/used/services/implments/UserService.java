package com.exchange.used.services.implments;

import com.exchange.used.configure.LayuiResult;
import com.exchange.used.entity.User;
import com.exchange.used.repository.UserRepository;
import com.exchange.used.services.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserServiceI {
    @Autowired
    UserRepository repository;
    @Override
    public LayuiResult login(String username, String password) {
        LayuiResult layuiResult = new LayuiResult();
        try {
            if (username == null || username.equals("") || password == null || password.equals("")) {
                layuiResult.setCode(-1);
                layuiResult.setMsg("用户名或者密码为空！");
                return layuiResult;
            }
            User user = repository.getByUsernameAndPassword(username, password);
            if (user == null) {
                layuiResult.setCode(-1);
                layuiResult.setMsg("您输入的用户名或者密码不正确!");
                return layuiResult;
            }
            layuiResult.setCode(0);
            if (user.getFkroleid().equals("1"))
                layuiResult.setMsg("管理员");
            else layuiResult.setMsg("用户");
            layuiResult.getData().put("user", user);
        }catch (Exception e){
            e.printStackTrace();
            layuiResult.setCode(-1);
            layuiResult.setMsg(e.getMessage());
        }
        return layuiResult;
    }

    @Override
    public boolean namever(String username) {
        try {
            User user =repository.getByUsername(username);
            if (user == null)
                return true;
            else return false;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean add(User user) {
        try {
            repository.save(user);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
