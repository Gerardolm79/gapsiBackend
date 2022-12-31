package com.tech.exam.gapsi.service;

import com.tech.exam.gapsi.utils.FileUtils;
import com.tech.exam.gaspi.entity.Provider;
import com.tech.exam.gaspi.pageable.ProviderPageable;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProviderServiceImpl implements IProviderService{
    
    private ProviderPageable provPageable = null;
    
    @Override
    public List<Provider> findAll() {
        
        return FileUtils.readData();
    }
    

    @Override
    public ProviderPageable findByPage(int page) {
    
        List<Provider> totalProviders = FileUtils.readData();
        List<Provider> providersPaging = new ArrayList<>();
        provPageable = new ProviderPageable();
        
        int starts = (page-1)*5;
        for(int i=starts; i<totalProviders.size() && i<starts+5; i++){
            System.out.println("Provider" + i + ": " + totalProviders.get(i));
            providersPaging.add(totalProviders.get(i));
        }
        provPageable.setProviders(providersPaging);
        
        
        provPageable.setTotal(totalProviders.size());
        provPageable.setPage(page);
        provPageable.setSize(5);
        return provPageable;
    }
    

    @Override
    public String saveProvider(Provider provider) {
        
        
            boolean result = FileUtils.saveProvider(provider);
            if(result){
                return "Provider added successfully...";
            }else{
                return "Provider already exists...";
            }
        
    }

    @Override
    public String deleteProvider(String name) {
        
       boolean result = FileUtils.deleteData(-1, name);
        
        if(result){
            return "Provider deleted";
        }else{
            return "Provider not found";
        }
    }
    
    @Override
    public String deleteProvider(long id) {
        
       boolean result = FileUtils.deleteData(id, null);
        
        if(result){
            return "Provider deleted";
        }else{
            return "Provider not found";
        }
    }
        
    
}
