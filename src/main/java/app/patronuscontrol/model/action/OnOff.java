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
public class OnOff extends Action {

    private boolean state;

    @Override
    public Attribute getAttribute() {
        return Attribute.ON_OFF;
    }
}
