package app.patronuscontrol.model.contract.philips;

import app.patronuscontrol.entity.object.attribute.ObjectAttributeEntity;
import app.patronuscontrol.entity.object.attribute.enums.Attribute;
import lombok.Getter;

@Getter
public abstract class ConcreteObject {
    protected String name;
    protected ObjectAttributeEntity attribute;

    public Object getState(Attribute att) {
        return this.getState(att, this.attribute);
    }
    
    public abstract Object getState(Attribute att, ObjectAttributeEntity attEntity);
}
