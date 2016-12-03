package com.github.maximkirko.wpserver.datamodel.action;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by MadMax on 28.11.2016.
 */
public enum ActionEnum {

    CallATowTruck,
    WheelsBlock,
    AssignFee;

    public static String getRusAction(ActionEnum actionEnum) {
        switch (actionEnum) {
            case CallATowTruck:
                return "Вызвать эвакуатор";
            case WheelsBlock:
                return "Заблокировать колёса";
            case AssignFee:
                return "Выписать штраф";
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
