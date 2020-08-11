package com.redfeng.test2.state.properties;

import net.minecraft.util.IStringSerializable;

public enum QSlabType implements IStringSerializable {
    FIRST("first"),
    SECOND("second"),
    THIRD("third"),
    FOURTH("fourth"),
    ALL("all");

    private final String name;

    private QSlabType(String name) {
        this.name = name;
    }

    public String toString() {
        return this.name;
    }

    public String getName() {
        return this.name;
    }
}