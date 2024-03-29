package com.youtube.ecommerce.dao;

import com.youtube.ecommerce.entity.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDAO extends CrudRepository<Product, Integer> {
public List<Product> findAll(Pageable pageable);
}
