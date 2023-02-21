package app.patronuscontrol.service;

import app.patronuscontrol.entity.object.attribute.OnOffLegrand;
import app.patronuscontrol.entity.object.type.ObjectTypeEntity;
import app.patronuscontrol.entity.object.attribute.ColorHue;
import app.patronuscontrol.entity.object.attribute.OnOffHue;
import app.patronuscontrol.repository.ObjectRepository;
import app.patronuscontrol.repository.ObjectTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ObjectTypeService {


    private final ObjectTypeRepository objectTypeRepository;
    @Autowired
    private ObjectRepository objectRepository;


    ObjectTypeService(ObjectTypeRepository objectTypeRepository) {
        this.objectTypeRepository = objectTypeRepository;
    }

    public void testMethod() {
        OnOffHue onOffHue = new OnOffHue(null);
        ColorHue colorHue = new ColorHue(onOffHue);
        ObjectTypeEntity lampeHUE = new ObjectTypeEntity();
        lampeHUE.setObjectAttributeEntity(colorHue);
        lampeHUE.setName("Lampe HUE");
        objectTypeRepository.save(lampeHUE);


        OnOffLegrand onOffLegrand = new OnOffLegrand(null);
        ObjectTypeEntity prise = new ObjectTypeEntity();
        prise.setObjectAttributeEntity(onOffLegrand);
        prise.setName("Prise Legrand");
        objectTypeRepository.save(prise);





    }


}

