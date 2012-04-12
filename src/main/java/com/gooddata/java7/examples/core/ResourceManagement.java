/**
 * Copyright (C) 2007-2012, GoodData(R) Corporation. All rights reserved.
 */
package com.gooddata.java7.examples.core;

import java.io.BufferedReader;
import java.io.FileReader;

public class ResourceManagement {

    public static void main(String[] args) throws Exception {
        String path = "src/com/gooddata/java7/examples/core/ResourceManagement.java";
        System.out.println(readLine(path));
    }

    public static String readLine(String path) throws Exception {
        // resources must implement AutoCloseable interface
        try (FileReader fr = new FileReader(path); BufferedReader br = new BufferedReader(fr)) {
            return br.readLine();
        }
    }

}
