// package com.example;

import java.sql.*;

public class UserTable
{
    private String tableName;

    public UserTable(String tableName)
    {
        this.tableName = tableName;
    }

    // DELETE
    public void deleteUser(int id)
    {
        //safe delete query
        String sql = "DELETE FROM ? WHERE id = ?";

        //tries to delete the user record specified
        try
        {
            //gets db connection
            Connection conn = Menu.getDbConnection();

            //creates a prepare statement for safe queries
            PreparedStatement stmt = conn.prepareStatement(sql);

            //sets first '?' parameter
            stmt.setString(1, tableName);
            stmt.setInt(2, id);

            //executes query
            stmt.executeUpdate();

            System.out.println("Utente eliminato.");
        }
        
        //if delete query failed
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
