package org.example;

import java.sql.DriverManager;
import java.sql.SQLException;

public class SalaAula {

    private String url = "jdbc:sqlite:salafatec.db";

    public void conectar() {


        try (var conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                var meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been created.");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public void criarTabela() {


        // SQL statement for creating a new table
        var sql = "CREATE TABLE IF NOT EXISTS sala ("
                + "	ra text PRIMARY KEY,"
                + "	name text NOT NULL"
                + ");";

        try (var conn = DriverManager.getConnection(url);
             var stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void addAluno(String nome, String ra) {
        String sql = "INSERT INTO sala(ra,name) VALUES('" + ra + "','" + nome + "')";
        System.out.println(sql);
        try (var conn = DriverManager.getConnection(url);
             var stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public void buscarTodos() {
        var sql = "SELECT * FROM sala";

        try (var conn = DriverManager.getConnection(url);
             var stmt = conn.createStatement();
             var rs = stmt.executeQuery(sql)) {


            System.out.println(rs);
            while (rs.next()) {
                System.out.println(rs.getString("ra"));
                System.out.println(rs.getString("name"));

            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
