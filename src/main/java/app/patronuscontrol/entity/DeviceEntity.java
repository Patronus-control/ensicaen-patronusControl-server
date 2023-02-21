package app.patronuscontrol.entity;

import app.patronuscontrol.model.action.Action;
import app.patronuscontrol.model.dto.DeviceDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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


    @OneToOne
    private DeviceTypeEntity deviceTypeEntity;


    public void doAction(Action action) {
        if (deviceTypeEntity != null) {
            deviceTypeEntity.doAction(action);
        }
    }


    public DeviceDTO toDTO() {
        DeviceDTO deviceDTO = new DeviceDTO();
        deviceDTO.setId(this.id);
        deviceDTO.setMacAddr(this.macAddr);
        deviceDTO.setName(this.name);
        deviceDTO.setIcon(this.icon);
        return deviceDTO;
    }

}
