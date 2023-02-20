package app.patronuscontrol.model.contract;

import app.patronuscontrol.model.entity.Action;
import lombok.Getter;

@Getter
public class InterractContract {
    private String macAddr;

    private Action action;
}
