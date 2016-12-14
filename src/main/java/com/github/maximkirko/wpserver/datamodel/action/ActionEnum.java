package com.github.maximkirko.wpserver.datamodel.action;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by MadMax on 28.11.2016.
 */
public enum ActionEnum {

    CallATowTruck ("Вызвать эвакуатор"),
    WheelsBlock ("Заблокировать колёса"),
    AssignFee ("Выписать штраф");

    private final String name;

    private ActionEnum(String v) {
        name = v;
    }

    public static ActionEnum getAction(String s) {

        for (ActionEnum en : ActionEnum.values()) {
            if (en.toString().equals(s)) {
                return en;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return this.name;
    }

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

    public static List<ActionEnum> getActions() {
        List<ActionEnum> actions = new ArrayList<>();
        actions.add(CallATowTruck);
        actions.add(WheelsBlock);
        actions.add(AssignFee);

        return actions;
    }

    public static List<String> getRusActionList() {
        List<String> actions = new ArrayList<>();

        actions.add("Вызвать эвакуатор");
        actions.add("Заблокировать колёса");
        actions.add("Выписать штраф");

        return actions;
    }
}
