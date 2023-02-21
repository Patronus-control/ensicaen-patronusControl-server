package app.patronuscontrol.entity.object.attribute;

import app.patronuscontrol.entity.object.ObjectEntity;
import app.patronuscontrol.entity.object.attribute.enums.Attribute;
import app.patronuscontrol.entity.object.attribute.enums.Brand;
import app.patronuscontrol.model.action.Action;
import app.patronuscontrol.model.action.OnOff;
import jakarta.persistence.Entity;

@Entity
public class OnOffHue extends ObjectAttributeEntity {


    public OnOffHue(ObjectAttributeEntity objectAttributeEntity) {
        super(objectAttributeEntity);
        this.setBrand(Brand.PHILIPS);
        this.setAttribute(Attribute.ON_OFF);
    }

    public OnOffHue() {
        this.setBrand(Brand.PHILIPS);
        this.setAttribute(Attribute.ON_OFF);
    }


    @Override
    protected void execute(Action action, ObjectEntity objectEntity) {



        System.out.println("Hue ON/OFF  state :" + ((OnOff)action).isState());

    }
}