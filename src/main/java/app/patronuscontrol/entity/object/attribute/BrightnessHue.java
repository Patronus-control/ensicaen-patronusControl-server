package app.patronuscontrol.entity.object.attribute;

import app.patronuscontrol.configuration.AppConfig;
import app.patronuscontrol.entity.object.ObjectEntity;
import app.patronuscontrol.entity.object.attribute.enums.Attribute;
import app.patronuscontrol.entity.object.attribute.enums.Brand;
import app.patronuscontrol.model.action.Action;
import app.patronuscontrol.model.action.Brightness;
import app.patronuscontrol.service.apiservice.PhilipsService;
import jakarta.persistence.Entity;
import jakarta.persistence.Transient;
import lombok.Getter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Getter
@Entity
public class BrightnessHue extends ObjectAttributeEntity {
    @Transient
    private int brightness;

    @Transient
    public static final int MAX_BRIGHT = 254;


    public BrightnessHue(ObjectAttributeEntity objectAttributeEntity) {
        super(objectAttributeEntity);
        this.setBrand(Brand.PHILIPS);
        this.setAttribute(Attribute.BRIGHTNESS);
    }

    public BrightnessHue() {
        super();
        this.setBrand(Brand.PHILIPS);
        this.setAttribute(Attribute.BRIGHTNESS);
    }

    @Override
    protected boolean execute(Action action, ObjectEntity objectEntity) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        PhilipsService philipsService = context.getBean(PhilipsService.class);

        Brightness specialisedAction = (Brightness) action;
        System.out.println(specialisedAction.getBrightness());

        try {
            philipsService.setBrightness(1, specialisedAction.getBrightness());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }

        return true;
    }

    public void setState(Object state) {
        System.out.println(state);
        this.brightness = (int) state;
    }

    @Override
    public Object getState() {
        return brightness;
    }
}
