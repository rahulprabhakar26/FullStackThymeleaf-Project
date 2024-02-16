package com.kodnest.demo.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodnest.demo.entity.Laptop;
import com.kodnest.demo.repository.LaptopRepository;
import com.kodnest.demo.service.LaptopService;

@Service
public class LaptopServiceImpl implements LaptopService {
	
	
	@Autowired
	LaptopRepository laptopRepo;

	@Override
	public List<Laptop> getlaptop() {
		return laptopRepo.findAll();
	}

	@Override
	public String updateLaptopById(Integer id, Laptop updateRecord) {
		
		//get the record to update
		Optional<Laptop> existingRecord = laptopRepo.findById(id);
	
		if(existingRecord.isPresent()) {
		//modify the update record
		Laptop laptop = existingRecord.get();
		laptop.setName(updateRecord.getName());
		laptop.setColor(updateRecord.getColor());
		
		//save the record
		  laptopRepo.save(laptop);
		
		return "Updated Success";
		
	}else {
		return "Record not found";
	}
	}

	@Override
	public Laptop postLaptop(Laptop laptop) {
		
		 return laptopRepo.save(laptop);
		 
	}

	@Override
	public String deleteRecordById(Integer id) {
		laptopRepo.deleteById(id);
		return "Delete Successfully";
	}

}
