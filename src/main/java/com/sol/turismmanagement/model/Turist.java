package com.sol.turismmanagement.model;

import jakarta.persistence.*;

@Entity
public class Turist {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String turistName;
    @ManyToOne
    @JoinColumn(name = "placeId")
    private Places places;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTuristName() {
        return turistName;
    }

    public void setTuristName(String turistName) {
        this.turistName = turistName;
    }

    public Places getPlaces() {
        return places;
    }

    public void setPlaces(Places places) {
        this.places = places;
    }
}
