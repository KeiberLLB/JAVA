package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConfigDB {
    //Variable que va a contener el estado de la conexión
    static Connection objConnection = null;
    //método par abrir la conexión entre java y la base de datos
    public static Connection openConnection() {
        try {
            //class forName permite obtener o implementar el driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Creamos variables con nuestra credenciales de la base de datos
            String url = "jdbc:mysql://localhost:3306/_01_jdbc";
            String user = "root";
            String password = "Rlwl2023.";
            //Establecemos la conexión
            objConnection = (Connection) DriverManager.getConnection(url, user, password);
            System.out.println("Successful connection!");
        } catch (ClassNotFoundException e) {
            System.out.println("Error >> Driver not Installed");
        } catch (SQLException e) {
            System.out.println("Error >> A connection to the database could not be established");
        }
        return objConnection;
    }

    public static void closeConnection() {
        try {
            if (objConnection != null) objConnection.close();
            System.out.println("Connection Finished");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}