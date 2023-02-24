package app.patronuscontrol.model.dto;


import app.patronuscontrol.entity.DeviceEntity;
import app.patronuscontrol.entity.object.attribute.enums.Attribute;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;


@Getter
@Setter
public class DeviceDTO {

    private Long id;

    private String macAddr;

    private String name;

    private byte[] icon;

    private Map<Attribute, Object> stateList;


    public DeviceEntity toEntity() {
        DeviceEntity deviceEntity = new DeviceEntity();
        deviceEntity.setId(this.id);
        deviceEntity.setMacAddr(this.macAddr);
        deviceEntity.setName(this.name);
        deviceEntity.setIcon(this.icon);
        return deviceEntity;
    }




}
