package com.joc.mstracing.order.domain;

/**
 * Created by o'connell on 9/18/17.
 */

public class Product {

    private long id;

    private String sku;

    private String description;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}