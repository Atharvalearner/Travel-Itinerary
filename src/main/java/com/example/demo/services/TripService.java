package com.example.demo.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.models.Trip;
import com.example.demo.repositories.TripRepo;

@Service
public class TripService {
	@Autowired
    private TripRepo tripRepository;
    public Trip createTrip(Trip trip) {
        return tripRepository.save(trip);
    }
    public List<Trip> getAllTrips() {
    	List<Trip> t = tripRepository.findAll();
        return t;
    }

    public Trip getTripById(String id) {
    	Optional<Trip> t = tripRepository.findById(id);
    	return t.get();
    }
    public Trip updateTrip(String id, Trip trip) {
    	Optional<Trip> t = tripRepository.findById(id);
    	Trip t1 = t.get();
    	t1.setTripName(trip.getTripName());
    	t1.setStartDate(trip.getStartDate());
    	t1.setEndDate(trip.getEndDate());
    	t1.setDestination(trip.getDestination());
    	t1.setBudget(trip.getBudget());
    	tripRepository.save(t1);
        return t1;
    }
    public void deleteTrip(String id) {
        tripRepository.deleteById(id);
    }
}