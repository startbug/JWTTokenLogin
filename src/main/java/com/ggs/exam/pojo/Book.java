package com.ggs.exam.pojo;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private String id;

    private String bname;

    private Double price;

    private Integer cid;

    private Integer pnum;

    private String imgurl;

    private String description;

    private String author;

    private Integer sales;

}