package com.lmv.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties
public class Config {

    private CustomDataSourceConfig customDataSource;
    private LoggingConfig logging;

    public CustomDataSourceConfig getCustomDataSource() {
        return customDataSource;
    }

    public void setCustomDataSource(CustomDataSourceConfig customDataSource) {
        this.customDataSource = customDataSource;
    }

    public LoggingConfig getLogging() {
        return logging;
    }

    public void setLogging(LoggingConfig logging) {
        this.logging = logging;
    }
}
