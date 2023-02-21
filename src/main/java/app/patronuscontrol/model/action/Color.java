package app.patronuscontrol.model.action;

import app.patronuscontrol.entity.Attribute;
import lombok.Getter;

@Getter
public class Color implements Action {


    private final int red;
    private final int green;
    private final int blue;

    public Color(int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    @Override
    public Attribute getAttribute() {
        return Attribute.COLOR_CHANGE;
    }
}
