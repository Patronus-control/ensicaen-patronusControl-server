package app.patronuscontrol.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "device_attributes")
@IdClass(DeviceAttributeId.class)
public class DeviceAttribute {
    @Id
    @ManyToOne
    @JoinColumn(name = "device", referencedColumnName = "id")
    private SupportedDevice supportedDevice;

    @Id
    @Enumerated(EnumType.ORDINAL)
    private Action action;

    @Id
    @Enumerated(EnumType.ORDINAL)
    private Brand brand;
}
