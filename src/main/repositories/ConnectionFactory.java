package main.repositories;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
  public static Connection getConnection() throws SQLException {
    Properties props = new Properties();
    try (InputStream inputStream = ConnectionFactory.class.getClassLoader().getResourceAsStream("connectionDB.properties")) {
      props.load(inputStream);
    } catch (IOException e) {
      e.printStackTrace();
    }

    String url = props.getProperty("db.url");
    String username = props.getProperty("db.username");
    String password = props.getProperty("db.password");

    return DriverManager.getConnection(url, username, password);
  }
}

