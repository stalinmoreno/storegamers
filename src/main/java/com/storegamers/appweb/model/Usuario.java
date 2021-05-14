package com.storegamers.appweb.model;

public class Usuario{
    
    private String username;
    private Long contraseña;



    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getContraseña() {
        return this.contraseña;
    }

    public void setContraseña(Long contraseña) {
        this.contraseña = contraseña;
    }
    
}