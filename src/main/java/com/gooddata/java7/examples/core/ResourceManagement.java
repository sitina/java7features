/**
 * Copyright (C) 2007-2012, GoodData(R) Corporation. All rights reserved.
 */
package com.gooddata.java7.examples.core;

import java.io.BufferedReader;
import java.io.FileReader;

public class ResourceManagement {

    public static void main(String[] args) throws Exception {
        String path = "src/com/gooddata/java7/examples/core/ResourceManagement.java";
        System.out.println(readLineJava7(path));
    }

    public static String readLineJava7(String path) throws Exception {
        try (
                FileReader fr = new FileReader(path);
                BufferedReader br = new BufferedReader(fr)) {
            return br.readLine();
        }
    }

}
