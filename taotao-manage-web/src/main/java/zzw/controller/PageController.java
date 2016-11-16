package zzw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by john on 2016/11/8.
 */
@Controller
@RequestMapping("/page")
public class PageController {

    @RequestMapping("{pageName}")
    public String toPage(@PathVariable String pageName) {



        return pageName;
    }
}
