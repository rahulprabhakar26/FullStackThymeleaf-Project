package com.kodnest.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kodnest.demo.entity.Laptop;

@Service
public interface LaptopService {

	List<Laptop> getlaptop();

	String updateLaptopById(Integer id, Laptop laptop);

	Laptop postLaptop(Laptop laptop);

	String deleteRecordById(Integer id);

	
	

}
