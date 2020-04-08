package ua.iot.trip.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.iot.trip.dataaccess.AdminRepo;
import ua.iot.trip.dataaccess.DestinationRepo;
import ua.iot.trip.rest.model.Admin;
import ua.iot.trip.rest.model.Destination;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    private AdminRepo adminRepo;

    @Autowired
    private DestinationRepo destinationRepo;

    public Admin createAdmin(Admin admin){
        return adminRepo.save(admin);
    }

    public List<Admin> getAllAdmins() {
        return adminRepo.findAll();
    }

    public List<Admin> findAdminByUsername(String username) {
        return adminRepo.findByUsername(username);
    }

    public Destination createDestination (Destination destination){
        return destinationRepo.save(destination);
    }

    public List<Destination> getAllDestinations(){
        return destinationRepo.findAll();
    }

    public List<Destination> findDestinationByCountry(String country){
        return destinationRepo.findByCountry(country);
    }
}
