package com.gabriel.springboot.app.dailyitineraries.repositories;

import com.gabriel.springboot.app.dailyitineraries.entities.Itinerary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItineraryRepository extends JpaRepository<Itinerary, Long> {
}
