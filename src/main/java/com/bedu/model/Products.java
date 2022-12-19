package com.bedu.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//mark class as an Entity 
@Entity
//defining class name as Table name
@Table
public class Products
{
    //Defining book id as primary key
    @Id
    @Column
    private int productid;
    @Column
    private String productname;
    @Column
    private String category;
    @Column
    private int price;
}