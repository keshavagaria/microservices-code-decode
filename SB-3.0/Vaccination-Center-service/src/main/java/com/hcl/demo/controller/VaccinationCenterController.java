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
import org.springframework.web.client.RestTemplate;

import com.hcl.demo.entity.VaccinationCenter;
import com.hcl.demo.model.Citizen;
import com.hcl.demo.model.RequiredResponse;
import com.hcl.demo.repository.VaccinatonCenterRepository;


@RestController
@RequestMapping("/vaccinationcenter")
public class VaccinationCenterController {

	
	@Autowired
	private VaccinatonCenterRepository centerRepository;
	@Autowired
	private RestTemplate restTemplate;
	@PostMapping("/add")
	public ResponseEntity<VaccinationCenter> addVaccinationCenter(
			@RequestBody VaccinationCenter newCenter){
		VaccinationCenter center = centerRepository.save(newCenter);
		return new ResponseEntity<>(center,HttpStatus.OK);
	}
	@GetMapping("/resp/{id}")
	//@HystrixCommand(fallbackMethod = "handleCitizenDowntime")
	public ResponseEntity<RequiredResponse> getAllDataBasedOnCenter(@PathVariable Integer id){
		RequiredResponse requiredResponse=new RequiredResponse();
		//fetch center details
		VaccinationCenter center =  centerRepository.findById(id).get();
		requiredResponse.setCenter(center);
		//fetch citizen details
		List<Citizen> citizens = restTemplate.getForObject("http://CITIZEN-SERVICE/citizen/"+id, List.class);
		requiredResponse.setCitizens(citizens);
		return new ResponseEntity<RequiredResponse>(requiredResponse,HttpStatus.OK);
	}
	
	/*
	 * public ResponseEntity<RequiredResponse> handleCitizenDowntime(@PathVariable
	 * Integer id){
	 * 
	 * RequiredResponse requiredResponse=new RequiredResponse(); //fetch center
	 * details VaccinationCenter center = centerRepository.findById(id).get();
	 * requiredResponse.setCenter(center); return new
	 * ResponseEntity<RequiredResponse>(requiredResponse,HttpStatus.OK); }
	 */
}
