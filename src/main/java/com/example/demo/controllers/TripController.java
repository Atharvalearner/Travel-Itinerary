package com.example.demo.controllers;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.models.Trip;
import com.example.demo.services.TripService;

@RestController
@RequestMapping("/trips")
public class TripController {
    
    @Autowired
    private TripService tripService;

    @PostMapping									// Add trip
	public String createItem(@RequestBody Trip trip) {
		tripService.createTrip(trip);
		return "Trip inserted successfully";
	}
	@GetMapping										// Get all trips
	public List<Trip> getAllEmp(){
		List<Trip> trip = new ArrayList<>();
		trip = tripService.getAllTrips();
		return trip;
	}
	@GetMapping("/insert")							// insert trip through setter method directly
	public String saveItem() {
		Trip i = new Trip();
		i.setId("28");
		i.setTripName("Sandhan vhally");
		i.setStartDate("2-2-2025");
		i.setEndDate("9-2-2025");
		i.setDestination("Ahmednagar");
		i.setBudget(3500.00);
		tripService.createTrip(i);
		return "Trip saved successfully";
	}
//	@PostMapping("/savedata")							// directly insert data from console
//	public String insertData(@RequestBody Trip e) {
//		System.out.println("Trip Id : " + e.getId());
//		System.out.println("Trip Name : " + e.getName());
//		System.out.println("Trip salary : " + e.getPrice());
//		tripService.createItem(e);
//		return "inserted data of Trip Successfully";
//	}
	@GetMapping("/{id}")								// get trip by id
	public Trip getEmp(@PathVariable String id) {
		Trip e = tripService.getTripById(id);
		return e;
	}
	@DeleteMapping("/{id}")								// delete trip by their id
	public String deleteEmp(@PathVariable String id) {
		tripService.deleteTrip(id);
		return "Trip deleted of Id: " + id;
	}
	@PutMapping("/{id}")								// update trip by their id
	public Trip updateEmp(@PathVariable String id, @RequestBody Trip e) {
		tripService.updateTrip(id, e);
		return e;
	}
}
