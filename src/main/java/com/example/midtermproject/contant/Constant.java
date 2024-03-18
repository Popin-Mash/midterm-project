package com.example.midtermproject.contant;

import com.example.midtermproject.models.req.ItemKeyValue;
import com.example.midtermproject.models.req.StockType;

import java.util.ArrayList;
import java.util.List;

public class Constant {

    public static List<ItemKeyValue> getAllStatus() {
        List<ItemKeyValue> itemKeyValues = new ArrayList<>();
        itemKeyValues.add(new ItemKeyValue(1, "ACT", "Active"));
        itemKeyValues.add(new ItemKeyValue(2, "DEL", "Delete"));
        itemKeyValues.add(new ItemKeyValue(3, "DSL", "Disable"));
        return itemKeyValues;
    }

    public static List<String> getAllStatusString() {
        List<String> list = new ArrayList<>();
        list.add("ACT");
        list.add("DEL");
        list.add("DLS");
        return list;
    }

    public static List<StockType> getAllstockType() {
        List<StockType> listStock = new ArrayList<>();

        listStock.add(new StockType(1, "CUT", "CutStock"));
        listStock.add(new StockType(2, "STK", "Stock"));
        listStock.add(new StockType(1, "OUT", "Out Stock"));
        return listStock;
    }

}
