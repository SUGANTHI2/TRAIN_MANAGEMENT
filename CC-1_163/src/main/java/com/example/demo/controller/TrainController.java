package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Train;
import com.example.demo.service.TrainService;

@RestController
@CrossOrigin(origins="http://localhost:3000")
public class TrainController {
	@Autowired
	TrainService service;
	
	@PostMapping("/train")
	public String create(@RequestBody Train train) {
		return service.addTrain(train);
	}
	
	@GetMapping("/train/{offset}/{pagesize}")
	public List<Train> getWithPagination(@PathVariable int offset,@PathVariable int pagesize){
		return service.getTrainWithPagination(offset,pagesize);
	}
	
	@GetMapping("/train/{offset}/{pagesize}/{field}")
	public List<Train> getWithSortedPagination(@PathVariable int offset,@PathVariable int pagesize,@PathVariable String field){
		return service.getTrainWithPaginationAndSorting(offset, pagesize, field);
	}
	
	@GetMapping("/train/get")
	public List<Train> get(){
		return service.getTrain();
	}
	
	@DeleteMapping("/train/delete/{id}")
	public String delete(@PathVariable int id) {
		return service.deleteTrainById(id);
	}
	
	@PutMapping("/train/put")
	public Train update(@RequestBody Train train ) {
		return service.updateTrainById(train);
	}
}
