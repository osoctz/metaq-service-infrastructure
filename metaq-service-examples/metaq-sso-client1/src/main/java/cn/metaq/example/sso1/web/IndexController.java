package cn.metaq.example.sso1.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("index")
    public String index(){
        return "index";
    }

    @GetMapping("list")
    public String welcome(){

        System.out.printf("list");
        return "list";
    }
}