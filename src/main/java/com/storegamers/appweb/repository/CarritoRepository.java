package com.storegamers.appweb.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import  com.storegamers.appweb.model.Carrito;
import java.util.List;

public interface  CarritoRepository extends JpaRepository<Carrito, Long>  {

    public List<Carrito> findByIdUsuario(Long idUsuario);   

    }