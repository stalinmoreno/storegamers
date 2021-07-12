package com.storegamers.appweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.storegamers.app.model.Contacto;

@Repository
public interface ContactoRepository extends JpaRepository<Contacto, Integer>{
    
}
