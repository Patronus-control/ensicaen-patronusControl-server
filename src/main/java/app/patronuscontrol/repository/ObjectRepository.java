package app.patronuscontrol.repository;

import app.patronuscontrol.entity.object.ObjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ObjectRepository extends JpaRepository<ObjectEntity, Long> {
}