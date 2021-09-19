package com.epam.rd.autotasks.confbeans.config;

import com.epam.rd.autotasks.confbeans.video.Channel;
import com.epam.rd.autotasks.confbeans.video.Video;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import java.time.LocalDateTime;

@Configuration
@ComponentScan("com.epam.rd.autotasks.confbeans.config")
@PropertySource("classpath:configResources.properties")
public class PrototypeChannelConfig {
    @Value("${video1.name}")
    private String name1;

    @Value("${video2.name}")
    private String name2;

    @Value("${video3.name}")
    private String name3;

    @Bean()
    @Scope("prototype")
    public Channel channel() {
        Channel channel = new Channel();
        channel.addVideo(video1());
        channel.addVideo(video2());
        channel.addVideo(video3());
        return channel;
    }

    @Bean()
    public Video video1() {
        return new Video(name1, LocalDateTime.of(2020, 10, 10, 10, 10));
    }

    @Bean()
    public Video video2() {
        return new Video(name2, LocalDateTime.of(2020, 10, 10, 10, 11));
    }

    @Bean()
    public Video video3() {
        return new Video(name3, LocalDateTime.of(2020, 10, 10, 10, 12));
    }

    @Bean()
    public Channel channelShadow() {
        return channel();
    }
}