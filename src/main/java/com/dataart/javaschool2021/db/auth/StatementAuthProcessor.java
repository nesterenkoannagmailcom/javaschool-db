package com.dataart.javaschool2021.db.auth;

import com.dataart.javaschool2021.db.conn.SimpleDbConnectionProvider;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StatementAuthProcessor implements AuthProcessor {
    private final SimpleDbConnectionProvider dbConnectionProvider = new SimpleDbConnectionProvider();

    @Override
    public String performLogin(String userName, String password) throws SQLException {
        Connection connection = dbConnectionProvider.getDbConnection();

        Statement statement = connection.createStatement();

        String sql = "select username from users " +
                "where username='" + userName + "' " +
                "  and password='" + password + "'";


        ResultSet resultSet = statement.executeQuery(sql);
        if (resultSet.next()) {
            return resultSet.getString("username");
        } else {
            return null;
        }
    }
}
