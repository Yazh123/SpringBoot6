package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Baby;
import com.example.demo.service.BabyService;


@RestController
public class ApiController {
	 @Autowired
     BabyService bs;
   
     
     @PostMapping("/")
     public boolean postinfo(@RequestBody Baby babe) {
    	 bs.saveinfo(babe);
    	 return true;
     }
     
     @PostMapping("/n")
     public boolean postninfo(@RequestBody List<Baby> babe) {
    	 bs.saveninfo(babe);
    	 return true;
     }
     
     @GetMapping("/{babyid}")
     public Optional<Baby> findid(@PathVariable int babyid)
     {
         return bs.findid(babyid);
     }
    
     
     @GetMapping("{offset}/{pagesize}")
     public List<Baby> showpageinfo(@PathVariable int offset, @PathVariable int pagesize){
     	return bs.getbypage(offset, pagesize);
     }
 	
    
    @GetMapping("page/{offset}/{pagesize}")
    public List<Baby> showsortpageinfo(@PathVariable int offset, @PathVariable int pagesize){
    	return bs.getsortpage(offset, pagesize);
    }
	
}
