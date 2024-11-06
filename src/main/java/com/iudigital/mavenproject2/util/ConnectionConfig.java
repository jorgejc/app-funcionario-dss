package com.iudigital.mavenproject2.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionConfig {

    private static final String URL = "jdbc:mysql://localhost:3306/movies-film";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";
    
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

}
