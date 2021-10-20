package com.dataart.javaschool2021.db.auth;

import com.dataart.javaschool2021.db.conn.PooledDbConnectionProvider;
import com.dataart.javaschool2021.db.conn.SimpleDbConnectionProvider;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PreparedStatementAuthProcessor implements AuthProcessor {
    private final PooledDbConnectionProvider dbConnectionProvider = new PooledDbConnectionProvider();

    @Override
    public String performLogin(String userName, String password) throws Exception {
        try (Connection connection = dbConnectionProvider.getDbConnection()) {

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
}
