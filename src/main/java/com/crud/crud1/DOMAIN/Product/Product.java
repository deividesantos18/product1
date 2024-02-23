package com.crud.crud1.DOMAIN.Product;

import jakarta.persistence.*;
import lombok.*;

@Table(name="product1")
@Entity(name="product1")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;

    private int price_in_cents;

    private Boolean active;

    public Product(RequestProduct rsproduct){
        this.name= rsproduct.name();
        this.price_in_cents=rsproduct.price_in_cents();
        this.active=true;
    }

}
