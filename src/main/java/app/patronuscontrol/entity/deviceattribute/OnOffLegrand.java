package app.patronuscontrol.entity.deviceattribute;

import app.patronuscontrol.entity.Attribute;
import app.patronuscontrol.entity.Brand;
import app.patronuscontrol.model.action.Action;
import app.patronuscontrol.model.action.OnOff;
import jakarta.persistence.Entity;

@Entity
public class OnOffLegrand extends DeviceAttributeEntity {


    public OnOffLegrand(DeviceAttributeEntity deviceAttribute) {
        super(deviceAttribute);
        this.setBrand(Brand.LEGRAND);
        this.setAttribute(Attribute.ON_OFF);
    }

    public OnOffLegrand() {
        this.setBrand(Brand.LEGRAND);
        this.setAttribute(Attribute.ON_OFF);
    }




    @Override
    protected void execute(Action action) {
        System.out.println("Hue ON/OFF  state :" + ((OnOff)action).isState());
    }
}
