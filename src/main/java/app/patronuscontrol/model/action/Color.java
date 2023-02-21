package app.patronuscontrol.model.action;

import app.patronuscontrol.entity.object.attribute.enums.Attribute;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Color extends Action {


    private int red;
    private int green;
    private int blue;


    @Override
    public Attribute getAttribute() {
        return Attribute.COLOR_CHANGE;
    }
}
