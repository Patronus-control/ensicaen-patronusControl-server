package app.patronuscontrol.service;

import app.patronuscontrol.repository.ObjectAttributeRepository;
import org.springframework.stereotype.Service;

@Service
public class ObjectAttributeService {
    private final ObjectAttributeRepository objectAttributeRepository;

    public ObjectAttributeService(ObjectAttributeRepository objectAttributeRepository) {
        this.objectAttributeRepository = objectAttributeRepository;
    }


}
