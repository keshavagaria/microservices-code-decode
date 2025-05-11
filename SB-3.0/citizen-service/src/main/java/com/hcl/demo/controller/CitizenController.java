package com.hcl.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.demo.entity.Citizen;
import com.hcl.demo.repository.CitizenRepository;

@RestController
@RequestMapping("/citizen")
public class CitizenController {
	
	@Autowired
	private CitizenRepository citizenRepository;
	
	@RequestMapping("/test")
	public ResponseEntity<String> test(){
		
		return new ResponseEntity<>("App is running...",HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<List<Citizen>> getById(@PathVariable Integer id){
		List<Citizen> citizens = citizenRepository.findByVaccinationCenterId(id);
		return new ResponseEntity<>(citizens,HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<Citizen> addCitizen(@RequestBody Citizen newCitizen){
		Citizen citizen = citizenRepository.save(newCitizen);
		return new ResponseEntity<>(citizen,HttpStatus.OK);
	}
}
