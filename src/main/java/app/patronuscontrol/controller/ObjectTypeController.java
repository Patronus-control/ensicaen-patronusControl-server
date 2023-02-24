package app.patronuscontrol.controller;

import app.patronuscontrol.service.ObjectTypeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/object-type")
public class ObjectTypeController {


    private final ObjectTypeService objectTypeService;


    public ObjectTypeController(ObjectTypeService objectTypeService) {
        this.objectTypeService = objectTypeService;
    }

    @GetMapping("/test")
    public void testMethod() {
        objectTypeService.testMethod();
    }

}
