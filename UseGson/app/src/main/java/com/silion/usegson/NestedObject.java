package com.silion.usegson;

/**
 * Created by silion on 2015/10/9.
 */
public class NestedObject {
    public int id;
    public String body;
    public float number;
    public String created_at;
    public Child child;

    public class Child {
        public int id;
        public String name;
    }

    public String toString() {
        return "NestedObject id = " + id + ", body = " + body +
                ", number = " + number + ", createdAt = " + created_at +
                "\n" +"child = " + this.child.id + ", " + this.child.name;
    }
}