package ua.iot.trip.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ua.iot.trip.business.AdminService;
import ua.iot.trip.dataaccess.DestinationRepo;
import ua.iot.trip.rest.model.Destination;

import java.util.List;

@RestController
@RequestMapping("/destination")
public class DestinationController {
    @Autowired
    private AdminService service;

    @GetMapping
    public List<Destination> getDestinations(){
        List<Destination> destinations = service.getAllDestinations();
        return destinations;
    }

    @GetMapping(path = "/{country}")
    public List<Destination> getDestinationByCountry(@PathVariable("country") String country){
        List<Destination> destinationsByCountry = service.findDestinationByCountry(country);
        return destinationsByCountry;
    }

    @PostMapping
    public List<Destination> createDestination(String country, String city){
        Destination destination = new Destination(country, city);
        service.createDestination(destination);
        List<Destination> destinations = service.getAllDestinations();
        return destinations;
    }

}
