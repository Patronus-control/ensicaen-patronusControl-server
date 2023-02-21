package app.patronuscontrol.entity.object.attribute;

import app.patronuscontrol.entity.object.ObjectEntity;
import app.patronuscontrol.entity.object.attribute.enums.Attribute;
import app.patronuscontrol.entity.object.attribute.enums.Brand;
import app.patronuscontrol.model.action.Action;
import app.patronuscontrol.model.action.Color;
import jakarta.persistence.Entity;

@Entity
public class ColorHue extends ObjectAttributeEntity {


    public ColorHue(ObjectAttributeEntity objectAttributeEntity) {
        super(objectAttributeEntity);
        this.setBrand(Brand.PHILIPS);
        this.setAttribute(Attribute.COLOR_CHANGE);
    }

    public ColorHue() {
        this.setBrand(Brand.PHILIPS);
        this.setAttribute(Attribute.COLOR_CHANGE);
    }

    @Override
    protected void execute(Action action, ObjectEntity objectEntity) {

        Color color = (Color) action;

        System.out.println("Hue ON/OFF  r :" + color.getRed() + " g :" + color.getGreen() + " b :" + color.getBlue());

    }
}
