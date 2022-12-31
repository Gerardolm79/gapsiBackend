package com.tech.exam.gaspi.pageable;

import com.tech.exam.gaspi.entity.Provider;
import java.util.List;


public class ProviderPageable {
    
    private List<Provider> providers;
    
    private int page;
    
    private int size;
    
    private int total;


    public List<Provider> getProviders() {
        return providers;
    }

    public int getPage() {
        
        return page;
    }
    
    public int getSize() {
        
        return size;
    }
    
    public int getTotal() {
        return total;
    }
    
    public void setProviders(List<Provider> providers) {
        this.providers = providers;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    
    
            
}
