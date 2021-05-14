package com.storegamers.appweb.model;


public class Cliente {

    private String nombres;
    private String correo;
    private String confirmarcorreo;
    private Long contraseña;
    private Long repetircontraseña;


    public String getNombres() {
        return this.nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getCorreo() {
        return this.correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getConfirmarcorreo() {
        return this.confirmarcorreo;
    }

    public void setConfirmarcorreo(String confirmarcorreo) {
        this.confirmarcorreo = confirmarcorreo;
    }

    public Long getContraseña() {
        return this.contraseña;
    }

    public void setContraseña(Long contraseña) {
        this.contraseña = contraseña;
    }

    public Long getRepetircontraseña() {
        return this.repetircontraseña;
    }

    public void setRepetircontraseña(Long repetircontraseña) {
        this.repetircontraseña = repetircontraseña;
    }
    








}
