package ua.iot.trip.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.iot.trip.ReviewGenerator;
import ua.iot.trip.dataaccess.ReviewRepo;
import ua.iot.trip.rest.model.Review;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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

    public void deleteAllReviews(){
        reviewRepo.deleteAll();
    }

    public void saveDataFromCsv(){
        String line ="";
        ReviewGenerator reviewGenerator = new ReviewGenerator();
        reviewGenerator.generateReview();
        try {
            BufferedReader br = new BufferedReader(new FileReader("Review.csv"));
            while ((line = br.readLine())!=null){
                String[] data = line.split(" ");
                Review review = new Review();
            //    review.setReviewId(Integer.parseInt(data[0]));
                review.setListingName(data[0]);
                review.setReviewTitle(data[1]);
                review.setReviewText(data[2]);
                review.setDateCreated(data[3]);
                review.setRateStars(Integer.parseInt(data[4]));
                review.setUsername(data[5]);
                reviewRepo.save(review);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
