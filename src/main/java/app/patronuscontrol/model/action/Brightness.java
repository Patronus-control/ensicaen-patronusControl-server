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
public class Brightness extends Action {

    private float brightness;

    @Override
    public Attribute getAttribute() {
        return Attribute.BRIGHTNESS;
    }
}
