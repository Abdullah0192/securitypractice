/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.securitypractice.dto;

/**
 *
 * @author Aabdu
 */
public class RegisterRequest {
    private String username;
    private String password;
//    private String role;
    public RegisterRequest(){
        
    }
    public RegisterRequest(String username, String password){
//    public RegisterRequest(String username, String password, String role){
        this.username=  username;
        this.password = password;
//        this.role = role;
    }
//    public String getUsername(String username){
    public String getUsername(){
        return username;
    }
    public void setUsername(String username){
        this.username = username;
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }
//    public String getRole(){
//        return role;
//    }
//    public void setRole(String role){
//        this.role= role;
//    }
}
