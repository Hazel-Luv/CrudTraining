package com.example.demo.Controller;

import com.example.demo.Domain.Product;
import com.example.demo.Enumeration.Category;
import com.example.demo.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Product")
public class ProductController {

@Autowired
    ProductService productService;

    @PostMapping("/details")
    public ResponseEntity<String> saveProductDetails(
            @RequestParam String name,
            @RequestParam String description,
            @RequestParam Double productPrice,
            @RequestParam Integer quantity,
            @RequestParam String supplier,
            @RequestParam Category category){

        Product product = new Product();
        product.setName(name);
        product.setDescription(description);
        product.setProductPrice(productPrice);
        product.setQuantity(quantity);
        product.setSupplier(supplier);
        product.setCategory(String.valueOf(category));

        System.out.println("Reached Controller");
        String returnString = "failed to register";

        if(productService.productRegistration(product)!=null){
            System.out.println("Product registered successfully. ");
            returnString = "success";
        }
        return ResponseEntity.ok(returnString);
    }

    //retrieve all products
    @GetMapping("/details/All")
    public ResponseEntity<List<Product>> retrieveAllProducts() {
        return new ResponseEntity<>(productService.retrieveProductList(), HttpStatus.OK);
    }

    @PutMapping("/details")
    public ResponseEntity<String> updateProductDetails(@RequestBody Product product) {

        System.out.println("reached controller");
        String str = "user not updated";

        if (productService.productUpdation(product)) {
            str = "successfully updated";
        }
        return ResponseEntity.ok(str);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {

        String std = productService.deleteProductDetails(id);

        return new ResponseEntity<>(std, HttpStatus.OK);

    }
}
