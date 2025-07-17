package com.example;

import java.sql.*;

public class Create {

    // 'URL di connessione al database MySQL 
    static String URL = "jdbc:mysql://localhost:3306/databaseJDBC";

    // Nome utente per l'accesso al database
    static String USER = "root";

    // Password per l'accesso al database
    static String PASSWORD = "";

    public static void main(String[] args) {

        // Chiamata al metodo che esegue l'inserimento di un utente nel database
        insertUtente("Alberto Bianchi", "alberto_bianchi@example.com");
    }

    // Metodo statico che esegue l'inserimento (CREATE) di un utente nel database
    public static void insertUtente(String nome, String email) {

        // Query SQL con parametri da sostituire con PreparedStatement 
        String sql = "INSERT INTO utenti (nome, email) VALUES (?, ?)";

        // Apertura del blocco try-with-resources che chiude automaticamente connessione e statement
        try (

            // Apertura della connessione al database
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);

            // Preparazione della query SQL da eseguire con parametri
            PreparedStatement stmt = conn.prepareStatement(sql)
        ) {
            // Sostituzione del primo parametro (?) con il nome ricevuto in input
            stmt.setString(1, nome);

            // Sostituzione del secondo parametro (?) con l'email ricevuta in input
            stmt.setString(2, email);

            // Esecuzione dell'istruzione SQL (INSERT)
            stmt.executeUpdate();

            System.out.println("L'utente " + nome + " con email " + email + " è stato inserito correttamente nel DB");

        // Gestione degli eventuali errori SQL 
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
