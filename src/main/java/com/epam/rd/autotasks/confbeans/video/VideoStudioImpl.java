package com.epam.rd.autotasks.confbeans.video;

import java.time.LocalDateTime;

public class VideoStudioImpl implements VideoStudio {
    private final String movieName;
    private int startVideoValue;
    private int year, month, dayOfMonth, hour, minute;

    public VideoStudioImpl(String movieName, int startVideoValue, int year, int month, int dayOfMonth, int hour, int minute) {
        this.movieName = movieName;
        this.startVideoValue = startVideoValue;
        this.year = year;
        this.month = month;
        this.dayOfMonth = dayOfMonth;
        this.hour = hour;
        this.minute = minute;
    }

    @Override
    public Video produce() {
        Video video = new Video(movieName + startVideoValue,
                LocalDateTime.of(year, month, dayOfMonth, hour, minute));
        startVideoValue++;
        year += 2;
        return video;
    }
}