package com.exchange.used.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String function1(){
        return "login" ;
    }
    @RequestMapping(value = "/manage",method = RequestMethod.GET)
    public String function2(){
        return "manage" ;
    }
    @RequestMapping(value = "/goods",method = RequestMethod.GET)
    public String function3(){
        return "goods" ;
    }
    @RequestMapping(value = "/rejister",method = RequestMethod.GET)
    public String function4() {return "register";}
}
