package com.storegamers.appweb.repository;

import com.storegamers.appweb.model.Pago;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  PagoRepository extends JpaRepository<Pago, Integer>{

    
}
