package app.patronuscontrol.model.dto;


import app.patronuscontrol.entity.DeviceEntity;
import app.patronuscontrol.entity.object.attribute.enums.Attribute;
import app.patronuscontrol.model.dto.object.ObjectDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;


@Getter
@Setter
public class DeviceDTO {

    private Long id;

    private PointDTO point;

    private String macAddr;

    private String name;

    private byte[] icon;

    private Map<Attribute, Object> stateList;

    private List<ObjectDTO> objectList;


    public DeviceEntity toEntity() {
        DeviceEntity deviceEntity = new DeviceEntity();
        deviceEntity.setId(this.id);
        deviceEntity.setMacAddr(this.macAddr);
        deviceEntity.setName(this.name);
        deviceEntity.setIcon(this.icon);
        if(this.point != null) {
            deviceEntity.setPointEntity(this.point.toEntity());
        }
        return deviceEntity;
    }




}
