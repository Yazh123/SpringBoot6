package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.model.Baby;
import com.example.demo.repository.BabyRepo;

@Service
public class BabyService {
    @Autowired
    BabyRepo br;
    
    public Baby saveinfo(Baby ss) {
    	return br.save(ss);
    }
    
    public List<Baby> saveninfo(List<Baby> ss) {
    	return (List<Baby>)br.saveAll(ss);
    }
    
    public Optional<Baby> findid(int babyid){
    	return br.findById(babyid);
    }
    
    
    public List<Baby> getbypage(int offset,int pagesize){
    	Page<Baby> p= br.findAll(PageRequest.of(offset, pagesize));
    	return p.getContent();
    }
    
    public List<Baby> getsortpage(int offset,int pagesize){
    	Page<Baby> p= br.findAll(PageRequest.of(offset, pagesize,Sort.by("babyid").descending()));
    	return p.getContent();
    }
}
