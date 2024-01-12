package com.vti.beautyweb.service;

import com.vti.beautyweb.dto.ProductDto;
import com.vti.beautyweb.entity.Product;
import com.vti.beautyweb.form.ProductCreateForm;
import com.vti.beautyweb.form.ProductFilterForm;
import com.vti.beautyweb.form.ProductUpdateForm;
import com.vti.beautyweb.map.ProductMapper;
import com.vti.beautyweb.repository.ProductRepository;
import com.vti.beautyweb.specification.ProductSpecification;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService{
    private final ProductRepository productRepository;

//    @Override
//    public Page<ProductDto> findByName(String name, Pageable pageable) {
//        return productRepository.findByName(name, pageable);
//    }

    @Override
    public Page<ProductDto> findAll(ProductFilterForm form, Pageable pageable) {
        var spec = ProductSpecification.buildSpec(form);
        return productRepository.findAll(spec, pageable)
                .map(ProductMapper::map);
    }

    @Override
    public ProductDto create(ProductCreateForm form) {
        var product = ProductMapper.map(form);
        var savedProduct = productRepository.save(product);
        return ProductMapper.map(savedProduct);
    }

    @Override
    public ProductDto update(ProductUpdateForm form, Long id) {
        var product = ProductMapper.map(form);
        product.setId(id);
        var savedProduct = productRepository.save(product);
        return ProductMapper.map(savedProduct);
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }

//    public List<ProductDto> findProductsByFilter(ProductFilterForm form) {
//        Specification<ProductDto> spec = ProductSpecification.buildSpec(form);
//        return productRepository.findAll(spec);
//    }
}
