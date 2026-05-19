package com.GameHubStore.controller;

import lombok.RequiredArgsConstructor;
import com.GameHubStore.model.dtos.ProductResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.GameHubStore.model.dtos.ProductRequest;
import com.GameHubStore.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addProduct(@RequestBody ProductRequest productRequest){
        this.productService.addProduct(productRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllProducts(){
        return this.productService.getAllProducts();
    }
}
