package com.dataart.javaschool2021.db.auth;

import com.dataart.javaschool2021.db.conn.DbConnectionProvider;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class StatementAuthProcessor implements AuthProcessor {
    private final DbConnectionProvider dbConnectionProvider;

    public StatementAuthProcessor(DbConnectionProvider dbConnectionProvider) {
        this.dbConnectionProvider = dbConnectionProvider;
    }

    @Override
    public String performLogin(String userName, String password) throws Exception {
        Connection connection = dbConnectionProvider.getDbConnection();

        Statement statement = connection.createStatement();

        String sql = "select username from users " +
                "where username='" + userName + "' " +
                "  and password='" + password + "'";


        ResultSet resultSet = statement.executeQuery(sql);
        if (resultSet.next()) {
            return resultSet.getString(1);
        } else {
            return null;
        }
    }
}
