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

import lombok.*;

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
  private long idproduct;
  private String name;
  private String descripcion;
  private BigDecimal price;
  private String image_url;
  private int stock;
  private String status;

}
