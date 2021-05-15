package com.storegamers.appweb.model;

public class Cliente {

    private String nombres;
    private String correo;
    private String confirmarcorreo;
    private Long contrasenia;
    private Long repetircontrasenia;

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

    public Long getContrasenia() {
        return this.contrasenia;
    }

    public void setContrasenia(Long contrasenia) {
        this.contrasenia = contrasenia;
    }

    public Long getRepetircontrasenia() {
        return this.repetircontrasenia;
    }

    public void setRepetircontrasenia(Long repetircontrasenia) {
        this.repetircontrasenia = repetircontrasenia;
    }

}
