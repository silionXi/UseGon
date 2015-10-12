package com.silion.usegson;

import java.util.Date;

/**
 * Created by silion on 2015/10/9.
 */
public class SingleObjectData {
    public int id;
    public String body;
    public float number;
    //user date format
    public Date created_at;

    public String toString() {
        return "SingleObjectData id = " + id + ", body = " + body +
                ", number = " + number + ", created_at = " + created_at;
    }
}