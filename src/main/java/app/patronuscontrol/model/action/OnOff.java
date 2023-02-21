package app.patronuscontrol.model.action;

import app.patronuscontrol.entity.object.attribute.enums.Attribute;
import lombok.Getter;

@Getter
public class OnOff implements Action {

    private final boolean state;


    public OnOff(boolean state) {
        this.state = state;
    }

    @Override
    public Attribute getAttribute() {
        return Attribute.ON_OFF;
    }
}
