package app.patronuscontrol.entity.deviceattribute;

import app.patronuscontrol.entity.Attribute;
import app.patronuscontrol.entity.Brand;
import app.patronuscontrol.model.action.Action;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "device_attributes")
public abstract class DeviceAttributeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    DeviceAttributeEntity deviceAttributeEntity;


    @Enumerated(EnumType.ORDINAL)
    Brand brand;

    @Enumerated(EnumType.ORDINAL)
    Attribute attribute;

    DeviceAttributeEntity(DeviceAttributeEntity deviceAttribute) {
        this.deviceAttributeEntity = deviceAttribute;
    }

    public DeviceAttributeEntity() {

    }


    protected abstract void execute(Action action);

    public void doAction(Action action) {
        if(action.getAttribute() == attribute) {
            execute(action);
        }
        if(deviceAttributeEntity != null) {
            deviceAttributeEntity.doAction(action);
        }
    }



}
