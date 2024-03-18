package com.example.midtermproject.models.req;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class StockType {
    private int id;
    private String key;
    private String value;
}
