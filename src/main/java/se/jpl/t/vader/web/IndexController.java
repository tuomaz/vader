package se.jpl.t.vader.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import se.jpl.t.vader.domain.SensorSample;
import se.jpl.t.vader.service.SensorSampleService;

/**
 * @author Fredrik Tuomas
 * 
 */
@Controller
public class IndexController {
    @Autowired
    SensorSampleService sss;
    
    @RequestMapping("/")
    public String first(Model model, HttpServletRequest request) {
        List<SensorSample> samples = sss.getRecent();
        model.addAttribute("samples", samples);
        return "index";
    }
}