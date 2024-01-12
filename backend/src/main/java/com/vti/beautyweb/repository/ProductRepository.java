package com.vti.beautyweb.repository;

import com.vti.beautyweb.dto.ProductDto;
import com.vti.beautyweb.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {
//    Page<ProductDto> findByName(String name, Pageable pageable);
}
