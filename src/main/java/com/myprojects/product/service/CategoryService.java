package com.myprojects.product.service;

import com.myprojects.product.dto.CategoryDTO;
import com.myprojects.product.entity.Category;
import com.myprojects.product.mapper.CategoryMapper;
import com.myprojects.product.repository.CategoryRepository;

import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryService {

    private CategoryRepository categoryRepository;

    // CategoryService(CategoryRepository categoryRepository){
    //     this.categoryRepository = categoryRepository;
    // }

    // create category
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        Category category = CategoryMapper.toCategoryEntity(categoryDTO);
        category = categoryRepository.save(category);
        return CategoryMapper.toCategoryDTO(category);
    }

    // get all categories
    public List<CategoryDTO> getAllCategories() {
        return categoryRepository.findAll().stream().map(CategoryMapper::toCategoryDTO).toList();
    }

    // get category by id
    public CategoryDTO getCategoryById(@PathVariable Long id) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Category Not Found"));
        return CategoryMapper.toCategoryDTO(category);
    }
    // delete category
    public String deleteCategoryById(@PathVariable Long id) {
        categoryRepository.deleteById(id);
        return "Category Deleted Successfully";
    }
}
