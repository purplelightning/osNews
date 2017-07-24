package com.example.wind.osnews.robot;

/**
 * Created by wind on 17-7-21.
 */

public class RobotResultBean {

    private int code;
    private String text;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "RobotResultBean{"+"code="+code+", text="
                +text+'\''+'}';
    }
}
