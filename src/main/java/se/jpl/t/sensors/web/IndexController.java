package se.jpl.t.sensors.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Fredrik Tuomas
 * 
 */
@Controller
public class IndexController {
    @RequestMapping("/")
    public String first() {
        return "index";
    }
    
    @RequestMapping("/index")
    public String index() {
        return "index";
    }
}