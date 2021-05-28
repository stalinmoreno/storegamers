package com.storegamers.appweb.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import  com.storegamers.appweb.model.Carrito;

public interface  CarritoRepository extends JpaRepository<Carrito, Long>  {

    
    }