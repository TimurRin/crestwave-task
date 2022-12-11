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

    @Value("${params.min.start}")
    private int paramsMinStart;
    @Value("${params.max.start}")
    private int paramsMaxStart;
    @Value("${params.min.count}")
    private int paramsMinCount;
    @Value("${params.max.count}")
    private int paramsMaxCount;

    public String getTcpServerAddress() {
        return tcpServerAddress;
    }

    public int getTcpServerPort() {
        return tcpServerPort;
    }

    public int getParamsMinStart() {
        return paramsMinStart;
    }

    public int getParamsMaxStart() {
        return paramsMaxStart;
    }

    public int getParamsMinCount() {
        return paramsMinCount;
    }

    public int getParamsMaxCount() {
        return paramsMaxCount;
    }
}