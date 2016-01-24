package com.tom.nullstuff;

import java.util.Collections;

public class UnknownJobRole extends JobRole {

    @Override
    public boolean isUnderSalaryBand() {
        return false;
    }

    @Override
    public boolean isHighTurnOverRole() {
        return false;
    }
}
