package com.example.paketproduct.model;

import java.util.ArrayList;
import java.util.List;

public class Barang {
    private final String name;
    private final String description;

    public Barang(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

}
