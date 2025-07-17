
import java.sql.*;
import java.util.Scanner;

public class AggiornaUtente {
    static final String URL = "jdbc:mysql://localhost:3306/myscheme";
    static final String USER = "root";
    static final String PASSWORD = "dmty@Z'7(=x6";

    public static void main(String[] args) {
        Scanner scanNum = new Scanner(System.in);
        Scanner scanStr = new Scanner(System.in);

        int scelta;
        String bufferStr;

        while (true) {

            System.out.println("");
            System.out.println("   GESTIONE UTENTI JDBC");
            System.out.println("0. Esci");
            System.out.println("1. ");
            System.out.println("2. ");
            System.out.println("3. Aggiorna nome utente");
            System.out.println("4. ");

            System.out.print("Scelta: ");

            scelta = scanNum.nextInt();
            scanNum.nextLine(); // Smaltire newline

            if (scelta <= 0) {
                break;
            }

            switch (scelta) {
                case 1:

                    break;

                case 2:

                    break;

                case 3: // Aggiorna nome utente

                    // Lettura ID
                    System.out.print("Seleziona id dell'utente da rinominare: ");
                    scelta = scanNum.nextInt();
                    scanNum.nextLine(); // Smaltire newline

                    // Lettura nuovo nome
                    System.out.println("Nuovo nome utente: ");
                    bufferStr = scanStr.nextLine();

                    // Esecuzione statement
                    updateUtente(scelta, bufferStr);
                    break;

                case 0:
                    System.out.println("Uscita dal programma.");
                    break;
                default:
                    System.out.println("Scelta non valida.");
            }

        }

        scanStr.close();
        scanNum.close();

    }

    // CREATE
    public static void insertUtente(String nome, String email) {
        String sql = "INSERT INTO utenti (nome, email) VALUES (?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nome);
            stmt.setString(2, email);
            stmt.executeUpdate();
            System.out.println("Utente inserito.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // READ
    public static void readUtenti() {
        String sql = "SELECT * FROM utenti";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +
                        ", Nome: " + rs.getString("nome") +
                        ", Email: " + rs.getString("email"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Aggiorna nome utente
    public static void updateUtente(int id, String nuovoNome) {
        String sql = "UPDATE utenti SET nome = ? WHERE id = ?";
        try (
                Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nuovoNome);
            stmt.setInt(2, id);
            stmt.executeUpdate();
            System.out.println("Utente aggiornato.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}