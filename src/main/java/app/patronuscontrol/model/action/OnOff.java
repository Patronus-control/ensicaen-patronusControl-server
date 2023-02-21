package app.patronuscontrol.model.action;

import app.patronuscontrol.entity.Attribute;
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
