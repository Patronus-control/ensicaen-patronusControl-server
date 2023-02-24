package app.patronuscontrol.entity.object.attribute;

import app.patronuscontrol.entity.object.ObjectEntity;
import app.patronuscontrol.entity.object.attribute.enums.Attribute;
import app.patronuscontrol.entity.object.attribute.enums.Brand;
import app.patronuscontrol.model.action.Action;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.EnumMap;
import java.util.Map;

@Getter
@Setter
@Entity
@Table(name = "object_attributes")
public abstract class ObjectAttributeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    ObjectAttributeEntity objectAttributeEntity;


    @Enumerated(EnumType.ORDINAL)
    Brand brand;

    @Enumerated(EnumType.ORDINAL)
    Attribute attribute;

    ObjectAttributeEntity(ObjectAttributeEntity objectAttributeEntity) {
        this.objectAttributeEntity = objectAttributeEntity;
    }

    public ObjectAttributeEntity() {

    }


    protected abstract boolean execute(Action action, ObjectEntity objectEntity);

    public int doAction(Action action, ObjectEntity objectEntity) {
        int ret = 0;

        if(action.getAttribute() == attribute) {
            if(execute(action, objectEntity)) {
                ret = 1;
            }
        }

        if(objectAttributeEntity != null) {
            ret += objectAttributeEntity.doAction(action, objectEntity);
        }

        return ret;
    }

    public void setState(Object state) {
        if(objectAttributeEntity != null) {
            objectAttributeEntity.setState(state);
        }
    }

    public abstract Object getState();

    public Map<Attribute, Object> getStateList() {
        return getStateList(new EnumMap<>(Attribute.class));
    }

    public Map<Attribute, Object> getStateList(Map<Attribute, Object> ret) {
        ret.put(this.attribute, this.getState());

        if (this.objectAttributeEntity == null) {
            return ret;
        } else {
            return this.objectAttributeEntity.getStateList(ret);
        }
    }
}
