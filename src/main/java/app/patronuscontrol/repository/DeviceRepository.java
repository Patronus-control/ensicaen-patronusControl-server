package app.patronuscontrol.repository;

import app.patronuscontrol.entity.DeviceEntity;
import app.patronuscontrol.entity.object.raycasting.PointEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DeviceRepository extends JpaRepository<DeviceEntity, Long> {
    Optional<DeviceEntity> findByPointEntity(PointEntity pointEntity);
    Optional<DeviceEntity> findByMacAddr(String macAddr);

}
