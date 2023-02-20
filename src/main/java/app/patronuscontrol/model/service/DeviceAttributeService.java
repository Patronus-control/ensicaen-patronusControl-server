package app.patronuscontrol.model.service;

import app.patronuscontrol.model.repository.DeviceAttributeRepository;
import app.patronuscontrol.model.repository.DeviceRepository;
import org.springframework.stereotype.Service;

@Service
public class DeviceAttributeService {
    private DeviceAttributeRepository deviceAttributeRepository;

    public DeviceAttributeService(DeviceAttributeRepository repo) {
        this.deviceAttributeRepository = repo;
    }
}
