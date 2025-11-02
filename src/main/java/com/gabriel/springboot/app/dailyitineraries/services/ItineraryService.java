package com.gabriel.springboot.app.dailyitineraries.services;

import com.gabriel.springboot.app.dailyitineraries.entities.Itinerary;

import java.util.List;
import java.util.Optional;

public interface ItineraryService {
    List<Itinerary> findAll();
    Optional<Itinerary> findById(Long id);
    Itinerary save(Itinerary itinerary);
    Optional<Itinerary>deleteById(Long id);
}
