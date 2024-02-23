package com.crud.crud1.DOMAIN.Product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RequestProduct(String id,@NotBlank String name,@NotNull int price_in_cents) {
}
