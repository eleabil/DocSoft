package ua.iot.trip.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ua.iot.trip.business.ReviewService;
import ua.iot.trip.rest.model.Review;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/review/try")
public class ReviewControllerLab3 {
    private static final String SUCCESS = "Review was successfully deleted!";
    private static final String FAIL = "Failed to delete the review!";

    @Autowired
    private ReviewService reviewService;

    @GetMapping
    public String getReviews(Map<String, Object> model) {
        List<Review> reviews = reviewService.getAllReviews();
        model.put("reviews", reviews);
        return "review";
    }
    @GetMapping("/{id}")
    public String getReviewById(@PathVariable Integer id, Map<String, Object> model) {
        Review review = reviewService.getReviewById(id);
        model.put("reviews", review);
        return "review";
    }

    @PostMapping
    public String add(@RequestParam String listingName, @RequestParam String reviewTitle,
                      @RequestParam String reviewText, @RequestParam int rateStars,
                      @RequestParam String username, Map<String, Object> model) {
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        String dateCreated = formatter.format(new Date());
        Review review = new Review(listingName, reviewTitle, reviewText, dateCreated, rateStars, username);
        reviewService.createReview(review);
        Iterable<Review> reviews = reviewService.getAllReviews();
        model.put("reviews", reviews);
        return "review";
    }

    @PostMapping("/filterById")
    public String find(@RequestParam Integer filterId, Map<String, Object> model) {
        Review review = reviewService.getReviewById(filterId);
        model.put("reviews", review);
        return "review";
    }
    @PostMapping("/filterByRate")
    public String find(@RequestParam int filterRateStars,
                         Map<String, Object> model) { //params must be the same as names in mustache files
        List<Review> reviewsByRate = reviewService.getReviewByRate(filterRateStars);
        model.put("reviews", reviewsByRate);
        return "review";
    }

    @PostMapping("/filterByListingName")
    public String find(@RequestParam String filterListingName,
                       Map<String, Object> model) { //params must be the same as names in mustache files
        List<Review> reviewsByListingName = reviewService.getReviewByListingName(filterListingName);
        model.put("reviews", reviewsByListingName);
        return "review";
    }

    @GetMapping("/put")
    public String getPut(Map<String, Object> model) {
        List<Review> reviews = reviewService.getAllReviews();
        model.put("updReview", reviews);
        return "putReview";
    }

    @PostMapping("update")
    public String update(@RequestParam Integer id, String title, String text, int rate, Map<String, Object> model) {
        Review updatedReview = reviewService.updateReview(title,text, rate, id);
        model.put("updReview", updatedReview);
        return "putReview";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, Map<String, Object> model) {
        try {
            reviewService.deleteReviewById(id);
            System.out.println(SUCCESS);
            model.put("message", SUCCESS);
        } catch (Exception e){
            e.printStackTrace();
            System.out.println(FAIL);

            model.put("message", FAIL);
        }
        return "deleteReview";
    }

    @GetMapping("/delete")
    public String getDelete(Map<String, Object> model) {
        //List<Review> reviews = reviewService.getAllReviews();
        model.put("message", " ");
        return "deleteReview";
    }

    @PostMapping("delete")
    public String deleteRev(@RequestParam Integer id, Map<String, Object> model) {
        reviewService.deleteReviewById(id);
        model.put("message", SUCCESS);
        return "deleteReview";
    }
}