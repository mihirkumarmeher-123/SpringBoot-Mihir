package com.myprojects.product.service;

import com.myprojects.product.dto.CategoryDTO;
import com.myprojects.product.entity.Category;
import com.myprojects.product.mapper.CategoryMapper;
import com.myprojects.product.repository.CategoryRepository;

import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

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
    // get category by id
    // delete category
}
