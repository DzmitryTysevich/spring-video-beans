package com.epam.rd.autotasks.confbeans.config;

import com.epam.rd.autotasks.confbeans.video.Channel;
import com.epam.rd.autotasks.confbeans.video.VideoStudio;
import com.epam.rd.autotasks.confbeans.video.VideoStudioImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration()
@PropertySource("classpath:configResources.properties")
public class ChannelWithVideoStudioConfig {
    @Value("${franchise.name}")
    private String movieName;

    @Bean
    public Channel channel() {
        Channel channel = new Channel();
        for (int i = 0; i < 8; i++) {
            channel.addVideo(studio().produce());
        }
        return channel;
    }

    @Bean
    public VideoStudio studio() {
        return new VideoStudioImpl(movieName,1, 2001, 10, 18, 10, 0);
    }
}