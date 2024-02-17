package pe.com.consult.security.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.consult.security.dto.request.ProductRequest;
import pe.com.consult.security.persistence.entity.Product;
import pe.com.consult.security.persistence.entity.security.User;
import pe.com.consult.security.persistence.repository.ProductRepository;
import pe.com.consult.security.service.ProductService;
import pe.com.consult.security.service.util.GeneratorCodeService;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private GeneratorCodeService generatorCodeService;

    @Override
    public Product createProduct(ProductRequest productRequest) {

        Product lastUser = productRepository.findTopByOrderByIdDesc();
        int lastCodeProduct = (lastUser != null) ? Integer.parseInt(lastUser.getCodeProduct().substring(1)) + 1 : 1;
        String codeProduct = generatorCodeService.generatorCode("P",lastCodeProduct);

        Product product = Product.builder()
                .codeProduct(codeProduct)
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .status(true)
                .build();

        return productRepository.save(product);
    }
}
