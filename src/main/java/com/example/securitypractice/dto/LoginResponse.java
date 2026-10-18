/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.securitypractice.dto;

/**
 *
 * @author Aabdu
 */
public class LoginResponse {
    private String token;
    public LoginResponse(){
        
    }
    public LoginResponse(String token){
        this.token = token;
    }
    public String getToken(){
        return token;
    }
    public void setToken(String token){
        this.token = token;
    }
}
