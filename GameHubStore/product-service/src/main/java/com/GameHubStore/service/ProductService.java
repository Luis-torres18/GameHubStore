package com.GameHubStore.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import com.GameHubStore.model.dtos.ProductRequest;
import com.GameHubStore.model.dtos.ProductResponse;
import com.GameHubStore.model.entities.Product;
import org.springframework.stereotype.Service;
import com.GameHubStore.repository.ProductRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;

    public void addProduct(ProductRequest productRequest){
        var product = Product.builder()
                .nombre(productRequest.getNombre())
                .marca(productRequest.getMarca())
                .modelo(productRequest.getModelo())
                .precio(productRequest.getPrecio())
                .categoriaId(productRequest.getCategoriaId())
                .descripcion(productRequest.getDescripcion())
                .estado(productRequest.getEstado())
                .build();

        productRepository.save(product);
        log.info("Product added successfully");
    }

    public List<ProductResponse> getAllProducts(){
        var products = productRepository.findAll();

        return products.stream().map(this::mapToProductResponse).collect(Collectors.toList());
    }

    private ProductResponse mapToProductResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .nombre(product.getNombre())
                .marca(product.getMarca())
                .modelo(product.getModelo())
                .precio(product.getPrecio())
                .categoriaId(product.getCategoriaId())
                .descripcion(product.getDescripcion())
                .estado(product.getEstado())
                .build();
    }
}
