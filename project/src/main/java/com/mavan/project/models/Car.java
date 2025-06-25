package com.mavan.project.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "cars")
public class Car {
    @Id
    private int id;

    @Column
    private String name;  
}