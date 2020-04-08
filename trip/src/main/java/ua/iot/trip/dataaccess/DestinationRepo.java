package ua.iot.trip.dataaccess;


import org.springframework.data.jpa.repository.JpaRepository;
import ua.iot.trip.rest.model.Destination;

import java.util.List;

public interface DestinationRepo extends JpaRepository<Destination, Integer> {
    List<Destination> findByCountry(String country);
}
