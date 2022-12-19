package com.bedu.repository;
import org.springframework.data.repository.CrudRepository;

import com.bedu.model.Products;
public interface ProductsRepository extends CrudRepository<Products, Integer>
{
}
