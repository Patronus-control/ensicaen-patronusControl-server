package app.patronuscontrol.repository;

import app.patronuscontrol.entity.object.raycasting.PointEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PointRepository extends JpaRepository<PointEntity, Long> {

}
