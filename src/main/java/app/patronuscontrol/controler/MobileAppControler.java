package app.patronuscontrol.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MobileAppControler {
    @GetMapping("/")
    public String index() {
        return "MobileAppFront";
    }

    @PostMapping("/interract")
    public void interract() {

    }

    @PostMapping("/register")
    public void register() {

    }
}
