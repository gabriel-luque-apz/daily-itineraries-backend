package com.gabriel.springboot.app.dailyitineraries.services;

import com.gabriel.springboot.app.dailyitineraries.entities.Itinerary;
import com.gabriel.springboot.app.dailyitineraries.repositories.ItineraryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ItineraryServiceImpl implements ItineraryService {

    final private ItineraryRepository repository;

    public ItineraryServiceImpl(ItineraryRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Itinerary> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Itinerary> findById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    @Override
    public Itinerary save(Itinerary itinerary) {
        return repository.save(itinerary);
    }

    @Transactional
    @Override
    public Optional<Itinerary> deleteById(Long id) {
        Optional<Itinerary> itinerary = repository.findById(id);
        if (itinerary.isPresent()) {
            repository.deleteById(id);
            return itinerary;
        }
        return Optional.empty();
    }
}
