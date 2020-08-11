package com.redfeng.test2.state.properties;

import net.minecraft.util.IStringSerializable;

public enum MySlabType implements IStringSerializable {
    TOP("top"),
    BOTTOM("bottom"),
    DOUBLE("double");

    private final String name;

    private MySlabType(String name) {
        this.name = name;
    }

    public String toString() {
        return this.name;
    }

    public String getName() {
        return this.name;
    }
}