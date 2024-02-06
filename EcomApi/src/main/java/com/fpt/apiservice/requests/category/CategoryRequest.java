package com.fpt.apiservice.requests.category;


public record CategoryRequest (
        String name,
        String thumbnail,
        Long parentId
) {

}