package app.patronuscontrol.model;

import jakarta.persistence.*;

@Entity
@Table(name = "device_attributes")
@IdClass(DeviceAttributeId.class)
public class DeviceAttribute {
    @Id
    @ManyToOne
    @JoinColumn(name = "device", referencedColumnName = "id")
    private SupportedDevice supportedDevice;

    @Id
    @ManyToOne
    @JoinColumn(name = "attribute", referencedColumnName = "id")
    private Attribute attribute;
}
