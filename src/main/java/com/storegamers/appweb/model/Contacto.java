package com.storegamers.appweb.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
@Table(name = "t_contacto")
public class Contacto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "el nombre no puede ser nulo")
    private String nombres;

    @NotNull(message = "el apellido no puede ser nulo")
    private String apellidos;

    @NotNull(message = "el telefono no puede ser nulo")
    private String telefono;

    @NotNull(message = "el correo no puede ser nulo")
    private String correo;

    @NotNull(message = "el mensaje no puede ser nulo")
    private String mensaje;
}
