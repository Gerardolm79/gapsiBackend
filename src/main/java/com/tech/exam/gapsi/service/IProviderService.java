
package com.tech.exam.gapsi.service;

import com.tech.exam.gaspi.entity.Provider;
import com.tech.exam.gaspi.pageable.ProviderPageable;
import java.util.List;

    
public interface IProviderService {
    
    public List<Provider> findAll();
    
    public ProviderPageable findByPage(int page);
    
    public Provider saveProvider(Provider provider);
    
    public String deleteProvider(String name);
    
    public String deleteProvider(long id);
}
