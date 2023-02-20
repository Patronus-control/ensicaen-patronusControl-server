package app.patronuscontrol.model.repository;

import app.patronuscontrol.model.entity.DeviceAttributeEntity;
import app.patronuscontrol.model.entity.DeviceAttributeId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceAttributeRepository extends JpaRepository<DeviceAttributeEntity, DeviceAttributeId> {

}
