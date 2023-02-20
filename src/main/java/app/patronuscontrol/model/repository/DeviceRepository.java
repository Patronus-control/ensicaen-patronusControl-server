package app.patronuscontrol.model.repository;

import app.patronuscontrol.model.entity.DeviceEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DeviceRepository extends JpaRepository<DeviceEntity, Long> {
    @Transactional
    @Query("FROM DeviceEntity d WHERE d.macAddr = ?1")
    public List<DeviceEntity> findByMacAddrOvr(@Param("macAddr") final String macAddr);
}
