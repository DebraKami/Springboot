package com.youtube.ecommerce.service;

import com.youtube.ecommerce.dao.ProductDAO;
import com.youtube.ecommerce.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductDAO productDAO;
    public Product addNewProduct(Product product){
return productDAO.save(product);

    }
    public List<Product> getAllProducts(int pageNumber){
        Pageable pageable= PageRequest.of(pageNumber,5);

         return(List<Product>) productDAO.findAll(pageable);
    }
    public  Product getProductDetailsById(Integer productId){
        return productDAO.findById(productId).get();
    }

    public void deleteProductDetails(Integer productId){
        productDAO.deleteById(productId);
    }
public List<Product> getProductDetails(boolean isSingleProductCheckout, Integer productId){
        if(isSingleProductCheckout){
            //we are going to buy a single product
            List<Product> list=new ArrayList<>();
            Product product=productDAO.findById(productId).get();
            list.add(product);
            return list;
        }else{
          //we are going to checkout the entire cart
        }
        return new ArrayList<>();
}

}
