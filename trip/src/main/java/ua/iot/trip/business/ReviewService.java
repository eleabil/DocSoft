package ua.iot.trip.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.iot.trip.dataaccess.ReviewRepo;
import ua.iot.trip.rest.model.Review;

import java.util.List;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepo reviewRepo;

    public List<Review> getAllReviews(){
        return reviewRepo.findAll();
    }

    public Review createReview(Review review){
        return reviewRepo.save(review);
    }

    public Review getReviewById(Integer id){
        return reviewRepo.findReviewByReviewId(id);
    }

    public List<Review> getReviewByRate(int rateStars){
        return reviewRepo.findByRateStars(rateStars);
    }

    public void deleteReviewById(Integer id) {
        reviewRepo.deleteByReviewId(id);
    }
}
