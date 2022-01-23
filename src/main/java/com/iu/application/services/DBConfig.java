package com.iu.application.services;

@Configuration(proxyBeanMethods = false)
public class DBConfig {

    /**
     * Configure Database Source
     * @return datasource for jdbcTemplate
     */
    @Primary
    @Bean
    public HikariDataSource dataSource(){
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/officemanager");
        dataSource.setUsername("root");
        dataSource.setPassword("admin");
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setMaximumPoolSize(10);
        dataSource.setIdleTimeout(600000);
        return dataSource;
    }
}