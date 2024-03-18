package com.example.midtermproject.models;

import com.example.midtermproject.models.req.ItemKeyValue;
import com.example.midtermproject.models.req.StockType;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int code;
    private String barcode;
    private double cost;
    private double price;
    private double qty;
    private String description;
    private String stockType;
    private String status;

    @ManyToOne
    private Category category;

    @Transient
    private List<ItemKeyValue> statuslist;
    @Transient
    private List<Category> categories;
    @Transient
    private List<StockType> stocktypelist;



}
