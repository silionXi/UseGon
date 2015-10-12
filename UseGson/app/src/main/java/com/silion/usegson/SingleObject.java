package com.silion.usegson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by silion on 2015/10/9.
 */
public class SingleObject {
    public int id;
    public String body;
    public float number;
    //public String created_at;
    @SerializedName("created_at")
    public String createdAt;

    public String toString() {
        return "SingleObject id = " + id + ", body = " + body +
                ", number = " + number + ", createdAt = " + createdAt;
    }
}