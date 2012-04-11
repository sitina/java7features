package com.gooddata.java7.examples.nio2;

import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.util.List;

public class ReadLines {

    public void test() throws Exception {
        List<String> lines =  Files.readAllLines(FileSystems.getDefault().getPath("test.txt"), StandardCharsets.UTF_8);
        for (String line : lines) System.out.println(line);
    }
}
