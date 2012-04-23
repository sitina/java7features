/**
 * Copyright (C) 2007-2012, GoodData(R) Corporation. All rights reserved.
 */
package com.gooddata.java7.examples.core;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class ResourceManagement {

    public static void main(String[] args) throws Exception {
        String path = "src/main/java/com/gooddata/java7/examples/core/ResourceManagement.java";
        System.out.println(readLine(path));
    }

    public static String readLine(String path) {
        // resources must implement AutoCloseable interface
        try (FileReader fr = new ExtFileReader(path); BufferedReader br = new ExtBufferedReader(fr)) {
            return br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static class ExtFileReader extends FileReader {

        public ExtFileReader(String fileName) throws FileNotFoundException {
            super(fileName);
        }

        @Override
        public void close() throws IOException {
            super.close();
            System.out.println("FileReader close");
        }

    }

    public static class ExtBufferedReader extends BufferedReader {

        public ExtBufferedReader(Reader in) {
            super(in);
        }

        @Override
        public void close() throws IOException {
            super.close();
            System.out.println("BufferedReader close");
            throw new IOException();
        }

    }

}
