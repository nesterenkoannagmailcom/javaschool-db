package com.dataart.javaschool2021.db.auth;

import com.dataart.javaschool2021.db.conn.DbConnector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class StatementAuthProcessor implements AuthProcessor {

    @Override
    public String performLogin(String userName, String password) throws Exception {
        Connection connection = DbConnector.getDbConnection();

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
