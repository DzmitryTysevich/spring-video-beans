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
public class ChannelWithPhantomVideoStudioConfig {
    @Value("${franchise.name}")
    private String movieName;
    private int startVideoValue = 1;
    private int startYearValue = 2001;

    @Bean
    public Channel channel() {
        Channel channel = new Channel();
        for (int i = 0; i < 8; i++) {
            channel.addVideo(nextRelease());
        }
        return channel;
    }

    @Bean
    @Scope("prototype")
    public Video nextRelease() {
        return getVideo();
    }

    @Bean
    @Scope("prototype")
    public Video nextNextRelease() {
        return getVideo();
    }

    private Video getVideo() {
        Video video = new Video(movieName + startVideoValue,
                LocalDateTime.of(startYearValue, 10, 18, 10, 0));
        startVideoValue++;
        startYearValue += 2;
        return video;
    }
}