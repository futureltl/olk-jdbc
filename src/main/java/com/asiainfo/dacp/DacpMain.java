package com.asiainfo.dacp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class DacpMain {

    public static void main(String[] args) {

        if (null == args || args.length < 4) {
            System.out.println("Please input 4 parameters like jdbc-url username password sql.");
            return;
        }

        String jdbcURL = args[0];
        String userName = args[1];
        String password = args[2];
        String sql = args[3];

        try (Connection connection = DriverManager.getConnection(jdbcURL, userName, password);
                Statement stmt = connection.createStatement();
                ResultSet resultSet = stmt.executeQuery(sql);) {

            System.out.println(String.format("%10s", "col0"));
            String col0 = null;
            int count = 0;
            while (resultSet.next()) {
                col0 = resultSet.getString(1);
                System.out.println(String.format("row%d %s", count, col0));
                count++;
            }

            System.out.println("\ntotal=" + count);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
