package app.patronuscontrol.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "device_attributes")
@IdClass(DeviceAttributeId.class)
public class DeviceAttributeEntity {
    @Id
    @ManyToOne
    @JoinColumn(name = "device", referencedColumnName = "id")
    private DeviceEntity supportedDevice;

    @Id
    @Enumerated(EnumType.ORDINAL)
    private Action action;

    @Id
    @Enumerated(EnumType.ORDINAL)
    private Brand brand;
}
