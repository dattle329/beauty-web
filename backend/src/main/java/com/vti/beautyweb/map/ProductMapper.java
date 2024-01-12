package com.vti.beautyweb.map;

import com.vti.beautyweb.dto.ProductDto;
import com.vti.beautyweb.entity.Product;
import com.vti.beautyweb.form.ProductCreateForm;
import com.vti.beautyweb.form.ProductUpdateForm;

public class ProductMapper {
    public static Product map(ProductCreateForm form){
        var product = new Product();
        product.setName(form.getName());
        product.setImg(form.getImg());
        product.setPrice(form.getPrice());
        return product;
    }

    public static Product map(ProductUpdateForm form){
        var product = new Product();
        product.setName(form.getName());
        product.setImg(form.getImg());
        product.setPrice(form.getPrice());
        return product;
    }

    public static ProductDto map(Product product){
        var dto = new ProductDto();
        dto.setName(product.getName());
        dto.setImg(product.getImg());
        dto.setPrice(product.getPrice());
        return dto;
    }
}
