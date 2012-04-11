/**
 * Copyright (C) 2007-2012, GoodData(R) Corporation. All rights reserved.
 */
package com.gooddata.java7.examples.nio2;

import java.net.URI;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathExample {

    public static void main(String[] args) throws Exception {
        // You can easily create a Path object by using one of the following get methods from the Paths (note the plural) helper class:
        Path p1 = Paths.get("/tmp/foo");
        Path p2 = Paths.get(args[0]);
        Path p3 = Paths.get(URI.create("file:///Users/joe/FileTest.java"));

        // The Paths.get method is shorthand for the following code:
        Path p4 = FileSystems.getDefault().getPath("/users/sally");

        // The following example creates /u/joe/logs/foo.log assuming your home directory is /u/joe, or C:\joe\logs\foo.log if you are on Windows.
        Path p5 = Paths.get(System.getProperty("user.home"), "logs", "foo.log");
    }

}
