package com.storegamers.appweb.repository;

import com.storegamers.appweb.model.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
public interface  UsuarioRepository extends JpaRepository<Usuario, String> {
    @Query(value = "select password from t_user where password = :oldPssw", nativeQuery = true)
    String searchPassword(@Param("oldPssw") String oldPssw);

    @Transactional
    @Modifying
    @Query(value = "UPDATE t_user SET password=:newPass WHERE password =:oldPass", nativeQuery = true)
    void changePassword(@Param("newPass") String newPass, @Param("oldPass") String oldPass);

}