package com.mars.ssmlearing.repository.config;

import com.mysql.cj.jdbc.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import java.sql.SQLException;

@Configuration
public class SimpleDataSourceConfig {

    @Bean("simpleDataSource")
    public SimpleDriverDataSource simpleDataSource() throws SQLException {
        return new SimpleDriverDataSource(new Driver(), "jdbc:mysql://localhost:3306/ssm", "tester", "123456");
    }

    @Bean("jdbcTemplate")
    public JdbcTemplate buildJdbcTemplate(@Autowired SimpleDriverDataSource simpleDataSource) {
        return new JdbcTemplate(simpleDataSource);
    }
}
