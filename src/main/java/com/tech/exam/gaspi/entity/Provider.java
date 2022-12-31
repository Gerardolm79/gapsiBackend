
package com.tech.exam.gaspi.entity;

public class Provider {
    
    private long id;
    
    private String commercialName;
    
    private String businessName;
    
    private String address;

    public long getId(){
        return id;
    }
    
    public String getCommercialName() {
        return commercialName;
    }

    public String getBusinessName() {
        return businessName;
    }

    public String getAddress() {
        return address;
    }

    public void setId(long id){
        this.id = id;
    }
    public void setCommercialName(String commercialName) {
        this.commercialName = commercialName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    
    @Override
    public String toString(){
        return this.id 
             + ", " + this.commercialName
             + ", " + this.businessName
             + ", " + this.address;
    }
    
}
