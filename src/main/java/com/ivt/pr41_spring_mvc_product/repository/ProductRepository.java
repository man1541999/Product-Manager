/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ivt.pr41_spring_mvc_product.repository;


import com.ivt.pr41_spring_mvc_product.entities.ProductEntity;
import com.ivt.pr41_spring_mvc_product.enums.Color;
import com.ivt.pr41_spring_mvc_product.enums.Size;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author trunghuynh
 */
public interface ProductRepository extends CrudRepository<ProductEntity, Long>{

    // Native Query
    @Query(value = "select p.* from product p \n" +
                    "join category c on p.category_id = c.id\n" +
                    "join productDetail d on p.id = d.product_id\n" +
                    "where c.name like ?1 and d.size like ?2 and d.color like ?3", nativeQuery = true)
    List<ProductEntity> findProductByNameCaAndSizeAndColor(String nameCate, String size, String color);

    @Query(value = "select * from product order by id desc limit 2 ", nativeQuery = true)
    List<ProductEntity> top5ProductLasted();
    
    // JPQL
    
    @Query("select p from ProductEntity p where p.category.name like ?1 and p.productDetail.size like ?2 and p.productDetail.color like ?3")
    List<ProductEntity> findProductByNameCaAndSizeAndColorJPQL(String nameCate, Size size, Color color);
    
    @Query("select p from ProductEntity p order by p.id desc")
    List<ProductEntity> top5ProductLastedJPQL();
    
    // findBy
   
    
}
