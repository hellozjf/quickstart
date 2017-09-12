package com.hellozjf.sqlserver;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestSqlServerConnection {
    public static void main(String[] args) throws Exception {
        String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String url = "jdbc:sqlserver://192.168.3.88:1433;DatabaseName=AIS20060107130036";

        Class.forName(driver);
        Connection conn = DriverManager.getConnection(url, "sa", "NBst1006");
        System.out.println("success");
        conn.close();
    }
}
