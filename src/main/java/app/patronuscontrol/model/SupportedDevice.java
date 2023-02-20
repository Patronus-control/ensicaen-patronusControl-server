package app.patronuscontrol.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "supported_devices")
public class SupportedDevice {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "brand", referencedColumnName = "id", nullable = false)
    private SupportedBrand brand;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = true, length = 100)
    private String description;

    @Lob
    private byte[] icon;

    @OneToMany(mappedBy = "deviceType", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Device> devices = new ArrayList<>();
}
