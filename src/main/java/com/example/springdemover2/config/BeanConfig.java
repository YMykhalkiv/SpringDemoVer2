package com.example.springdemover2.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class BeanConfig {

     @Bean
    public DataSource getDataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("com.mysql.cj.jdbc.Driver");
        dataSourceBuilder.url("jdbc:mysql://yarikdb2.c9a4ysg2ihs0.eu-central-1.rds.amazonaws.com:3306/YarikDemoDB");
        dataSourceBuilder.username("admin");
        dataSourceBuilder.password("adminadmin");
        return dataSourceBuilder.build();
    }
}
