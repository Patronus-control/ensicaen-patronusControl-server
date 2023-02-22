package app.patronuscontrol.controller;

import app.patronuscontrol.entity.DeviceEntity;
import app.patronuscontrol.entity.object.ObjectEntity;
import app.patronuscontrol.model.action.Action;
import app.patronuscontrol.model.dto.DeviceDTO;
import app.patronuscontrol.model.dto.object.ObjectDTO;
import app.patronuscontrol.service.DeviceService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "device")
@RestController
public class DeviceController {

    private final DeviceService deviceService;


    public DeviceController(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    /**
     * Get All Devices
     *
     * @return List<DeviceDTO>
     */
    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    Iterable<DeviceDTO> getAllDevices() {
        return deviceService.getAllDevices().stream().map(DeviceEntity::toDTO).toList();
    }

    /**
     * Get Device by mac address
     *
     * @param macAddr mac address
     * @return DeviceDTO
     */
    @GetMapping(value = "/macAddr/{macAddr}", produces = MediaType.APPLICATION_JSON_VALUE)
    DeviceDTO getDeviceByMacAddr(@PathVariable String macAddr) {
        return deviceService.findByMacAddr(macAddr).map(DeviceEntity::toDTO).orElse(null);
    }

    /**
     * Execute an action
     *
     * @param action Action to execute
     * @param id Device which will execute the action
     * @return Number of failed actions
     */
    @PostMapping(value = "/action/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    int doAction(@PathVariable Long id, @RequestBody Action action) {
        return deviceService.doAction(id, action);
    }

    /**
     * Create a new device
     *
     * @param device device to create
     * @return DeviceDTO
     */
    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    DeviceDTO createDevice(@RequestBody DeviceDTO device) {
        return deviceService.createDevice(device.toEntity()).toDTO();
    }


    @GetMapping(value= "/get-object/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    Iterable<ObjectDTO> getObjects(@PathVariable Long id) {
        return deviceService.getObjects(id).stream().map(ObjectEntity::toDTO).toList();
    }


    @PostMapping(value= "/add-object/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    void addObject(@PathVariable Long id, @RequestBody Long objectID) {
        deviceService.addObject(id, objectID);
    }

    @PostMapping(value= "/remove-object/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    void removeObject(@PathVariable Long id, @RequestBody Long objectID) {
        deviceService.removeObject(id, objectID);
    }


}
