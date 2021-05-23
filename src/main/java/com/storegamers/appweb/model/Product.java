package com.storegamers.appweb.model;

import java.math.BigDecimal;
//import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
<<<<<<< HEAD
import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

import com.sun.tools.javac.util.Convert;

import lombok.*;

@Data
=======

import lombok.*;

>>>>>>> 530ec020fcac84e3d4ae92fbffee6ccbdbdc4022
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "t_product")
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
<<<<<<< HEAD
  public Integer id;
  public String name;
  public String description;
  public BigDecimal price;
  public String image_url;
  public Integer stock;
  public Integer status;

  public String MonedaPrice() {
    return "S/. " + price;
  }
=======
  private long idproduct;
  private String name;
  private String descripcion;
  private BigDecimal price;
  private String image_url;
  private int stock;
  private String status;
>>>>>>> 530ec020fcac84e3d4ae92fbffee6ccbdbdc4022

}
