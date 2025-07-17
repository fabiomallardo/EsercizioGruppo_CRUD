import java.sql.*;

public class Menu
{
    private static final String URL = "jdbc:mysql://localhost:3306/users_crud";
    private static final String USER = "root";
    private static String password = "tiPiacerebbeSaperla";
    private static Connection dbConnection = null;

    public static Connection getDbConnection()
    {
        return dbConnection;
    }

    //init method
    public static void init()
    {
        //inits scanner inputs
        GlobalScanner.InitScannerInputs();

        //password input
        password = PasswordField.readPassword("Insert password: ");

        //tries to establish a db connection
        try
        {
            dbConnection = DriverManager.getConnection(URL, USER, password);
        }

        //if connection failed
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    //run method
    public static void run()
    {
        //variables declaration & init
        int menuOption = 0;
        UserTable usrTable = new UserTable("users");

        do
        {
            //menu description
            System.out.println("\nScegliere una delle operazioni:");
            System.out.println("1: inserimento utente");
            System.out.println("2: visualizzazione utenti");
            System.out.println("3: modifica nome utente");
            System.out.println("4: Cancellazione utente");
            System.out.println("0: esci");

            //menu input
            menuOption = GlobalScanner.readIntInput();
            System.out.print("\n");

            switch(menuOption)
            {
                //option 1
                case 1:
                    break;

                //option 2
                case 2:
                    break;

                //option 3
                case 3:
                    break;

                //specified user id delete
                case 4:
                    int userId = GlobalScanner.readIntInput("Insert the user ID to delete", true);
                    usrTable.deleteUser(userId);
                    break;

                //exit
                case 0:
                    break;

                //menu input not available
                default:
                    System.out.println("Inserire un'opzione valida");
                    break;
            }
        }
        while(menuOption != 0);

        //closes scanner inputs
        GlobalScanner.CloseScannerInputs();

        //tries to close db connection
        try
        {
            dbConnection.close();
        }
        
        //if db connection close failed
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
