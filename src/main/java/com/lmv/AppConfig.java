package com.lmv;

import com.lmv.configuration.Config;
import com.lmv.util.AESEncryptionHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
@EnableConfigurationProperties(Config.class)
public class AppConfig {

    @Autowired
    Config config;


    @Bean
    @Primary
    public DataSource dataSource() {
        return DataSourceBuilder
                .create()
                .username(config.getCustomDataSource().getUsername())
                .password(AESEncryptionHelper.decrypt(config.getCustomDataSource().getPassword()))
                .url(config.getCustomDataSource().getUrl())
                .driverClassName(config.getCustomDataSource().getClassName())
                .build();
    }
}
