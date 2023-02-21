package app.patronuscontrol.model.action;


import app.patronuscontrol.entity.object.attribute.enums.Attribute;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "attribute")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Color.class, name = "COLOR_CHANGE"),
        @JsonSubTypes.Type(value = OnOff.class, name = "ON_OFF")
})
public abstract class Action {

    public abstract Attribute getAttribute();


}
