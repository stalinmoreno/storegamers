package com.storegamers.appweb.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;

import lombok.*;

//@Getter
//@Setter
@NoArgsConstructor
@AllArgsConstructor
// @Builder
@Entity
@Table(name = "t_user")
public class Usuario implements Serializable {
    @Id
    @Column(name = "user_id")
    private String userID;
    private String password;

    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    // @JoinTable(name = "t_perfil", joinColumns = @JoinColumn(name = "perfil_id"))
    @JoinColumn(name = "perfil_id")
    private Perfil perfil;

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

}
