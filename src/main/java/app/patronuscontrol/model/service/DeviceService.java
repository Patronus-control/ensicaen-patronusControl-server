package app.patronuscontrol.model.service;

import app.patronuscontrol.model.entity.DeviceEntity;
import app.patronuscontrol.model.repository.DeviceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeviceService {
    private DeviceRepository deviceRepository;

    public DeviceService(DeviceRepository repo) {
        this.deviceRepository = repo;
    }

    public List<DeviceEntity> findByMacAddrOvr(String macAddr) {
        return deviceRepository.findByMacAddrOvr(macAddr);
    }
}
