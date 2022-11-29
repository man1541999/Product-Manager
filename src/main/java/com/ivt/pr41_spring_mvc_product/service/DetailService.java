/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ivt.pr41_spring_mvc_product.service;

import com.ivt.pr41_spring_mvc_product.entities.ProductDetailEntity;
import com.ivt.pr41_spring_mvc_product.repository.DetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author trunghuynh
 */
@Service
public class DetailService {
    @Autowired
    DetailRepository detailRepository;
    
    public void save(ProductDetailEntity detailEntity){
        detailRepository.save(detailEntity);
    }
}
