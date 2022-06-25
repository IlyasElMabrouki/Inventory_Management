package gestionstock;
import java.sql.*;

public class connection {

    public Connection con;

    public void connecter() {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/GestionStock", "root", "ilyas-2002");
        } 
        catch (Exception e) {
            System.err.println(e);
        }
    }

}
