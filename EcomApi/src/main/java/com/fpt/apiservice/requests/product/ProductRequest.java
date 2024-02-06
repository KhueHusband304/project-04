package com.fpt.apiservice.requests.product;

import java.math.BigDecimal;
import java.util.List;

public record ProductRequest (
        String name,
        BigDecimal price,
        String condition,
        String description,
        Integer quantity,
        Long brand,
        Long category,
        String thumbnail,
        List<String> images
) {

}