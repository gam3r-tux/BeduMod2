package com.bedu.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bedu.model.Products;
import com.bedu.service.ProductsService;

/*
 * Controller for CRUD operations with product entity
 * author : Jose Ramos Briseno
 * date:    18-12-2022
 */

//mark class as Controller
@RestController
public class ProductsController 
{
    // logger
    private static final Logger logger = LoggerFactory.getLogger(ProductsController.class);

    //autowire the ProductsService class
    @Autowired
    ProductsService productsService;
    //creating a get mapping that retrieves all the products detail from the database 
    @GetMapping("/product")
    private List<Products> getAllProducts() 
    {
        logger.info("GetAll existing products");
        return productsService.getAllProducts();
    }
    //creating a get mapping that retrieves the detail of a specific product
    @GetMapping("/product/{productid}")
    private Products getProducts(@PathVariable("productid") int productid) 
    {
        logger.info("GetBy ID a product");
        return productsService.getProductsById(productid);
    }
    //creating a delete mapping that deletes a specified product
    @DeleteMapping("/product/{productid}")
    private void deleteProduct(@PathVariable("productid") int productid) 
    {
        logger.info("Delete a product");
        productsService.delete(productid);
    }
    //creating post mapping that post the product detail in the database
    @PostMapping("/products")
    private int saveProduct(@RequestBody Products products) 
    {
        logger.info("Insert a new product");
        productsService.saveOrUpdate(products);
        return products.getProductid();
    }
    //creating put mapping that updates the product detail 
    @PutMapping("/products")
    private Products update(@RequestBody Products products) 
    {
        logger.info("Update a product");
        productsService.saveOrUpdate(products);
        return products;
    }
}
