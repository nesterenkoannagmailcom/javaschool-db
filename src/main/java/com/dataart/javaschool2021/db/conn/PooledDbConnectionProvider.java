package com.dataart.javaschool2021.db.conn;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Пул коннектов к БД.
 * Обычно приложения не создают коннекты бесконтрольно, а используют ограниченный пул
 * и обычно приложения не тратят время на открытие коннекта каждый раз, а переиспользуют их -
 * подключение к БД - дорогая операция
 */
public class PooledDbConnectionProvider {
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

    public Connection getDbConnection() throws SQLException {
        return ds.getConnection();
    }
}
