package com.storegamers.appweb.repository;

import java.util.List;
import java.util.Optional;

import com.storegamers.appweb.model.Carrito;
import com.storegamers.appweb.model.Product;
import com.storegamers.appweb.model.Proforma;
import com.storegamers.appweb.model.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProformaRepository extends JpaRepository<Proforma, Integer> {

    @Query(value = "SELECT o FROM Proforma o WHERE o.user=?1")
    List<Proforma> findItemsByUsuario(Usuario user);

    @Query(value = "SELECT o FROM Proforma o WHERE o.user=?1 And o.product=?2")
    Optional<Proforma> findProformaByUsuarioAndProducto(Usuario user, Product product);

    // public List<Carrito> findByIdUsuario(Long idUsuario);   

   
}
