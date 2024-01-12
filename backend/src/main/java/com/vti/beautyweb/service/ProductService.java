package com.vti.beautyweb.service;

import com.vti.beautyweb.dto.ProductDto;
import com.vti.beautyweb.form.ProductCreateForm;
import com.vti.beautyweb.form.ProductFilterForm;
import com.vti.beautyweb.form.ProductUpdateForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {
//    Page<ProductDto> findByName(String name, Pageable pageable);
    Page<ProductDto> findAll(ProductFilterForm form, Pageable pageable);
    ProductDto create(ProductCreateForm form);
    ProductDto update(ProductUpdateForm form, Long id);
    void delete(Long id);
}
