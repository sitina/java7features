/**
 * Copyright (C) 2007-2012, GoodData(R) Corporation. All rights reserved.
 */
package com.gooddata.java7.examples.core;

import java.io.FileNotFoundException;

public class Exceptions {

    public void multipleExceptionsExample() {
        try {
            throwTest();
        } catch (FileNotFoundException | IllegalAccessException e) {
            // multiple exc. handling
        }
    }

    public static void throwTest() throws FileNotFoundException, IllegalAccessException {
        //
    }

}
