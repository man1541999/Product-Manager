/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ivt.pr41_spring_mvc_product.service;

import com.ivt.pr41_spring_mvc_product.entities.ProductEntity;
import com.ivt.pr41_spring_mvc_product.repository.ProductRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

/**
 *
 * @author trunghuynh
 */
@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    
    @Transactional
    public List<ProductEntity> getProducts() {
        List<ProductEntity> productEntitys = (List<ProductEntity>) productRepository.findAll();
        if (!CollectionUtils.isEmpty(productEntitys)) {
           for (ProductEntity productEntity : productEntitys) {
                Hibernate.initialize(productEntity.getProductDetail());
               
            }
           return productEntitys;
        }
        return new ArrayList<>();
    }
    public void save(ProductEntity entity){
        productRepository.save(entity);
    }
    public void deleteProduct(long id){
        productRepository.deleteById(id);
    }
    public ProductEntity findProductById(long id){
        Optional<ProductEntity> productOpt = productRepository.findById(id);
        if (productOpt.isPresent()) {
            return productOpt.get();
        }
        return new ProductEntity();
    }
}
