package com.kodnest.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.kodnest.demo.entity.Laptop;
import com.kodnest.demo.service.LaptopService;

@Controller
public class LaptopController {
	
	@Autowired
	LaptopService laptopService;
	
	@GetMapping("/get")
	public String  getLaptop(Model model) {
		model.addAttribute("laptops",laptopService.getlaptop());
		return "ViewRecord";
		
	}
	
	@PutMapping(value="/put/{id}")
	public String updateLaptopById(@PathVariable Integer id, @RequestBody Laptop laptop) {
		return laptopService.updateLaptopById(id, laptop);
		
	}
	
	@PostMapping(value="/post")
	public Laptop postLaptop(@RequestBody Laptop laptop) {
		return laptopService.postLaptop(laptop);
		
	}
	
	@DeleteMapping(value="/delete/{id}")
	public String deleteRecordById(@PathVariable Integer id) {
		return laptopService.deleteRecordById(id);
	}

}
