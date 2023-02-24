package app.patronuscontrol.service;

import app.patronuscontrol.entity.DeviceEntity;
import app.patronuscontrol.entity.object.HueObject;
import app.patronuscontrol.entity.object.ObjectEntity;
import app.patronuscontrol.entity.object.type.ObjectTypeEntity;
import app.patronuscontrol.model.dto.object.HueObjectDTO;
import app.patronuscontrol.repository.ObjectRepository;
import app.patronuscontrol.repository.ObjectTypeRepository;
import app.patronuscontrol.service.apiservice.BasicApiService;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Getter
@Service
public class ObjectService {

    private final ObjectRepository objectRepository;
    private final ObjectTypeRepository objectTypeRepository;

    private final BasicApiService basicApiService;

    public ObjectService(ObjectRepository objectRepository, ObjectTypeRepository objectTypeRepository, BasicApiService basicApiService) {
        this.objectRepository = objectRepository;
        this.objectTypeRepository = objectTypeRepository;
        this.basicApiService = basicApiService;
    }

    /**
     * Get all objects
     *
     * @return Iterable of all objects
     */
    public List<ObjectEntity> getAllObjects() {
        return objectRepository.findAll();
    }

    /**
     * Get object by id
     *
     * @param id id of object
     * @return ObjectEntity
     */
    public Optional<ObjectEntity> getObjectById(Long id) {
        return objectRepository.findById(id);
    }

    public HueObject getHueObject(int id) {
        return this.objectRepository.findByHueId(id).orElse(null);
    }

    public void createObjectTest() {
        Optional<ObjectTypeEntity> objectTypeOpt = this.objectTypeRepository.findById(1L);
        if (objectTypeOpt.isPresent()) {
            HueObject objectEntity = new HueObject();
            objectEntity.setHueId(1);
            objectEntity.setObjectTypeEntity(objectTypeOpt.get());
            objectRepository.save(objectEntity);
        }
    }

    public void initianlize() {
        basicApiService.initialize(this);
    }
}
