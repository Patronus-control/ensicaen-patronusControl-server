package app.patronuscontrol.service;

import app.patronuscontrol.entity.DeviceEntity;
import app.patronuscontrol.repository.DeviceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeviceService {
    private final DeviceRepository deviceRepository;

    public DeviceService(DeviceRepository repo) {
        this.deviceRepository = repo;
    }

    public Optional<DeviceEntity> findByMacAddr(String macAddr) {
        return deviceRepository.findByMacAddr(macAddr);
    }

    public DeviceEntity createDevice(DeviceEntity device) {
        return deviceRepository.save(device);
    }

    public List<DeviceEntity> getAllDevices() {
        return deviceRepository.findAll();
    }
}
