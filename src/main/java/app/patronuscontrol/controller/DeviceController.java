package app.patronuscontrol.controller;

import app.patronuscontrol.entity.DeviceEntity;
import app.patronuscontrol.entity.object.ObjectEntity;
import app.patronuscontrol.entity.object.raycasting.PointEntity;
import app.patronuscontrol.model.action.Action;
import app.patronuscontrol.model.dto.DeviceDTO;
import app.patronuscontrol.model.dto.object.ObjectDTO;
import app.patronuscontrol.service.DeviceService;
import app.patronuscontrol.service.RayCastingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RequestMapping(value = "device")
@RestController
public class DeviceController {

    private final DeviceService deviceService;
    @Autowired
    private RayCastingService rayCastingService;


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


    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    DeviceDTO getDevice(@PathVariable Long id) {
        return deviceService.getDevice(id).toDTO();
    }


    /**
     * Get Device by mac address
     *
     * @param macAddr mac address
     * @return DeviceDTO
     */
    @GetMapping(value = "/macAddr/{macAddr}", produces = MediaType.APPLICATION_JSON_VALUE)
    DeviceDTO getDeviceByMacAddr(@PathVariable String macAddr) {
        return deviceService.findByMacAddr(macAddr).map(DeviceEntity::toDTOStateList).orElse(null);
    }

    /**
     * Execute an action
     *
     * @param action Action to execute
     * @param id     Device which will execute the action
     * @return Number of failed actions
     */
    @PostMapping(value = "/action/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    DeviceDTO doAction(@PathVariable Long id, @RequestBody Action action) {
        return deviceService.doAction(id, action).toDTOStateList();
    }

    /**
     * Create a new device
     *
     * @param device device to create
     * @return DeviceDTO
     */
    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    DeviceDTO createDevice(@RequestBody DeviceDTO device) {
        return deviceService.createDevice(device).toDTO();
    }


    @GetMapping(value = "/get-object/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    Iterable<ObjectDTO> getObjects(@PathVariable Long id) {
        return deviceService.getObjects(id).stream().map(ObjectEntity::toDTO).toList();
    }

    @GetMapping(value = "/get-device-state-list/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    DeviceDTO getDeviceStateList(@PathVariable Long id) {
        return deviceService.findById(id).map(DeviceEntity::toDTOStateList).orElse(null);
    }


    @PostMapping(value = "/add-object/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    void addObject(@PathVariable Long id, @RequestBody Long objectID) {
        deviceService.addObject(id, objectID);
    }

    @PostMapping(value = "/remove-object/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    void removeObject(@PathVariable Long id, @RequestBody Long objectID) {
        deviceService.removeObject(id, objectID);
    }


    @GetMapping(value = "/find-by-coordinates/{x}/{y}/{ang}", produces = MediaType.APPLICATION_JSON_VALUE)
    DeviceDTO findByCoordinates(@PathVariable Double x, @PathVariable Double y, @PathVariable Double ang) {
        return rayCastingService.searchDevice(new PointEntity(x, y), ang).map(DeviceEntity::toDTO).orElse(null);
    }


}
