package app.patronuscontrol.repository;

import app.patronuscontrol.entity.DeviceEntity;
import app.patronuscontrol.entity.object.HueObject;
import app.patronuscontrol.entity.object.ObjectEntity;
import app.patronuscontrol.model.dto.object.HueObjectDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ObjectRepository extends JpaRepository<ObjectEntity, Long> {
    //@Query("SELECT o FROM HueObject o WHERE o.hueId = ?1")
    Optional<HueObject> findByHueId(int id);
}