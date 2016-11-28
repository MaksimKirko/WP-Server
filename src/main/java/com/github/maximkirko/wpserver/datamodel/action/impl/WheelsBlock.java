package com.github.maximkirko.wpserver.datamodel.action.impl;

import com.github.maximkirko.wpserver.datamodel.action.Action;

/**
 * Created by MadMax on 28.09.2016.
 */
public class WheelsBlock extends Action {

    public WheelsBlock() {

    }

    @Override
    public void performAction() {
        System.out.print("Wheels were blocked.");
    }
}
