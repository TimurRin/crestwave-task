package ru.timurrin.crestwave.task.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:config.properties")
public class Config {
    @Value("${tcp.server.address}")
    private String tcpServerAddress;

    @Value("${tcp.server.port}")
    private int tcpServerPort;

    public String getTcpServerAddress() {
        return tcpServerAddress;
    }

    public int getTcpServerPort() {
        return tcpServerPort;
    }
}