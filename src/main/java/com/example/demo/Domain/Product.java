package com.example.demo.Domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "product")
//@Table(name = "product", schema = "public")
public class Product {
    @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
  //  @Column(nullable = false, name = "productId")
    private Long productNumber;
    //@Column(name = "productName")
    private String name;
    //@Column(name = "description")
    private String description;
    //@Column(nullable = false, name = "price")
    private Double productPrice;
   // @Column(name = "quantity")
    private Integer quantity;
  //  @Column(name = "category")
    private String category;
   // @Column(name = "supplier")
    private String supplier;
}
