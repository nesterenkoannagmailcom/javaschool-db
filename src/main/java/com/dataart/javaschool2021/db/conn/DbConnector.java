package com.dataart.javaschool2021.db.conn;

import java.sql.Connection;
import java.sql.SQLException;

public class DbConnector {
    private static final DbConnectionProvider dbConnectionProvider
            // TODO тут можно переключиться на использование пула коннектов
            // обычно приложения используют ограниченный пул, а не создают коннекты бесконтрольно
            // и переиспользуют открытые соединения, а не тратят время на установку новых
            = new SimpleDbConnectionProvider();
//            = new PooledDbConnectionProvider();

    public static DbConnectionProvider getInstance() {
        return dbConnectionProvider;
    }

    public static Connection getDbConnection() throws SQLException {
        return getInstance().getDbConnection();
    }
}
