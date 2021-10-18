package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class BrokenAuthProcessor implements AuthProcessor {

    @Override
    public String performLogin(String userName, String password) throws Exception {
        Class.forName("org.postgresql.Driver"); // поднять postgres в докере
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/demodb?user=postgres&password=123");
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
