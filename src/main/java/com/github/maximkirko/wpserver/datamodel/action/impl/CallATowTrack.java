package com.github.maximkirko.wpserver.datamodel.action.impl;


import com.github.maximkirko.wpserver.datamodel.action.Action;

import javax.persistence.*;


/**
 * Created by MadMax on 28.09.2016.
 */

//@Entity
//@Inheritance(strategy = InheritanceType.JOINED)
//@DiscriminatorColumn(name = "TYPE")
public class CallATowTrack extends Action {

    public CallATowTrack() {

    }

    @Override
    public void performAction() {
        System.out.println("Tow track called.");
    }
}
