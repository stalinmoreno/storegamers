package com.storegamers.appweb.model;

import javax.persistence.*;

import lombok.*;

//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
// @Builder

@Entity
@Table(name = "t_customer")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "correo")
    private String email;
    private String name;

    @OneToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private Usuario user;

    public Cliente() {
    }

    public Cliente(Integer id, String email, String name, Usuario user) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

}