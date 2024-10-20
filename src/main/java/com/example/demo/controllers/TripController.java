package com.example.demo.controllers;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.demo.models.Trip;
import com.example.demo.services.TripService;

@Controller
@RequestMapping("/trips")
public class TripController {
    
    @Autowired
    private TripService tripService;
    
    @GetMapping("/create")			// Show form for creating a trip
    public String showCreateForm(Model model) {
        model.addAttribute("trip", new Trip());
        return "createTrip";
    }
    @PostMapping("/create")    		// Save a new trip
    public String saveTrip(@ModelAttribute("trip") Trip trip) {
        tripService.createTrip(trip);
        return "redirect:/trips/list";
    }
    @GetMapping("/list")			// List all trips
    public String listTrips(Model model) {
        List<Trip> trips = tripService.getAllTrips();
        model.addAttribute("trips", trips);
        return "listTrips";
    }
    @GetMapping("/edit/{id}")		// Edit a trip
    public String showEditForm(@PathVariable String id, Model model) {
        Trip trip = tripService.getTripById(id);
        model.addAttribute("trip", trip);
        return "editTrips";
    }
    @PostMapping("/update")			// Update trip
    public String updateTrip(@ModelAttribute Trip trip) {
        tripService.updateTrip(trip.getId(), trip);
        return "redirect:/trips/list";
    }
    @GetMapping("/delete/{id}")		// Delete trip
    public String deleteTrip(@PathVariable String id) {
        tripService.deleteTrip(id);
        return "redirect:/trips/list";
    }
}
