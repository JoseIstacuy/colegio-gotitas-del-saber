/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.edu.ingsoft.colegio.gotitas.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author PC
 */
import main.java.edu.ingsoft.colegio.gotitas.config.DataBaseConnection;
import main.java.edu.ingsoft.colegio.gotitas.dto.reponse.LoginResponse;
import main.java.edu.ingsoft.colegio.gotitas.dto.request.LoginRequest;
public class AuthRepository {
    //atributos
    
    private boolean sqlStatus = false;
 
    public AuthRepository() {
    }
 
    public LoginResponse findUserByEmail(LoginRequest loginRequest) throws Exception {
 
        String sql = "SELECT d.nombre, d.apellido, u.contraseña_hash "
                + "FROM usuarios AS u "
                + "RIGHT JOIN docentes AS d "
                + "ON d.id_docente = u.id_docente "
                + "WHERE u.email = ?";
 
        try (PreparedStatement pstm = DataBaseConnection
                .getConnectionDataBase()
                .prepareStatement(sql)) {
 
            pstm.setString(1, loginRequest.getEmail());
 
            try (ResultSet rs = pstm.executeQuery()) {
 
                if (rs.next()) {
 
                    return new LoginResponse(
                            rs.getString("nombre"),
                            rs.getString("apellido"),
                            rs.getString("contraseña_hash")
                    );
                }
            }
 
        } catch (SQLException e) {
 
            System.out.println(
                    "Error al encontrar el Email: " + e.getMessage()
            );
 
            throw e;
        }
 
        return null;
    }
}
