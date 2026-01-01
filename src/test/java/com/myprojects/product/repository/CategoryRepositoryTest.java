package com.myprojects.product.repository;

import com.myprojects.product.entity.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Transactional
class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository categoryRepository;

    @BeforeEach
    void setUp() {
        Category category = new Category();
        category.setName("test");
        categoryRepository.save(category);
    }

    @Test
    void findByName() {
        Optional<Category> found = categoryRepository.findByName("test");
        assertTrue(found.isPresent());
    }

    @Test
    void deleteByName() {
        categoryRepository.deleteByName("test");
        assertTrue(categoryRepository.findByName("test").isEmpty());
    }
}
