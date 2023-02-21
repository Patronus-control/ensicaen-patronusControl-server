package app.patronuscontrol.entity.deviceattribute;

import app.patronuscontrol.entity.Attribute;
import app.patronuscontrol.entity.Brand;
import app.patronuscontrol.model.action.Action;
import app.patronuscontrol.model.action.Color;
import jakarta.persistence.Entity;

@Entity
public class ColorHue extends DeviceAttributeEntity {


    public ColorHue(DeviceAttributeEntity deviceAttribute) {
        super(deviceAttribute);
        this.setBrand(Brand.PHILIPS);
        this.setAttribute(Attribute.COLOR_CHANGE);
    }

    public ColorHue() {
        this.setBrand(Brand.PHILIPS);
        this.setAttribute(Attribute.COLOR_CHANGE);
    }

    @Override
    protected void execute(Action action) {

        Color color = (Color) action;

        System.out.println("Hue ON/OFF  r :" + color.getRed() + " g :" + color.getGreen() + " b :" + color.getBlue());

    }
}
