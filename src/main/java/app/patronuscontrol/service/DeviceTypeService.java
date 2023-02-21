package app.patronuscontrol.service;

import app.patronuscontrol.entity.DeviceTypeEntity;
import app.patronuscontrol.entity.deviceattribute.ColorHue;
import app.patronuscontrol.entity.deviceattribute.OnOffHue;
import app.patronuscontrol.repository.DeviceTypeRepository;
import org.springframework.stereotype.Service;

@Service
public class DeviceTypeService {


    private final DeviceTypeRepository deviceTypeRepository;


    DeviceTypeService(DeviceTypeRepository deviceTypeRepository) {
        this.deviceTypeRepository = deviceTypeRepository;
    }

    public void testMethod() {
        OnOffHue onOffHue = new OnOffHue(null);

        ColorHue colorHue = new ColorHue(onOffHue);
        DeviceTypeEntity lampe = new DeviceTypeEntity();
        lampe.setDeviceAttributeEntity(colorHue);
        lampe.setName("Lampe HUE");
        deviceTypeRepository.save(lampe);


    }


}

