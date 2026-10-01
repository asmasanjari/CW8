package ir.maktabsharif.library.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConaction {
    private static String url = "jdbc:postgresql://localhost:5432/library";
    private static String user = "postgres";
    private static String password = "3411111208";

    public static Connection getConnection() throws SQLException {
        /*try {
            return DriverManager.getConnection(url, user, password);

        } catch (Exception e) {
            e.printStackTrace();*/
        return DriverManager.getConnection(url, user, password);

    }

}

