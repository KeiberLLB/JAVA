package com.riwi.products.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.riwi.products.entities.Product;
import com.riwi.products.repositories.ProductRepository;
import com.riwi.products.services.service_abstract.IProductService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductService implements IProductService {
  @Autowired
  // el final hace que la variable no cambie su valor
  // para que el final funcione se debe crear un contructor (@AllArgsConstructor)
  private final ProductRepository productRepository;

  @Override
  public Product save(Product objProduct) {
    return this.productRepository.save(objProduct);
    
  }

  @Override
  public List<Product> getAll() {
    return this.productRepository.findAll();
  }

  @Override
  public Product findById(Long id) {
    return this.productRepository.findById(id).orElseThrow();
  }

  @Override
  public void delete(Long id) {
    this.productRepository.findById(id).orElseThrow();
    this.productRepository.deleteById(id);
  }

  @Override
  public Product update(Long id, Product objProduct) {
    this.productRepository.findById(id).orElseThrow();
    objProduct.setId(id);
    return this.productRepository.save(objProduct);
  }

  @Override
  public List<Product> search(String name) {
    return this.productRepository.findByNameContaining(name);
  }
}
