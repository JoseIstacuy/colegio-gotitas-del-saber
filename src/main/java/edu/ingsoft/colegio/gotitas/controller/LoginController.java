package main.java.edu.ingsoft.colegio.gotitas.controller;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import main.java.edu.ingsoft.colegio.gotitas.config.DataBaseConnection;
import main.java.edu.ingsoft.colegio.gotitas.service.AuthService;
import main.java.edu.ingsoft.colegio.gotitas.utils.SceneManager;
import java.sql.SQLException;
import javafx.scene.control.Alert;
import main.java.edu.ingsoft.colegio.gotitas.dto.reponse.LoginResponse;
import main.java.edu.ingsoft.colegio.gotitas.dto.request.LoginRequest;
 
public class LoginController implements Initializable {
 
    private final AuthService authService;
    private final SceneManager sceneManager;
    @FXML
    private TextField txtFieldEmailField;
    @FXML
    private TextField txtFieldPass;
 
    public LoginController(AuthService authService, SceneManager sceneManager) {
        this.authService = authService;
        this.sceneManager = sceneManager;
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("TODO LO QUE ESTA ACA, SE EJECUTA CUANDOSE MUESTRE LA VISTA ");
    }
    public void handleSayHello(){
        System.out.println("Hola mi nombre es: " + txtFieldEmailField.getText());
    }
   //metodos
    
    public void handleTestDataBaseConncetion() throws Exception{
        try{
            DataBaseConnection.getConnectionDataBase();
            System.out.println("conectado");
        }catch(SQLException e){
            System.out.println("error al conectar: "+ e.getMessage());
        }
    }
    
    public void handleLogin() throws Exception{
        if(txtFieldEmailField.getText().isEmpty() || txtFieldPass.getText().isEmpty()){
            sceneManager.showInfoAlert("campos faltantes", "Revisar informacion", "Uno o mas campos estan vacios", Alert.AlertType.CONFIRMATION);
            
        }else{
            try{
            LoginResponse responseService = authService.login(new LoginRequest(txtFieldEmailField.getText(), txtFieldPass.getText()));
            LoginResponse userLogged = new LoginResponse(responseService.getNombre(), responseService.getApellido());
            sceneManager.showInfoAlert("bienvenidoa gatitas del saber", "inicio Existoso", "Bienvenido"+userLogged.getNombre(), Alert.AlertType.INFORMATION);
        }catch(RuntimeException e){
            sceneManager.showInfoAlert("datos incorrectos", "Revisa tu informacion", "intenta de nuevo", Alert.AlertType.INFORMATION);
        }
        }   
            
    }
 
}