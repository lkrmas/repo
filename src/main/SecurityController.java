package main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/security")
public class SecurityController {

    @RequestMapping("/access")
    public String security() {
        return "security";
    }

    @RequestMapping(value="/failure")
    public String failure() {
        return "security";
    }

    @RequestMapping(value="/success")
    public String success() {
        return "security";
    }

    @RequestMapping("/index")
    public String index() {
        return "security";
    }

}
