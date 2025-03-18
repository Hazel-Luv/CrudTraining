package com.example.demo.Service;

import com.example.demo.Domain.Product;
import com.example.demo.Repository.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductDao productDao;
    // method that retrieve all records from product table
    public Product productRegistration(Product product){

        Product newProduct = null;
        if(productDao.IsExsistingProduct(product.getName(),product.getCategory())== 0){
            System.out.println("reached service");
            productDao.save(product);
            newProduct = product;
        }
        return newProduct;
    }
// method that retrieve all records from product table
    public List<Product> retrieveProductList(){
        List<Product> lists = new ArrayList<>();

        lists = productDao.findAll();

        return lists;
    }


    // update products
    public boolean productUpdation(Product product) {
        boolean udt = false;
        if (productDao.existsById(product.getProductNumber())) {
            productDao.save(product);
            udt = true;
        }
        return udt;
    }

    public String deleteProductDetails(Long id) {

        String delete = "Student not deleted";
        if (productDao.existsById(id)) {
            delete = "Student deleted";
            productDao.deleteById(id);
        }
        return delete;
    }
}
