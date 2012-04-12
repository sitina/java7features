/**
 * Copyright (C) 2007-2012, GoodData(R) Corporation. All rights reserved.
 */
package com.gooddata.java7.examples.core;

import java.io.FileNotFoundException;

import org.junit.Test;

public class Exceptions {

    @Test
    public void test() {
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
