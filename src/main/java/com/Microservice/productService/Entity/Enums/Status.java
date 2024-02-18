package com.Microservice.productService.Entity.Enums;

public enum Status {
    ENABLE("ENAMBLE"),DISABLE("DISABLE"),SUSPENDED("SUSPENDED");


    private String statusName;
    private Status(String name){
        this.statusName =  name;
    }

    public String getStatusName() {
        return statusName;
    }
}
