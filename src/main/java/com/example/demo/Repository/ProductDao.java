package com.example.demo.Repository;

import com.example.demo.Domain.Product;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDao extends JpaRepository<Product, Long> {

    @Query(value = "SELECT COUNT(*) FROM product WHERE product.name = ?1 and product.category=?2",nativeQuery = true)
    int IsExsistingProduct(String product,String category);

    @Query(value = "SELECT * FROM product",nativeQuery = true)
    List<Product> retrieveProductList();

}
