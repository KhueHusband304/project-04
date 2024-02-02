package com.fpt.apiservice.models;

import jakarta.persistence.Column;

public class Brand extends Model{

    private String name;

    @Column(name="slug")
    private String slug;

    @Column(name="thumbnail")
    private String thumbnail;
}
