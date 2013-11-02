package se.jpl.t.vader.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import se.jpl.t.vader.domain.SensorSample;
import se.jpl.t.vader.service.SensorSampleService;

@RequestMapping("/rest")
@Controller
public class RestController {
    @Autowired
    SensorSampleService sss;

    @ResponseStatus(HttpStatus.ACCEPTED)
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public void addPet(@RequestBody List<SensorSample> samples) {
        if (samples != null) {
            for (SensorSample sample : samples) {
                sss.save(sample);
            }
        }
    }
    
    @ResponseBody
    @RequestMapping(value ="/getOne", produces="application/json")
    public SensorSample getOne() {
        return sss.getOne();
    }
}
