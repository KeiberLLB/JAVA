package com.riwi.products.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "product")
@Data // con esta anotacion se generan todos los get, set y el toString
@AllArgsConstructor // anotacion para generar contrucctor con todos los atributos
@NoArgsConstructor // anotacion para generar contrucctor vacio
public class Product {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private int quantity;
  private double price;
}
