package app.patronuscontrol.entity.object.type;

import app.patronuscontrol.entity.object.ObjectEntity;
import app.patronuscontrol.entity.object.attribute.ObjectAttributeEntity;
import app.patronuscontrol.entity.object.attribute.enums.Attribute;
import app.patronuscontrol.model.action.Action;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.EnumMap;
import java.util.Map;

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

    public void setState(Object state) {
        if(objectAttributeEntity != null) {
            objectAttributeEntity.setState(state);
        }
    }


    public Map<Attribute, Object> getStateList() {
        if(objectAttributeEntity != null) {
            return objectAttributeEntity.getStateList();
        }

        return new EnumMap<>(Attribute.class);
    }
}
