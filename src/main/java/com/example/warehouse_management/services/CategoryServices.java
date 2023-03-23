package com.example.warehouse_management.services;

import com.example.warehouse_management.payload.request.CategoryRequest;
import com.example.warehouse_management.payload.response.CategoryResponse;

import java.util.List;


public interface CategoryServices {
    public CategoryResponse addCategory(CategoryRequest request);
    public List<CategoryResponse> findAll();
}
