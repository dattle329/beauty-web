package com.vti.beautyweb.controller;

import com.vti.beautyweb.dto.ProductDto;
import com.vti.beautyweb.entity.Product;
import com.vti.beautyweb.form.ProductCreateForm;
import com.vti.beautyweb.form.ProductFilterForm;
import com.vti.beautyweb.form.ProductUpdateForm;
import com.vti.beautyweb.service.ProductService;
import com.vti.beautyweb.specification.ProductSpecification;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
@AllArgsConstructor
@CrossOrigin("*")
public class ProductController {
    private final ProductService productService;


    @GetMapping("/api/v1/products")
    public Page<ProductDto> findAll(ProductFilterForm form, Pageable pageable){
        return productService.findAll(form, pageable);
    }

    @PostMapping("/api/v1/product")
    public ProductDto create(@RequestBody @Valid ProductCreateForm form){
        return productService.create(form);
    }

    @PutMapping("/api/v1/product/{id}")
    public ProductDto update(@RequestBody ProductUpdateForm form,@PathVariable("id") Long id){
        return productService.update(form, id);
    }

    @DeleteMapping("/api/v1/product/{id}")
    public void delete(@PathVariable("id") Long id){
        productService.delete(id);
    }
}
