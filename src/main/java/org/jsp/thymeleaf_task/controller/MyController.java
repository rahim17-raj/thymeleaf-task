package org.jsp.thymeleaf_task.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MyController {
    @GetMapping("/")
    public String getHome()
    {
        return "home";
    }

    @GetMapping("/otp")
    public String getOTP(ModelMap map)
    {
        int otp=new Random().nextInt(1000,10000);
        map.put("otp", otp);
        return "home";
    }

    @GetMapping("/toss")
    public String getCoinToss(ModelMap map)
    {
        List<String> coin=Arrays.asList("HEAD","TAILS");
        map.put("toss", coin.get(new Random().nextInt(0,2)));
        return "home";
    }

    @GetMapping("/random-color")
    public String getRandomColor(ModelMap map)
    {
        List<String> color=Arrays.asList("red","blue","green","orange");
        map.put("color", color.get(new Random().nextInt(0,color.size())));
        return "home";
    }

    @GetMapping("/wish")
    public String getWish(ModelMap map,@RequestParam String msg,@RequestParam String color)
    {
        map.put("msg", msg);
        map.put("color", color);    
        return "home";
    }

    @GetMapping("/calculator")
    public String getCalculator(ModelMap map,@RequestParam double num1,@RequestParam double num2,@RequestParam String opt)
    {
        map.put("num1", num1);
        map.put("num2", num2);
        double res=0;
        switch (opt) {
            case "add":
                res=num1+num2;
                break;
            case "sub":
                res=num1-num2;
                break;
            case "mul":
                res=num1*num2;
                break;
            case "div":
                res=num1/num2;
                break;
            default:
                break;
        }
        map.addAttribute("res", res);
        return "home";
    }
}
