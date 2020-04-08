package ua.iot.trip.rest.model;

import javax.persistence.*;

@Entity
//@Table(name="Admin")
public class Admin {

    //    @Column(name = "admin_id", updatable = false, nullable = false)
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer admin_id;

    @Column
    private String username;

    public Admin() {
    }

    public Admin(String username) {
        this.username = username;
    }

    public Integer getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(Integer admin_id) {
        this.admin_id = admin_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}