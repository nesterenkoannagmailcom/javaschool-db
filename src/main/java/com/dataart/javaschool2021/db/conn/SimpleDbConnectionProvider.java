package com.dataart.javaschool2021.db.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class SimpleDbConnectionProvider {
    public Connection getDbConnection() throws SQLException {
        Properties props = new Properties();
        props.setProperty("user", "postgres");
        props.setProperty("password", "123");

        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/demodb", props);
    }
}
