package app.patronuscontrol.controler;

import app.patronuscontrol.model.service.DeviceService;
import app.patronuscontrol.model.contract.InterractContract;
import app.patronuscontrol.model.contract.RegisterContract;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class MobileAppControler {
    private DeviceService deviceService;

    public MobileAppControler(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    @GetMapping("/")
    public String index() {
        return "MobileAppFront";
    }

    @PostMapping("/interract")
    public void interract(@RequestBody InterractContract interract) {
        // TODO : Création de l'objet vià la factory

        // TODO : Appel de l'action sur l'objet
    }

    @PostMapping("/register")
    public void register(@RequestBody RegisterContract register) {
        if(deviceService.findByMacAddrOvr(register.getMacAddr()).isEmpty()) {
            // TODO : insert
        } else {
            // TODO : throw error : mac already present
        }
    }
}
