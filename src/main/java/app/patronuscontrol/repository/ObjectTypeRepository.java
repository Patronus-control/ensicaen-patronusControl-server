package app.patronuscontrol.repository;

import app.patronuscontrol.entity.object.type.ObjectTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObjectTypeRepository extends JpaRepository<ObjectTypeEntity, Long> {



}