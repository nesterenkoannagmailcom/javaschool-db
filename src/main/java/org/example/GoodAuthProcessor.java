package org.example;

import java.sql.*;

public class GoodAuthProcessor implements AuthProcessor {

    @Override
    public String performLogin(String userName, String password) throws Exception {
        Class.forName("org.h2.Driver"); // поднять postgres в докере
        Connection connection = DriverManager.getConnection(" jdbc:h2:./demoDb");
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
