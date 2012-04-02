/**
 * Copyright (C) 2007-2012, GoodData(R) Corporation. All rights reserved.
 */
package com.gooddata.java7.examples.core;

public class Switches {

    public static void main(String[] args) {
        System.out.println(testSwitch("test1"));
        System.out.println(testSwitch("test2"));
        System.out.println(testSwitch("test3"));
    }

    public static String testSwitch(String parameter) {
        switch (parameter) {
        case "test1" :
            return "value was test1";
        case "test2" :
            return "value was test2";
        default:
            return "default value";
        }
    }

}
