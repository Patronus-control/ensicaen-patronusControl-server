package app.patronuscontrol.entity.object.attribute;

import app.patronuscontrol.configuration.AppConfig;
import app.patronuscontrol.entity.object.ObjectEntity;
import app.patronuscontrol.entity.object.attribute.enums.Attribute;
import app.patronuscontrol.entity.object.attribute.enums.Brand;
import app.patronuscontrol.model.action.Action;
import app.patronuscontrol.model.action.OnOff;
import app.patronuscontrol.service.apiservice.PhilipsService;
import jakarta.persistence.Entity;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Entity
public class OnOffHue extends ObjectAttributeEntity {

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
        boolean actualState;

        try {
            actualState = philipsService.isLightOn(1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }

        if(actualState != specialisezAction.isState()) {
            try {
                philipsService.setLightOn(1, specialisezAction.isState());
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return false;
            }

        }

        System.out.println("Hue ON/OFF  state :" + specialisezAction.isState());
        return true;
    }

    @Override
    protected void udpateState() {

    }
}
