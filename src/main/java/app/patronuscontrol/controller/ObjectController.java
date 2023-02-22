package app.patronuscontrol.controller;

import app.patronuscontrol.entity.object.ObjectEntity;
import app.patronuscontrol.model.dto.object.ObjectDTO;
import app.patronuscontrol.service.ObjectService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("object")
public class ObjectController {


    private final ObjectService objectService;

    ObjectController(ObjectService objectService) {
        this.objectService = objectService;
    }




    /**
     * Get all Objects
     *
     * @return List of Objects
     */
    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    Iterable<ObjectDTO> getAllObjects() {
        return objectService.getAllObjects().stream().map(ObjectEntity::toDTO).toList();
    }

    /**
     * Init all objects from the network
     */
    @GetMapping(value = "/initianlize")
    void initianlize() {
        objectService.initianlize();
    }


    /**
     * Test
     */
    @GetMapping(value = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
    void test() {
        objectService.createObjectTest();
    }

}
