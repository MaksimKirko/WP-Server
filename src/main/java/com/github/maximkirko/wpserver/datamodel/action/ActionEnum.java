package com.github.maximkirko.wpserver.datamodel.action;

import com.github.maximkirko.wpserver.datamodel.action.impl.AssignFee;
import com.github.maximkirko.wpserver.datamodel.action.impl.CallATowTrack;
import com.github.maximkirko.wpserver.datamodel.action.impl.WheelsBlock;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MadMax on 28.11.2016.
 */
public enum ActionEnum {

    CallATowTrack,
    WheelsBlock,
    AssignFee;

    public static Action getActionFromEnum(ActionEnum actionEnum) {
        switch(actionEnum) {
            case CallATowTrack : return new CallATowTrack();
            case WheelsBlock: return new WheelsBlock();
            case AssignFee: return new AssignFee();
        }
        return null;
    }

    public static String getRusAction(ActionEnum actionEnum) {
        switch(actionEnum) {
            case CallATowTrack : return "Вызвать эвакуатор";
            case WheelsBlock: return "Заблокировать колёса";
            case AssignFee: return "Выписать штраф";
        }
        return null;
    }

    public static List<String> getRusActionList() {
        List<String> actions = new ArrayList<>();

        actions.add("Вызвать эвакуатор");
        actions.add("Заблокировать колёса");
        actions.add("Выписать штраф");

        return actions;
    }
}
