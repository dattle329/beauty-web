package com.vti.beautyweb.specification;

import com.vti.beautyweb.dto.ProductDto;
import com.vti.beautyweb.entity.Product;
import com.vti.beautyweb.form.ProductFilterForm;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import java.util.ArrayList;

public class ProductSpecification {
    public static Specification<Product> buildSpec(ProductFilterForm form){
        return (root, query, builder) -> {
            var predicates = new ArrayList<Predicate>();

            var search = form.getSearch();
            if(StringUtils.hasText(search)){
                var pattern = "%" + search.trim() +"%";
                var predicate = builder.like(root.get("name"), pattern); //From post where (this code = )title like '%JAVA%^'
                predicates.add(predicate);
            }
        return builder.and(predicates.toArray(predicates.toArray(new Predicate[0])));
    };
}
}