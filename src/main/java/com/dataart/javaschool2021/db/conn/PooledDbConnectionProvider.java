package com.dataart.javaschool2021.db.conn;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class PooledDbConnectionProvider implements DbConnectionProvider {
    HikariConfig config = new HikariConfig();
    HikariDataSource ds;

    public PooledDbConnectionProvider() {
        config.setJdbcUrl("jdbc:postgresql://localhost:5432/demodb");
        config.setUsername("postgres");
        config.setPassword("123");
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "5");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "100");
        ds = new HikariDataSource(config);
    }

    @Override
    public Connection getDbConnection() throws SQLException {
        return ds.getConnection();
    }
}
