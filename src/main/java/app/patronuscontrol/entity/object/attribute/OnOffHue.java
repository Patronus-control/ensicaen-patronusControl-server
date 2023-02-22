package app.patronuscontrol.entity.object.attribute;

import app.patronuscontrol.configuration.AppConfig;
import app.patronuscontrol.entity.object.HueObject;
import app.patronuscontrol.entity.object.ObjectEntity;
import app.patronuscontrol.entity.object.attribute.enums.Attribute;
import app.patronuscontrol.entity.object.attribute.enums.Brand;
import app.patronuscontrol.model.action.Action;
import app.patronuscontrol.model.action.OnOff;
import app.patronuscontrol.service.apiservice.PhilipsService;
import jakarta.persistence.Entity;
import jakarta.persistence.Transient;
import lombok.Getter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Getter
@Entity
public class OnOffHue extends ObjectAttributeEntity {
    @Transient
    private boolean on;


    public OnOffHue(ObjectAttributeEntity objectAttributeEntity) {
        super(objectAttributeEntity);
        this.setBrand(Brand.PHILIPS);
        this.setAttribute(Attribute.ON_OFF);
    }

    public OnOffHue() {
        super();
        this.setBrand(Brand.PHILIPS);
        this.setAttribute(Attribute.ON_OFF);
    }


    @Override
    protected boolean execute(Action action, ObjectEntity objectEntity) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        PhilipsService philipsService = context.getBean(PhilipsService.class);

        OnOff specialisezAction = (OnOff) action;

        try {
            philipsService.setLightOn(((HueObject) objectEntity).getHueId(), specialisezAction.isState());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }

        System.out.println("Hue ON/OFF  state :" + specialisezAction.isState());
        return true;
    }

    @Override
    public void setState(Object state) {
        this.on = (boolean) state;
    }

    public Object getState() {
        return isOn();
    }
}
