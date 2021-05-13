package com.storegamers.appweb.controller;

import com.storegamers.appweb.repository.CatalogueRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.storegamers.appweb.model.Catalogue;
import org.springframework.validation.BindingResult;
import javax.validation.Valid;
import java.util.List;

@Controller
public class CatalogueController {

  private static final String INDEX = "home";
  private final CatalogueRepository catalogueData;

  public CatalogueController(CatalogueRepository catalogueData) {
    this.catalogueData = catalogueData;
  }

  @GetMapping("/")
  public String index(Model model) {
    List<Catalogue> listCatalogue = this.catalogueData.findAll();
    return INDEX;
  }

}
