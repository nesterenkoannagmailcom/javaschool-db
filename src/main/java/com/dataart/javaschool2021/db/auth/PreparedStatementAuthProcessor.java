package com.dataart.javaschool2021.db.auth;

import com.dataart.javaschool2021.db.conn.DbConnectionProvider;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PreparedStatementAuthProcessor implements AuthProcessor {
    private final DbConnectionProvider dbConnectionProvider;

    public PreparedStatementAuthProcessor(DbConnectionProvider dbConnectionProvider) {
        this.dbConnectionProvider = dbConnectionProvider;
    }

    @Override
    public String performLogin(String userName, String password) throws Exception {
        Connection connection = dbConnectionProvider.getDbConnection();

        String sql = "select username from users " +
                "where username=? " +
                "  and password=?";

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, userName);
        statement.setString(2, password);

        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            return resultSet.getString(1);
        } else {
            return null;
        }
    }
}
