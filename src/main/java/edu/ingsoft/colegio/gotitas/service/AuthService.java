/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.edu.ingsoft.colegio.gotitas.service;

import main.java.edu.ingsoft.colegio.gotitas.dto.reponse.LoginResponse;
import main.java.edu.ingsoft.colegio.gotitas.dto.request.LoginRequest;
import main.java.edu.ingsoft.colegio.gotitas.repository.AuthRepository;
import main.java.edu.ingsoft.colegio.gotitas.security.jbcrypt.BCrypt;

/**
 *
 * @author PC
 */
public class AuthService {
    private final AuthRepository authRepository;
    public AuthService(AuthRepository authRepository){
        this.authRepository = authRepository;
    }
    public LoginResponse login(LoginRequest loginRequest) throws Exception{
        if(loginRequest == null){
            throw new RuntimeException("Credenciales vacias.");
        }else if(loginRequest.getEmail() == null || loginRequest.getContraseña_hash() == null) {
            throw new RuntimeException("El correo o la contraseña no pueden estar vacias");
        }
        LoginResponse response = authRepository.findUserByEmail(loginRequest);
        if(response == null){
                throw new RuntimeException("Usuario no encontrado");
        }
        String contrasenaHashed = response.getContraseña_Hash();
        if(contrasenaHashed == null){
            throw new RuntimeException("contrasena invalida");
        }else {
            if(BCrypt.checkpw(loginRequest.getContraseña_hash(),contrasenaHashed)){
                return new LoginResponse (response.getNombre(),response.getApellido(), response.getContraseña_Hash());
            }
        }
        return null;
    }
}
