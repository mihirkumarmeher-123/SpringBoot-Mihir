package com.myprojects.product.controller;

import com.myprojects.product.dto.ProductDTO;
import com.myprojects.product.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name="Product REST API CRUD operation",
        description = "CREATE, READ, UPDATE, and DELETE operations for product REST API"
)
@ApiResponse(
        responseCode = "201",
        description = "CREATED"
)
@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
public class ProductController {

    private ProductService productService;
    //getAllProducts
    @Operation(
            summary = "Fetch All Products",
            description = "REST API to fetch all products"
    )
    @GetMapping
    public List<ProductDTO> getAllProducts() {
        return productService.getAllProducts();
    }

    //getProductById
    @Operation(
            summary = "Fetch Product by product Id",
            description = "REST API to fetch product by product Id"
    )
    @GetMapping("/{id}")
    public ProductDTO getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    //create Product
    @Operation(
            summary = "Create Product",
            description = "REST API to create product"
    )
    @ApiResponse(
            responseCode = "201",
            description = "CREATED"
    )
    @PreAuthorize("hasAuthority('ROLE_SELLER')")
    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO) {
        ProductDTO createdProduct = productService.createProduct(productDTO);
        return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
    }

    //update product
    @Operation(
            summary = "Update Product by product Id",
            description = "REST API to update product by product Id"
    )
    @PreAuthorize("hasAuthority('ROLE_SELLER')")
    @PutMapping("/{id}")
    public ProductDTO updateProduct(@PathVariable Long id, @RequestBody ProductDTO productDTO) {
        return productService.updateProduct(id, productDTO);
    }

    //delete product
    @Operation(
            summary = "Delete Product by product Id",
            description = "REST API to delete product by product Id"
    )
    @PreAuthorize("hasAuthority('ROLE_SELLER')")
    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id) {
        return productService.deleteProduct(id);
    }
}
