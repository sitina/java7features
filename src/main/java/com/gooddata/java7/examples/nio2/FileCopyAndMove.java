/**
 * Copyright (C) 2007-2012, GoodData(R) Corporation. All rights reserved.
 */
package com.gooddata.java7.examples.nio2;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Set;

public class FileCopyAndMove {

    private static final String FILE_EXAMPLE = "/tmp/MyStuff.txt";

    private static final String FILE_EXAMPLE_2 = "/tmp/MyStuff2.txt";

    @SuppressWarnings("unused")
    public void pathsExample() throws Exception {
        // base Path string "/usr"
        Path base = Paths.get("/usr");
        // foo Path string "/usr/foo"
        Path foo = base.resolve("foo");
        // bar Path string "/usr/foo/bar"
        Path bar = foo.resolve("bar");
        // relative Path string "foo/bar"
        Path relative = base.relativize(bar);
    }

    @SuppressWarnings("unused")
    public void createFile() throws Exception {
        Path target = Paths.get(FILE_EXAMPLE);
        Path file = Files.createFile(target);
    }

    public void createFileWithPermissions() throws Exception {
        Path target = Paths.get(FILE_EXAMPLE);
        Set<PosixFilePermission> perms = PosixFilePermissions.fromString("rw-rw-rw-");
        FileAttribute<Set<PosixFilePermission>> attr = PosixFilePermissions.asFileAttribute(perms);
        Files.createFile(target, attr);
    }

    public void deleteFile() throws Exception {
        Path target = Paths.get(FILE_EXAMPLE);
        Files.delete(target);
    }

    public void copyFile() throws Exception {
        Path source = Paths.get(FILE_EXAMPLE);
        Path target = Paths.get(FILE_EXAMPLE_2);
        Files.copy(source, target);

        // or

        Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
    }

    public void moveFile() throws Exception {
        Path source = Paths.get(FILE_EXAMPLE);
        Path target = Paths.get(FILE_EXAMPLE_2);

        Files.move(source, target, StandardCopyOption.REPLACE_EXISTING, StandardCopyOption.COPY_ATTRIBUTES);
    }

}
