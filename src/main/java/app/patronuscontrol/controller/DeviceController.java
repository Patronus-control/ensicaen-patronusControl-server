package app.patronuscontrol.controller;

import app.patronuscontrol.entity.DeviceEntity;
import app.patronuscontrol.model.dto.DeviceDTO;
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
     * @return List<DeviceDTO>
     */
    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    Iterable<DeviceDTO> getAllDevices() {
        return deviceService.getAllDevices().stream().map(DeviceEntity::toDTO).toList();
    }

    /**
     * Get Device by mac address
     * @param macAddr mac address
     * @return DeviceDTO
     */
    @GetMapping(value= "/macAddr/{macAddr}", produces = MediaType.APPLICATION_JSON_VALUE)
    DeviceDTO getDeviceByMacAddr(@PathVariable String macAddr) {
        return deviceService.findByMacAddr(macAddr).map(DeviceEntity::toDTO).orElse(null);
    }


    /**
     * Create a new device
     * @param device device to create
     * @return DeviceDTO
     */
    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    DeviceDTO createDevice(@RequestBody DeviceDTO device) {
        return deviceService.createDevice(device.toEntity()).toDTO();
    }

}
