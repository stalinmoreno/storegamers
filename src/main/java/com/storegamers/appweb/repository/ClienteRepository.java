package com.storegamers.appweb.repository;

import java.util.List;

import com.storegamers.appweb.model.Cliente;
import com.storegamers.appweb.model.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    @Query(value = "SELECT o FROM Cliente o WHERE o.user=?1")
    Cliente findByUsuario(Usuario user);

    @Query(value = "select tu.user_id, tu.password, tc.id, tc.correo, tc.name  from t_user tu inner join t_customer tc on tu.user_id=tc.user_id where tu.user_id = ?1", nativeQuery = true)
    Cliente getUserFull(Usuario user);

    @Query(value = "select * from t_customer tc", nativeQuery = true)
    List<Cliente> getCustomerFull();

}