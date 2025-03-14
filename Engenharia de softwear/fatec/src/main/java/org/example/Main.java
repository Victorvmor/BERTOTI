package org.example;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Main {

    private static SalaAula sala = new SalaAula();

    public static void main(String[] args) {//TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        //sala.conectar();
        //sala.criarTabela();
        //sala.addAluno("joao", "123");
        sala.buscarTodos();
    }
}