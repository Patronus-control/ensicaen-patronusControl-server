package app.patronuscontrol.entity;

import app.patronuscontrol.entity.object.ObjectEntity;
import app.patronuscontrol.model.action.Action;
import app.patronuscontrol.model.dto.DeviceDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "devices", indexes = @Index(name = "macIdx", columnList = "mac_addr"))
public class DeviceEntity {
    @Id
    private Long id;
    @Column(name = "mac_addr", nullable = false, length = 17, unique = true)
    private String macAddr;

    @Column(nullable = false, length = 100)
    private String name;

    @Lob
    private byte[] icon;

    @ManyToMany
    private List<ObjectEntity> objectEntityList;


    public int doAction(Action action) {
        int nb_failed = 0;

        for(ObjectEntity objectEntity: objectEntityList) {
            nb_failed += objectEntity.doAction(action);
        }

        return nb_failed;
    }


    public DeviceDTO toDTO() {
        DeviceDTO deviceDTO = new DeviceDTO();
        deviceDTO.setId(this.id);
        deviceDTO.setMacAddr(this.macAddr);
        deviceDTO.setName(this.name);
        deviceDTO.setIcon(this.icon);
        return deviceDTO;
    }

    public DeviceDTO toDTO(boolean withState) {
        DeviceDTO deviceDTO = new DeviceDTO();
        if(withState) {
            // TODO
           // deviceDTO.setStateList(this.getStateList());
        }
        return deviceDTO;
    }


}
