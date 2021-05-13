package com.storegamers.appweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.storegamers.appweb.model.Catalogue;

@Repository
public interface CatalogueRepository extends JpaRepository<Catalogue, Integer> {

}
