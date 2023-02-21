package app.patronuscontrol.entity.object.attribute;

import app.patronuscontrol.entity.object.ObjectEntity;
import app.patronuscontrol.entity.object.attribute.enums.Attribute;
import app.patronuscontrol.entity.object.attribute.enums.Brand;
import app.patronuscontrol.model.action.Action;
import app.patronuscontrol.model.action.OnOff;
import app.patronuscontrol.model.contract.PhilipsContract;
import app.patronuscontrol.model.contract.philips.HueLight;
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
    protected boolean execute(Action action, ObjectEntity objectEntity) {
        PhilipsContract contract = new PhilipsContract("http://192.168.1.5", "Tnkby-b77cXCG9YiIwoq7SZoMO07vAjL8TacIaKz");
        OnOff specialisezAction = (OnOff) action;
        boolean actualState;

        try {
            actualState = contract.isLightOn(1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }

        if(actualState != specialisezAction.isState()) {
            try {
                contract.setLightOn(1, specialisezAction.isState());
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return false;
            }

        }

        System.out.println("Hue ON/OFF  state :" + specialisezAction.isState());
        return true;
    }
}
