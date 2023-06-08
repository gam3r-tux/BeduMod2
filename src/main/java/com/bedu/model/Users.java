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
public class Users
{
    //Defining book id as primary key
    @Id
    @Column
    private int userid;
    @Column
    private String username;
    @Column
    private String lastname;
    @Column
    private int age;
}