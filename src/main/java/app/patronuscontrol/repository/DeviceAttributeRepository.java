package app.patronuscontrol.repository;

import app.patronuscontrol.entity.deviceattribute.DeviceAttributeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceAttributeRepository extends JpaRepository<DeviceAttributeEntity, Long> {

}
