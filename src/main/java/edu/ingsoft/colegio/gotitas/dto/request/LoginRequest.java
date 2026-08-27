/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.edu.ingsoft.colegio.gotitas.dto.request;

/**
 *
 * @author PC
 */
public class LoginRequest {
    private String email;
    private String contraseña_hash;

    public LoginRequest(String email, String contraseña_hash) {
        this.email = email;
        this.contraseña_hash = contraseña_hash;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContraseña_hash() {
        return contraseña_hash;
    }

    public void setContraseña_hash(String contraseña_hash) {
        this.contraseña_hash = contraseña_hash;
    }
    
    

}
