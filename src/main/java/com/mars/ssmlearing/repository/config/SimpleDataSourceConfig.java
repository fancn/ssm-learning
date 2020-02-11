package com.mars.ssmlearing.repository.config;

import com.mysql.cj.jdbc.Driver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import java.sql.SQLException;

@Configuration
public class SimpleDataSourceConfig {

    @Bean
    public SimpleDriverDataSource simpleDataSource() throws SQLException {
        return new SimpleDriverDataSource(new Driver(), "jdbc:mysql://172.22.5.5:3306/gear", "tester", "123456");
    }

}
