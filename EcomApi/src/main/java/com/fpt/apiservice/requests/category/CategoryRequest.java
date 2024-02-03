package com.fpt.apiservice.requests.category;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class CategoryRequest {
    @NotEmpty(message = "code is not empty")
    private String name;

    private Long parentId;
}
