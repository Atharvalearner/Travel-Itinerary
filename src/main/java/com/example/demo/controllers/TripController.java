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
    
    // Show form for creating a trip
    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("trip", new Trip());
        return "createTrip";
    }
  
    // Save a new trip
    @PostMapping("/create")
    public String saveTrip(@ModelAttribute("trip") Trip trip) {
        tripService.createTrip(trip);
        return "redirect:/trips/list";
    }

    // List all trips
    @GetMapping("/list")
    public String listTrips(Model model) {
        List<Trip> trips = tripService.getAllTrips();
        model.addAttribute("trips", trips);
        return "listTrips";
    }

    // Edit a trip
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable String id, Model model) {
        Trip trip = tripService.getTripById(id);
        model.addAttribute("trip", trip);
        return "editTrips";
    }

    // Update trip
    @PostMapping("/update")
    public String updateTrip(@ModelAttribute Trip trip) {
        tripService.updateTrip(trip.getId(), trip);
        return "redirect:/trips/list";
    }

    // Delete trip
    @GetMapping("/delete/{id}")
    public String deleteTrip(@PathVariable String id) {
        tripService.deleteTrip(id);
        return "redirect:/trips/list";
    }
}
