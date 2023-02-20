package app.patronuscontrol.model.contract;

import app.patronuscontrol.model.entity.Action;
import app.patronuscontrol.model.entity.Brand;
import lombok.Getter;
import org.springframework.data.util.Pair;

import java.util.List;

@Getter
public class RegisterContract {
    private Byte[] coordinate;
    private String macAddr;
    private String name;
    private Byte[] icon;
    private List<Pair<Action, Brand>> actions;
}