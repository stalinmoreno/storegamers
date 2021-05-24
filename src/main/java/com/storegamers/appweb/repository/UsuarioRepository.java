package com.storegamers.appweb.repository;

import com.storegamers.appweb.model.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  UsuarioRepository extends JpaRepository<Usuario, String>{

    
}