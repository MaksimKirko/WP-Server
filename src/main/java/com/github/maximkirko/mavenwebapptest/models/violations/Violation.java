package com.github.maximkirko.mavenwebapptest.models.violations;

import com.github.maximkirko.mavenwebapptest.management.IAction;

/**
 * Created by Pavel on 12.10.2016.
 */
public abstract class Violation {

    private String description;
    private double fee;
    private IAction action;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public IAction getAction() {
        return action;
    }

    public void setAction(IAction action) {
        this.action = action;
    }

    public abstract Enum getType();
}
