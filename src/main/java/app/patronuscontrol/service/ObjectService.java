package app.patronuscontrol.service;

import app.patronuscontrol.entity.object.HueObject;
import app.patronuscontrol.entity.object.ObjectEntity;
import app.patronuscontrol.entity.object.type.ObjectTypeEntity;
import app.patronuscontrol.repository.ObjectRepository;
import app.patronuscontrol.repository.ObjectTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ObjectService {

    private final ObjectRepository objectRepository;
    private final ObjectTypeRepository objectTypeRepository;


    public ObjectService(ObjectRepository objectRepository, ObjectTypeRepository objectTypeRepository) {
        this.objectRepository = objectRepository;
        this.objectTypeRepository = objectTypeRepository;
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

    public void createObjectTest() {
        Optional<ObjectTypeEntity> objectTypeOpt = this.objectTypeRepository.findById(1L);
        if (objectTypeOpt.isPresent()) {
            HueObject objectEntity = new HueObject();
            objectEntity.setHueId(1);
            objectEntity.setObjectTypeEntity(objectTypeOpt.get());
            objectRepository.save(objectEntity);
        }


    }


}
