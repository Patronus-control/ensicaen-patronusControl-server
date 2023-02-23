package app.patronuscontrol.service;

import app.patronuscontrol.entity.DeviceEntity;
import app.patronuscontrol.entity.object.ObjectEntity;
import app.patronuscontrol.model.action.Action;
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

    public DeviceEntity createDevice(DeviceEntity device) {
        return deviceRepository.save(device);
    }

    public List<DeviceEntity> getAllDevices() {
        return deviceRepository.findAll();
    }

    public int doAction(Long id, Action action) {
        AtomicInteger ret = new AtomicInteger(0);

        this.deviceRepository.findById(id).ifPresent(device -> ret.set(device.doAction(action)));

        return ret.get();
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
}
