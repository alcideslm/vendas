package tarefas.conn;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Alcides Lemos
 */
public class ConnPostgres extends ConnGeneric{
    private static final String DBURL = "jdbc:postgresql://localhost:5432/pi";
    private static final String USER = "postgres";
    private static final String PASS = "182950";
    
    
    public ConnPostgres(){
        try {
            Class.forName("org.postgresql.Driver");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    
    @Override
    public Connection getConnection() {
        if (conn == null){
            try {
                conn = (Connection) DriverManager.getConnection(DBURL,USER,PASS);
                System.out.println("Conectou ao DB!");
            } catch (Exception e) { 
                e.printStackTrace();
            }
        }
        return conn;
    }
}
