/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ivt.pr41_spring_mvc_product.repository;


import com.ivt.pr41_spring_mvc_product.entities.ProductDetailEntity;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author trunghuynh
 */
public interface DetailRepository extends CrudRepository<ProductDetailEntity, Long>{
    
}
