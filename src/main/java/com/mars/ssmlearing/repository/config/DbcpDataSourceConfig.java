package com.mars.ssmlearing.repository.config;

import com.mysql.cj.jdbc.Driver;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import java.sql.SQLException;

@Configuration
public class DbcpDataSourceConfig {

    @Bean("dbcpDataSource")
    public BasicDataSource dbcpDataSource() throws SQLException {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriver(new Driver());
        dataSource.setUrl("jdbc:mysql://localhost:3306");
        dataSource.setUsername("tester");
        dataSource.setPassword("123456");
        dataSource.setMaxIdle(5);
        dataSource.setMaxWaitMillis(100000);
        dataSource.setMaxTotal(10);
        return dataSource;
    }

    @Bean("dbcpTransactionManager")
    public PlatformTransactionManager buildTransactionManager(@Qualifier("dbcpDataSource") BasicDataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean("dbcpJdbcTemplate")
    public JdbcTemplate buildJdbcTemplate(@Qualifier("dbcpDataSource") BasicDataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
