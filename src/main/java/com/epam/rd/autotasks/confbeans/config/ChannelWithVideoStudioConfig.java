package com.epam.rd.autotasks.confbeans.config;

import com.epam.rd.autotasks.confbeans.video.Channel;
import com.epam.rd.autotasks.confbeans.video.VideoStudioImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.time.LocalDateTime;

@Configuration()
@ComponentScan("com.epam.rd.autotasks.confbeans.config")
@PropertySource("classpath:configResources.properties")
public class ChannelWithVideoStudioConfig {
    @Value("${franchise.name}")
    private String franchise;

    @Bean
    public Channel channel() {
        Channel channel = new Channel();
        for (int videoCounter = 1, yearCounter = 0; videoCounter <= 8; videoCounter++, yearCounter += 2) {
            studio().addDataForVideo(franchise + videoCounter,
                    LocalDateTime.of(2001 + yearCounter, 10, 18, 10, 0));
            channel.addVideo(studio().produce());
        }
        return channel;
    }

    @Bean
    public VideoStudioImpl studio() {
        return new VideoStudioImpl();
    }
}