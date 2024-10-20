package com.example.demo.models;
import jakarta.persistence.*;

@Entity
@Table(name = "trips")
public class Trip {
    @Id
    private String id;
    private String tripName;
    private String destination;
    private String startDate;
    private String endDate;
    private Double budget;
    private String description;
    public Trip(String id, String tripName, String destination, String startDate, String endDate, Double budget,String description) {
		super();
		this.id = id;
		this.tripName = tripName;
		this.destination = destination;
		this.startDate = startDate;
		this.endDate = endDate;
		this.budget = budget;
		this.description = description;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Trip() {
        super();
    }
    public void setId(String id) {
		this.id = id;
	}
    
    public String getId() {
		return id;
	}

	public String getTripName() {
        return tripName;
    }

    public void setTripName(String tripName) {
        this.tripName = tripName;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Double getBudget() {
        return budget;
    }

    public void setBudget(Double budget) {
        this.budget = budget;
    }
}
