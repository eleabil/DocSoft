package ua.iot.trip.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ua.iot.trip.business.AdminService;
import ua.iot.trip.rest.model.Admin;
import ua.iot.trip.rest.model.Destination;


import java.util.List;
import java.util.Map;

@RestController
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World-def")
                                   String name, Map<String , Object> model) {
        model.put("name", name);
        return "greeting";
    }

    @GetMapping
    public String main(Map<String, Object> model) {
        Iterable<Admin> admins = adminService.getAllAdmins();
        model.put("admins", admins);
        return "main";
    }
    //    @RequestMapping без прив'язки до в'юшки (типу замість пост маппінг)
    @PostMapping
    public String add(@RequestParam String username, Map<String, Object> model){
        Admin admin = new Admin(username);
        adminService.createAdmin(admin);  //save new admin to repo
        Iterable<Admin> admins = adminService.getAllAdmins(); // take list from repo
        model.put("admins", admins);  //put it into model
        return "main"; //return list to user
    }
    @PostMapping("filter")
    public String filter(@RequestParam String filterByUsername,
                         Map<String, Object> model){ //params must be the same as names in mustache files
        List<Admin> adminsByUsername = adminService.findAdminByUsername(filterByUsername);
        model.put("admins", adminsByUsername);
        return "main";
    }
}
