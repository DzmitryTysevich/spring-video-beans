package com.epam.rd.autotasks.confbeans.config;

import com.epam.rd.autotasks.confbeans.video.Channel;
import com.epam.rd.autotasks.confbeans.video.Video;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

import java.time.LocalDateTime;

@Configuration
@PropertySource("classpath:configResources.properties")
public class ChannelWithInjectedPrototypeVideoConfig {
    @Value("${franchise2.name}")
    private String movieName;

    private int day;
    private final LocalDateTime localDateTime = LocalDateTime.of(2001, 10, 1, 10, 0);

    @Bean
    @Scope(scopeName = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
    public Channel channel() {
        Channel channel = new Channel();
        for (int i = 0; i < 2; i++) {
            channel.addVideo(video());
            channel.addVideo(otherVideo());
            channel.addVideo(anotherOtherVideo());
        }
        channel.addVideo(video());
        return channel;
    }

    @Bean
    @Primary
    @Scope("prototype")
    public Video video() {
        return getVideo();
    }

    @Bean
    @Scope("prototype")
    public Video otherVideo() {
        return getVideo();
    }

    @Bean
    @Scope("prototype")
    public Video anotherOtherVideo() {
        return getVideo();
    }

    private Video getVideo() {
        Video video = new Video(movieName, localDateTime.plusDays(day));
        day = video.getPubTime().getDayOfMonth();
        return video;
    }
}