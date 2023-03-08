package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.model.Train;
import com.example.demo.repository.TrainRepository;

@Service
public class TrainService {
	@Autowired
	TrainRepository repository;
	
	public String addTrain(Train train) {
		repository.save(train);
		return "Added";
	}
	
	public List<Train> getTrain(){
		return repository.findAll();
	}
	
	public Optional<Train> getTrainById(int id){
		return repository.findById(id);
	}
	
	public Train updateTrainById(Train train) {
		return repository.save(train);
	}
	
	public String deleteTrainById(int id) {
		repository.deleteById(id);
		return "Deleted";
	}
	
	public List<Train> getTrainWithPagination(int offset,int pageSize){
		Page<Train> train=repository.findAll(PageRequest.of(offset, pageSize));
		return train.getContent();
	}
	
	public List<Train> getTrainWithPaginationAndSorting( int offset, int pageSize,String field){
		Page<Train> train=repository.findAll(PageRequest.of(offset, pageSize,Sort.by(field)));
		return train.getContent();
	}
}
