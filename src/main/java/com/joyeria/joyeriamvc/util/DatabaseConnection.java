/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.joyeria.joyeriamvc.util;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import javax.swing.JOptionPane;
/**
 *
 * @author hfria
 */
public class DatabaseConnection {

    public static Connection getConnection() {
            try {
                Properties props = new Properties();

                try (InputStream input = new FileInputStream("database.properties")) {
                    props.load(input);
                } catch (Exception e) {
                    try (InputStream input = DatabaseConnection.class.getClassLoader().getResourceAsStream("database.properties")) {
                        if (input == null) {
                            throw new RuntimeException("database.properties no fue encontrado");
                        }
                        props.load(input);
                    }
                }

                String url = props.getProperty("db.url");
                String user = props.getProperty("db.user");
                String password = props.getProperty("db.password");

                Connection connection = DriverManager.getConnection(url, user, password);
                return connection;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error en conexión a base de datos");
            }
        return null;

    }
   
    
}
