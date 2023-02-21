package app.patronuscontrol.service;

import app.patronuscontrol.entity.deviceattribute.DeviceAttributeEntity;
import app.patronuscontrol.repository.DeviceAttributeRepository;
import org.springframework.stereotype.Service;

@Service
public class DeviceAttributeService {
    private final DeviceAttributeRepository deviceAttributeRepository;
    public DeviceAttributeService(DeviceAttributeRepository repo) {
        this.deviceAttributeRepository = repo;
    }


}
