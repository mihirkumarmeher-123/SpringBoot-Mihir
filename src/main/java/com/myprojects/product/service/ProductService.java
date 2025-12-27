package com.myprojects.product.service;

import com.myprojects.product.dto.ProductDTO;
import com.myprojects.product.entity.Category;
import com.myprojects.product.entity.Product;
import com.myprojects.product.mapper.ProductMapper;
import com.myprojects.product.repository.CategoryRepository;
import com.myprojects.product.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    public ProductDTO createProduct(ProductDTO productDTO) {

     Category category = categoryRepository.findById(productDTO.getCategoryId())
             .orElseThrow(()-> new RuntimeException("Category not found"));

     //DTO -> Entity
     Product product = ProductMapper.toProductEntity(productDTO, category);
     product = productRepository.save(product);

     //Entity -> DTO
        return ProductMapper.toProductDTO(product);
    }

    //get all Products
    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll().stream().map(ProductMapper::toProductDTO).toList();

//        List<Product> products = productRepository.findAll();
//        List<ProductDTO> productDTOs = new ArrayList<>();
//        for (Product product : products) {
//            ProductDTO productDTO = ProductMapper.toProductDTO(product);
//            productDTOs.add(productDTO);
//        }
//        return productDTOs;
    }

    //get product by Id
    public ProductDTO getProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Product not found"));
        return ProductMapper.toProductDTO(product);
    }

    //Update Product
    public ProductDTO updateProduct(Long id,ProductDTO productDTO) {
        Product product = productRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Product not found"));

        Category category = categoryRepository.findById(productDTO.getCategoryId())
                .orElseThrow(()-> new RuntimeException("Category not found"));

        product.setName(productDTO.getName());
        product.setCategory(category);
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());

        productRepository.save(product);
        return ProductMapper.toProductDTO(product);
    }

    //delete product by id
    public String deleteProduct(Long id) {
        productRepository.deleteById(id);
        return "Product Deleted Successfully";
    }
}
