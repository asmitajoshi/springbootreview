package aj.springbootreview.one.controllers;

import aj.springbootreview.one.services.SimpleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SimpleController {
    @Autowired
    SimpleService simpleService;

    public SimpleController() {}
    @RequestMapping("/")
    public @ResponseBody String defaultGreeting() {
        return "Hello, World";
    }

    @RequestMapping("/greeting")
    public @ResponseBody String greeting() {
        return simpleService.greet();
    }
}
