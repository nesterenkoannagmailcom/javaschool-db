package com.dataart.javaschool2021.db.conn;

import java.sql.Connection;
import java.sql.SQLException;

public interface DbConnectionProvider {
    Connection getDbConnection() throws SQLException;
}
