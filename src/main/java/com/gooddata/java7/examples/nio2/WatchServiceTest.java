/**
 * Copyright (C) 2007-2012, GoodData(R) Corporation. All rights reserved.
 */
package com.gooddata.java7.examples.nio2;

import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_DELETE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.List;
import java.util.concurrent.TimeUnit;

// http://www.javacodegeeks.com/2012/02/java-7-watchservice.html
public class WatchServiceTest {

    public void watchServiceExample() throws Exception {
        Path path = Paths.get("/home");
        WatchService watchService = FileSystems.getDefault().newWatchService();
        WatchKey watchKey = path.register(watchService, ENTRY_CREATE, ENTRY_DELETE, ENTRY_MODIFY);
        WatchKey watchKey2 = watchService.poll(60, TimeUnit.SECONDS);

        boolean notDone = true;

        while (notDone) {
            List<WatchEvent<?>> events = watchKey.pollEvents();

            for (WatchEvent event : events) {
                processEvent(watchKey, event);
            }

            if (!watchKey.reset()) {
                // ...handle situation no longer valid
            }
        }
    }

    private void processEvent(WatchKey watchKey, WatchEvent event) {
        // WatchKey watchable returns the calling Path object of Path.register
        Path watchedPath = (Path) watchKey.watchable();
        // returns the event type
        WatchEvent.Kind<?> eventKind = event.kind();
        // returns the context of the event
        Path target = (Path) event.context();
    }

}
