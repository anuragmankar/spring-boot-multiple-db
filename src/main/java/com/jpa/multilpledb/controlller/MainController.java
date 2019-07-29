package com.jpa.multilpledb.controlller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.jpa.multilpledb.prod.repo.ProdErrorRepository;
import com.jpa.multilpledb.qual.repo.QualErrorRepository;

@RestController
public class MainController {

	private final QualErrorRepository qualErrorRepository;
	private final ProdErrorRepository prodErrorRepository;
	
	Gson gson = new Gson();
	
	
	@Autowired
	MainController(QualErrorRepository qualErrorRepository,ProdErrorRepository prodErrorRepository)
	{
		this.qualErrorRepository = qualErrorRepository;
		this.prodErrorRepository = prodErrorRepository;
	}
	
	@RequestMapping("/prod/{id}")
	public String getProdData(@PathVariable("id") Long id){
		Optional<com.jpa.multilpledb.prod.domain.SqsPostPublishTable> data= prodErrorRepository.findById(id);
		if(data.isPresent())
		{
			 return gson.toJson(data.get());  
		}
		return "Data not Found";	
	}
	
	@RequestMapping("/qual/{id}")
	public String getQualData(@PathVariable("id") Long id){
		Optional<com.jpa.multilpledb.qual.domain.SqsPostPublishTable> data= qualErrorRepository.findById(id);
		if(data.isPresent())
		{
			 return gson.toJson(data.get());  
		}
		return "Data not Found";	
	}
	
}
