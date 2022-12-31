/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tech.exam.gapsi.controller;

import com.tech.exam.gapsi.service.IProviderService;
import com.tech.exam.gaspi.entity.Provider;
import com.tech.exam.gaspi.pageable.ProviderPageable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/provider")
public class ProviderController {

    @Autowired
    private IProviderService providerSvc;

    
    @GetMapping("/list")
    public List<Provider> getProviderList(){
        
        return providerSvc.findAll();
    }
    
    @GetMapping("/list/{page}")
    public ProviderPageable getProviderList(@PathVariable Integer page){
        
        return providerSvc.findByPage(page.intValue());
    }
    
    
    @PostMapping("save")
    public Provider saveProvider(@RequestBody Provider provider){
        return providerSvc.saveProvider(provider);
    }
    
    @DeleteMapping("delete/{id}")
    public String deleteProvider(@PathVariable ("id") Long id){
        return providerSvc.deleteProvider(id);
    }
    
    @DeleteMapping("deleteByName/{name}")
    public String deleteProvider(@PathVariable ("name") String name){
        return providerSvc.deleteProvider(name);
    }
    
}
