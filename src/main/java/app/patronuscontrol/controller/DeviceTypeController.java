package app.patronuscontrol.controller;

import app.patronuscontrol.service.DeviceTypeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/device-type")
public class DeviceTypeController {


    private final DeviceTypeService deviceTypeService;


    public DeviceTypeController(DeviceTypeService deviceTypeService) {
        this.deviceTypeService = deviceTypeService;
    }

    @GetMapping("/test")
    public void testMethod() {
        deviceTypeService.testMethod();
    }

}
