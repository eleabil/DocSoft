package ua.iot.trip.rest.model;

import javax.persistence.*;

@Entity
@Table(name = "destination")
public class Destination {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer destination_id;

    @Column(name = "country")
    private String country;
    @Column(name = "city")
    private String city;

    public Destination() {
    }

    public Destination(String country, String city) {
        this.country = country;
        this.city = city;
    }

    public Integer getDestination_id() {
        return destination_id;
    }

    public void setDestination_id(Integer destination_id) {
        this.destination_id = destination_id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
