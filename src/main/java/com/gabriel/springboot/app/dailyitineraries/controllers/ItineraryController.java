package com.gabriel.springboot.app.dailyitineraries.controllers;

import com.gabriel.springboot.app.dailyitineraries.dtos.request.ItineraryRequestDTO;
import com.gabriel.springboot.app.dailyitineraries.entities.Itinerary;
import com.gabriel.springboot.app.dailyitineraries.entities.User;
import com.gabriel.springboot.app.dailyitineraries.services.ItineraryService;
import com.gabriel.springboot.app.dailyitineraries.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/itineraries")
public class ItineraryController {

    final private ItineraryService itineraryService;
    final private UserService userService;

    public ItineraryController(ItineraryService itineraryService, UserService userService) {
        this.itineraryService = itineraryService;
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<Itinerary>> findAll() {
        return ResponseEntity.ok(itineraryService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Itinerary> findById(@PathVariable Long id) {
        Optional<Itinerary> itinerary = itineraryService.findById(id);
        if (itinerary.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(itinerary.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Itinerary> create(@RequestBody ItineraryRequestDTO itineraryDTO) {
        User user = userService.findById(itineraryDTO.getUserId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        Itinerary itinerary = new Itinerary();
        itinerary.setTitle(itineraryDTO.getTitle());
        itinerary.setDescription(itineraryDTO.getDescription());
        itinerary.setDate(itineraryDTO.getDate());
        itinerary.setPriority(itineraryDTO.getPriority());
        itinerary.setUser(user);

        return ResponseEntity.status(HttpStatus.CREATED).body(itineraryService.save(itinerary));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Itinerary> update(@PathVariable Long id, @RequestBody Itinerary itinerary) {
        Optional<Itinerary> itineraryToUpdate = itineraryService.findById(id);
        if (itineraryToUpdate.isPresent()) {
            Itinerary updatedItinerary = itineraryToUpdate.orElseThrow();

            updatedItinerary.setTitle(itinerary.getTitle());
            updatedItinerary.setDescription(itinerary.getDescription());
            updatedItinerary.setDate(itinerary.getDate());
            updatedItinerary.setPriority(itinerary.getPriority());


            return ResponseEntity.status(HttpStatus.CREATED).body(itineraryService.save(updatedItinerary));
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Itinerary> delete(@PathVariable Long id) {
        Optional<Itinerary> itinerary = itineraryService.deleteById(id);
        if (itinerary.isPresent()) {
            Itinerary updatedItinerary = itinerary.orElseThrow();
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(updatedItinerary);
        }
        return ResponseEntity.notFound().build();
    }
}
