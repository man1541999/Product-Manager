/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ivt.pr41_spring_mvc_product.controller;

import com.ivt.pr41_spring_mvc_product.entities.CategoryEntity;
import com.ivt.pr41_spring_mvc_product.entities.ProductDetailEntity;
import com.ivt.pr41_spring_mvc_product.entities.ProductEntity;
import com.ivt.pr41_spring_mvc_product.enums.Color;
import com.ivt.pr41_spring_mvc_product.enums.Size;
import com.ivt.pr41_spring_mvc_product.service.CategoryService;
import com.ivt.pr41_spring_mvc_product.service.DetailService;

import com.ivt.pr41_spring_mvc_product.service.ProductService;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

/**
 *
 * @author trunghuynh
 */
@Controller
public class productController {

    @Autowired
    ProductService productService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    DetailService detailService;

    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public String viewHome(Model model) {
        model.addAttribute("products", productService.getProducts());
        return "home";
    }

    @RequestMapping("/add")
    public String ViewProductFormAdd(Model model) {
        model.addAttribute("product", new ProductEntity());

        model.addAttribute("categories", categoryService.getCategories());
        model.addAttribute("action", "add");
        return "product-form1";
    }

    @RequestMapping({"/handle"})
    public String handle(@ModelAttribute("product") ProductEntity product,
            HttpServletRequest servletRequest, HttpSession session,
            Model model) {
        ProductDetailEntity detailEntity = new ProductDetailEntity();

        String uploadRootPath = "C:\\Users\\ADMIN\\Documents\\test-2(zip)\\PR41_Spring_MVC_Product\\src\\main\\webapp\\resources\\image";
        File uploadRootDir = new File(uploadRootPath);
        //
        // Tạo thư mục gốc upload nếu nó không tồn tại.
        if (!uploadRootDir.exists()) {
            uploadRootDir.mkdirs();
        }
        CommonsMultipartFile fileData = product.getFileData();
        // Tên file gốc tại Client.

        String fileName = fileData.getOriginalFilename();
        System.out.println("Client File Name = " + fileName);
        if (fileName != null && fileName.length() > 0) {
            try {
                // Tạo file tại Server.
                File serverFile = new File(uploadRootDir.getAbsolutePath() + File.separator + fileName);

                // Luồng ghi dữ liệu vào file trên Server.
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
                stream.write(fileData.getBytes());
                stream.close();
                System.out.println("Write file: " + serverFile);
            } catch (Exception e) {
                System.out.println("Error Write file: " + fileName);
            }
        }


        model.addAttribute("productDetail", detailEntity);
        model.addAttribute("color", Color.values());
        model.addAttribute("size", Size.values());

     
        session.setAttribute("name", product.getName());
        session.setAttribute("fileName", fileName);
        session.setAttribute("price", product.getPrice());
        session.setAttribute("date", product.getCreateDate());
        session.setAttribute("description", product.getDescription());
        session.setAttribute("category", product.getCategory());

        return "product-form-Detail";
    }

    @RequestMapping(value = {"/", "/result"}, method = RequestMethod.POST)
    public String result(@ModelAttribute("productDetail") ProductDetailEntity detailEntity,
            @ModelAttribute("product") ProductEntity product, HttpSession session,
            Model model) {
        
        product.setName(session.getAttribute("name").toString());
        product.setImageName(session.getAttribute("fileName").toString());
        product.setPrice((double) session.getAttribute("price"));
        product.setCreateDate((Date) session.getAttribute("date"));
        product.setDescription(session.getAttribute("description").toString());
        product.setCategory((CategoryEntity) session.getAttribute("category"));
        
        detailEntity.setProduct(product);
        product.setProductDetail(detailEntity);

        productService.save(product);

        return "redirect:/home";
    }

    @RequestMapping("/update/{id}")
    public String ViewProductFormUpdate(
            Model model,
            @PathVariable("id") long id
    ) {
        ProductEntity product = productService.findProductById(id);
        if (product.getId() > 0) {
            model.addAttribute("action", "update");
        } else {
            model.addAttribute("action", "add");
        }
        model.addAttribute("product", product);
        model.addAttribute("categories", categoryService.getCategories());
        return "product-form";
    }

    @RequestMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") long id,
            Model model
    ) {
        productService.deleteProduct(id);
        return "redirect:/home";
    }
}
