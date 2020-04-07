package ua.iot.trip.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.iot.trip.dataaccess.AdminRepo;
import ua.iot.trip.rest.model.Admin;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    private AdminRepo adminRepo;

    public Admin createAdmin(Admin admin){
        return adminRepo.save(admin);
    }

    public List<Admin> getAllAdmins() {
        return adminRepo.findAll();
    }

    public List<Admin> findAdminByUsername(String username) {
        return adminRepo.findByUsername(username);
    }
}
