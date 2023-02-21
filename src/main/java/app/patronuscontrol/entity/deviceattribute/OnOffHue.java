package app.patronuscontrol.entity.deviceattribute;

import app.patronuscontrol.entity.Attribute;
import app.patronuscontrol.entity.Brand;
import app.patronuscontrol.model.action.Action;
import app.patronuscontrol.model.action.OnOff;
import jakarta.persistence.Entity;

@Entity
public class OnOffHue extends DeviceAttributeEntity {


    public OnOffHue(DeviceAttributeEntity deviceAttribute) {
        super(deviceAttribute);
        this.setBrand(Brand.PHILIPS);
        this.setAttribute(Attribute.ON_OFF);
    }

    public OnOffHue() {
        this.setBrand(Brand.PHILIPS);
        this.setAttribute(Attribute.ON_OFF);
    }


    @Override
    protected void execute(Action action) {



        System.out.println("Hue ON/OFF  state :" + ((OnOff)action).isState());

    }
}
