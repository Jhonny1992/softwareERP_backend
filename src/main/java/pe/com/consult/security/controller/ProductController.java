package pe.com.consult.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.consult.security.dto.request.ProductRequest;
import pe.com.consult.security.persistence.entity.Product;
import pe.com.consult.security.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody ProductRequest productRequest){

        Product objproduct = productService.createProduct(productRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(objproduct);

    }
}
