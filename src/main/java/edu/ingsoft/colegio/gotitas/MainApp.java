
package main.java.edu.ingsoft.colegio.gotitas;

import javafx.application.Application;
import javafx.stage.Stage;
import main.java.edu.ingsoft.colegio.gotitas.config.DataBaseConnection;
import main.java.edu.ingsoft.colegio.gotitas.utils.SceneManager;
import java.sql.SQLException;

public class MainApp extends Application{

    private Stage primaryStage;
    
    @Override
    public void start(Stage primaryStage)throws Exception{
        this.primaryStage = primaryStage;
        SceneManager sceneManager = new SceneManager(primaryStage);
        sceneManager.showLoginView();
        primaryStage.show();
    }

    public static void main(String[] args) throws Exception{
      launch();
      try{
          DataBaseConnection.getConnectionDataBase();
          System.out.println("Connectado!");
      }catch(SQLException e){
          System.out.println("Error en la conexion");
      }
      launch();
    }
    
}
