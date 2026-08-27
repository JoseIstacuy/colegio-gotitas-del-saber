
package main.java.edu.ingsoft.colegio.gotitas.config;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author PC
 */
public class DataBaseConnection {
    
    private static Connection connection;
    /*
    el singleton debe de ser privado, esto para evitar 
    que se creen instancias de esta clase
    */
    
    private DataBaseConnection(){}
        //metodos
        
        public static Connection getConnectionDataBase() throws SQLException{
            if(connection == null || connection.isClosed()){
                connection = DriverManager.getConnection(Credentials.URL_DB, Credentials.USER_MYSQL_DB, Credentials.PASS_DB);
            }
            return connection;
        }
    }

