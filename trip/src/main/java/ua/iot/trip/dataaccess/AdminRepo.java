package ua.iot.trip.dataaccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.iot.trip.rest.model.Admin;

import java.util.List;

// allows to get the whole list of fields of find them by identificator
@Repository
public interface AdminRepo extends JpaRepository<Admin , Integer> {
    List<Admin> findByUsername(String username);

}