package app.patronuscontrol.entity;

import app.patronuscontrol.entity.deviceattribute.DeviceAttributeEntity;
import app.patronuscontrol.model.action.Action;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "device_type")
public class DeviceTypeEntity {
    @OneToOne(cascade = CascadeType.ALL)
    DeviceAttributeEntity deviceAttributeEntity;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(nullable = false)
    private Long id;


    private String name;

    public void doAction(Action action) {
        if (deviceAttributeEntity != null) {
            deviceAttributeEntity.doAction(action);
        }
    }


}
