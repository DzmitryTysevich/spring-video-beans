package com.epam.rd.autotasks.confbeans.config;

import com.epam.rd.autotasks.confbeans.video.Channel;
import com.epam.rd.autotasks.confbeans.video.Video;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import java.time.LocalDateTime;

@Configuration
@PropertySource("classpath:configResources.properties")
public class SingletonChannelWithPrototypeVideosConfig {
    @Value("${video1.name}")
    private String name1;

    @Value("${video2.name}")
    private String name2;

    @Value("${video3.name}")
    private String name3;

    @Bean()
    public Channel channel() {
        Channel channel = new Channel();
        channel.addVideo(video1());
        channel.addVideo(video2());
        channel.addVideo(video3());
        return channel;
    }

    @Bean()
    @Scope("prototype")
    public Video video1() {
        return new Video(name1, LocalDateTime.of(2020, 10, 10, 10, 10));
    }

    @Bean()
    @Scope("prototype")
    public Video video2() {
        return new Video(name2, LocalDateTime.of(2020, 10, 10, 10, 11));
    }

    @Bean()
    @Scope("prototype")
    public Video video3() {
        return new Video(name3, LocalDateTime.of(2020, 10, 10, 10, 12));
    }

    @Bean()
    public Channel channelShadow() {
        return channel();
    }
}
