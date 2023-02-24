package app.patronuscontrol.service;

import app.patronuscontrol.entity.DeviceEntity;
import app.patronuscontrol.entity.object.ObjectEntity;
import app.patronuscontrol.model.action.Action;
import app.patronuscontrol.model.dto.DeviceDTO;
import app.patronuscontrol.model.dto.object.ObjectDTO;
import app.patronuscontrol.repository.DeviceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.DoubleStream;

@Service
public class DeviceService {
    private final DeviceRepository deviceRepository;

    private final ObjectService objectService;

    public DeviceService(DeviceRepository deviceRepository, ObjectService objectService) {
        this.deviceRepository = deviceRepository;
        this.objectService = objectService;
    }

    public Optional<DeviceEntity> findByMacAddr(String macAddr) {
        return deviceRepository.findByMacAddr(macAddr);
    }

    public Optional<DeviceEntity> findById(Long id) {
        return deviceRepository.findById(id);
    }

    public DeviceEntity createDevice(DeviceDTO device) {
        DeviceEntity deviceEntity = device.toEntity();
        for(ObjectDTO objectDTO: device.getObjectList()) {
            deviceEntity.getObjectEntityList().add(this.objectService.getObjectById(objectDTO.getId()).orElse(null));
        }

        return deviceRepository.save(deviceEntity);
    }

    public List<DeviceEntity> getAllDevices() {
        return deviceRepository.findAll();
    }

    public DeviceEntity doAction(Long id, Action action) {
        Optional<DeviceEntity> deviceEntity = this.deviceRepository.findById(id);
        deviceEntity.ifPresent(entity -> entity.doAction(action));
        return deviceEntity.orElse(null);
    }

    public List<ObjectEntity> getObjects(Long id) {
        return this.deviceRepository.findById(id).map(DeviceEntity::getObjectEntityList).orElse(null);
    }

    public void addObject(Long id, Long objectId) {
        this.deviceRepository.findById(id).ifPresent(device -> {
            objectService.getObjectById(objectId).ifPresent(objectEntity -> {
                device.getObjectEntityList().add(objectEntity);
                this.deviceRepository.save(device);
            });
        });
    }

    public void removeObject(Long id, Long objectID) {
        this.deviceRepository.findById(id).ifPresent(device -> {
            objectService.getObjectById(objectID).ifPresent(objectEntity -> {
                device.getObjectEntityList().remove(objectEntity);
                this.deviceRepository.save(device);
            });
        });
    }

    public DeviceEntity getDevice(Long id) {
        return this.deviceRepository.findById(id).orElse(null);
    }
}
