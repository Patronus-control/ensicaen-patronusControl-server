package app.patronuscontrol.entity.object;

import app.patronuscontrol.entity.object.attribute.enums.Attribute;
import app.patronuscontrol.entity.object.type.ObjectTypeEntity;
import app.patronuscontrol.model.action.Action;
import app.patronuscontrol.model.dto.object.ObjectDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.EnumMap;
import java.util.Map;

@Getter
@Setter
@Entity
@Table(name = "object")
public abstract class ObjectEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @OneToOne
    private ObjectTypeEntity objectTypeEntity;


    public int doAction(Action action) {
        return objectTypeEntity.doAction(action, this);
    }


    public abstract ObjectDTO toDTO();

    void setState(Object state) {
        if(objectTypeEntity != null) {
            objectTypeEntity.setState(state);
        }
    }

    public Map<Attribute, Object> getStateList() {
        if(objectTypeEntity != null) {
            return objectTypeEntity.getStateList();
        }

        return new EnumMap<>(Attribute.class);
    }

    public abstract void fetchStateListAttributes();
}
