package com.storegamers.appweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.storegamers.appweb.model.Product;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
  @Query(value = "select p.* from t_product p where p.status = 1", nativeQuery = true)
  List<Product> getAllProducts();

  @Query(value = "select p.* from t_product p where p.id = ?1", nativeQuery = true)
  Product getOneProduct(Integer id);

}
