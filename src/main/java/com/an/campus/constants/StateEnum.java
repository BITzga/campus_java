package com.an.campus.constants;

public enum StateEnum {

    SUCCESS(200), WARN(400), ERROR(500);

    private int state;

    StateEnum(int state) {
        this.state = state;
    }

    public int getState() {
        return state;
    }
}
