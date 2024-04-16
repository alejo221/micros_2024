package com.msexcercise.productservice.service;

import com.msexcercise.productservice.dto.ProductRequest;
import com.msexcercise.productservice.dto.ProductResponse;
import com.msexcercise.productservice.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import com.msexcercise.productservice.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void createProduct(ProductRequest productRequest){
        Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();

        productRepository.save(product);
        log.info("Product {} is saved", product.getId());
    }

    public List<ProductResponse> getAllProducts(){
        List<Product> products = productRepository.findAll();
        return products.stream().map(this::mapToProduceResponse)
                .toList();
    }

    private ProductResponse mapToProduceResponse(Product product){
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }
}
