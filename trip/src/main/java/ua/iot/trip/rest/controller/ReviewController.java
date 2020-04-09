package ua.iot.trip.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.iot.trip.business.ReviewService;
import ua.iot.trip.rest.model.Review;

import java.util.List;

@RestController
@RequestMapping("/review")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping
    public List<Review> getReviews(){
        List<Review> reviews = reviewService.getAllReviews();
        return reviews;
    }

    @GetMapping(path = "/{id}")
    public Review getById(@PathVariable("id") Integer id){
        return reviewService.getReviewById(id);
    }

    @GetMapping(path = "/rate/{rateStars}")
    public List<Review> getByRate(@PathVariable("rateStars") int rateStars){
        List<Review> reviewsByRate = reviewService.getReviewByRate(rateStars);
        return reviewsByRate;
    }

    @PostMapping
    public Review createReview(String listingName, String reviewTitle,
                               String reviewText, String dateCreated,
                               int rateStars, String username){
        Review review = new Review(listingName, reviewTitle,
                reviewText, dateCreated, rateStars, username);
        reviewService.createReview(review);
        return review;
    }

    @DeleteMapping(path = "/delete/{id}")
    public String deleteById(@PathVariable("id") Integer id){
        reviewService.deleteReviewById(id);
        return "The review with id: " + id + " was successfully deleted!";
    }

    @DeleteMapping(path = "/delete/all")
    public String deleteAll(){
        reviewService.deleteAllReviews();
        return "All records were successfully deleted!";
    }

    @RequestMapping(path = "/csvinput")
    public List<Review> inputDataToDb(){
        reviewService.saveDataFromCsv();
        return reviewService.getAllReviews();
    }
}
