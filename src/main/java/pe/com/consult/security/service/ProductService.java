package pe.com.consult.security.service;

import pe.com.consult.security.dto.request.ProductRequest;
import pe.com.consult.security.persistence.entity.Product;

public interface ProductService {
    Product createProduct(ProductRequest productRequest);
}
