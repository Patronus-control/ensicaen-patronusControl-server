package app.patronuscontrol.repository;

import app.patronuscontrol.entity.object.attribute.ObjectAttributeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObjectAttributeRepository extends JpaRepository<ObjectAttributeEntity, Long> {

}
