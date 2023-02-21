package app.patronuscontrol.entity.object;

import app.patronuscontrol.entity.object.type.ObjectTypeEntity;
import app.patronuscontrol.model.action.Action;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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


    public void doAction(Action action) {
        objectTypeEntity.doAction(action, this);
    }

}
