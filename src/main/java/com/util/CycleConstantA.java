package com.util;

/** N3 - cyclic constant A -> B -> A. Scanner must be cycle-safe. */
public final class CycleConstantA {

    private CycleConstantA() {
    }

    public static final String URL_CYCLE_A = CycleConstantB.URL_CYCLE_B;
}
