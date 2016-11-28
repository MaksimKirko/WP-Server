package com.github.maximkirko.wpserver.datamodel.action.impl;

import com.github.maximkirko.wpserver.datamodel.action.Action;

/**
 * Created by MadMax on 28.11.2016.
 */
public class AssignFee extends Action {

    public AssignFee() {

    }

    @Override
    public void performAction() {
        System.out.println("Fee was assigned.");
    }
}