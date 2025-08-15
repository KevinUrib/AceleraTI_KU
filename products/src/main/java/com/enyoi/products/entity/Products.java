package com.enyoi.products.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document("products")
@Getter
@Setter
public class Products {

    @Id
    private String id;

    private String name;
    private String description;
}
