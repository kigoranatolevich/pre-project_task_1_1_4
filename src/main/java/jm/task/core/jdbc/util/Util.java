package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    // реализуйте настройку соеденения с БД
    private final static String URL =
            "jdbc:mysql://localhost:3306/pre_project_task_1_1_4?useUnicode=true" +
                    "&useSSL=true&useJDBCCompliantTimezoneShift=true" +
                    "&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private final static String USERNAME = "root";
    private final static String PASSWORD = "root";
    private static volatile Connection con;

    private Util() {

    }

    public static Connection getConnection() {
        if (con == null) {
            synchronized (Util.class) {
                if (con == null) {
                    try {
                        con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                        System.out.println("Соединение создано");
                    } catch (SQLException e) {
                        System.out.println("Ошибка соединения");
                        e.printStackTrace();
                        throw new RuntimeException(e);
                    }
                }
            }
        }

        return con;
    }
}
