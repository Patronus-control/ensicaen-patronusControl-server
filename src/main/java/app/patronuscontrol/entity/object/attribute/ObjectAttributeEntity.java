package app.patronuscontrol.entity.object.attribute;

import app.patronuscontrol.entity.object.ObjectEntity;
import app.patronuscontrol.entity.object.attribute.enums.Attribute;
import app.patronuscontrol.entity.object.attribute.enums.Brand;
import app.patronuscontrol.model.action.Action;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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


    protected abstract void execute(Action action, ObjectEntity objectEntity);

    public void doAction(Action action, ObjectEntity objectEntity) {
        if(action.getAttribute() == attribute) {
            execute(action, objectEntity);
        }
        if(objectAttributeEntity != null) {
            objectAttributeEntity.doAction(action, objectEntity);
        }
    }



}
