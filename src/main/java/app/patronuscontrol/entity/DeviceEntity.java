package app.patronuscontrol.entity;

import app.patronuscontrol.entity.object.ObjectEntity;
import app.patronuscontrol.entity.object.attribute.enums.Attribute;
import app.patronuscontrol.model.action.Action;
import app.patronuscontrol.model.dto.DeviceDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@Entity
@Table(name = "devices", indexes = @Index(name = "macIdx", columnList = "mac_addr"))
public class DeviceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "mac_addr", nullable = false, length = 17, unique = true)
    private String macAddr;

    @Column(nullable = false, length = 100)
    private String name;

    @Lob
    private byte[] icon;

    @ManyToMany
    private List<ObjectEntity> objectEntityList = new ArrayList<>();


    public int doAction(Action action) {
        int nbFailed = 0;

        for(ObjectEntity objectEntity: objectEntityList) {
            nbFailed += objectEntity.doAction(action);
        }

        return nbFailed;
    }


    public DeviceDTO toDTO() {
        DeviceDTO deviceDTO = new DeviceDTO();
        deviceDTO.setId(this.id);
        deviceDTO.setMacAddr(this.macAddr);
        deviceDTO.setName(this.name);
        deviceDTO.setIcon(this.icon);
        return deviceDTO;
    }

    public DeviceDTO toDTOStateList() {
        return this.toDTO(true);
    }

    public DeviceDTO toDTO(boolean withState) {
        DeviceDTO deviceDTO = this.toDTO();

        if(withState) {
            deviceDTO.setStateList(this.getStateList());
        }

        return deviceDTO;
    }

    private Map<Attribute, Object> getStateList() {
        Map<Attribute, Object> ret = new EnumMap<>(Attribute.class);

        for (ObjectEntity objEntity : objectEntityList) {
            ret.putAll(objEntity.getStateList());
        }

        return ret;
    }
}
