/**
 * Copyright (C) 2007-2012, GoodData(R) Corporation. All rights reserved.
 */
package com.gooddata.java7.examples.core;

import java.io.FileNotFoundException;

public class Exceptions {

    public static void main(String[] args) {
        try {
            throwTest();
        } catch (FileNotFoundException | IllegalAccessException e) {
            // exc. handling
        }
    }

    public static void throwTest() throws FileNotFoundException, IllegalAccessException {
        //
    }

}
