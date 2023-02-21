package app.patronuscontrol.entity.object.type;

import app.patronuscontrol.entity.object.ObjectEntity;
import app.patronuscontrol.entity.object.attribute.ObjectAttributeEntity;
import app.patronuscontrol.model.action.Action;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "object_type")
public class ObjectTypeEntity {
    @OneToOne(cascade = CascadeType.ALL)
    ObjectAttributeEntity objectAttributeEntity;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(nullable = false)
    private Long id;


    private String name;


    public int doAction(Action action, ObjectEntity objectEntity) {
        return objectAttributeEntity.doAction(action, objectEntity);
    }



}
