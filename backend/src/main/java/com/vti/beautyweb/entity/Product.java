package com.vti.beautyweb.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "product")
@Getter
@Setter
public class Product {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(name = "name", length = 200, nullable = false)
    private String name;

    @Column(name = "img", length = 500, nullable = false)
    private String img;

    @Column(name = "price", nullable = false)
    private Long price;
}
