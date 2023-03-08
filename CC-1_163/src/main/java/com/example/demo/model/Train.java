package com.example.demo.model;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Train {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String trainName;
	private int routeNumber;
	private String boardingPlace;
	private String destinationPlace;
	private float arrivalTime;
	private float departureTime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTrainName() {
		return trainName;
	}
	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}
	public int getRouteNumber() {
		return routeNumber;
	}
	public void setRouteNumber(int routeNumber) {
		this.routeNumber = routeNumber;
	}
	public String getBoardingPlace() {
		return boardingPlace;
	}
	public void setBoardingPlace(String boardingPlace) {
		this.boardingPlace = boardingPlace;
	}
	public String getDestinationPlace() {
		return destinationPlace;
	}
	public void setDestinationPlace(String destinationPlace) {
		this.destinationPlace = destinationPlace;
	}
	public float getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(float arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public float getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(float departureTime) {
		this.departureTime = departureTime;
	}
	
	
}
