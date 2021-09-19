package com.epam.rd.autotasks.confbeans.video;

import java.time.LocalDateTime;

public class VideoStudioImpl implements VideoStudio {
    private String name;
    private LocalDateTime localDateTime;

    public void addDataForVideo(String name, LocalDateTime localDateTime) {
        this.name = name;
        this.localDateTime = localDateTime;
    }

    @Override
    public Video produce() {
        return new Video(name, localDateTime);
    }
}